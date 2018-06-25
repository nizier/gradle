package d1.domain;

import d1.domain.DCL_IO_DECL_GOODS_HISTORY;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Mapper
public interface DCL_IO_DECL_GOODS_HISTORYMapper {
    @Insert({
        "insert into DCL_IO_DECL_GOODS_HISTORY (GOODS_ID, DECL_NO, ",
        "GOODS_NO, PROD_HS_CODE, ",
        "HS_CODE_DESC, INSP_TYPE, ",
        "CIQ_CODE, CIQ_NAME, ",
        "CIQ_CLASSIFY_CODE, CIQ_CLASSIFY_NAME, ",
        "DECL_GOODS_CNAME, DECL_GOODS_ENAME, ",
        "QTY, QTY_MEAS_UNIT, ",
        "WEIGHT, WT_MEAS_UNIT, ",
        "STD_QTY, GOODS_TOTAL_VAL, ",
        "CURRENCY, PRICE_PER_UNIT, ",
        "GOODS_SPEC, GOODS_MODEL, ",
        "GOODS_BRAND, ORI_CTRY_CODE, ",
        "ORIG_PLACE_CODE, PURPOSE, ",
        "PRODUCE_DATE, PROD_BATCH_NO, ",
        "PROD_VALID_DT, PROD_QGP, ",
        "GOODS_ATTR, STUFF, ",
        "UN_CODE, DANG_NAME, ",
        "PACK_TYPE, PACK_SPEC, ",
        "CUSTM_SPV_COND, PROD_TAG_PIC, ",
        "IS_LIST_GOODS, CABIN_NO, ",
        "WAGON_NO, TOTAL_VAL_US, ",
        "TOTAL_VAL_CN, MNUFCTR_REG_NO, ",
        "BY1, BY2, OPER_TIME, ",
        "FALG_ARCHIVE, ENG_MAN_ENT_CNM, ",
        "SITUATION_CODE, SITUATION_LEVEL, ",
        "STD_QTY_UNIT_CODE, STD_WEIGHT, ",
        "STD_WEIGHT_UNIT_CODE, RATE, ",
        "MNUFCTR_REG_NAME, ARCHIVE_TIME, ",
        "NO_DANG_FLAG, BY3, BY4, ",
        "INSP_PATTERN_CODE, WT_DET_MODE_CODE, ",
        "WT_DET_WORK_MODE, DCL_IO_DECL_ID, ",
        "GOODS_CHECK_REQ, PRI_KEY, ",
        "TRANS_TYPE_TJ, OPER_TIME_TJ)",
        "values (#{goodsId,jdbcType=VARCHAR}, #{declNo,jdbcType=VARCHAR}, ",
        "#{goodsNo,jdbcType=DECIMAL}, #{prodHsCode,jdbcType=VARCHAR}, ",
        "#{hsCodeDesc,jdbcType=VARCHAR}, #{inspType,jdbcType=VARCHAR}, ",
        "#{ciqCode,jdbcType=VARCHAR}, #{ciqName,jdbcType=VARCHAR}, ",
        "#{ciqClassifyCode,jdbcType=VARCHAR}, #{ciqClassifyName,jdbcType=VARCHAR}, ",
        "#{declGoodsCname,jdbcType=VARCHAR}, #{declGoodsEname,jdbcType=VARCHAR}, ",
        "#{qty,jdbcType=DECIMAL}, #{qtyMeasUnit,jdbcType=VARCHAR}, ",
        "#{weight,jdbcType=DECIMAL}, #{wtMeasUnit,jdbcType=VARCHAR}, ",
        "#{stdQty,jdbcType=DECIMAL}, #{goodsTotalVal,jdbcType=DECIMAL}, ",
        "#{currency,jdbcType=VARCHAR}, #{pricePerUnit,jdbcType=DECIMAL}, ",
        "#{goodsSpec,jdbcType=VARCHAR}, #{goodsModel,jdbcType=VARCHAR}, ",
        "#{goodsBrand,jdbcType=VARCHAR}, #{oriCtryCode,jdbcType=VARCHAR}, ",
        "#{origPlaceCode,jdbcType=VARCHAR}, #{purpose,jdbcType=VARCHAR}, ",
        "#{produceDate,jdbcType=VARCHAR}, #{prodBatchNo,jdbcType=VARCHAR}, ",
        "#{prodValidDt,jdbcType=TIMESTAMP}, #{prodQgp,jdbcType=DECIMAL}, ",
        "#{goodsAttr,jdbcType=VARCHAR}, #{stuff,jdbcType=VARCHAR}, ",
        "#{unCode,jdbcType=VARCHAR}, #{dangName,jdbcType=VARCHAR}, ",
        "#{packType,jdbcType=VARCHAR}, #{packSpec,jdbcType=VARCHAR}, ",
        "#{custmSpvCond,jdbcType=VARCHAR}, #{prodTagPic,jdbcType=VARCHAR}, ",
        "#{isListGoods,jdbcType=CHAR}, #{cabinNo,jdbcType=VARCHAR}, ",
        "#{wagonNo,jdbcType=VARCHAR}, #{totalValUs,jdbcType=DECIMAL}, ",
        "#{totalValCn,jdbcType=DECIMAL}, #{mnufctrRegNo,jdbcType=VARCHAR}, ",
        "#{by1,jdbcType=VARCHAR}, #{by2,jdbcType=VARCHAR}, #{operTime,jdbcType=TIMESTAMP}, ",
        "#{falgArchive,jdbcType=CHAR}, #{engManEntCnm,jdbcType=VARCHAR}, ",
        "#{situationCode,jdbcType=VARCHAR}, #{situationLevel,jdbcType=VARCHAR}, ",
        "#{stdQtyUnitCode,jdbcType=VARCHAR}, #{stdWeight,jdbcType=DECIMAL}, ",
        "#{stdWeightUnitCode,jdbcType=VARCHAR}, #{rate,jdbcType=DECIMAL}, ",
        "#{mnufctrRegName,jdbcType=VARCHAR}, #{archiveTime,jdbcType=TIMESTAMP}, ",
        "#{noDangFlag,jdbcType=CHAR}, #{by3,jdbcType=VARCHAR}, #{by4,jdbcType=VARCHAR}, ",
        "#{inspPatternCode,jdbcType=VARCHAR}, #{wtDetModeCode,jdbcType=VARCHAR}, ",
        "#{wtDetWorkMode,jdbcType=CHAR}, #{dclIoDeclId,jdbcType=VARCHAR}, ",
        "#{goodsCheckReq,jdbcType=VARCHAR}, #{priKey,jdbcType=VARCHAR}, ",
        "#{transTypeTj,jdbcType=VARCHAR}, #{operTimeTj,jdbcType=TIMESTAMP})"
    })
    int insert(DCL_IO_DECL_GOODS_HISTORY record);

    @Delete({"DELETE FROM DCL_IO_DECL_GOODS_HISTORY WHERE DECL_NO=#{DECL_NO,jdbcType=VARCHAR}"})
    int deleteDECL_NO(String DECL_NO);

    @InsertProvider(type=DCL_IO_DECL_GOODS_HISTORYSqlProvider.class, method="insertSelective")
    int insertSelective(DCL_IO_DECL_GOODS_HISTORY record);

    //根据报检单号，货物号，产品HS编号查找报检单详细信息
    @Select("SELECT * FROM DCL_IO_DECL_GOODS_HISTORY WHERE GOODS_NO=#{GOODS_NO,jdbcType=DECIMAL} AND DECL_NO=#{DECL_NO,jdbcType=VARCHAR}")
    @Results({
            @Result(column="PRI_KEY", property="priKey", jdbcType= JdbcType.VARCHAR),
            @Result(column="GOODS_ID", property="goodsId", jdbcType=JdbcType.VARCHAR),
            @Result(column="DECL_NO", property="declNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="GOODS_NO", property="goodsNo", jdbcType=JdbcType.DECIMAL),
            @Result(column="PROD_HS_CODE", property="prodHsCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="HS_CODE_DESC", property="hsCodeDesc", jdbcType=JdbcType.VARCHAR),
            @Result(column="INSP_TYPE", property="inspType", jdbcType=JdbcType.VARCHAR),
            @Result(column="CIQ_CODE", property="ciqCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="CIQ_NAME", property="ciqName", jdbcType=JdbcType.VARCHAR),
            @Result(column="CIQ_CLASSIFY_CODE", property="ciqClassifyCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="CIQ_CLASSIFY_NAME", property="ciqClassifyName", jdbcType=JdbcType.VARCHAR),
            @Result(column="DECL_GOODS_CNAME", property="declGoodsCname", jdbcType=JdbcType.VARCHAR),
            @Result(column="DECL_GOODS_ENAME", property="declGoodsEname", jdbcType=JdbcType.VARCHAR),
            @Result(column="QTY", property="qty", jdbcType=JdbcType.DECIMAL),
            @Result(column="QTY_MEAS_UNIT", property="qtyMeasUnit", jdbcType=JdbcType.VARCHAR),
            @Result(column="WEIGHT", property="weight", jdbcType=JdbcType.DECIMAL),
            @Result(column="WT_MEAS_UNIT", property="wtMeasUnit", jdbcType=JdbcType.VARCHAR),
            @Result(column="STD_QTY", property="stdQty", jdbcType=JdbcType.DECIMAL),
            @Result(column="GOODS_TOTAL_VAL", property="goodsTotalVal", jdbcType=JdbcType.DECIMAL),
            @Result(column="CURRENCY", property="currency", jdbcType=JdbcType.VARCHAR),
            @Result(column="PRICE_PER_UNIT", property="pricePerUnit", jdbcType=JdbcType.DECIMAL),
            @Result(column="GOODS_SPEC", property="goodsSpec", jdbcType=JdbcType.VARCHAR),
            @Result(column="GOODS_MODEL", property="goodsModel", jdbcType=JdbcType.VARCHAR),
            @Result(column="GOODS_BRAND", property="goodsBrand", jdbcType=JdbcType.VARCHAR),
            @Result(column="ORI_CTRY_CODE", property="oriCtryCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="ORIG_PLACE_CODE", property="origPlaceCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="PURPOSE", property="purpose", jdbcType=JdbcType.VARCHAR),
            @Result(column="PRODUCE_DATE", property="produceDate", jdbcType=JdbcType.VARCHAR),
            @Result(column="PROD_BATCH_NO", property="prodBatchNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="PROD_VALID_DT", property="prodValidDt", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="PROD_QGP", property="prodQgp", jdbcType=JdbcType.DECIMAL),
            @Result(column="GOODS_ATTR", property="goodsAttr", jdbcType=JdbcType.VARCHAR),
            @Result(column="STUFF", property="stuff", jdbcType=JdbcType.VARCHAR),
            @Result(column="UN_CODE", property="unCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="DANG_NAME", property="dangName", jdbcType=JdbcType.VARCHAR),
            @Result(column="PACK_TYPE", property="packType", jdbcType=JdbcType.VARCHAR),
            @Result(column="PACK_SPEC", property="packSpec", jdbcType=JdbcType.VARCHAR),
            @Result(column="CUSTM_SPV_COND", property="custmSpvCond", jdbcType=JdbcType.VARCHAR),
            @Result(column="PROD_TAG_PIC", property="prodTagPic", jdbcType=JdbcType.VARCHAR),
            @Result(column="IS_LIST_GOODS", property="isListGoods", jdbcType=JdbcType.CHAR),
            @Result(column="CABIN_NO", property="cabinNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="WAGON_NO", property="wagonNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="TOTAL_VAL_US", property="totalValUs", jdbcType=JdbcType.DECIMAL),
            @Result(column="TOTAL_VAL_CN", property="totalValCn", jdbcType=JdbcType.DECIMAL),
            @Result(column="MNUFCTR_REG_NO", property="mnufctrRegNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="BY1", property="by1", jdbcType=JdbcType.VARCHAR),
            @Result(column="BY2", property="by2", jdbcType=JdbcType.VARCHAR),
            @Result(column="OPER_TIME", property="operTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="FALG_ARCHIVE", property="falgArchive", jdbcType=JdbcType.CHAR),
            @Result(column="ENG_MAN_ENT_CNM", property="engManEntCnm", jdbcType=JdbcType.VARCHAR),
            @Result(column="SITUATION_CODE", property="situationCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="SITUATION_LEVEL", property="situationLevel", jdbcType=JdbcType.VARCHAR),
            @Result(column="STD_QTY_UNIT_CODE", property="stdQtyUnitCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="STD_WEIGHT", property="stdWeight", jdbcType=JdbcType.DECIMAL),
            @Result(column="STD_WEIGHT_UNIT_CODE", property="stdWeightUnitCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="RATE", property="rate", jdbcType=JdbcType.DECIMAL),
            @Result(column="MNUFCTR_REG_NAME", property="mnufctrRegName", jdbcType=JdbcType.VARCHAR),
            @Result(column="ARCHIVE_TIME", property="archiveTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="NO_DANG_FLAG", property="noDangFlag", jdbcType=JdbcType.CHAR),
            @Result(column="BY3", property="by3", jdbcType= JdbcType.VARCHAR),
            @Result(column="BY4", property="by4", jdbcType=JdbcType.VARCHAR),
            @Result(column="INSP_PATTERN_CODE", property="inspPatternCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="WT_DET_MODE_CODE", property="wtDetModeCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="WT_DET_WORK_MODE", property="wtDetWorkMode", jdbcType=JdbcType.CHAR),
            @Result(column="DCL_IO_DECL_ID", property="dclIoDeclId", jdbcType=JdbcType.VARCHAR),
            @Result(column="GOODS_CHECK_REQ", property="goodsCheckReq", jdbcType=JdbcType.VARCHAR),
            @Result(column="TRANS_TYPE_TJ", property="transTypeTj", jdbcType=JdbcType.VARCHAR),
            @Result(column="OPER_TIME_TJ", property="operTimeTj", jdbcType=JdbcType.TIMESTAMP)
    })
    DCL_IO_DECL_GOODS_TASK getDclIoDeclGoodsTaskHistoryDetailInfo(@Param("GOODS_NO") BigDecimal GOODS_NO,@Param("DECL_NO") String DECL_NO);

    @Delete({"DELETE FROM DCL_IO_DECL_GOODS_HISTORY WHERE \"OPER_TIME_TJ\"<=to_date(#{strBeforeDate,jdbcType=VARCHAR}, 'yyyy-mm-dd')"})
    int deleteIO_DECL_GOODShistoryData(String strBeforeDate);
}