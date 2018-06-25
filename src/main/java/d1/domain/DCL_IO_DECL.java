package d1.domain;

import java.util.Hashtable;
import java.util.List;

public class DCL_IO_DECL {
    private DCL_IO_DECL_TASK dcl_io_decl_task;

    private Hashtable<String,DCL_IO_DECL_GOODS_TASK> dcl_io_decl_goods_taskHashtable;

    public DCL_IO_DECL_TASK getDcl_io_decl_task() {
        return dcl_io_decl_task;
    }

    public void setDcl_io_decl_task(DCL_IO_DECL_TASK dcl_io_decl_task) {

        this.dcl_io_decl_task = dcl_io_decl_task;
    }

    public Hashtable<String, DCL_IO_DECL_GOODS_TASK> getDcl_io_decl_goods_taskHashtable() {
        return dcl_io_decl_goods_taskHashtable;
    }

    public void setDcl_io_decl_goods_taskHashtable(Hashtable<String, DCL_IO_DECL_GOODS_TASK> dcl_io_decl_goods_taskHashtable) {
        this.dcl_io_decl_goods_taskHashtable = dcl_io_decl_goods_taskHashtable;
    }

}
