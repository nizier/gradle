package d1.web;

import d1.domain.DM_TS_CL_ORGMapper;
import d1.domain.QUESTIONMapper;
import d1.domain.vm.QuestionExportReport_Get_Vm;
import d1.domain.vm.QuestionExportReport_Res_Vm;
import d1.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionExportReportController {

    @Autowired
    private QUESTIONMapper questionMapper;
    @Autowired
    private DM_TS_CL_ORGMapper dm_ts_cl_orgMapper;

    @RequestMapping(value = "/questionExportReport/get", method = RequestMethod.GET)
    public  List<QuestionExportReport_Res_Vm> Get(QuestionExportReport_Get_Vm model)
    {
        //根据UserId 获取用户的部门及组织机构
        UserService.Instance().setUserInfoByUserId(model.getGetuserId(),dm_ts_cl_orgMapper);

        QuestionExportReport_Res_Vm resVm=new QuestionExportReport_Res_Vm();
        model.setOrganization(UserService.Instance().getOrgCode());

        List<QuestionExportReport_Res_Vm> listExportData= questionMapper.getgetQuestionExportReport(model);
        return listExportData;
    }
}
