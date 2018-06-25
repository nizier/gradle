package d1.web;

import d1.domain.*;
import d1.domain.vm.*;
import d1.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserInfoController {

    private Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private DM_TS_CL_ORGMapper dm_ts_cl_orgMapper;

    @RequestMapping(value = "/userInfo/get", method = RequestMethod.GET)
    public UserInfo_Res_Vm Get(UserInfo_Get_Vm model)
    {
        //根据UserId 获取用户的部门及组织机构
        UserService.Instance().setUserInfoByUserId(model.getGetuserId(),dm_ts_cl_orgMapper);

        UserInfo_Res_Vm res = new UserInfo_Res_Vm();
        res.setUserId(UserService.Instance().getUserId());
        res.setUserName(UserService.Instance().getUserName());
        res.setDeptNumber(UserService.Instance().getDeptNumber());
        res.setDeptName(UserService.Instance().getDeptName());
        res.setAbbReviation(UserService.Instance().getAbbReviation());
        res.setManaageOrgCode(UserService.Instance().getManaageOrgCode());
        res.setOrgCode(UserService.Instance().getOrgCode());
        res.setUserRole(UserService.Instance().getUserRole());
        return res;
    }
}
