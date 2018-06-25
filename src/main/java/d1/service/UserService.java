package d1.service;

import d1.domain.DM_TS_CL_ORG;
import d1.domain.DM_TS_CL_ORGMapper;
import d1.domain.QUESTIONMapper;
import d1.domain.vm.User_Res_Vm;
import org.apache.catalina.User;

import java.util.List;

public class UserService {
    private static UserService instance=null;
    public static UserService Instance(){
        if(instance==null)
            instance = new UserService();
        return instance;
    }
    private UserService(){
    }

    private String userId;
    private String userName;
    private String deptNumber;
    private String deptName;
    private String abbReviation;
    private String orgCode;
    private String manaageOrgCode;
    private String userRole;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }
    public String getUserNameAndId() {
        return userName+"("+userId+")";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(String deptNumber) {
        this.deptNumber = deptNumber;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getAbbReviation() {
        return abbReviation;
    }

    public void setAbbReviation(String abbReviation) {
        this.abbReviation = abbReviation;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getManaageOrgCode() {
        return manaageOrgCode;
    }

    public void setManaageOrgCode(String manaageOrgCode) {
        this.manaageOrgCode = manaageOrgCode;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    //获取用的部门信息及组织机构
    public void setUserInfoByUserId(String getuserId, DM_TS_CL_ORGMapper dm_ts_cl_orgMapper)
    {
        if((UserService.Instance().getUserId()==null||!UserService.Instance().getUserId().equals(getuserId))&&getuserId!=null) {
            User_Res_Vm userResVm = dm_ts_cl_orgMapper.getUserInfoByUserId(getuserId);
            if(userResVm!=null)
            {
                UserService.Instance().setUserId(userResVm.getUserId());
                UserService.Instance().setUserName(userResVm.getUserName());
                UserService.Instance().setAbbReviation(userResVm.getAbbReviation());
                UserService.Instance().setDeptNumber(userResVm.getDeptNumber());
                UserService.Instance().setDeptName(userResVm.getDeptName());

                //归我查询的组织机构
                String abbReviation = userResVm.getAbbReviation();
                String deptNumber = userResVm.getDeptNumber();
                List<DM_TS_CL_ORG> dm_ts_cl_orgList = dm_ts_cl_orgMapper.getOrgCodeByDeptNumber(abbReviation, deptNumber);
                String orgCode = "";

//                for (DM_TS_CL_ORG i :
//                        dm_ts_cl_orgList) {
//
//                    orgCode += "'" + i.getOrgCode() + "',";
//                }

                    for (int i = 0; i < dm_ts_cl_orgList.size(); i++) {
                        if (i > 1000) return;
                        DM_TS_CL_ORG dm_ts_cl_org = dm_ts_cl_orgList.get(i);
                        orgCode += "'" + dm_ts_cl_org.getOrgCode() + "',";
                    }
                
                orgCode = orgCode.substring(0, orgCode.length() - 1);

                UserService.Instance().setOrgCode(orgCode);

                //TODO 归我管理的组织机构，需要遍历，查看是否有无核查人员，设置setManaageOrgCode的值
                if(UserService.Instance().getUserId().equals("32408"))
                {
                    UserService.Instance().setManaageOrgCode("'211900'");
                    //TODO  获取当前用户所属角色
                    UserService.Instance().setUserRole("管理员");
                }

                if(!UserService.Instance().getUserId().equals("32408")&&!UserService.Instance().getUserId().equals("admin"))
                {
                    //TODO  获取当前用户所属角色
                    UserService.Instance().setUserRole("核查人员");
                }

            }
        }
    }



}
