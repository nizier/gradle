package d1.domain;

import d1.domain.DCL_IO_DECL_GOODS_TASK;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.text.MessageFormat;
import java.util.List;

public class DCL_IO_DECL_GOODS_TASKSqlProvider {

    //批量删除
    public String batchDelete(@Param("lists") List<DCL_IO_DECL_GOODS_TASK> lists) {
        //GOODS_ID为主键
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM DCL_IO_DECL_GOODS_TASK WHERE GOODS_ID in (");
        MessageFormat messageFormat = new MessageFormat("#'{'lists[{0}].GOODS_ID}");
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
    public String batchInsert(List<DCL_IO_DECL_GOODS_TASK> lists) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i<lists.size();i++) {
            DCL_IO_DECL_GOODS_TASK record = lists.get(i);
            sb.append(insertSelective(record));
            sb.append(";");
        }
        return sb.toString();
    }

    public String insertSelective(DCL_IO_DECL_GOODS_TASK record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("DCL_IO_DECL_GOODS_TASK");
        
        if (record.getGoodsId() != null) {
            sql.VALUES("GOODS_ID", "#{goodsId,jdbcType=VARCHAR}");
        }
        
        if (record.getDeclNo() != null) {
            sql.VALUES("DECL_NO", "#{declNo,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsNo() != null) {
            sql.VALUES("GOODS_NO", "#{goodsNo,jdbcType=DECIMAL}");
        }
        
        if (record.getProdHsCode() != null) {
            sql.VALUES("PROD_HS_CODE", "#{prodHsCode,jdbcType=VARCHAR}");
        }
        
        if (record.getHsCodeDesc() != null) {
            sql.VALUES("HS_CODE_DESC", "#{hsCodeDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getInspType() != null) {
            sql.VALUES("INSP_TYPE", "#{inspType,jdbcType=VARCHAR}");
        }
        
        if (record.getCiqCode() != null) {
            sql.VALUES("CIQ_CODE", "#{ciqCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCiqName() != null) {
            sql.VALUES("CIQ_NAME", "#{ciqName,jdbcType=VARCHAR}");
        }
        
        if (record.getCiqClassifyCode() != null) {
            sql.VALUES("CIQ_CLASSIFY_CODE", "#{ciqClassifyCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCiqClassifyName() != null) {
            sql.VALUES("CIQ_CLASSIFY_NAME", "#{ciqClassifyName,jdbcType=VARCHAR}");
        }
        
        if (record.getDeclGoodsCname() != null) {
            sql.VALUES("DECL_GOODS_CNAME", "#{declGoodsCname,jdbcType=VARCHAR}");
        }
        
        if (record.getDeclGoodsEname() != null) {
            sql.VALUES("DECL_GOODS_ENAME", "#{declGoodsEname,jdbcType=VARCHAR}");
        }
        
        if (record.getQty() != null) {
            sql.VALUES("QTY", "#{qty,jdbcType=DECIMAL}");
        }
        
        if (record.getQtyMeasUnit() != null) {
            sql.VALUES("QTY_MEAS_UNIT", "#{qtyMeasUnit,jdbcType=VARCHAR}");
        }
        
        if (record.getWeight() != null) {
            sql.VALUES("WEIGHT", "#{weight,jdbcType=DECIMAL}");
        }
        
        if (record.getWtMeasUnit() != null) {
            sql.VALUES("WT_MEAS_UNIT", "#{wtMeasUnit,jdbcType=VARCHAR}");
        }
        
        if (record.getStdQty() != null) {
            sql.VALUES("STD_QTY", "#{stdQty,jdbcType=DECIMAL}");
        }
        
        if (record.getGoodsTotalVal() != null) {
            sql.VALUES("GOODS_TOTAL_VAL", "#{goodsTotalVal,jdbcType=DECIMAL}");
        }
        
        if (record.getCurrency() != null) {
            sql.VALUES("CURRENCY", "#{currency,jdbcType=VARCHAR}");
        }
        
        if (record.getPricePerUnit() != null) {
            sql.VALUES("PRICE_PER_UNIT", "#{pricePerUnit,jdbcType=DECIMAL}");
        }
        
        if (record.getGoodsSpec() != null) {
            sql.VALUES("GOODS_SPEC", "#{goodsSpec,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsModel() != null) {
            sql.VALUES("GOODS_MODEL", "#{goodsModel,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsBrand() != null) {
            sql.VALUES("GOODS_BRAND", "#{goodsBrand,jdbcType=VARCHAR}");
        }
        
        if (record.getOriCtryCode() != null) {
            sql.VALUES("ORI_CTRY_CODE", "#{oriCtryCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOrigPlaceCode() != null) {
            sql.VALUES("ORIG_PLACE_CODE", "#{origPlaceCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPurpose() != null) {
            sql.VALUES("PURPOSE", "#{purpose,jdbcType=VARCHAR}");
        }
        
        if (record.getProduceDate() != null) {
            sql.VALUES("PRODUCE_DATE", "#{produceDate,jdbcType=VARCHAR}");
        }
        
        if (record.getProdBatchNo() != null) {
            sql.VALUES("PROD_BATCH_NO", "#{prodBatchNo,jdbcType=VARCHAR}");
        }
        
        if (record.getProdValidDt() != null) {
            sql.VALUES("PROD_VALID_DT", "#{prodValidDt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProdQgp() != null) {
            sql.VALUES("PROD_QGP", "#{prodQgp,jdbcType=DECIMAL}");
        }
        
        if (record.getGoodsAttr() != null) {
            sql.VALUES("GOODS_ATTR", "#{goodsAttr,jdbcType=VARCHAR}");
        }
        
        if (record.getStuff() != null) {
            sql.VALUES("STUFF", "#{stuff,jdbcType=VARCHAR}");
        }
        
        if (record.getUnCode() != null) {
            sql.VALUES("UN_CODE", "#{unCode,jdbcType=VARCHAR}");
        }
        
        if (record.getDangName() != null) {
            sql.VALUES("DANG_NAME", "#{dangName,jdbcType=VARCHAR}");
        }
        
        if (record.getPackType() != null) {
            sql.VALUES("PACK_TYPE", "#{packType,jdbcType=VARCHAR}");
        }
        
        if (record.getPackSpec() != null) {
            sql.VALUES("PACK_SPEC", "#{packSpec,jdbcType=VARCHAR}");
        }
        
        if (record.getCustmSpvCond() != null) {
            sql.VALUES("CUSTM_SPV_COND", "#{custmSpvCond,jdbcType=VARCHAR}");
        }
        
        if (record.getProdTagPic() != null) {
            sql.VALUES("PROD_TAG_PIC", "#{prodTagPic,jdbcType=VARCHAR}");
        }
        
        if (record.getIsListGoods() != null) {
            sql.VALUES("IS_LIST_GOODS", "#{isListGoods,jdbcType=CHAR}");
        }
        
        if (record.getCabinNo() != null) {
            sql.VALUES("CABIN_NO", "#{cabinNo,jdbcType=VARCHAR}");
        }
        
        if (record.getWagonNo() != null) {
            sql.VALUES("WAGON_NO", "#{wagonNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalValUs() != null) {
            sql.VALUES("TOTAL_VAL_US", "#{totalValUs,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalValCn() != null) {
            sql.VALUES("TOTAL_VAL_CN", "#{totalValCn,jdbcType=DECIMAL}");
        }
        
        if (record.getMnufctrRegNo() != null) {
            sql.VALUES("MNUFCTR_REG_NO", "#{mnufctrRegNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBy1() != null) {
            sql.VALUES("BY1", "#{by1,jdbcType=VARCHAR}");
        }
        
        if (record.getBy2() != null) {
            sql.VALUES("BY2", "#{by2,jdbcType=VARCHAR}");
        }
        
        if (record.getOperTime() != null) {
            sql.VALUES("OPER_TIME", "#{operTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFalgArchive() != null) {
            sql.VALUES("FALG_ARCHIVE", "#{falgArchive,jdbcType=CHAR}");
        }
        
        if (record.getEngManEntCnm() != null) {
            sql.VALUES("ENG_MAN_ENT_CNM", "#{engManEntCnm,jdbcType=VARCHAR}");
        }
        
        if (record.getSituationCode() != null) {
            sql.VALUES("SITUATION_CODE", "#{situationCode,jdbcType=VARCHAR}");
        }
        
        if (record.getSituationLevel() != null) {
            sql.VALUES("SITUATION_LEVEL", "#{situationLevel,jdbcType=VARCHAR}");
        }
        
        if (record.getStdQtyUnitCode() != null) {
            sql.VALUES("STD_QTY_UNIT_CODE", "#{stdQtyUnitCode,jdbcType=VARCHAR}");
        }
        
        if (record.getStdWeight() != null) {
            sql.VALUES("STD_WEIGHT", "#{stdWeight,jdbcType=DECIMAL}");
        }
        
        if (record.getStdWeightUnitCode() != null) {
            sql.VALUES("STD_WEIGHT_UNIT_CODE", "#{stdWeightUnitCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRate() != null) {
            sql.VALUES("RATE", "#{rate,jdbcType=DECIMAL}");
        }
        
        if (record.getMnufctrRegName() != null) {
            sql.VALUES("MNUFCTR_REG_NAME", "#{mnufctrRegName,jdbcType=VARCHAR}");
        }
        
        if (record.getArchiveTime() != null) {
            sql.VALUES("ARCHIVE_TIME", "#{archiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getNoDangFlag() != null) {
            sql.VALUES("NO_DANG_FLAG", "#{noDangFlag,jdbcType=CHAR}");
        }
        
        if (record.getBy3() != null) {
            sql.VALUES("BY3", "#{by3,jdbcType=VARCHAR}");
        }
        
        if (record.getBy4() != null) {
            sql.VALUES("BY4", "#{by4,jdbcType=VARCHAR}");
        }
        
        if (record.getInspPatternCode() != null) {
            sql.VALUES("INSP_PATTERN_CODE", "#{inspPatternCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWtDetModeCode() != null) {
            sql.VALUES("WT_DET_MODE_CODE", "#{wtDetModeCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWtDetWorkMode() != null) {
            sql.VALUES("WT_DET_WORK_MODE", "#{wtDetWorkMode,jdbcType=CHAR}");
        }
        
        if (record.getDclIoDeclId() != null) {
            sql.VALUES("DCL_IO_DECL_ID", "#{dclIoDeclId,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsCheckReq() != null) {
            sql.VALUES("GOODS_CHECK_REQ", "#{goodsCheckReq,jdbcType=VARCHAR}");
        }
        
        if (record.getPriKey() != null) {
            sql.VALUES("PRI_KEY", "#{priKey,jdbcType=VARCHAR}");
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

}