package d1.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import d1.commons.ReflectHelper;
import d1.domain.*;
import d1.domain.mgr.DCL_IO_DECLMgr;
import d1.domain.mgr.INS_RESULTMgr;
import d1.service.rules.CheckManager;
import d1.web.DeleteDataController;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

public class CheckService implements Runnable {
    private Logger logger = LoggerFactory.getLogger(CheckService.class);

    private Hashtable<String,Object> mappers;
    private String SearchTime;
    private DeleteDataController deleteDataController;

    public CheckService(Hashtable<String, Object> mappers, String SearchTime, DeleteDataController deleteDataController) {
        this.mappers = mappers;
        this.SearchTime=SearchTime;
        this.deleteDataController = deleteDataController;
    }

    public void  FetchData(String QueryTime)
    {
        String currentDECLNO=null;
        try {
            LoggerService.Instance().info("核查任务开始启动...",logger);
            //1.开始抽取任务
            new FetchService(mappers,QueryTime);
            //2.开始数据核查
            CheckManager checkManager = new CheckManager(mappers);
            //2.1 DCL_IO_DECL_GOODS_TASK  报检单货物表
            for(DCL_IO_DECL dcl_io_decl: DCL_IO_DECLMgr.Instance().getDatas().values()){
                currentDECLNO = dcl_io_decl.getDcl_io_decl_task().getDeclNo();
                checkManager.check(dcl_io_decl);

                DCL_IO_DECL_HISTORYMapper mapper1 = (DCL_IO_DECL_HISTORYMapper)mappers.get("DCL_IO_DECL_HISTORY");
                //删除主表历史数据
                DCL_IO_DECL_TASK dcl_io_decl_task=dcl_io_decl.getDcl_io_decl_task();
                String DECL_NO=dcl_io_decl_task.getDeclNo();
                mapper1.deleteByDECL_NO(DECL_NO);

                DCL_IO_DECL_GOODS_HISTORYMapper goods_historyMapper=(DCL_IO_DECL_GOODS_HISTORYMapper)mappers.get("DCL_IO_DECL_GOODS_HISTORY");
                Hashtable<String,DCL_IO_DECL_GOODS_TASK> dcl_io_decl_goods_taskHashtable= dcl_io_decl.getDcl_io_decl_goods_taskHashtable();

                //删除从表历史数据
                goods_historyMapper.deleteDECL_NO(DECL_NO);

                //插入主表历史数据
                //克隆到DCL_IO_DECL_HISTORY
                DCL_IO_DECL_HISTORY history=new DCL_IO_DECL_HISTORY();
                ReflectHelper.clonePOJO(dcl_io_decl_task,history);
                currentDECLNO = history.getDeclNo();
                mapper1.insert(history);
                //插入从表历史数据
                //克隆到DCL_IO_DECL_GOODS_HISTORY
                if(dcl_io_decl_goods_taskHashtable!=null&&dcl_io_decl_goods_taskHashtable.values()!=null)
                {
                    for (DCL_IO_DECL_GOODS_TASK goods_task:
                            dcl_io_decl_goods_taskHashtable.values()) {
                        DCL_IO_DECL_GOODS_TASK decl_goods_task = dcl_io_decl_goods_taskHashtable.get(goods_task.getDeclNo() + "__" + goods_task.getGoodsNo());
                        DCL_IO_DECL_GOODS_HISTORY dcl_io_decl_goods_history = new DCL_IO_DECL_GOODS_HISTORY();
                        ReflectHelper.clonePOJO(decl_goods_task, dcl_io_decl_goods_history);
                        currentDECLNO = dcl_io_decl_goods_history.getDeclNo();
                        goods_historyMapper.insert(dcl_io_decl_goods_history);
                    }
                }
            }

            LoggerService.Instance().info("DCL_IO_DEC数据核查结束",logger);

            //2.2 INS_RESULT_GOODS_TASK   货物检验结果表
            for(INS_RESULT ins_result: INS_RESULTMgr.Instance().getDatas().values()){
                currentDECLNO = ins_result.getIns_result_sum_task().getDeclNo();
                checkManager.check(ins_result);

                INS_RESULT_SUM_HISTORYMapper sum_historyMapper=(INS_RESULT_SUM_HISTORYMapper)mappers.get("INS_RESULT_SUM_HISTORY");
                INS_RESULT_SUM_TASK sum_task=ins_result.getIns_result_sum_task();
                String DECL_NO=sum_task.getDeclNo();
                //删除主表历史数据
                sum_historyMapper.deleteByDeclNo(DECL_NO);

                INS_RESULT_GOODS_HISTORYMapper result_goods_historyMapper=(INS_RESULT_GOODS_HISTORYMapper)mappers.get("INS_RESULT_GOODS_HISTORY");
                Hashtable<String,INS_RESULT_GOODS_TASK> ins_result_goods_taskHashtable=ins_result.getResult_goods_taskHashtable();
                //删除从表历史数据
                result_goods_historyMapper.deleteDECL_NO(DECL_NO);

                //插入主表历史数据
                INS_RESULT_SUM_HISTORY result_sum_history=new INS_RESULT_SUM_HISTORY();
                ReflectHelper.clonePOJO(sum_task,result_sum_history);
                currentDECLNO=result_sum_history.getDeclNo();
                sum_historyMapper.insert(result_sum_history);

                if(ins_result_goods_taskHashtable!=null&&ins_result_goods_taskHashtable.values()!=null)
                {
                    //插入从表数据
                    for (INS_RESULT_GOODS_TASK result_goods_task:
                            ins_result_goods_taskHashtable.values()) {
                        INS_RESULT_GOODS_TASK goods_task=ins_result_goods_taskHashtable.get(DECL_NO+"__"+result_goods_task.getGoodsNo());
                        INS_RESULT_GOODS_HISTORY result_goods_history1=new INS_RESULT_GOODS_HISTORY();
                        ReflectHelper.clonePOJO(result_goods_task,result_goods_history1);
                        currentDECLNO = result_goods_history1.getDeclNo();
                        result_goods_historyMapper.insert(result_goods_history1);
                    }
                }
            }
            LoggerService.Instance().info("INS_RESULT数据核查结束",logger);

            LoggerService.Instance().info("核查任务正常结束.",logger);
        }
        catch(Exception ex){
            LoggerService.Instance().error("核查任务异常终止!当前处理对象NO是:"+currentDECLNO,ex,logger);
        }finally {
            DCL_IO_DECLMgr.Instance().clearAll();
            INS_RESULTMgr.Instance().clearAll();
        }
    }

    @Override
    public void run() {
        Date beforeDate= DateUtils.addDays(new Date(),-1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String Yesterday=df.format(beforeDate);
        if(this.SearchTime==null||this.SearchTime.equals(""))
        {
            this.SearchTime=Yesterday;
            FetchData(this.SearchTime);
        }
        else
        {
            try {
                Date searchDate  = df.parse(this.SearchTime);
                Date YesterdayDate=df.parse(Yesterday);
                while (searchDate.getTime()<=YesterdayDate.getTime())
                {
                    FetchData(df.format(searchDate));
                    searchDate = DateUtils.addDays(searchDate,1);
                }
            } catch (ParseException e) {
                LoggerService.Instance().error("日期格式不对",e,logger);
            }
        }
        //数据核查完再删除历史数据
        deleteDataController.deleteData();
    }
}