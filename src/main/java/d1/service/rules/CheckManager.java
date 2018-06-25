package d1.service.rules;

import d1.domain.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class CheckManager {
    private List<AbstractCheckRule> rules = new ArrayList<AbstractCheckRule>();

    public CheckManager(Hashtable<String,Object> mappers){
        rules.add(CheckRule1.Instance());
        rules.add(CheckRule2.Instance());
        rules.add(CheckRule3.Instance());
        rules.add(CheckRule4.Instance());
        rules.add(CheckRule5.Instance());
        rules.add(CheckRule6.Instance());
        rules.add(CheckRule7.Instance());
        for(int i =0;i<rules.size();i++){
            AbstractCheckRule rule = rules.get(i);
            rule.initMappers(mappers);
        }
    }

    public void check(Object obj) throws Exception{

        for(int i =0;i<rules.size();i++){
            AbstractCheckRule rule = rules.get(i);
            String IsCheck=rule.GetByIdConfigInfo("CheckRule"+(i+1));
            if(IsCheck.equals("是")) continue;

            if(obj instanceof DCL_IO_DECL){
                rule.CheckDCL_IO_DECL((DCL_IO_DECL) obj);
            }
            if(obj instanceof INS_RESULT){
                rule.CheckINS_RESULT((INS_RESULT) obj);
            }
        }
    }
}
