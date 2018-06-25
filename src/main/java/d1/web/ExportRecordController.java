package d1.web;

import d1.domain.CHECK_LOGMapper;
import d1.domain.DM_TS_CL_ORGMapper;
import d1.domain.EXPORT_RECORD;
import d1.domain.EXPORT_RECORDMapper;
import d1.domain.vm.ExportRecord_Get_Vm;
import d1.domain.vm.ExportRecord_Res_Vm;
import d1.service.LoggerService;
import d1.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
public class ExportRecordController {
    private Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    private CHECK_LOGMapper loggerMapper;
    @Autowired
    private EXPORT_RECORDMapper export_recordMapper;
    @Autowired
    private DM_TS_CL_ORGMapper dm_ts_cl_orgMapper;

    @RequestMapping(value = "/exportRecord/get", method = RequestMethod.GET)
    public ExportRecord_Res_Vm Get(ExportRecord_Get_Vm model) throws Exception {

        //根据UserId 获取用户的部门及组织机构
        UserService.Instance().setUserInfoByUserId(model.getGetuserId(),dm_ts_cl_orgMapper);

        if (model.getPage() == null || model.getPage() <= 0) model.setPage(1);
        if (model.getPageSize() == null || model.getPageSize() <= 0) model.setPageSize(20);

        List<EXPORT_RECORD> entities = export_recordMapper.getList(model);
        int count = export_recordMapper.getListCount(model);

        ExportRecord_Res_Vm res = new ExportRecord_Res_Vm();
        res.setTotal(count);
        res.setRows(entities);
        return res;
    }

    @RequestMapping(value = "/exportRecord/delete", method = RequestMethod.DELETE)
    public int Delete(String id) throws Exception {
        //先删除文件
        EXPORT_RECORD exportRecord=  export_recordMapper.getDetail(id);
        String zipPath="data"+ File.separator+exportRecord.getFileName();
        File file=new File(zipPath);
        if(file.exists())
        {
            file.delete();
        }
        LoggerService.Instance().setLoggerMapper(loggerMapper);
        LoggerService.Instance().info("用户"+UserService.Instance().getUserNameAndId()+"删除"+exportRecord.getCreateByName()+"("+exportRecord.getCreateById()+")的导出记录",logger);
        //再删除表数据
        int deleteCount = export_recordMapper.deleteByPrimaryKey(id);
        return deleteCount;
    }
}
