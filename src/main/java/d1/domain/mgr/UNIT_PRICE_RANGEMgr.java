package d1.domain.mgr;

import d1.domain.UNIT_PRICE_RANGE;

import java.util.Hashtable;

public class UNIT_PRICE_RANGEMgr {
    private static UNIT_PRICE_RANGEMgr singleInstance = new UNIT_PRICE_RANGEMgr();
    private Hashtable<String,UNIT_PRICE_RANGE> unit_price_rangeHashtable=new  Hashtable<String,UNIT_PRICE_RANGE>();
    public static UNIT_PRICE_RANGEMgr Instance()
    {
        return singleInstance;
    }
    private UNIT_PRICE_RANGEMgr()
    {

    }

    public void SetUNIT_PRICE_RANGEToCache(UNIT_PRICE_RANGE unit_price_range) {
        String key=unit_price_range.getHsCode()+"__"+unit_price_range.getTradeMode()+"__"+unit_price_range.getExportOrImport();
        if(!unit_price_rangeHashtable.containsKey(key))
        {
            unit_price_rangeHashtable.put(key,unit_price_range);
        }
    }

    public boolean getUNIT_PRICE_RANGEFromCache(String key)
    {
        if(unit_price_rangeHashtable.containsKey(key))
        {
            return true;
        }
       return false;
    }
}
