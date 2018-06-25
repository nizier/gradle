package d1.domain.Report;

import java.math.BigDecimal;
import java.util.Date;

public class CheckResultReport_Res_Vm {
    //核查类型
    private String checkType;
    //核查项
    private String checkName;
    //入境数
    private int Import;
    //出境数
    private int Export;

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public int getImport() {
        return Import;
    }

    public void setImport(int anImport) {
        Import = anImport;
    }

    public int getExport() {
        return Export;
    }

    public void setExport(int export) {
        Export = export;
    }
}
