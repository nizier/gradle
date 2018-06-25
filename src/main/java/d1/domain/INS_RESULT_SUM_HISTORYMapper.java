package d1.domain;

import d1.domain.INS_RESULT_SUM_HISTORY;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface INS_RESULT_SUM_HISTORYMapper {
    @Delete({
        "delete from INS_RESULT_SUM_HISTORY",
        " WHERE DECL_NO=#{DECL_NO,jdbcType=VARCHAR}"
    })
    int deleteByDeclNo(String DECL_NO);

    @Insert({
        "insert into INS_RESULT_SUM_HISTORY (PRI_KEY, DECL_NO, ",
        "INS_BEGIN_DATE, INSP_END_DATE, ",
        "MNUFCTR_REG_NO, INSP_BAS_CAT_CODE, ",
        "EXE_INSP_ORG_CODE, EXC_INSP_DEPT_CODE, ",
        "WHETHER_EXTE_INS, WHETHER2ND_INS, ",
        "KEP_ISOLAT, CIQ_RESULT_CODE, ",
        "INSP_RESLT_CODE, CERT_TYPE_CODES, ",
        "MARK_NO, CIQ_VALID_PERI, ",
        "OPERATOR_CODE, CERT_ORIGINALS, ",
        "CERT_COPIES, TRANS_FLAG, ",
        "INSP_RES_EVAL, QUAR_RES_EVAL, ",
        "WOD_PACK_RES_EVAL, INSP_MODE_CODE, ",
        "OPERATE_TYPE_CODE, FST_RELS_SRT_CODE, ",
        "NOTICE_FLAG, MARK_NO_STR, ",
        "FLAG_NO_STR, QUAR_RESULT, ",
        "QUAR_PROC_RESULT, BASIS_CODING, ",
        "CHECK_PLACE, CHECKER, ",
        "SPOT_DESC, WOODPACK_QUAR_RESULT, ",
        "CONT_QUAR_RESULT, GOODS_EVAL_RESULT, ",
        "CONT_REGI_STATUS, REMARK, ",
        "FALG_ARCHIVE, OPER_TIME, ",
        "WEATHER_CODE, PRE_MEAS_BASIS_CODE, ",
        "CONT_NO_STR, CHNG_RESN, ",
        "INSP_CONT_CODES, ARCHIVE_TIME, ",
        "FINISH_DATE, WHETHER2ND_INS_SOURCE, ",
        "TRANS_TYPE_TJ, OPER_TIME_TJ)",
        "values (#{priKey,jdbcType=VARCHAR}, #{declNo,jdbcType=VARCHAR}, ",
        "#{insBeginDate,jdbcType=TIMESTAMP}, #{inspEndDate,jdbcType=TIMESTAMP}, ",
        "#{mnufctrRegNo,jdbcType=VARCHAR}, #{inspBasCatCode,jdbcType=VARCHAR}, ",
        "#{exeInspOrgCode,jdbcType=VARCHAR}, #{excInspDeptCode,jdbcType=VARCHAR}, ",
        "#{whetherExteIns,jdbcType=CHAR}, #{whether2ndIns,jdbcType=CHAR}, ",
        "#{kepIsolat,jdbcType=CHAR}, #{ciqResultCode,jdbcType=VARCHAR}, ",
        "#{inspResltCode,jdbcType=VARCHAR}, #{certTypeCodes,jdbcType=VARCHAR}, ",
        "#{markNo,jdbcType=VARCHAR}, #{ciqValidPeri,jdbcType=DECIMAL}, ",
        "#{operatorCode,jdbcType=VARCHAR}, #{certOriginals,jdbcType=VARCHAR}, ",
        "#{certCopies,jdbcType=VARCHAR}, #{transFlag,jdbcType=VARCHAR}, ",
        "#{inspResEval,jdbcType=VARCHAR}, #{quarResEval,jdbcType=VARCHAR}, ",
        "#{wodPackResEval,jdbcType=VARCHAR}, #{inspModeCode,jdbcType=VARCHAR}, ",
        "#{operateTypeCode,jdbcType=VARCHAR}, #{fstRelsSrtCode,jdbcType=CHAR}, ",
        "#{noticeFlag,jdbcType=CHAR}, #{markNoStr,jdbcType=VARCHAR}, ",
        "#{flagNoStr,jdbcType=VARCHAR}, #{quarResult,jdbcType=CHAR}, ",
        "#{quarProcResult,jdbcType=CHAR}, #{basisCoding,jdbcType=VARCHAR}, ",
        "#{checkPlace,jdbcType=VARCHAR}, #{checker,jdbcType=VARCHAR}, ",
        "#{spotDesc,jdbcType=VARCHAR}, #{woodpackQuarResult,jdbcType=CHAR}, ",
        "#{contQuarResult,jdbcType=CHAR}, #{goodsEvalResult,jdbcType=CHAR}, ",
        "#{contRegiStatus,jdbcType=CHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{falgArchive,jdbcType=CHAR}, #{operTime,jdbcType=TIMESTAMP}, ",
        "#{weatherCode,jdbcType=VARCHAR}, #{preMeasBasisCode,jdbcType=VARCHAR}, ",
        "#{contNoStr,jdbcType=VARCHAR}, #{chngResn,jdbcType=VARCHAR}, ",
        "#{inspContCodes,jdbcType=VARCHAR}, #{archiveTime,jdbcType=TIMESTAMP}, ",
        "#{finishDate,jdbcType=TIMESTAMP}, #{whether2ndInsSource,jdbcType=CHAR}, ",
        "#{transTypeTj,jdbcType=VARCHAR}, #{operTimeTj,jdbcType=TIMESTAMP})"
    })
    int insert(INS_RESULT_SUM_HISTORY record);

    @InsertProvider(type=INS_RESULT_SUM_HISTORYSqlProvider.class, method="insertSelective")
    int insertSelective(INS_RESULT_SUM_HISTORY record);

    @Select({
        "select",
        "PRI_KEY, DECL_NO, INS_BEGIN_DATE, INSP_END_DATE, MNUFCTR_REG_NO, INSP_BAS_CAT_CODE, ",
        "EXE_INSP_ORG_CODE, EXC_INSP_DEPT_CODE, WHETHER_EXTE_INS, WHETHER2ND_INS, KEP_ISOLAT, ",
        "CIQ_RESULT_CODE, INSP_RESLT_CODE, CERT_TYPE_CODES, MARK_NO, CIQ_VALID_PERI, ",
        "OPERATOR_CODE, CERT_ORIGINALS, CERT_COPIES, TRANS_FLAG, INSP_RES_EVAL, QUAR_RES_EVAL, ",
        "WOD_PACK_RES_EVAL, INSP_MODE_CODE, OPERATE_TYPE_CODE, FST_RELS_SRT_CODE, NOTICE_FLAG, ",
        "MARK_NO_STR, FLAG_NO_STR, QUAR_RESULT, QUAR_PROC_RESULT, BASIS_CODING, CHECK_PLACE, ",
        "CHECKER, SPOT_DESC, WOODPACK_QUAR_RESULT, CONT_QUAR_RESULT, GOODS_EVAL_RESULT, ",
        "CONT_REGI_STATUS, REMARK, FALG_ARCHIVE, OPER_TIME, WEATHER_CODE, PRE_MEAS_BASIS_CODE, ",
        "CONT_NO_STR, CHNG_RESN, INSP_CONT_CODES, ARCHIVE_TIME, FINISH_DATE, WHETHER2ND_INS_SOURCE, ",
        "TRANS_TYPE_TJ, OPER_TIME_TJ",
        "from INS_RESULT_SUM_HISTORY",
        "where PRI_KEY = #{priKey,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="PRI_KEY", property="priKey", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="DECL_NO", property="declNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="INS_BEGIN_DATE", property="insBeginDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="INSP_END_DATE", property="inspEndDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MNUFCTR_REG_NO", property="mnufctrRegNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="INSP_BAS_CAT_CODE", property="inspBasCatCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXE_INSP_ORG_CODE", property="exeInspOrgCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXC_INSP_DEPT_CODE", property="excInspDeptCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="WHETHER_EXTE_INS", property="whetherExteIns", jdbcType=JdbcType.CHAR),
        @Result(column="WHETHER2ND_INS", property="whether2ndIns", jdbcType=JdbcType.CHAR),
        @Result(column="KEP_ISOLAT", property="kepIsolat", jdbcType=JdbcType.CHAR),
        @Result(column="CIQ_RESULT_CODE", property="ciqResultCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="INSP_RESLT_CODE", property="inspResltCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="CERT_TYPE_CODES", property="certTypeCodes", jdbcType=JdbcType.VARCHAR),
        @Result(column="MARK_NO", property="markNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="CIQ_VALID_PERI", property="ciqValidPeri", jdbcType=JdbcType.DECIMAL),
        @Result(column="OPERATOR_CODE", property="operatorCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="CERT_ORIGINALS", property="certOriginals", jdbcType=JdbcType.VARCHAR),
        @Result(column="CERT_COPIES", property="certCopies", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRANS_FLAG", property="transFlag", jdbcType=JdbcType.VARCHAR),
        @Result(column="INSP_RES_EVAL", property="inspResEval", jdbcType=JdbcType.VARCHAR),
        @Result(column="QUAR_RES_EVAL", property="quarResEval", jdbcType=JdbcType.VARCHAR),
        @Result(column="WOD_PACK_RES_EVAL", property="wodPackResEval", jdbcType=JdbcType.VARCHAR),
        @Result(column="INSP_MODE_CODE", property="inspModeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATE_TYPE_CODE", property="operateTypeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="FST_RELS_SRT_CODE", property="fstRelsSrtCode", jdbcType=JdbcType.CHAR),
        @Result(column="NOTICE_FLAG", property="noticeFlag", jdbcType=JdbcType.CHAR),
        @Result(column="MARK_NO_STR", property="markNoStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="FLAG_NO_STR", property="flagNoStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="QUAR_RESULT", property="quarResult", jdbcType=JdbcType.CHAR),
        @Result(column="QUAR_PROC_RESULT", property="quarProcResult", jdbcType=JdbcType.CHAR),
        @Result(column="BASIS_CODING", property="basisCoding", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHECK_PLACE", property="checkPlace", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHECKER", property="checker", jdbcType=JdbcType.VARCHAR),
        @Result(column="SPOT_DESC", property="spotDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="WOODPACK_QUAR_RESULT", property="woodpackQuarResult", jdbcType=JdbcType.CHAR),
        @Result(column="CONT_QUAR_RESULT", property="contQuarResult", jdbcType=JdbcType.CHAR),
        @Result(column="GOODS_EVAL_RESULT", property="goodsEvalResult", jdbcType=JdbcType.CHAR),
        @Result(column="CONT_REGI_STATUS", property="contRegiStatus", jdbcType=JdbcType.CHAR),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="FALG_ARCHIVE", property="falgArchive", jdbcType=JdbcType.CHAR),
        @Result(column="OPER_TIME", property="operTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="WEATHER_CODE", property="weatherCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRE_MEAS_BASIS_CODE", property="preMeasBasisCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONT_NO_STR", property="contNoStr", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHNG_RESN", property="chngResn", jdbcType=JdbcType.VARCHAR),
        @Result(column="INSP_CONT_CODES", property="inspContCodes", jdbcType=JdbcType.VARCHAR),
        @Result(column="ARCHIVE_TIME", property="archiveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="FINISH_DATE", property="finishDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="WHETHER2ND_INS_SOURCE", property="whether2ndInsSource", jdbcType=JdbcType.CHAR),
        @Result(column="TRANS_TYPE_TJ", property="transTypeTj", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPER_TIME_TJ", property="operTimeTj", jdbcType=JdbcType.TIMESTAMP)
    })
    INS_RESULT_SUM_HISTORY selectByPrimaryKey(String priKey);

    @UpdateProvider(type=INS_RESULT_SUM_HISTORYSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(INS_RESULT_SUM_HISTORY record);

    @Update({
        "update INS_RESULT_SUM_HISTORY",
        "set DECL_NO = #{declNo,jdbcType=VARCHAR},",
          "INS_BEGIN_DATE = #{insBeginDate,jdbcType=TIMESTAMP},",
          "INSP_END_DATE = #{inspEndDate,jdbcType=TIMESTAMP},",
          "MNUFCTR_REG_NO = #{mnufctrRegNo,jdbcType=VARCHAR},",
          "INSP_BAS_CAT_CODE = #{inspBasCatCode,jdbcType=VARCHAR},",
          "EXE_INSP_ORG_CODE = #{exeInspOrgCode,jdbcType=VARCHAR},",
          "EXC_INSP_DEPT_CODE = #{excInspDeptCode,jdbcType=VARCHAR},",
          "WHETHER_EXTE_INS = #{whetherExteIns,jdbcType=CHAR},",
          "WHETHER2ND_INS = #{whether2ndIns,jdbcType=CHAR},",
          "KEP_ISOLAT = #{kepIsolat,jdbcType=CHAR},",
          "CIQ_RESULT_CODE = #{ciqResultCode,jdbcType=VARCHAR},",
          "INSP_RESLT_CODE = #{inspResltCode,jdbcType=VARCHAR},",
          "CERT_TYPE_CODES = #{certTypeCodes,jdbcType=VARCHAR},",
          "MARK_NO = #{markNo,jdbcType=VARCHAR},",
          "CIQ_VALID_PERI = #{ciqValidPeri,jdbcType=DECIMAL},",
          "OPERATOR_CODE = #{operatorCode,jdbcType=VARCHAR},",
          "CERT_ORIGINALS = #{certOriginals,jdbcType=VARCHAR},",
          "CERT_COPIES = #{certCopies,jdbcType=VARCHAR},",
          "TRANS_FLAG = #{transFlag,jdbcType=VARCHAR},",
          "INSP_RES_EVAL = #{inspResEval,jdbcType=VARCHAR},",
          "QUAR_RES_EVAL = #{quarResEval,jdbcType=VARCHAR},",
          "WOD_PACK_RES_EVAL = #{wodPackResEval,jdbcType=VARCHAR},",
          "INSP_MODE_CODE = #{inspModeCode,jdbcType=VARCHAR},",
          "OPERATE_TYPE_CODE = #{operateTypeCode,jdbcType=VARCHAR},",
          "FST_RELS_SRT_CODE = #{fstRelsSrtCode,jdbcType=CHAR},",
          "NOTICE_FLAG = #{noticeFlag,jdbcType=CHAR},",
          "MARK_NO_STR = #{markNoStr,jdbcType=VARCHAR},",
          "FLAG_NO_STR = #{flagNoStr,jdbcType=VARCHAR},",
          "QUAR_RESULT = #{quarResult,jdbcType=CHAR},",
          "QUAR_PROC_RESULT = #{quarProcResult,jdbcType=CHAR},",
          "BASIS_CODING = #{basisCoding,jdbcType=VARCHAR},",
          "CHECK_PLACE = #{checkPlace,jdbcType=VARCHAR},",
          "CHECKER = #{checker,jdbcType=VARCHAR},",
          "SPOT_DESC = #{spotDesc,jdbcType=VARCHAR},",
          "WOODPACK_QUAR_RESULT = #{woodpackQuarResult,jdbcType=CHAR},",
          "CONT_QUAR_RESULT = #{contQuarResult,jdbcType=CHAR},",
          "GOODS_EVAL_RESULT = #{goodsEvalResult,jdbcType=CHAR},",
          "CONT_REGI_STATUS = #{contRegiStatus,jdbcType=CHAR},",
          "REMARK = #{remark,jdbcType=VARCHAR},",
          "FALG_ARCHIVE = #{falgArchive,jdbcType=CHAR},",
          "OPER_TIME = #{operTime,jdbcType=TIMESTAMP},",
          "WEATHER_CODE = #{weatherCode,jdbcType=VARCHAR},",
          "PRE_MEAS_BASIS_CODE = #{preMeasBasisCode,jdbcType=VARCHAR},",
          "CONT_NO_STR = #{contNoStr,jdbcType=VARCHAR},",
          "CHNG_RESN = #{chngResn,jdbcType=VARCHAR},",
          "INSP_CONT_CODES = #{inspContCodes,jdbcType=VARCHAR},",
          "ARCHIVE_TIME = #{archiveTime,jdbcType=TIMESTAMP},",
          "FINISH_DATE = #{finishDate,jdbcType=TIMESTAMP},",
          "WHETHER2ND_INS_SOURCE = #{whether2ndInsSource,jdbcType=CHAR},",
          "TRANS_TYPE_TJ = #{transTypeTj,jdbcType=VARCHAR},",
          "OPER_TIME_TJ = #{operTimeTj,jdbcType=TIMESTAMP}",
        "where PRI_KEY = #{priKey,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(INS_RESULT_SUM_HISTORY record);

    @Delete({"DELETE FROM INS_RESULT_SUM_HISTORY WHERE \"OPER_TIME_TJ\"<=to_date(#{strBeforeDate,jdbcType=VARCHAR}, 'yyyy-mm-dd')"})
    int deleteRESULT_SUMhistoryData(String strBeforeDate);
}