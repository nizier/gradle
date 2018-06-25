package d1.web;

import d1.domain.*;
import d1.service.DeleteService;
import d1.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;
@RestController
public class DeleteDataController {

    private Hashtable<String,Object> mappers = new Hashtable<String,Object>();

    @Autowired
    DCL_IO_DECL_HISTORYMapper dcl_io_decl_historyMapper;
    @Autowired
    DCL_IO_DECL_TASKMapper dcl_io_decl_taskMapper;
    @Autowired
    INS_RESULT_SUM_TASKMapper ins_result_sum__taskMapper;
    @Autowired
    INS_RESULT_SUM_HISTORYMapper ins_result_sum_historyMapper;
    @Autowired
    INS_RESULT_GOODS_TASKMapper ins_result_goods_taskMapper;
    @Autowired
    INS_RESULT_GOODS_HISTORYMapper ins_result_goods_historyMapper;
    @Autowired
    DCL_IO_DECL_GOODS_TASKMapper dcl_io_decl_goods_taskMapper;
    @Autowired
    DCL_IO_DECL_GOODS_HISTORYMapper dcl_io_decl_goods_historyMapper;
    @Autowired
    QUESTIONMapper questionMapper;
    @Autowired
    CHECK_CONFIGMapper check_configMapper;
    @Autowired
    DM_C_HS_LEVELMapper dm_c_hs_levelMapper;
    @Autowired
    DM_C_MEASUREMENT_UNITMapper dm_c_measurement_unitMapper;
    @Autowired
    DM_C_COUNTRYMapper dm_c_countryMapper;
    @Autowired
    DM_C_Z_BBD_HS_CODEMapper dm_c_z_bbd_hs_codeMapper;
    @Autowired
    DM_C_CHINA_DISTRIC_LEVELMapper dm_c_china_distric_levelMapper;
    @Autowired
    CHECK_LOGMapper check_logMapper;
    public CHECK_CONFIGMapper getCHECK_CONFIGMapper(){
        return check_configMapper;
    }

    @RequestMapping(value = "/startdeletetask", method = RequestMethod.GET)
    public String deleteData()
    {
        if(mappers.isEmpty()){
            mappers.put("DCL_IO_DECL_HISTORY",dcl_io_decl_historyMapper);
            mappers.put("DCL_IO_DECL_TASK",dcl_io_decl_taskMapper);
            mappers.put("INS_RESULT_SUM_TASK",ins_result_sum__taskMapper);
            mappers.put("INS_RESULT_SUM_HISTORY",ins_result_sum_historyMapper);
            mappers.put("INS_RESULT_GOODS_TASK",ins_result_goods_taskMapper);
            mappers.put("INS_RESULT_GOODS_HISTORY",ins_result_goods_historyMapper);
            mappers.put("DCL_IO_DECL_GOODS_TASK",dcl_io_decl_goods_taskMapper);
            mappers.put("DCL_IO_DECL_GOODS_HISTORY",dcl_io_decl_goods_historyMapper);
            mappers.put("QUESTION",questionMapper);
            mappers.put("DM_C_HS_LEVEL",dm_c_hs_levelMapper);
            mappers.put("DM_C_MEASUREMENT_UNIT",dm_c_measurement_unitMapper);
            mappers.put("DM_C_COUNTRY",dm_c_countryMapper);
            mappers.put("DM_C_Z_BBD_HS_CODE",dm_c_z_bbd_hs_codeMapper);
            mappers.put("DM_C_CHINA_DISTRIC_LEVEL",dm_c_china_distric_levelMapper);
            mappers.put("CHECK_CONFIG",check_configMapper);
            LoggerService.Instance().setLoggerMapper(check_logMapper);
        }

        new Thread(new DeleteService(mappers)).start();
        return "start delete task...";
    }
}
