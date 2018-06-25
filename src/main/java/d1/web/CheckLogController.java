package d1.web;


import d1.domain.CHECK_CONFIG;
import d1.domain.CHECK_LOG;
import d1.domain.CHECK_LOGMapper;
import d1.domain.DM_TS_CL_ORGMapper;
import d1.domain.vm.CheckLog_Get_Vm;
import d1.domain.vm.CheckLog_Res_Get_Vm;
import d1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckLogController {

    @Autowired
    private CHECK_LOGMapper checkLogMapper;

    @Autowired
    private DM_TS_CL_ORGMapper dm_ts_cl_orgMapper;

    @RequestMapping(value = "/checkLog/get",method = RequestMethod.GET)
    public CheckLog_Res_Get_Vm Get(CheckLog_Get_Vm model)
    {
        //根据UserId 获取用户的部门及组织机构
        UserService.Instance().setUserInfoByUserId(model.getGetuserId(),dm_ts_cl_orgMapper);

        if (model.getPage() == null || model.getPage() <= 0) model.setPage(1);
        if (model.getPageSize() == null || model.getPageSize() <= 0) model.setPageSize(20);

        List<CHECK_LOG> entities=checkLogMapper.getList(model);
        Integer count=checkLogMapper.getListCount(model);

        CheckLog_Res_Get_Vm res=new CheckLog_Res_Get_Vm();
        res.setCount(count);
        res.setResult(entities);

        return  res;
    }

    @RequestMapping(value = "/checkLog/getDetail", method = RequestMethod.GET)
    public CHECK_LOG getDetail(String id) throws Exception {

        CHECK_LOG entity = checkLogMapper.getDetail(id);

        return entity;
    }

}
