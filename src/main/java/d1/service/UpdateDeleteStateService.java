package d1.service;

import d1.domain.QUESTION;
import d1.domain.QUESTIONMapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Hashtable;

public class UpdateDeleteStateService {

    private Hashtable<String,Object> mappers;

    protected QUESTIONMapper questionMapper;

    public UpdateDeleteStateService(Hashtable<String,Object> mappers,String dataId)throws Exception {

        questionMapper=(QUESTIONMapper) mappers.get("QUESTION");

        QUESTION question2 = new QUESTION();
        question2.setDataId(dataId);
        question2.setState("已删除");
        question2.setUpdateTime(new Date());
        questionMapper.putByDataId(question2);

    }
}
