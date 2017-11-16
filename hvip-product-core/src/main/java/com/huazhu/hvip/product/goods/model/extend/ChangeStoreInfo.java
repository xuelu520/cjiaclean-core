/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChangeStoreInfo.java
 * Author:   HUQIANBO001
 * Date:     2016-04-06 17:02:53
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-06 17:02:53><version><desc>
 */

package com.huazhu.hvip.product.goods.model.extend;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ChangeStoreInfo implements Serializable {

    private Long goodsId; //商品id
    private Integer changeType; //改变类型 1.下单 2.发货 3.退货收货 4.未付款取消  11.后台设置库存
    private Integer changeNum; //改变库存数
    private String remark; //备注

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getChangeType() {
        return changeType;
    }

    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }

    public Integer getChangeNum() {
        return changeNum;
    }

    public void setChangeNum(Integer changeNum) {
        this.changeNum = changeNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
