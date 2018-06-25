package d1.domain;

import java.math.BigDecimal;
import java.util.Date;

public class INS_RESULT_GOODS_HISTORY {
    private String resultGoodsId;

    private String declNo;

    private BigDecimal goodsNo;

    private String prodHsCode;

    private String statKindCode;

    private String spec;

    private String mesuUnTypCode;

    private BigDecimal weightNet;

    private BigDecimal weightGross;

    private String wtUnitCode;

    private BigDecimal stdWt;

    private String stdWtUnitCode;

    private BigDecimal statclWtValue;

    private String statWtUnitCode;

    private BigDecimal qty;

    private String qtyUnitCode;

    private BigDecimal stdQty;

    private String stdQtyUnitCode;

    private BigDecimal statclQtyValue;

    private String statQuatyUnCo;

    private BigDecimal packQty;

    private String packTypeCode;

    private String currency;

    private BigDecimal goodsTotalVal;

    private BigDecimal totalValUs;

    private BigDecimal totalValCn;

    private String goodsPlace;

    private Date entryDate;

    private Date cmplDschrgDt;

    private BigDecimal unquaWt;

    private BigDecimal unqualQty;

    private BigDecimal unqualAmt;

    private BigDecimal unquAmntUsd;

    private BigDecimal disquaAmtRmb;

    private BigDecimal claimAmt;

    private BigDecimal claimAmtUsd;

    private BigDecimal claimAmtRmb;

    private String disquaContCodes;

    private String inspUnqResn;

    private String inpUnqualHaCode;

    private String inspPatternCode;

    private String wtDetModeCode;

    private String wtDetWorkModeC;

    private String damagIdProCode;

    private String damgedResnCode;

    private BigDecimal damagedAmt;

    private BigDecimal damageAmtUsd;

    private BigDecimal damageAmtRmb;

    private String qurUnqulRsnCode;

    private String qurUnqProcCode;

    private String speQuarTrmtMecC;

    private String quarTrtOrgCode;

    private String quarTrtDeptCode;

    private String statUnitName;

    private String inspContCodes;

    private String goodsNameCn;

    private String goodsNameEn;

    private String goodsflag;

    private String inspResEval;

    private String inspOrgCode;

    private String inspDeptCode;

    private BigDecimal inspUnquafWt;

    private BigDecimal unqulCommInsQty;

    private BigDecimal inspUnquaAmt;

    private BigDecimal inspUnquAmntUs;

    private BigDecimal inspDisquaAmtRmb;

    private String quarResEval;

    private String quaraOrgCode;

    private String quarDeptCode;

    private BigDecimal quaranUnquaWt;

    private BigDecimal unqulfdQuarQty;

    private BigDecimal unqualQuarAmt;

    private BigDecimal unqulQuarAmtUs;

    private BigDecimal unqulQuarAmtCn;

    private BigDecimal relsWtValue;

    private BigDecimal relsQtyValue;

    private BigDecimal releaseAmt;

    private BigDecimal relsAmountUsd;

    private BigDecimal relsAmountRmb;

    private BigDecimal relsPackQty;

    private BigDecimal relsStdWt;

    private BigDecimal relsStdQty;

    private String apprslOrgCode;

    private String apprtDeptCode;

    private String inspContStr;

    private String quarContStr;

    private String inspDisquaContCodes;

    private String quarDisquaContCodes;

    private String prevtivTreatmt;

    private String mnufctrCode;

    private String prodBatchNo;

    private String inspOperCode;

    private Date insOpertDate;

    private String quarOperCode;

    private Date quarCondtTime;

    private String idenOperCode;

    private Date apprCondtTime;

    private String sntTrtOperCode;

    private Date treatOperateDate;

    private String treatUnit;

    private BigDecimal treatTime;

    private String treatTimeUnit;

    private BigDecimal treatTemper;

    private String medicName;

    private BigDecimal prevTreatTm;

    private String preTreatTmUnit;

    private BigDecimal prvntTreatTemp;

    private String prevMedicName;

    private BigDecimal treatMedicDens;

    private BigDecimal medicConcen;

    private BigDecimal actualQty;

    private BigDecimal realWeight;

    private BigDecimal actSmplNum;

    private BigDecimal suggSmplNum;

    private BigDecimal inspQty;

    private BigDecimal declWt;

    private BigDecimal declGoodsValues;

    private BigDecimal declValuesUsd;

    private BigDecimal declValuesRmb;

    private String produceDate;

    private String extDisquaCauseCode;

    private String extDisquaCauseDesc;

    private String extDisquCauseCode;

    private String extDisquCauseDesc;

    private String standardNo;

    private String disDetailInfo;

    private String riskInfoLevelCode;

    private String reportOrgCode;

    private String disquaTypeCode;

    private String falgArchive;

    private Date operTime;

    private String contNo;

    private String preMeasBasisCode;

    private Date archiveTime;

    private String inspResSpot;

    private String quarResSpot;

    private String priKey;

    private String transTypeTj;

    private Date operTimeTj;

    public String getResultGoodsId() {
        return resultGoodsId;
    }

    public void setResultGoodsId(String resultGoodsId) {
        this.resultGoodsId = resultGoodsId == null ? null : resultGoodsId.trim();
    }

    public String getDeclNo() {
        return declNo;
    }

    public void setDeclNo(String declNo) {
        this.declNo = declNo == null ? null : declNo.trim();
    }

    public BigDecimal getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(BigDecimal goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getProdHsCode() {
        return prodHsCode;
    }

    public void setProdHsCode(String prodHsCode) {
        this.prodHsCode = prodHsCode == null ? null : prodHsCode.trim();
    }

    public String getStatKindCode() {
        return statKindCode;
    }

    public void setStatKindCode(String statKindCode) {
        this.statKindCode = statKindCode == null ? null : statKindCode.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getMesuUnTypCode() {
        return mesuUnTypCode;
    }

    public void setMesuUnTypCode(String mesuUnTypCode) {
        this.mesuUnTypCode = mesuUnTypCode == null ? null : mesuUnTypCode.trim();
    }

    public BigDecimal getWeightNet() {
        return weightNet;
    }

    public void setWeightNet(BigDecimal weightNet) {
        this.weightNet = weightNet;
    }

    public BigDecimal getWeightGross() {
        return weightGross;
    }

    public void setWeightGross(BigDecimal weightGross) {
        this.weightGross = weightGross;
    }

    public String getWtUnitCode() {
        return wtUnitCode;
    }

    public void setWtUnitCode(String wtUnitCode) {
        this.wtUnitCode = wtUnitCode == null ? null : wtUnitCode.trim();
    }

    public BigDecimal getStdWt() {
        return stdWt;
    }

    public void setStdWt(BigDecimal stdWt) {
        this.stdWt = stdWt;
    }

    public String getStdWtUnitCode() {
        return stdWtUnitCode;
    }

    public void setStdWtUnitCode(String stdWtUnitCode) {
        this.stdWtUnitCode = stdWtUnitCode == null ? null : stdWtUnitCode.trim();
    }

    public BigDecimal getStatclWtValue() {
        return statclWtValue;
    }

    public void setStatclWtValue(BigDecimal statclWtValue) {
        this.statclWtValue = statclWtValue;
    }

    public String getStatWtUnitCode() {
        return statWtUnitCode;
    }

    public void setStatWtUnitCode(String statWtUnitCode) {
        this.statWtUnitCode = statWtUnitCode == null ? null : statWtUnitCode.trim();
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getQtyUnitCode() {
        return qtyUnitCode;
    }

    public void setQtyUnitCode(String qtyUnitCode) {
        this.qtyUnitCode = qtyUnitCode == null ? null : qtyUnitCode.trim();
    }

    public BigDecimal getStdQty() {
        return stdQty;
    }

    public void setStdQty(BigDecimal stdQty) {
        this.stdQty = stdQty;
    }

    public String getStdQtyUnitCode() {
        return stdQtyUnitCode;
    }

    public void setStdQtyUnitCode(String stdQtyUnitCode) {
        this.stdQtyUnitCode = stdQtyUnitCode == null ? null : stdQtyUnitCode.trim();
    }

    public BigDecimal getStatclQtyValue() {
        return statclQtyValue;
    }

    public void setStatclQtyValue(BigDecimal statclQtyValue) {
        this.statclQtyValue = statclQtyValue;
    }

    public String getStatQuatyUnCo() {
        return statQuatyUnCo;
    }

    public void setStatQuatyUnCo(String statQuatyUnCo) {
        this.statQuatyUnCo = statQuatyUnCo == null ? null : statQuatyUnCo.trim();
    }

    public BigDecimal getPackQty() {
        return packQty;
    }

    public void setPackQty(BigDecimal packQty) {
        this.packQty = packQty;
    }

    public String getPackTypeCode() {
        return packTypeCode;
    }

    public void setPackTypeCode(String packTypeCode) {
        this.packTypeCode = packTypeCode == null ? null : packTypeCode.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public BigDecimal getGoodsTotalVal() {
        return goodsTotalVal;
    }

    public void setGoodsTotalVal(BigDecimal goodsTotalVal) {
        this.goodsTotalVal = goodsTotalVal;
    }

    public BigDecimal getTotalValUs() {
        return totalValUs;
    }

    public void setTotalValUs(BigDecimal totalValUs) {
        this.totalValUs = totalValUs;
    }

    public BigDecimal getTotalValCn() {
        return totalValCn;
    }

    public void setTotalValCn(BigDecimal totalValCn) {
        this.totalValCn = totalValCn;
    }

    public String getGoodsPlace() {
        return goodsPlace;
    }

    public void setGoodsPlace(String goodsPlace) {
        this.goodsPlace = goodsPlace == null ? null : goodsPlace.trim();
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getCmplDschrgDt() {
        return cmplDschrgDt;
    }

    public void setCmplDschrgDt(Date cmplDschrgDt) {
        this.cmplDschrgDt = cmplDschrgDt;
    }

    public BigDecimal getUnquaWt() {
        return unquaWt;
    }

    public void setUnquaWt(BigDecimal unquaWt) {
        this.unquaWt = unquaWt;
    }

    public BigDecimal getUnqualQty() {
        return unqualQty;
    }

    public void setUnqualQty(BigDecimal unqualQty) {
        this.unqualQty = unqualQty;
    }

    public BigDecimal getUnqualAmt() {
        return unqualAmt;
    }

    public void setUnqualAmt(BigDecimal unqualAmt) {
        this.unqualAmt = unqualAmt;
    }

    public BigDecimal getUnquAmntUsd() {
        return unquAmntUsd;
    }

    public void setUnquAmntUsd(BigDecimal unquAmntUsd) {
        this.unquAmntUsd = unquAmntUsd;
    }

    public BigDecimal getDisquaAmtRmb() {
        return disquaAmtRmb;
    }

    public void setDisquaAmtRmb(BigDecimal disquaAmtRmb) {
        this.disquaAmtRmb = disquaAmtRmb;
    }

    public BigDecimal getClaimAmt() {
        return claimAmt;
    }

    public void setClaimAmt(BigDecimal claimAmt) {
        this.claimAmt = claimAmt;
    }

    public BigDecimal getClaimAmtUsd() {
        return claimAmtUsd;
    }

    public void setClaimAmtUsd(BigDecimal claimAmtUsd) {
        this.claimAmtUsd = claimAmtUsd;
    }

    public BigDecimal getClaimAmtRmb() {
        return claimAmtRmb;
    }

    public void setClaimAmtRmb(BigDecimal claimAmtRmb) {
        this.claimAmtRmb = claimAmtRmb;
    }

    public String getDisquaContCodes() {
        return disquaContCodes;
    }

    public void setDisquaContCodes(String disquaContCodes) {
        this.disquaContCodes = disquaContCodes == null ? null : disquaContCodes.trim();
    }

    public String getInspUnqResn() {
        return inspUnqResn;
    }

    public void setInspUnqResn(String inspUnqResn) {
        this.inspUnqResn = inspUnqResn == null ? null : inspUnqResn.trim();
    }

    public String getInpUnqualHaCode() {
        return inpUnqualHaCode;
    }

    public void setInpUnqualHaCode(String inpUnqualHaCode) {
        this.inpUnqualHaCode = inpUnqualHaCode == null ? null : inpUnqualHaCode.trim();
    }

    public String getInspPatternCode() {
        return inspPatternCode;
    }

    public void setInspPatternCode(String inspPatternCode) {
        this.inspPatternCode = inspPatternCode == null ? null : inspPatternCode.trim();
    }

    public String getWtDetModeCode() {
        return wtDetModeCode;
    }

    public void setWtDetModeCode(String wtDetModeCode) {
        this.wtDetModeCode = wtDetModeCode == null ? null : wtDetModeCode.trim();
    }

    public String getWtDetWorkModeC() {
        return wtDetWorkModeC;
    }

    public void setWtDetWorkModeC(String wtDetWorkModeC) {
        this.wtDetWorkModeC = wtDetWorkModeC == null ? null : wtDetWorkModeC.trim();
    }

    public String getDamagIdProCode() {
        return damagIdProCode;
    }

    public void setDamagIdProCode(String damagIdProCode) {
        this.damagIdProCode = damagIdProCode == null ? null : damagIdProCode.trim();
    }

    public String getDamgedResnCode() {
        return damgedResnCode;
    }

    public void setDamgedResnCode(String damgedResnCode) {
        this.damgedResnCode = damgedResnCode == null ? null : damgedResnCode.trim();
    }

    public BigDecimal getDamagedAmt() {
        return damagedAmt;
    }

    public void setDamagedAmt(BigDecimal damagedAmt) {
        this.damagedAmt = damagedAmt;
    }

    public BigDecimal getDamageAmtUsd() {
        return damageAmtUsd;
    }

    public void setDamageAmtUsd(BigDecimal damageAmtUsd) {
        this.damageAmtUsd = damageAmtUsd;
    }

    public BigDecimal getDamageAmtRmb() {
        return damageAmtRmb;
    }

    public void setDamageAmtRmb(BigDecimal damageAmtRmb) {
        this.damageAmtRmb = damageAmtRmb;
    }

    public String getQurUnqulRsnCode() {
        return qurUnqulRsnCode;
    }

    public void setQurUnqulRsnCode(String qurUnqulRsnCode) {
        this.qurUnqulRsnCode = qurUnqulRsnCode == null ? null : qurUnqulRsnCode.trim();
    }

    public String getQurUnqProcCode() {
        return qurUnqProcCode;
    }

    public void setQurUnqProcCode(String qurUnqProcCode) {
        this.qurUnqProcCode = qurUnqProcCode == null ? null : qurUnqProcCode.trim();
    }

    public String getSpeQuarTrmtMecC() {
        return speQuarTrmtMecC;
    }

    public void setSpeQuarTrmtMecC(String speQuarTrmtMecC) {
        this.speQuarTrmtMecC = speQuarTrmtMecC == null ? null : speQuarTrmtMecC.trim();
    }

    public String getQuarTrtOrgCode() {
        return quarTrtOrgCode;
    }

    public void setQuarTrtOrgCode(String quarTrtOrgCode) {
        this.quarTrtOrgCode = quarTrtOrgCode == null ? null : quarTrtOrgCode.trim();
    }

    public String getQuarTrtDeptCode() {
        return quarTrtDeptCode;
    }

    public void setQuarTrtDeptCode(String quarTrtDeptCode) {
        this.quarTrtDeptCode = quarTrtDeptCode == null ? null : quarTrtDeptCode.trim();
    }

    public String getStatUnitName() {
        return statUnitName;
    }

    public void setStatUnitName(String statUnitName) {
        this.statUnitName = statUnitName == null ? null : statUnitName.trim();
    }

    public String getInspContCodes() {
        return inspContCodes;
    }

    public void setInspContCodes(String inspContCodes) {
        this.inspContCodes = inspContCodes == null ? null : inspContCodes.trim();
    }

    public String getGoodsNameCn() {
        return goodsNameCn;
    }

    public void setGoodsNameCn(String goodsNameCn) {
        this.goodsNameCn = goodsNameCn == null ? null : goodsNameCn.trim();
    }

    public String getGoodsNameEn() {
        return goodsNameEn;
    }

    public void setGoodsNameEn(String goodsNameEn) {
        this.goodsNameEn = goodsNameEn == null ? null : goodsNameEn.trim();
    }

    public String getGoodsflag() {
        return goodsflag;
    }

    public void setGoodsflag(String goodsflag) {
        this.goodsflag = goodsflag == null ? null : goodsflag.trim();
    }

    public String getInspResEval() {
        return inspResEval;
    }

    public void setInspResEval(String inspResEval) {
        this.inspResEval = inspResEval == null ? null : inspResEval.trim();
    }

    public String getInspOrgCode() {
        return inspOrgCode;
    }

    public void setInspOrgCode(String inspOrgCode) {
        this.inspOrgCode = inspOrgCode == null ? null : inspOrgCode.trim();
    }

    public String getInspDeptCode() {
        return inspDeptCode;
    }

    public void setInspDeptCode(String inspDeptCode) {
        this.inspDeptCode = inspDeptCode == null ? null : inspDeptCode.trim();
    }

    public BigDecimal getInspUnquafWt() {
        return inspUnquafWt;
    }

    public void setInspUnquafWt(BigDecimal inspUnquafWt) {
        this.inspUnquafWt = inspUnquafWt;
    }

    public BigDecimal getUnqulCommInsQty() {
        return unqulCommInsQty;
    }

    public void setUnqulCommInsQty(BigDecimal unqulCommInsQty) {
        this.unqulCommInsQty = unqulCommInsQty;
    }

    public BigDecimal getInspUnquaAmt() {
        return inspUnquaAmt;
    }

    public void setInspUnquaAmt(BigDecimal inspUnquaAmt) {
        this.inspUnquaAmt = inspUnquaAmt;
    }

    public BigDecimal getInspUnquAmntUs() {
        return inspUnquAmntUs;
    }

    public void setInspUnquAmntUs(BigDecimal inspUnquAmntUs) {
        this.inspUnquAmntUs = inspUnquAmntUs;
    }

    public BigDecimal getInspDisquaAmtRmb() {
        return inspDisquaAmtRmb;
    }

    public void setInspDisquaAmtRmb(BigDecimal inspDisquaAmtRmb) {
        this.inspDisquaAmtRmb = inspDisquaAmtRmb;
    }

    public String getQuarResEval() {
        return quarResEval;
    }

    public void setQuarResEval(String quarResEval) {
        this.quarResEval = quarResEval == null ? null : quarResEval.trim();
    }

    public String getQuaraOrgCode() {
        return quaraOrgCode;
    }

    public void setQuaraOrgCode(String quaraOrgCode) {
        this.quaraOrgCode = quaraOrgCode == null ? null : quaraOrgCode.trim();
    }

    public String getQuarDeptCode() {
        return quarDeptCode;
    }

    public void setQuarDeptCode(String quarDeptCode) {
        this.quarDeptCode = quarDeptCode == null ? null : quarDeptCode.trim();
    }

    public BigDecimal getQuaranUnquaWt() {
        return quaranUnquaWt;
    }

    public void setQuaranUnquaWt(BigDecimal quaranUnquaWt) {
        this.quaranUnquaWt = quaranUnquaWt;
    }

    public BigDecimal getUnqulfdQuarQty() {
        return unqulfdQuarQty;
    }

    public void setUnqulfdQuarQty(BigDecimal unqulfdQuarQty) {
        this.unqulfdQuarQty = unqulfdQuarQty;
    }

    public BigDecimal getUnqualQuarAmt() {
        return unqualQuarAmt;
    }

    public void setUnqualQuarAmt(BigDecimal unqualQuarAmt) {
        this.unqualQuarAmt = unqualQuarAmt;
    }

    public BigDecimal getUnqulQuarAmtUs() {
        return unqulQuarAmtUs;
    }

    public void setUnqulQuarAmtUs(BigDecimal unqulQuarAmtUs) {
        this.unqulQuarAmtUs = unqulQuarAmtUs;
    }

    public BigDecimal getUnqulQuarAmtCn() {
        return unqulQuarAmtCn;
    }

    public void setUnqulQuarAmtCn(BigDecimal unqulQuarAmtCn) {
        this.unqulQuarAmtCn = unqulQuarAmtCn;
    }

    public BigDecimal getRelsWtValue() {
        return relsWtValue;
    }

    public void setRelsWtValue(BigDecimal relsWtValue) {
        this.relsWtValue = relsWtValue;
    }

    public BigDecimal getRelsQtyValue() {
        return relsQtyValue;
    }

    public void setRelsQtyValue(BigDecimal relsQtyValue) {
        this.relsQtyValue = relsQtyValue;
    }

    public BigDecimal getReleaseAmt() {
        return releaseAmt;
    }

    public void setReleaseAmt(BigDecimal releaseAmt) {
        this.releaseAmt = releaseAmt;
    }

    public BigDecimal getRelsAmountUsd() {
        return relsAmountUsd;
    }

    public void setRelsAmountUsd(BigDecimal relsAmountUsd) {
        this.relsAmountUsd = relsAmountUsd;
    }

    public BigDecimal getRelsAmountRmb() {
        return relsAmountRmb;
    }

    public void setRelsAmountRmb(BigDecimal relsAmountRmb) {
        this.relsAmountRmb = relsAmountRmb;
    }

    public BigDecimal getRelsPackQty() {
        return relsPackQty;
    }

    public void setRelsPackQty(BigDecimal relsPackQty) {
        this.relsPackQty = relsPackQty;
    }

    public BigDecimal getRelsStdWt() {
        return relsStdWt;
    }

    public void setRelsStdWt(BigDecimal relsStdWt) {
        this.relsStdWt = relsStdWt;
    }

    public BigDecimal getRelsStdQty() {
        return relsStdQty;
    }

    public void setRelsStdQty(BigDecimal relsStdQty) {
        this.relsStdQty = relsStdQty;
    }

    public String getApprslOrgCode() {
        return apprslOrgCode;
    }

    public void setApprslOrgCode(String apprslOrgCode) {
        this.apprslOrgCode = apprslOrgCode == null ? null : apprslOrgCode.trim();
    }

    public String getApprtDeptCode() {
        return apprtDeptCode;
    }

    public void setApprtDeptCode(String apprtDeptCode) {
        this.apprtDeptCode = apprtDeptCode == null ? null : apprtDeptCode.trim();
    }

    public String getInspContStr() {
        return inspContStr;
    }

    public void setInspContStr(String inspContStr) {
        this.inspContStr = inspContStr == null ? null : inspContStr.trim();
    }

    public String getQuarContStr() {
        return quarContStr;
    }

    public void setQuarContStr(String quarContStr) {
        this.quarContStr = quarContStr == null ? null : quarContStr.trim();
    }

    public String getInspDisquaContCodes() {
        return inspDisquaContCodes;
    }

    public void setInspDisquaContCodes(String inspDisquaContCodes) {
        this.inspDisquaContCodes = inspDisquaContCodes == null ? null : inspDisquaContCodes.trim();
    }

    public String getQuarDisquaContCodes() {
        return quarDisquaContCodes;
    }

    public void setQuarDisquaContCodes(String quarDisquaContCodes) {
        this.quarDisquaContCodes = quarDisquaContCodes == null ? null : quarDisquaContCodes.trim();
    }

    public String getPrevtivTreatmt() {
        return prevtivTreatmt;
    }

    public void setPrevtivTreatmt(String prevtivTreatmt) {
        this.prevtivTreatmt = prevtivTreatmt == null ? null : prevtivTreatmt.trim();
    }

    public String getMnufctrCode() {
        return mnufctrCode;
    }

    public void setMnufctrCode(String mnufctrCode) {
        this.mnufctrCode = mnufctrCode == null ? null : mnufctrCode.trim();
    }

    public String getProdBatchNo() {
        return prodBatchNo;
    }

    public void setProdBatchNo(String prodBatchNo) {
        this.prodBatchNo = prodBatchNo == null ? null : prodBatchNo.trim();
    }

    public String getInspOperCode() {
        return inspOperCode;
    }

    public void setInspOperCode(String inspOperCode) {
        this.inspOperCode = inspOperCode == null ? null : inspOperCode.trim();
    }

    public Date getInsOpertDate() {
        return insOpertDate;
    }

    public void setInsOpertDate(Date insOpertDate) {
        this.insOpertDate = insOpertDate;
    }

    public String getQuarOperCode() {
        return quarOperCode;
    }

    public void setQuarOperCode(String quarOperCode) {
        this.quarOperCode = quarOperCode == null ? null : quarOperCode.trim();
    }

    public Date getQuarCondtTime() {
        return quarCondtTime;
    }

    public void setQuarCondtTime(Date quarCondtTime) {
        this.quarCondtTime = quarCondtTime;
    }

    public String getIdenOperCode() {
        return idenOperCode;
    }

    public void setIdenOperCode(String idenOperCode) {
        this.idenOperCode = idenOperCode == null ? null : idenOperCode.trim();
    }

    public Date getApprCondtTime() {
        return apprCondtTime;
    }

    public void setApprCondtTime(Date apprCondtTime) {
        this.apprCondtTime = apprCondtTime;
    }

    public String getSntTrtOperCode() {
        return sntTrtOperCode;
    }

    public void setSntTrtOperCode(String sntTrtOperCode) {
        this.sntTrtOperCode = sntTrtOperCode == null ? null : sntTrtOperCode.trim();
    }

    public Date getTreatOperateDate() {
        return treatOperateDate;
    }

    public void setTreatOperateDate(Date treatOperateDate) {
        this.treatOperateDate = treatOperateDate;
    }

    public String getTreatUnit() {
        return treatUnit;
    }

    public void setTreatUnit(String treatUnit) {
        this.treatUnit = treatUnit == null ? null : treatUnit.trim();
    }

    public BigDecimal getTreatTime() {
        return treatTime;
    }

    public void setTreatTime(BigDecimal treatTime) {
        this.treatTime = treatTime;
    }

    public String getTreatTimeUnit() {
        return treatTimeUnit;
    }

    public void setTreatTimeUnit(String treatTimeUnit) {
        this.treatTimeUnit = treatTimeUnit == null ? null : treatTimeUnit.trim();
    }

    public BigDecimal getTreatTemper() {
        return treatTemper;
    }

    public void setTreatTemper(BigDecimal treatTemper) {
        this.treatTemper = treatTemper;
    }

    public String getMedicName() {
        return medicName;
    }

    public void setMedicName(String medicName) {
        this.medicName = medicName == null ? null : medicName.trim();
    }

    public BigDecimal getPrevTreatTm() {
        return prevTreatTm;
    }

    public void setPrevTreatTm(BigDecimal prevTreatTm) {
        this.prevTreatTm = prevTreatTm;
    }

    public String getPreTreatTmUnit() {
        return preTreatTmUnit;
    }

    public void setPreTreatTmUnit(String preTreatTmUnit) {
        this.preTreatTmUnit = preTreatTmUnit == null ? null : preTreatTmUnit.trim();
    }

    public BigDecimal getPrvntTreatTemp() {
        return prvntTreatTemp;
    }

    public void setPrvntTreatTemp(BigDecimal prvntTreatTemp) {
        this.prvntTreatTemp = prvntTreatTemp;
    }

    public String getPrevMedicName() {
        return prevMedicName;
    }

    public void setPrevMedicName(String prevMedicName) {
        this.prevMedicName = prevMedicName == null ? null : prevMedicName.trim();
    }

    public BigDecimal getTreatMedicDens() {
        return treatMedicDens;
    }

    public void setTreatMedicDens(BigDecimal treatMedicDens) {
        this.treatMedicDens = treatMedicDens;
    }

    public BigDecimal getMedicConcen() {
        return medicConcen;
    }

    public void setMedicConcen(BigDecimal medicConcen) {
        this.medicConcen = medicConcen;
    }

    public BigDecimal getActualQty() {
        return actualQty;
    }

    public void setActualQty(BigDecimal actualQty) {
        this.actualQty = actualQty;
    }

    public BigDecimal getRealWeight() {
        return realWeight;
    }

    public void setRealWeight(BigDecimal realWeight) {
        this.realWeight = realWeight;
    }

    public BigDecimal getActSmplNum() {
        return actSmplNum;
    }

    public void setActSmplNum(BigDecimal actSmplNum) {
        this.actSmplNum = actSmplNum;
    }

    public BigDecimal getSuggSmplNum() {
        return suggSmplNum;
    }

    public void setSuggSmplNum(BigDecimal suggSmplNum) {
        this.suggSmplNum = suggSmplNum;
    }

    public BigDecimal getInspQty() {
        return inspQty;
    }

    public void setInspQty(BigDecimal inspQty) {
        this.inspQty = inspQty;
    }

    public BigDecimal getDeclWt() {
        return declWt;
    }

    public void setDeclWt(BigDecimal declWt) {
        this.declWt = declWt;
    }

    public BigDecimal getDeclGoodsValues() {
        return declGoodsValues;
    }

    public void setDeclGoodsValues(BigDecimal declGoodsValues) {
        this.declGoodsValues = declGoodsValues;
    }

    public BigDecimal getDeclValuesUsd() {
        return declValuesUsd;
    }

    public void setDeclValuesUsd(BigDecimal declValuesUsd) {
        this.declValuesUsd = declValuesUsd;
    }

    public BigDecimal getDeclValuesRmb() {
        return declValuesRmb;
    }

    public void setDeclValuesRmb(BigDecimal declValuesRmb) {
        this.declValuesRmb = declValuesRmb;
    }

    public String getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(String produceDate) {
        this.produceDate = produceDate == null ? null : produceDate.trim();
    }

    public String getExtDisquaCauseCode() {
        return extDisquaCauseCode;
    }

    public void setExtDisquaCauseCode(String extDisquaCauseCode) {
        this.extDisquaCauseCode = extDisquaCauseCode == null ? null : extDisquaCauseCode.trim();
    }

    public String getExtDisquaCauseDesc() {
        return extDisquaCauseDesc;
    }

    public void setExtDisquaCauseDesc(String extDisquaCauseDesc) {
        this.extDisquaCauseDesc = extDisquaCauseDesc == null ? null : extDisquaCauseDesc.trim();
    }

    public String getExtDisquCauseCode() {
        return extDisquCauseCode;
    }

    public void setExtDisquCauseCode(String extDisquCauseCode) {
        this.extDisquCauseCode = extDisquCauseCode == null ? null : extDisquCauseCode.trim();
    }

    public String getExtDisquCauseDesc() {
        return extDisquCauseDesc;
    }

    public void setExtDisquCauseDesc(String extDisquCauseDesc) {
        this.extDisquCauseDesc = extDisquCauseDesc == null ? null : extDisquCauseDesc.trim();
    }

    public String getStandardNo() {
        return standardNo;
    }

    public void setStandardNo(String standardNo) {
        this.standardNo = standardNo == null ? null : standardNo.trim();
    }

    public String getDisDetailInfo() {
        return disDetailInfo;
    }

    public void setDisDetailInfo(String disDetailInfo) {
        this.disDetailInfo = disDetailInfo == null ? null : disDetailInfo.trim();
    }

    public String getRiskInfoLevelCode() {
        return riskInfoLevelCode;
    }

    public void setRiskInfoLevelCode(String riskInfoLevelCode) {
        this.riskInfoLevelCode = riskInfoLevelCode == null ? null : riskInfoLevelCode.trim();
    }

    public String getReportOrgCode() {
        return reportOrgCode;
    }

    public void setReportOrgCode(String reportOrgCode) {
        this.reportOrgCode = reportOrgCode == null ? null : reportOrgCode.trim();
    }

    public String getDisquaTypeCode() {
        return disquaTypeCode;
    }

    public void setDisquaTypeCode(String disquaTypeCode) {
        this.disquaTypeCode = disquaTypeCode == null ? null : disquaTypeCode.trim();
    }

    public String getFalgArchive() {
        return falgArchive;
    }

    public void setFalgArchive(String falgArchive) {
        this.falgArchive = falgArchive == null ? null : falgArchive.trim();
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getContNo() {
        return contNo;
    }

    public void setContNo(String contNo) {
        this.contNo = contNo == null ? null : contNo.trim();
    }

    public String getPreMeasBasisCode() {
        return preMeasBasisCode;
    }

    public void setPreMeasBasisCode(String preMeasBasisCode) {
        this.preMeasBasisCode = preMeasBasisCode == null ? null : preMeasBasisCode.trim();
    }

    public Date getArchiveTime() {
        return archiveTime;
    }

    public void setArchiveTime(Date archiveTime) {
        this.archiveTime = archiveTime;
    }

    public String getInspResSpot() {
        return inspResSpot;
    }

    public void setInspResSpot(String inspResSpot) {
        this.inspResSpot = inspResSpot == null ? null : inspResSpot.trim();
    }

    public String getQuarResSpot() {
        return quarResSpot;
    }

    public void setQuarResSpot(String quarResSpot) {
        this.quarResSpot = quarResSpot == null ? null : quarResSpot.trim();
    }

    public String getPriKey() {
        return priKey;
    }

    public void setPriKey(String priKey) {
        this.priKey = priKey == null ? null : priKey.trim();
    }

    public String getTransTypeTj() {
        return transTypeTj;
    }

    public void setTransTypeTj(String transTypeTj) {
        this.transTypeTj = transTypeTj == null ? null : transTypeTj.trim();
    }

    public Date getOperTimeTj() {
        return operTimeTj;
    }

    public void setOperTimeTj(Date operTimeTj) {
        this.operTimeTj = operTimeTj;
    }
}