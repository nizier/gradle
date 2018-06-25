package d1.service;

import d1.domain.CHECK_CONFIG;
import d1.domain.CHECK_CONFIGMapper;

import java.util.Hashtable;

public class CheckConfigService {
    private static CheckConfigService instance=null;
    private Hashtable<String,CHECK_CONFIG> configs = new Hashtable<String,CHECK_CONFIG>();
    public static CheckConfigService Instance(){
        if(instance==null)
            instance = new CheckConfigService();
        return instance;
    }
    private CheckConfigService(){

    }
    public CHECK_CONFIG getConfigObj(CHECK_CONFIGMapper mapper,String key){
        if(this.configs.get(key)!=null)
            return this.configs.get(key);
        CHECK_CONFIG config = mapper.getDetail(key);
        this.configs.put(key, config);
        return  config;
    }

    public void updateValue(CHECK_CONFIG model) {
        if(this.configs.get(model.getId())==null)
            return ;
        CHECK_CONFIG config = configs.get(model.getId());
        config.setValue(model.getValue());
    }

    public void setConfigObj(CHECK_CONFIG check_config) {
        if(check_config!=null){
            this.configs.put(check_config.getId(), check_config);
        }
    }
}
