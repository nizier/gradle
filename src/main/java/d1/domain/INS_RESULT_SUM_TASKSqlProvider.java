package d1.domain;

import d1.domain.INS_RESULT_SUM_TASK;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.text.MessageFormat;
import java.util.List;

public class INS_RESULT_SUM_TASKSqlProvider {

    //批量删除
    public String batchDelete(@Param("lists") List<INS_RESULT_SUM_TASK> lists) {
        //PRI_KEY为主键
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM INS_RESULT_SUM_TASK WHERE PRI_KEY in (");
        MessageFormat messageFormat = new MessageFormat("#'{'lists[{0}].PRI_KEY}");
        for(int i = 0 ;i<lists.size();i++) {
            sb.append(messageFormat.format(new Integer[]{i}));
            if (i < lists.size() - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    //批量添加
    public String batchInsert(List<INS_RESULT_SUM_TASK> lists) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i<lists.size();i++) {
            INS_RESULT_SUM_TASK record = lists.get(i);
            sb.append(insertSelective(record));
            sb.append(";");
        }
        return sb.toString();
    }

    public String insertSelective(INS_RESULT_SUM_TASK record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("INS_RESULT_SUM_TASK");
        
        if (record.getPriKey() != null) {
            sql.VALUES("PRI_KEY", "#{priKey,jdbcType=VARCHAR}");
        }
        
        if (record.getDeclNo() != null) {
            sql.VALUES("DECL_NO", "#{declNo,jdbcType=VARCHAR}");
        }
        
        if (record.getInsBeginDate() != null) {
            sql.VALUES("INS_BEGIN_DATE", "#{insBeginDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInspEndDate() != null) {
            sql.VALUES("INSP_END_DATE", "#{inspEndDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMnufctrRegNo() != null) {
            sql.VALUES("MNUFCTR_REG_NO", "#{mnufctrRegNo,jdbcType=VARCHAR}");
        }
        
        if (record.getInspBasCatCode() != null) {
            sql.VALUES("INSP_BAS_CAT_CODE", "#{inspBasCatCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExeInspOrgCode() != null) {
            sql.VALUES("EXE_INSP_ORG_CODE", "#{exeInspOrgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExcInspDeptCode() != null) {
            sql.VALUES("EXC_INSP_DEPT_CODE", "#{excInspDeptCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWhetherExteIns() != null) {
            sql.VALUES("WHETHER_EXTE_INS", "#{whetherExteIns,jdbcType=CHAR}");
        }
        
        if (record.getWhether2ndIns() != null) {
            sql.VALUES("WHETHER2ND_INS", "#{whether2ndIns,jdbcType=CHAR}");
        }
        
        if (record.getKepIsolat() != null) {
            sql.VALUES("KEP_ISOLAT", "#{kepIsolat,jdbcType=CHAR}");
        }
        
        if (record.getCiqResultCode() != null) {
            sql.VALUES("CIQ_RESULT_CODE", "#{ciqResultCode,jdbcType=VARCHAR}");
        }
        
        if (record.getInspResltCode() != null) {
            sql.VALUES("INSP_RESLT_CODE", "#{inspResltCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCertTypeCodes() != null) {
            sql.VALUES("CERT_TYPE_CODES", "#{certTypeCodes,jdbcType=VARCHAR}");
        }
        
        if (record.getMarkNo() != null) {
            sql.VALUES("MARK_NO", "#{markNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCiqValidPeri() != null) {
            sql.VALUES("CIQ_VALID_PERI", "#{ciqValidPeri,jdbcType=DECIMAL}");
        }
        
        if (record.getOperatorCode() != null) {
            sql.VALUES("OPERATOR_CODE", "#{operatorCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCertOriginals() != null) {
            sql.VALUES("CERT_ORIGINALS", "#{certOriginals,jdbcType=VARCHAR}");
        }
        
        if (record.getCertCopies() != null) {
            sql.VALUES("CERT_COPIES", "#{certCopies,jdbcType=VARCHAR}");
        }
        
        if (record.getTransFlag() != null) {
            sql.VALUES("TRANS_FLAG", "#{transFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getInspResEval() != null) {
            sql.VALUES("INSP_RES_EVAL", "#{inspResEval,jdbcType=VARCHAR}");
        }
        
        if (record.getQuarResEval() != null) {
            sql.VALUES("QUAR_RES_EVAL", "#{quarResEval,jdbcType=VARCHAR}");
        }
        
        if (record.getWodPackResEval() != null) {
            sql.VALUES("WOD_PACK_RES_EVAL", "#{wodPackResEval,jdbcType=VARCHAR}");
        }
        
        if (record.getInspModeCode() != null) {
            sql.VALUES("INSP_MODE_CODE", "#{inspModeCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOperateTypeCode() != null) {
            sql.VALUES("OPERATE_TYPE_CODE", "#{operateTypeCode,jdbcType=VARCHAR}");
        }
        
        if (record.getFstRelsSrtCode() != null) {
            sql.VALUES("FST_RELS_SRT_CODE", "#{fstRelsSrtCode,jdbcType=CHAR}");
        }
        
        if (record.getNoticeFlag() != null) {
            sql.VALUES("NOTICE_FLAG", "#{noticeFlag,jdbcType=CHAR}");
        }
        
        if (record.getMarkNoStr() != null) {
            sql.VALUES("MARK_NO_STR", "#{markNoStr,jdbcType=VARCHAR}");
        }
        
        if (record.getFlagNoStr() != null) {
            sql.VALUES("FLAG_NO_STR", "#{flagNoStr,jdbcType=VARCHAR}");
        }
        
        if (record.getQuarResult() != null) {
            sql.VALUES("QUAR_RESULT", "#{quarResult,jdbcType=CHAR}");
        }
        
        if (record.getQuarProcResult() != null) {
            sql.VALUES("QUAR_PROC_RESULT", "#{quarProcResult,jdbcType=CHAR}");
        }
        
        if (record.getBasisCoding() != null) {
            sql.VALUES("BASIS_CODING", "#{basisCoding,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckPlace() != null) {
            sql.VALUES("CHECK_PLACE", "#{checkPlace,jdbcType=VARCHAR}");
        }
        
        if (record.getChecker() != null) {
            sql.VALUES("CHECKER", "#{checker,jdbcType=VARCHAR}");
        }
        
        if (record.getSpotDesc() != null) {
            sql.VALUES("SPOT_DESC", "#{spotDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getWoodpackQuarResult() != null) {
            sql.VALUES("WOODPACK_QUAR_RESULT", "#{woodpackQuarResult,jdbcType=CHAR}");
        }
        
        if (record.getContQuarResult() != null) {
            sql.VALUES("CONT_QUAR_RESULT", "#{contQuarResult,jdbcType=CHAR}");
        }
        
        if (record.getGoodsEvalResult() != null) {
            sql.VALUES("GOODS_EVAL_RESULT", "#{goodsEvalResult,jdbcType=CHAR}");
        }
        
        if (record.getContRegiStatus() != null) {
            sql.VALUES("CONT_REGI_STATUS", "#{contRegiStatus,jdbcType=CHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("REMARK", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getFalgArchive() != null) {
            sql.VALUES("FALG_ARCHIVE", "#{falgArchive,jdbcType=CHAR}");
        }
        
        if (record.getOperTime() != null) {
            sql.VALUES("OPER_TIME", "#{operTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getWeatherCode() != null) {
            sql.VALUES("WEATHER_CODE", "#{weatherCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPreMeasBasisCode() != null) {
            sql.VALUES("PRE_MEAS_BASIS_CODE", "#{preMeasBasisCode,jdbcType=VARCHAR}");
        }
        
        if (record.getContNoStr() != null) {
            sql.VALUES("CONT_NO_STR", "#{contNoStr,jdbcType=VARCHAR}");
        }
        
        if (record.getChngResn() != null) {
            sql.VALUES("CHNG_RESN", "#{chngResn,jdbcType=VARCHAR}");
        }
        
        if (record.getInspContCodes() != null) {
            sql.VALUES("INSP_CONT_CODES", "#{inspContCodes,jdbcType=VARCHAR}");
        }
        
        if (record.getArchiveTime() != null) {
            sql.VALUES("ARCHIVE_TIME", "#{archiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFinishDate() != null) {
            sql.VALUES("FINISH_DATE", "#{finishDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getWhether2ndInsSource() != null) {
            sql.VALUES("WHETHER2ND_INS_SOURCE", "#{whether2ndInsSource,jdbcType=CHAR}");
        }
        
        if (record.getTransTypeTj() != null) {
            sql.VALUES("TRANS_TYPE_TJ", "#{transTypeTj,jdbcType=VARCHAR}");
        }
        
        if (record.getOperTimeTj() != null) {
            sql.VALUES("OPER_TIME_TJ", "#{operTimeTj,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIscheck() != null) {
            sql.VALUES("IsCheck", "#{ischeck,jdbcType=DECIMAL}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(INS_RESULT_SUM_TASK record) {
        SQL sql = new SQL();
        sql.UPDATE("INS_RESULT_SUM_TASK");
        
        if (record.getDeclNo() != null) {
            sql.SET("DECL_NO = #{declNo,jdbcType=VARCHAR}");
        }
        
        if (record.getInsBeginDate() != null) {
            sql.SET("INS_BEGIN_DATE = #{insBeginDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInspEndDate() != null) {
            sql.SET("INSP_END_DATE = #{inspEndDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMnufctrRegNo() != null) {
            sql.SET("MNUFCTR_REG_NO = #{mnufctrRegNo,jdbcType=VARCHAR}");
        }
        
        if (record.getInspBasCatCode() != null) {
            sql.SET("INSP_BAS_CAT_CODE = #{inspBasCatCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExeInspOrgCode() != null) {
            sql.SET("EXE_INSP_ORG_CODE = #{exeInspOrgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExcInspDeptCode() != null) {
            sql.SET("EXC_INSP_DEPT_CODE = #{excInspDeptCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWhetherExteIns() != null) {
            sql.SET("WHETHER_EXTE_INS = #{whetherExteIns,jdbcType=CHAR}");
        }
        
        if (record.getWhether2ndIns() != null) {
            sql.SET("WHETHER2ND_INS = #{whether2ndIns,jdbcType=CHAR}");
        }
        
        if (record.getKepIsolat() != null) {
            sql.SET("KEP_ISOLAT = #{kepIsolat,jdbcType=CHAR}");
        }
        
        if (record.getCiqResultCode() != null) {
            sql.SET("CIQ_RESULT_CODE = #{ciqResultCode,jdbcType=VARCHAR}");
        }
        
        if (record.getInspResltCode() != null) {
            sql.SET("INSP_RESLT_CODE = #{inspResltCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCertTypeCodes() != null) {
            sql.SET("CERT_TYPE_CODES = #{certTypeCodes,jdbcType=VARCHAR}");
        }
        
        if (record.getMarkNo() != null) {
            sql.SET("MARK_NO = #{markNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCiqValidPeri() != null) {
            sql.SET("CIQ_VALID_PERI = #{ciqValidPeri,jdbcType=DECIMAL}");
        }
        
        if (record.getOperatorCode() != null) {
            sql.SET("OPERATOR_CODE = #{operatorCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCertOriginals() != null) {
            sql.SET("CERT_ORIGINALS = #{certOriginals,jdbcType=VARCHAR}");
        }
        
        if (record.getCertCopies() != null) {
            sql.SET("CERT_COPIES = #{certCopies,jdbcType=VARCHAR}");
        }
        
        if (record.getTransFlag() != null) {
            sql.SET("TRANS_FLAG = #{transFlag,jdbcType=VARCHAR}");
        }
        
        if (record.getInspResEval() != null) {
            sql.SET("INSP_RES_EVAL = #{inspResEval,jdbcType=VARCHAR}");
        }
        
        if (record.getQuarResEval() != null) {
            sql.SET("QUAR_RES_EVAL = #{quarResEval,jdbcType=VARCHAR}");
        }
        
        if (record.getWodPackResEval() != null) {
            sql.SET("WOD_PACK_RES_EVAL = #{wodPackResEval,jdbcType=VARCHAR}");
        }
        
        if (record.getInspModeCode() != null) {
            sql.SET("INSP_MODE_CODE = #{inspModeCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOperateTypeCode() != null) {
            sql.SET("OPERATE_TYPE_CODE = #{operateTypeCode,jdbcType=VARCHAR}");
        }
        
        if (record.getFstRelsSrtCode() != null) {
            sql.SET("FST_RELS_SRT_CODE = #{fstRelsSrtCode,jdbcType=CHAR}");
        }
        
        if (record.getNoticeFlag() != null) {
            sql.SET("NOTICE_FLAG = #{noticeFlag,jdbcType=CHAR}");
        }
        
        if (record.getMarkNoStr() != null) {
            sql.SET("MARK_NO_STR = #{markNoStr,jdbcType=VARCHAR}");
        }
        
        if (record.getFlagNoStr() != null) {
            sql.SET("FLAG_NO_STR = #{flagNoStr,jdbcType=VARCHAR}");
        }
        
        if (record.getQuarResult() != null) {
            sql.SET("QUAR_RESULT = #{quarResult,jdbcType=CHAR}");
        }
        
        if (record.getQuarProcResult() != null) {
            sql.SET("QUAR_PROC_RESULT = #{quarProcResult,jdbcType=CHAR}");
        }
        
        if (record.getBasisCoding() != null) {
            sql.SET("BASIS_CODING = #{basisCoding,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckPlace() != null) {
            sql.SET("CHECK_PLACE = #{checkPlace,jdbcType=VARCHAR}");
        }
        
        if (record.getChecker() != null) {
            sql.SET("CHECKER = #{checker,jdbcType=VARCHAR}");
        }
        
        if (record.getSpotDesc() != null) {
            sql.SET("SPOT_DESC = #{spotDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getWoodpackQuarResult() != null) {
            sql.SET("WOODPACK_QUAR_RESULT = #{woodpackQuarResult,jdbcType=CHAR}");
        }
        
        if (record.getContQuarResult() != null) {
            sql.SET("CONT_QUAR_RESULT = #{contQuarResult,jdbcType=CHAR}");
        }
        
        if (record.getGoodsEvalResult() != null) {
            sql.SET("GOODS_EVAL_RESULT = #{goodsEvalResult,jdbcType=CHAR}");
        }
        
        if (record.getContRegiStatus() != null) {
            sql.SET("CONT_REGI_STATUS = #{contRegiStatus,jdbcType=CHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("REMARK = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getFalgArchive() != null) {
            sql.SET("FALG_ARCHIVE = #{falgArchive,jdbcType=CHAR}");
        }
        
        if (record.getOperTime() != null) {
            sql.SET("OPER_TIME = #{operTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getWeatherCode() != null) {
            sql.SET("WEATHER_CODE = #{weatherCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPreMeasBasisCode() != null) {
            sql.SET("PRE_MEAS_BASIS_CODE = #{preMeasBasisCode,jdbcType=VARCHAR}");
        }
        
        if (record.getContNoStr() != null) {
            sql.SET("CONT_NO_STR = #{contNoStr,jdbcType=VARCHAR}");
        }
        
        if (record.getChngResn() != null) {
            sql.SET("CHNG_RESN = #{chngResn,jdbcType=VARCHAR}");
        }
        
        if (record.getInspContCodes() != null) {
            sql.SET("INSP_CONT_CODES = #{inspContCodes,jdbcType=VARCHAR}");
        }
        
        if (record.getArchiveTime() != null) {
            sql.SET("ARCHIVE_TIME = #{archiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFinishDate() != null) {
            sql.SET("FINISH_DATE = #{finishDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getWhether2ndInsSource() != null) {
            sql.SET("WHETHER2ND_INS_SOURCE = #{whether2ndInsSource,jdbcType=CHAR}");
        }
        
        if (record.getTransTypeTj() != null) {
            sql.SET("TRANS_TYPE_TJ = #{transTypeTj,jdbcType=VARCHAR}");
        }
        
        if (record.getOperTimeTj() != null) {
            sql.SET("OPER_TIME_TJ = #{operTimeTj,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIscheck() != null) {
            sql.SET("IsCheck = #{ischeck,jdbcType=DECIMAL}");
        }
        
        sql.WHERE("PRI_KEY = #{priKey,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

}