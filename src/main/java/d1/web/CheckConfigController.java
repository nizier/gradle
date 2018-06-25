package d1.web;


import d1.domain.CHECK_CONFIG;
import d1.domain.CHECK_CONFIGMapper;
import d1.domain.CHECK_LOGMapper;
import d1.domain.DM_TS_CL_ORGMapper;
import d1.domain.vm.CheckConfig_Get_Vm;
import d1.domain.vm.CheckConfig_Res_Get_Vm;
import d1.service.CheckConfigService;
import d1.service.LoggerService;
import d1.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import d1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CheckConfigController {
    private Logger logger = LoggerFactory.getLogger(CheckConfigController.class);

    @Autowired
    private CHECK_CONFIGMapper check_config_mapper;
    @Autowired
    private DM_TS_CL_ORGMapper dm_ts_cl_orgMapper;
    @Autowired
    CHECK_LOGMapper check_logMapper;
    @RequestMapping(value = "/checkConfig/get", method = RequestMethod.GET)
    public CheckConfig_Res_Get_Vm Get(CheckConfig_Get_Vm model) throws Exception {

        //根据UserId 获取用户的部门及组织机构
        UserService.Instance().setUserInfoByUserId(model.getGetuserId(),dm_ts_cl_orgMapper);

        if (model.getPage() == null || model.getPage() <= 0) model.setPage(1);
        if (model.getPageSize() == null || model.getPageSize() <= 0) model.setPageSize(20);

        List<CHECK_CONFIG> entities = check_config_mapper.getList(model);
        for(int i = 0;i<entities.size();i++){
            CheckConfigService.Instance().setConfigObj(entities.get(i));
        }
        Integer count = check_config_mapper.getListCount(model);

        CheckConfig_Res_Get_Vm res = new CheckConfig_Res_Get_Vm();
        res.setCount(count);
        res.setResult(entities);

        return res;
    }


    @RequestMapping(value = "/checkConfig/getDetail", method = RequestMethod.GET)
    public CHECK_CONFIG getDetail(String id) throws Exception {

        CHECK_CONFIG entity = CheckConfigService.Instance().getConfigObj(check_config_mapper,id);

        return entity;

    }


    @RequestMapping(value = "/checkConfig/put", method = RequestMethod.PUT)
    public int Put(@RequestBody CHECK_CONFIG model) throws Exception {

        int entity = check_config_mapper.put(model);
        CheckConfigService.Instance().updateValue(model);
        LoggerService.Instance().setLoggerMapper(check_logMapper);
        LoggerService.Instance().info("用户"+ UserService.Instance().getUserNameAndId()+"修改"+model.getName()+"值为"+model.getValue(),logger);
        return entity;

    }


}

