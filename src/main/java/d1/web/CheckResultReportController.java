package d1.web;

import d1.domain.DM_TS_CL_ORGMapper;
import d1.domain.QUESTION;
import d1.domain.QUESTIONMapper;
import d1.domain.Report.CheckResultReport_Get_Vm;
import d1.domain.Report.CheckResultReport_Res_Vm;
import d1.domain.vm.Question_Res_Get_Vm;
import d1.service.UserService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CheckResultReportController {
    private Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    private QUESTIONMapper questionMapper;
    @Autowired
    private DM_TS_CL_ORGMapper dm_ts_cl_orgMapper;

    @RequestMapping(value = "/checkResultReport/get", method = RequestMethod.GET)
    public List<CheckResultReport_Res_Vm> Get(CheckResultReport_Get_Vm model)
    {
        //根据UserId 获取用户的部门及组织机构
        UserService.Instance().setUserInfoByUserId(model.getGetuserId(),dm_ts_cl_orgMapper);

        //TODO 判断当前登录人的角色
//        if(UserService.Instance().getUserRole().equals("核查人员"))
//        {
            model.setOrganization(UserService.Instance().getOrgCode());
//        }
        model.setQueryType("0");
        List<CheckResultReport_Res_Vm> listResVm= questionMapper.getCheckResultReport(model);
        return listResVm;
    }

    @RequestMapping(value = "/checkResultReport/list", method = RequestMethod.GET)
    public Question_Res_Get_Vm list(CheckResultReport_Get_Vm model)
    {
        if (model.getPage() == null || model.getPage() <= 0) model.setPage(1);
        if (model.getPageSize() == null || model.getPageSize() <= 0) model.setPageSize(20);

        Question_Res_Get_Vm resVm=new Question_Res_Get_Vm();
        model.setQueryType("1");
        List<QUESTION> listResVm= questionMapper.getheckResultReportList(model);
        int count = questionMapper.getcheckResultReportListCount(model);
        resVm.setRows(listResVm);
        resVm.setTotal(count);
        return resVm;
    }
}
