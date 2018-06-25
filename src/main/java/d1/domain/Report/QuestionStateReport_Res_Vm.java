package d1.domain.Report;

public class QuestionStateReport_Res_Vm {
    //核查类型
    private String checkType;
    //核查项
    private String checkName;
    //未处理
    private int untreated;
    //修改仍错误
    private int editError;
    //已解决
    private int solve;
    //无法解决
    private int cannotSolve;
    //无需解决
    private int noNeedToSolve;

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

    public int getUntreated() {
        return untreated;
    }

    public void setUntreated(int untreated) {
        this.untreated = untreated;
    }

    public int getEditError() {
        return editError;
    }

    public void setEditError(int editError) {
        this.editError = editError;
    }

    public int getSolve() {
        return solve;
    }

    public void setSolve(int solve) {
        this.solve = solve;
    }

    public int getCannotSolve() {
        return cannotSolve;
    }

    public void setCannotSolve(int cannotSolve) {
        this.cannotSolve = cannotSolve;
    }

    public int getNoNeedToSolve() {
        return noNeedToSolve;
    }

    public void setNoNeedToSolve(int noNeedToSolve) {
        this.noNeedToSolve = noNeedToSolve;
    }
}
