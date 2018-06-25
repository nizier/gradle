package d1.service;

import d1.domain.*;
import d1.domain.mgr.DCL_IO_DECLMgr;
import d1.domain.mgr.INS_RESULTMgr;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

public class FetchService {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(FetchService.class);
    private Hashtable<String,Object> mappers;

    public FetchService(Hashtable<String,Object> mappers,String QueryTime) throws Exception{
        //DCL_IO_DECL_TASK
        List<DCL_IO_DECL_TASK> listDECLDatas=null;
        List<DCL_IO_DECL_GOODS_TASK> listGOODSTASKDatas=null;
        List<INS_RESULT_SUM_TASK> listSUMDatas=null;
        List<INS_RESULT_GOODS_TASK> listRESULTDatas=null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date queryEndDate = DateUtils.addDays(df.parse(QueryTime),1);
        String QueryEndTime=df.format(queryEndDate);
        try{
            DCL_IO_DECL_TASKMapper mapper1 = (DCL_IO_DECL_TASKMapper)mappers.get("DCL_IO_DECL_TASK");
            listDECLDatas= mapper1.listDatas(QueryTime,QueryEndTime);
            for (DCL_IO_DECL_TASK i:listDECLDatas
                    ) {
                if(i.getTransTypeTj().equals("DELETE")||i.getTransTypeTj().equals("delete"))
                {
                    new UpdateDeleteStateService(mappers,i.getDeclNo());
                }
                else
                {
                    DCL_IO_DECLMgr.Instance().SetDCL_IO_DECL_TASKToCache(i);
                }
            }

            LoggerService.Instance().info("DCL_IO_DECL_TASK数据缓存成功",logger);

            //DCL_IO_DECL_GOODS_TASK
            DCL_IO_DECL_GOODS_TASKMapper mapper2 = (DCL_IO_DECL_GOODS_TASKMapper)mappers.get("DCL_IO_DECL_GOODS_TASK");
            listGOODSTASKDatas=mapper2.listDatas(QueryTime,QueryEndTime);
            for (DCL_IO_DECL_GOODS_TASK i:listGOODSTASKDatas
                    ) {
                if(i.getTransTypeTj().equals("DELETE")||i.getTransTypeTj().equals("delete"))
                {
                    new UpdateDeleteStateService(mappers,i.getDeclNo()+"_"+i.getGoodsNo());
                }
                else
                {
                    DCL_IO_DECLMgr.Instance().SetDCL_IO_DECL_GOODS_TASKToCache(i);
                }
            }
            LoggerService.Instance().info("DCL_IO_DECL_GOODS_TASK数据缓存成功",logger);

            //INS_RESULT_SUM_TASK
            INS_RESULT_SUM_TASKMapper mapper4 = (INS_RESULT_SUM_TASKMapper)mappers.get("INS_RESULT_SUM_TASK");
            listSUMDatas=mapper4.listDatas(QueryTime,QueryEndTime);
            for (INS_RESULT_SUM_TASK i:listSUMDatas
                    ) {
                if(i.getTransTypeTj().equals("DELETE")||i.getTransTypeTj().equals("delete"))
                {
                    new UpdateDeleteStateService(mappers,i.getDeclNo());
                }
                else
                {
                    INS_RESULTMgr.Instance().SetINS_RESULT_SUMToCache(i);
                }
            }
            LoggerService.Instance().info("INS_RESULT_SUM_TASK数据缓存成功",logger);

            //INS_RESULT_GOODS_TASK
            INS_RESULT_GOODS_TASKMapper mapper3 = (INS_RESULT_GOODS_TASKMapper)mappers.get("INS_RESULT_GOODS_TASK");
            listRESULTDatas=mapper3.listDatas(QueryTime,QueryEndTime);
            for (INS_RESULT_GOODS_TASK i:listRESULTDatas
                    ) {
                if(i.getTransTypeTj().equals("DELETE")||i.getTransTypeTj().equals("delete"))
                {
                    new UpdateDeleteStateService(mappers,i.getDeclNo()+"_"+i.getGoodsNo());
                }
                else
                {
                    INS_RESULTMgr.Instance().SetINS_RESULT_GOODS_TASKToCache(i);
                }
            }
            LoggerService.Instance().info("INS_RESULT_GOODS_TASK数据缓存成功",logger);
        }catch (Exception e){
            throw e;
        }finally {
            //清空所有list缓存
            if(listDECLDatas!=null)listDECLDatas.clear();
            if(listGOODSTASKDatas!=null)listGOODSTASKDatas.clear();
            if(listSUMDatas!=null)listSUMDatas.clear();
            if(listRESULTDatas!=null)listRESULTDatas.clear();
        }
   }
}
