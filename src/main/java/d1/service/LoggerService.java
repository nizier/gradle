package d1.service;

import d1.commons.TimeHelper;
import d1.domain.CHECK_LOG;
import d1.domain.CHECK_LOGMapper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

public class LoggerService {
    private static LoggerService instance=null;
    public static LoggerService Instance(){
        if(instance==null)
            instance = new LoggerService();
        return instance;
    }
    private LoggerService(){
    }

    private CHECK_LOGMapper loggerMapper;
    public void setLoggerMapper(CHECK_LOGMapper loggerMapper)
    {
        this.loggerMapper = loggerMapper;
    }

    public void info(String content,Logger logger){
        logger.info(content);
        CHECK_LOG check_log=new CHECK_LOG();
        check_log.setType("info");
        check_log.setContent(content);
        check_log.setTime(TimeHelper.getNowDateTime());
        loggerMapper.insert(check_log);
    }
    public void error(String content,Logger logger){
        logger.error(content);
        CHECK_LOG check_log=new CHECK_LOG();
        check_log.setType("error");
        check_log.setContent(content);
        check_log.setTime(TimeHelper.getNowDateTime());
        loggerMapper.insert(check_log);
    }
    public void error(String msg,Throwable content,Logger logger){
        logger.error(msg,content);
        CHECK_LOG check_log=new CHECK_LOG();
        check_log.setType("error");
        check_log.setContent(msg+"\n"+ExceptionUtils.getStackTrace(content));
        check_log.setTime(TimeHelper.getNowDateTime());
        loggerMapper.insert(check_log);
    }
}
