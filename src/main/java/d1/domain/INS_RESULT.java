package d1.domain;

import java.util.Hashtable;

public class INS_RESULT {
    private INS_RESULT_SUM_TASK ins_result_sum_task;
    private Hashtable<String,INS_RESULT_GOODS_TASK> result_goods_taskHashtable;

    public INS_RESULT_SUM_TASK getIns_result_sum_task() {
        return ins_result_sum_task;
    }

    public void setIns_result_sum_task(INS_RESULT_SUM_TASK ins_result_sum_task) {
        this.ins_result_sum_task = ins_result_sum_task;
    }

    public Hashtable<String, INS_RESULT_GOODS_TASK> getResult_goods_taskHashtable() {
        return result_goods_taskHashtable;
    }

    public void setResult_goods_taskHashtable(Hashtable<String, INS_RESULT_GOODS_TASK> result_goods_taskHashtable) {
        this.result_goods_taskHashtable = result_goods_taskHashtable;
    }
}
