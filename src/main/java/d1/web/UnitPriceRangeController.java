package d1.web;


import d1.domain.*;
import d1.domain.vm.*;
import d1.service.LoggerService;
import d1.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;;

@RestController
public class UnitPriceRangeController {

    private Logger logger = LoggerFactory.getLogger(UnitPriceRangeController.class);

    @Autowired
    private CHECK_LOGMapper loggerMapper;

    @Autowired
    private UNIT_PRICE_RANGEMapper unit_price_range_mapper;
    @Autowired
    private DM_TS_CL_ORGMapper dm_ts_cl_orgMapper;

    @RequestMapping(value = "/unitPriceRange/get", method = RequestMethod.GET)
    public UNIT_PRICE_RANGE_Res_Get_Vm Get(UNIT_PRICE_RANGE_Get_Vm model) throws Exception {

        //根据UserId 获取用户的部门及组织机构
        UserService.Instance().setUserInfoByUserId(model.getGetuserId(),dm_ts_cl_orgMapper);

        if (model.getPage() == null || model.getPage() <= 0) model.setPage(1);
        if (model.getPageSize() == null || model.getPageSize() <= 0) model.setPageSize(20);

        List<UNIT_PRICE_RANGE> entities = unit_price_range_mapper.getList(model);
        int count = unit_price_range_mapper.getListCount(model);

        UNIT_PRICE_RANGE_Res_Get_Vm res = new UNIT_PRICE_RANGE_Res_Get_Vm();
        res.setCount(count);
        res.setResult(entities);
        return res;
    }

    @RequestMapping(value = "/unitPriceRange/getDetail", method = RequestMethod.GET)
    public UNIT_PRICE_RANGE GetDetail(String id) throws Exception {
        UNIT_PRICE_RANGE entity = unit_price_range_mapper.getDetail(id);
        return entity;
    }

    @RequestMapping(value = "/unitPriceRange/put", method = RequestMethod.PUT)
    public int Put(@RequestBody UNIT_PRICE_RANGE_Put_Vm model) throws Exception {
        model.setUpdateUser(UserService.Instance().getUserName());

        int entity = unit_price_range_mapper.put(model);
        return entity;
    }

    @RequestMapping(value = "/unitPriceRange/post", method = RequestMethod.POST)
    public int post(@RequestBody UNIT_PRICE_RANGE model)
    {
        UNIT_PRICE_RANGE unitPriceRange=new UNIT_PRICE_RANGE();
        unitPriceRange.setHsCode(model.getHsCode()==null?"":model.getHsCode());
        unitPriceRange.setProdName(model.getProdName()==null?"":model.getProdName());
        unitPriceRange.setTradeMode(model.getTradeMode()==null?"":model.getTradeMode());
        unitPriceRange.setExportOrImport(model.getExportOrImport()==null?"":model.getExportOrImport());
        unitPriceRange.setHsUnitCode(model.getHsUnitCode()==null?"":model.getHsUnitCode());
        unitPriceRange.setLowerValue(model.getLowerValue()==null?BigDecimal.valueOf(0):model.getLowerValue());
        unitPriceRange.setTopValue(model.getTopValue()==null?BigDecimal.valueOf(0):model.getTopValue());
        unitPriceRange.setBatch(model.getBatch());
        unitPriceRange.setCreateUser(UserService.Instance().getUserName()==null?"":UserService.Instance().getUserName());
        int addCount=unit_price_range_mapper.insert(unitPriceRange);
        String info="用户"+UserService.Instance().getUserNameAndId()+"新增,HS编码:"+unitPriceRange.getHsCode()+";商品名称:"+unitPriceRange.getProdName()+";贸易方式:"+unitPriceRange.getTradeMode()+";出入境:"+unitPriceRange.getExportOrImport()+";最小边界值:"+unitPriceRange.getLowerValue()+";最大边界值:"+unitPriceRange.getTopValue()+"的数据";
        LoggerService.Instance().setLoggerMapper(loggerMapper);
        LoggerService.Instance().info(info,logger);
        return addCount;
    }

    @RequestMapping(value = "/unitPriceRange/delete", method = RequestMethod.DELETE)
    public int Delete(String id) throws Exception {
        //获取数据
        UNIT_PRICE_RANGE entity = unit_price_range_mapper.getDetail(id);

        LoggerService.Instance().setLoggerMapper(loggerMapper);
        LoggerService.Instance().info("用户"+UserService.Instance().getUserNameAndId()+"删除"+entity.getHsCode()+"("+entity.getExportOrImport()+")的记录",logger);
        //再删除表数据
        int deleteCount = unit_price_range_mapper.deleteById(id);
        return deleteCount;
    }
}
