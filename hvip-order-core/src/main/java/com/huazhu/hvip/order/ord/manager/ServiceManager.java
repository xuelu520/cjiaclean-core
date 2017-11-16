package com.huazhu.hvip.order.ord.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.order.ord.model.Service;

/**
 * 工单模块
 * @author cmy
 * @create 2017-08-15 11:03
 **/
public interface ServiceManager extends GenericManager<Service,Long>{
    /**
     * 事务更改工单信息
     * @param paramObject
     * @return
     */
    Service updateOrderService( ParamObject paramObject);

    /**
     * 保洁员开始服务
     * @param p
     * @return
     */
    Service updateBeginService(ParamObject p);
}
