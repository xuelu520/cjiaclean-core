package com.huazhu.hvip.common.vo;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StoreSplitProportionVO implements Serializable {

    private Long StoreId; //店铺id

    private Integer splitProportion; //分成比例

    public Long getStoreId() {
        return StoreId;
    }

    public void setStoreId(Long storeId) {
        StoreId = storeId;
    }

    public Integer getSplitProportion() {
        return splitProportion;
    }

    public void setSplitProportion(Integer splitProportion) {
        this.splitProportion = splitProportion;
    }
}
