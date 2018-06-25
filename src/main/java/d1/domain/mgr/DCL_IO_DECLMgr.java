package d1.domain.mgr;

import d1.commons.ReflectHelper;
import d1.domain.*;
import d1.service.LoggerService;

import java.security.PublicKey;
import java.util.Hashtable;

public class DCL_IO_DECLMgr {
    private static DCL_IO_DECLMgr singleInstance = new DCL_IO_DECLMgr();
    private Hashtable<String,DCL_IO_DECL> Dcl_Io_Decl=new  Hashtable<String,DCL_IO_DECL>();
    public static DCL_IO_DECLMgr Instance()
    {
            return singleInstance;
    }
    private DCL_IO_DECLMgr()
    {

    }

   protected  DCL_IO_DECL_HISTORYMapper dcl_io_decl_historyMapper;

    public  Hashtable<String,DCL_IO_DECL> getDatas(){
        return this.Dcl_Io_Decl;
    }

    public DCL_IO_DECL getDCL_IO_DECLFromCache(String DeclNo)
    {
        return Dcl_Io_Decl.get(DeclNo);
    }

    // 报检单基本表
    public void SetDCL_IO_DECL_TASKToCache(DCL_IO_DECL_TASK dcl_io_decl_task) throws Exception {
        if(Dcl_Io_Decl.containsKey(dcl_io_decl_task.getDeclNo()))
        {
            DCL_IO_DECL obj = Dcl_Io_Decl.get(dcl_io_decl_task.getDeclNo());
            if(obj.getDcl_io_decl_task().getOperTimeTj().getTime()<dcl_io_decl_task.getOperTimeTj().getTime())
            {
                ReflectHelper.trim(dcl_io_decl_task);
                obj.setDcl_io_decl_task(dcl_io_decl_task);
            }
        }
        else
        {
            DCL_IO_DECL dcl_io_decl=new DCL_IO_DECL();
            ReflectHelper.trim(dcl_io_decl_task);
            dcl_io_decl.setDcl_io_decl_task(dcl_io_decl_task);
            Dcl_Io_Decl.put(dcl_io_decl_task.getDeclNo(),dcl_io_decl);
        }
    }

    // 报检单明细表
    public void SetDCL_IO_DECL_GOODS_TASKToCache(DCL_IO_DECL_GOODS_TASK dcl_io_decl_goods_task) throws Exception {
        //组合Key 报检单号+货物序号
        String key=dcl_io_decl_goods_task.getDeclNo()+"__"+dcl_io_decl_goods_task.getGoodsNo();
        //判断字典(Dcl_Io_Decl)是否存在此报检单号
       DCL_IO_DECL obj = Dcl_Io_Decl.get(dcl_io_decl_goods_task.getDeclNo());
        if(obj!=null)
        {
            Hashtable<String,DCL_IO_DECL_GOODS_TASK> hashtable = obj.getDcl_io_decl_goods_taskHashtable();
            if(hashtable==null) {
                hashtable = new Hashtable<String, DCL_IO_DECL_GOODS_TASK>();
                obj.setDcl_io_decl_goods_taskHashtable(hashtable);
            }

            if(hashtable.containsKey(key))
            {
                if(hashtable.get(key).getOperTimeTj().getTime()<dcl_io_decl_goods_task.getOperTimeTj().getTime())
                {
                    ReflectHelper.trim(dcl_io_decl_goods_task);
                    hashtable.put(key,dcl_io_decl_goods_task);
                }
            }
            else
            {
                ReflectHelper.trim(dcl_io_decl_goods_task);
                hashtable.put(key,dcl_io_decl_goods_task);
            }
        }
    }

    public void clearAll() {
        //清除所有数据,释放内存
        Dcl_Io_Decl.clear();
    }
}
