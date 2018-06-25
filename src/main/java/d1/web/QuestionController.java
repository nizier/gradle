package d1.web;


import d1.commons.ExcelHelper;
import d1.domain.*;
import d1.domain.vm.Question_Get_Vm;
import d1.domain.vm.Question_Res_Get_Vm;
import d1.service.LoggerService;
import d1.service.UserService;
import org.apache.catalina.User;
import org.apache.poi.hssf.usermodel.*;
import org.aspectj.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.zip.*;

import static d1.commons.StringHelper.getFourRandom;

@RestController
public class QuestionController {
    private Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    private QUESTIONMapper questionMapper;
    @Autowired
    private CHECK_LOGMapper loggerMapper;
    @Autowired
    private DM_TS_CL_ORGMapper dm_ts_cl_orgMapper;
    @Autowired
    private EXPORT_RECORDMapper export_recordMapper;

    @RequestMapping(value = "/question/get", method = RequestMethod.GET)
    public Question_Res_Get_Vm Get(Question_Get_Vm model) throws Exception {

        //根据UserId 获取用户的部门及组织机构
        UserService.Instance().setUserInfoByUserId(model.getGetuserId(),dm_ts_cl_orgMapper);

        if (model.getPage() == null || model.getPage() <= 0) model.setPage(1);
        if (model.getPageSize() == null || model.getPageSize() <= 0) model.setPageSize(20);

        //设置当前登录人所管理的组织机构
        if(UserService.Instance().getOrgCode()!=null&&UserService.Instance().getOrgCode().length()>0)
        {
//            if(model.getIsBelongMeManage().equals("1")) //归我管理
//            {
//                model.setOrganization(UserService.Instance().getManaageOrgCode());
//            }
//            else
//            {
//                model.setOrganization(UserService.Instance().getOrgCode());
//            }
            model.setOrganization(UserService.Instance().getOrgCode());
        }

        List<QUESTION> entities = questionMapper.getList(model);
        int count = questionMapper.getListCount(model);

        Question_Res_Get_Vm res = new Question_Res_Get_Vm();
        res.setTotal(count);
        res.setRows(entities);
        return res;
    }

    @RequestMapping(value = "/question/getDetail", method = RequestMethod.GET)
    public QUESTION GetDetail(String id) throws Exception {
        QUESTION entity = questionMapper.getDetail(id);
        return entity;
    }

    @RequestMapping(value = "/question/put", method = RequestMethod.PUT)
    public int Put(@RequestBody List<QUESTION> model) throws Exception {

        for (int i = 0; i < model.size(); i++) {
            QUESTION ques = model.get(i);
            int entity = questionMapper.put(ques);
            LoggerService.Instance().setLoggerMapper(loggerMapper);
            LoggerService.Instance().info("用户"+UserService.Instance().getUserNameAndId()+"更新数据"+ques.getDeclNo()+","+ques.getGoodsNo()+"的状态为"+ques.getState(),logger);
        }

        return model.size();
    }

    @RequestMapping(value = "/question/excel", method = RequestMethod.GET)
    public void excel(Question_Get_Vm model,HttpServletResponse response) throws Exception {

        model.setPage(1);
        model.setPageSize(200000);

        //设置当前登录人所管理的组织机构
        if(UserService.Instance().getOrgCode()!=null&&UserService.Instance().getOrgCode().length()>0)
        {
//            if(model.getIsBelongMeManage().equals("1")) //归我管理
//            {
//                model.setOrganization(UserService.Instance().getManaageOrgCode());
//                name="归我管理";
//            }
//            else
//            {
//                model.setOrganization(UserService.Instance().getOrgCode());
//                name="归我查询";
//            }
            model.setOrganization(UserService.Instance().getOrgCode());
        }

        //按照组织机构
        List<String> listOrganization=questionMapper.getListOrganization(model);
        int count=0;

        Date date=new Date();
        String path="temp"+File.separator;
        String dirPath= path+date.getTime()+getFourRandom(4)+File.separator;
        File dirFile=new File(dirPath);
        if(!dirFile.exists())
        {
            dirFile.mkdirs();
        }

        String exportId="";
        for (int j=0;j<listOrganization.size();j++)
        {
            String organization= listOrganization.get(j);
            model.setOrganization(organization);
            //实体数据
            List<QUESTION> entities = questionMapper.getList(model);

            String sheetName=model.getType().equals("error")?"错误问题表":"疑似问题表";

            // 第一步，创建一个webbook，对应一个Excel文件
            HSSFWorkbook wb = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet sheet = wb.createSheet(sheetName);
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
            HSSFRow row = sheet.createRow((int) 0);
            // 第四步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

            HSSFCell cell = row.createCell((short) 0);
            cell.setCellValue("类型");
            cell.setCellStyle(style);
            cell = row.createCell((short) 1);
            cell.setCellValue("核查类型");
            cell.setCellStyle(style);
            cell = row.createCell((short) 2);
            cell.setCellValue("核查项");
            cell.setCellStyle(style);
            cell = row.createCell((short) 3);
            cell.setCellValue("问题说明");
            cell.setCellStyle(style);
            cell = row.createCell((short) 4);
            cell.setCellValue("机构代码");
            cell.setCellStyle(style);
            cell = row.createCell((short) 5);
            cell.setCellValue("机构名称");
            cell.setCellStyle(style);
            cell = row.createCell((short) 6);
            cell.setCellValue("报检单号");
            cell.setCellStyle(style);
            cell = row.createCell((short) 7);
            cell.setCellValue("货物序号");
            cell.setCellStyle(style);
            cell = row.createCell((short) 8);
            cell.setCellValue("出入境");
            cell.setCellStyle(style);
            cell = row.createCell((short) 9);
            cell.setCellValue("系统核查时间");
            cell.setCellStyle(style);
            cell = row.createCell((short) 10);
            cell.setCellValue("人工操作人名称");
            cell.setCellStyle(style);
            cell = row.createCell((short) 11);
            cell.setCellValue("人工操作时间");
            cell.setCellStyle(style);
            cell = row.createCell((short) 12);
            cell.setCellValue("复核次数");
            cell.setCellStyle(style);
            cell = row.createCell((short) 13);
            cell.setCellValue("最后复核时间");
            cell.setCellStyle(style);
            cell = row.createCell((short) 14);
            cell.setCellValue("状态");
            cell.setCellStyle(style);
            cell = row.createCell((short) 15);
            cell.setCellValue("备注");
            cell.setCellStyle(style);
            cell = row.createCell((short) 16);
            cell.setCellValue("问题处理备注");
            cell.setCellStyle(style);

            // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
            for (int i = 0; i < entities.size(); i++) {
                row = sheet.createRow((int) i + 1);
                QUESTION stu = (QUESTION) entities.get(i);
                // 第四步，创建单元格，并设置值
                row.createCell((short) 0).setCellValue(stu.getType().equals("error")?"错误":"疑似");
                row.createCell((short) 1).setCellValue(stu.getCheckType());
                row.createCell((short) 2).setCellValue(stu.getCheckName());
                row.createCell((short) 3).setCellValue(stu.getCheckInfor());
                row.createCell((short) 4).setCellValue(stu.getOrganization());
                row.createCell((short) 5).setCellValue(stu.getOrganizationName());
                row.createCell((short) 6).setCellValue(stu.getDeclNo());
                row.createCell((short) 7).setCellValue(stu.getGoodsNo() == null ? null : stu.getGoodsNo().toString());
                row.createCell((short) 8).setCellValue(stu.getExitEntry());
                row.createCell((short) 9).setCellValue(stu.getCreateTime() == null ? null : new SimpleDateFormat("yyyy-MM-dd").format(stu.getCreateTime()));
                row.createCell((short) 10).setCellValue(stu.getCheckByName());
                row.createCell((short) 11).setCellValue(stu.getCheckTime() == null ? null : new SimpleDateFormat("yyyy-MM-dd").format(stu.getCheckTime()));
                row.createCell((short) 12).setCellValue(stu.getUpdateNum() == null ? null : stu.getUpdateNum().toString());
                row.createCell((short) 13).setCellValue(stu.getUpdateTime() == null ? null : new SimpleDateFormat("yyyy-MM-dd").format(stu.getUpdateTime()));
                row.createCell((short) 14).setCellValue(stu.getState());
                row.createCell((short) 15).setCellValue(stu.getRemark());
                row.createCell((short) 16).setCellValue(stu.getHandleRemark());

//                exportId+="'"+stu.getId()+"',";
                exportId+="ID='"+stu.getId()+"' OR ";
            }

            count+=entities.size();

            // 第六步，将文件存到指定位置
            FileOutputStream fout = new FileOutputStream(dirPath+organization+".xls");
            wb.write(fout);
            fout.close();
        }

        if(!exportId.equals(""))
        {
            exportId=exportId.substring(0,exportId.length()-3);
        }

        String zPath="data"+File.separator;
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String zipfileName=df.format( new Date())+getFourRandom(6)+".zip";
        String zipPath=zPath+zipfileName;
        File zipFile = new File(zPath);
        if(!zipFile.exists())
        {
            zipFile.mkdirs();
        }

        System.out.println("压缩中...");

      boolean flag=  ExcelHelper.fileToZip(dirFile.getPath(),zipFile.getPath(),zipfileName);
        if(flag)
        {
            System.out.println("压缩完成");
        }
        else
        {
            System.out.println("压缩失败");
        }

        LoggerService.Instance().setLoggerMapper(loggerMapper);
        try {


            InputStream in = new FileInputStream(zipPath); //获取文件的流
            int len = 0;
            byte buf[] = new byte[1024];//缓存作用
            response.reset();
            response.setContentType("application/octet-stream; charset=UTF-8");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + new String((zipfileName).getBytes(), "iso-8859-1"));
            OutputStream os =response.getOutputStream();

            while( (len = in.read(buf)) > 0 ) //切忌这后面不能加 分号 ”;“
            {
                os.write(buf, 0, len);//向客户端输出，实际是把数据存放在response中，然后web服务器再去response中读取
            }
        } catch (Exception e) {
            LoggerService.Instance().error("用户"+UserService.Instance().getUserNameAndId()+"导出"+count+"条数据到Excel失败",e,logger);
        }

        LoggerService.Instance().info("用户"+UserService.Instance().getUserNameAndId()+"导出"+count+"条数据到Excel",logger);

        //删除目录
        ExcelHelper.deleteFile(dirFile);

        //插入导出记录表
        EXPORT_RECORD exportRecord=new EXPORT_RECORD();
        exportRecord.setCreateById(UserService.Instance().getUserId()==null?"":UserService.Instance().getUserId());
        exportRecord.setCreateByName(UserService.Instance().getUserName()==null?"":UserService.Instance().getUserName());
        exportRecord.setFileName(zipfileName);
        exportRecord.setRemark("机构代码:"+getString(model.getOrganization())+";"+"出入境:"+getString(model.getExitEntry())+";"+"核查时间:"+model.getCreateStartTime()+"至"+model.getCreateEndTime()+";"+"报检单号:"+getString(model.getDeclNo())+";"+"状态:"+getString(model.getState())+";"+"核查项:"+getString(model.getCheckName()));
        export_recordMapper.insert(exportRecord);
        //更新导入状态
        String Id=exportId;
        if(!Id.equals(""))
        {
            questionMapper.putIsExportById(Id);
        }

    }

    private String getString(String str)
    {
        if(str==null)
        {
            return "全部";
        }
        return str;
    }
}


