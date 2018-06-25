package d1.service;

import d1.domain.*;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

public class DeleteService implements Runnable {
    private Logger logger = LoggerFactory.getLogger(CheckService.class);

    private Hashtable<String,Object> mappers;

    protected  CHECK_CONFIGMapper check_configMapper;

    public DeleteService(Hashtable<String,Object> mappers) {
        this.mappers = mappers;
        check_configMapper=(CHECK_CONFIGMapper)mappers.get("CHECK_CONFIG");
    }
    
    public void run()
    {
        try {
            LoggerService.Instance().info("删除历史数据任务开始启动...",logger);

            int days=365;
            CHECK_CONFIG check_config=CheckConfigService.Instance().getConfigObj(check_configMapper ,"DeleteData");
            if(check_config!=null)
            {
                days=Integer.valueOf(check_config.getValue()).intValue();
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date beforeDate= DateUtils.addDays(new Date(),-days);

            String strBeforeDate= df.format(beforeDate);

            System.out.println(strBeforeDate);
            //删除报检单表数据
            DCL_IO_DECL_HISTORYMapper dcl_io_decl_historyMapper = (DCL_IO_DECL_HISTORYMapper)mappers.get("DCL_IO_DECL_HISTORY");
            int count = dcl_io_decl_historyMapper.deleteIO_DECLhistoryData(strBeforeDate);
            LoggerService.Instance().info("DCL_IO_DECL_HISTORY历史数据删除结束,总条数="+count,logger);

            DCL_IO_DECL_GOODS_HISTORYMapper dcl_io_decl_goods_historyMapper=(DCL_IO_DECL_GOODS_HISTORYMapper)mappers.get("DCL_IO_DECL_GOODS_HISTORY");
            count=dcl_io_decl_goods_historyMapper.deleteIO_DECL_GOODShistoryData(strBeforeDate);

            LoggerService.Instance().info("DCL_IO_DECL_GOODS_HISTORY历史数据删除结束,总条数="+count,logger);

            //删除检验检疫数据
            INS_RESULT_SUM_HISTORYMapper sum_historyMapper=(INS_RESULT_SUM_HISTORYMapper)mappers.get("INS_RESULT_SUM_HISTORY");
            count=sum_historyMapper.deleteRESULT_SUMhistoryData(strBeforeDate);
            LoggerService.Instance().info("INS_RESULT_SUM_HISTORY历史数据删除结束,总条数="+count,logger);

            INS_RESULT_GOODS_HISTORYMapper result_goods_historyMapper=(INS_RESULT_GOODS_HISTORYMapper)mappers.get("INS_RESULT_GOODS_HISTORY");
            count=result_goods_historyMapper.deleteRESULT_GOODShistoryData(strBeforeDate);
            LoggerService.Instance().info("INS_RESULT_GOODS_HISTORY历史数据删除结束,总条数="+count,logger);

        }
        catch (Exception e)
        {
            LoggerService.Instance().error("删除历史数据异常终止",e,logger);
        }
    }

}
