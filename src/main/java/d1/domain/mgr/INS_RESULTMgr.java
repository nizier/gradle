package d1.domain.mgr;

import d1.commons.ReflectHelper;
import d1.domain.*;

import java.util.Hashtable;

public class INS_RESULTMgr {
    private static INS_RESULTMgr singleInstance = new INS_RESULTMgr();
    private Hashtable<String,INS_RESULT> Ins_Result=new  Hashtable<String,INS_RESULT>();
    public static INS_RESULTMgr Instance()
    {
        return singleInstance;
    }
    private INS_RESULTMgr()
    {

    }

    public Hashtable<String,INS_RESULT> getDatas()
    {
        return this.Ins_Result;
    }

    public void SetINS_RESULT_SUMToCache(INS_RESULT_SUM_TASK ins_result_sum_task) throws Exception {
        if(Ins_Result.containsKey(ins_result_sum_task.getDeclNo()))
        {
            INS_RESULT ins_result=Ins_Result.get(ins_result_sum_task.getDeclNo());
            if(ins_result.getIns_result_sum_task().getOperTimeTj().getTime()<ins_result_sum_task.getOperTimeTj().getTime())
            {
                ReflectHelper.trim(ins_result_sum_task);
                ins_result.setIns_result_sum_task(ins_result_sum_task);
            }
        }
        else
        {
            INS_RESULT ins_result=new INS_RESULT();
            ReflectHelper.trim(ins_result_sum_task);
            ins_result.setIns_result_sum_task(ins_result_sum_task);
            Ins_Result.put(ins_result_sum_task.getDeclNo(),ins_result);
        }
    }

    public void SetINS_RESULT_GOODS_TASKToCache(INS_RESULT_GOODS_TASK ins_result_goods_task) throws Exception {
        //组合Key 报检单号+货物序号
        String key=ins_result_goods_task.getDeclNo()+"__"+ins_result_goods_task.getGoodsNo();
        INS_RESULT ins_result=Ins_Result.get(ins_result_goods_task.getDeclNo());
        if(ins_result!=null)
        {
            Hashtable<String,INS_RESULT_GOODS_TASK> hashtable = ins_result.getResult_goods_taskHashtable();
            if(hashtable==null) {
                hashtable = new Hashtable<String, INS_RESULT_GOODS_TASK>();
                ins_result.setResult_goods_taskHashtable(hashtable);
            }

            if(hashtable.containsKey(key))
            {
                if(hashtable.get(key).getOperTimeTj().getTime()<ins_result_goods_task.getOperTimeTj().getTime())
                {
                    ReflectHelper.trim(ins_result_goods_task);
                    hashtable.put(key,ins_result_goods_task);
                }
            }
            else
            {
                ReflectHelper.trim(ins_result_goods_task);
                hashtable.put(key,ins_result_goods_task);
            }
        }
    }

    public void clearAll()
    {
        //清除所有数据,释放内存
        Ins_Result.clear();
    }
}
