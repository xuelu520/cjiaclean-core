/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SaveSupplierVO.java
 * Author:   chenli
 * Date:     2016-04-19 13:20:19
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-04-19 13:20:19> <version>   <desc>
 *
 */

package com.huazhu.hvip.supplier.request;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class SaveSupplierVO implements Serializable{

    private AddSupplierVO addSupplierVO;

    private EditSupplierVO editSupplierVO;

    public AddSupplierVO getAddSupplierVO() {
        return addSupplierVO;
    }

    public void setAddSupplierVO(AddSupplierVO addSupplierVO) {
        this.addSupplierVO = addSupplierVO;
    }

    public EditSupplierVO getEditSupplierVO() {
        return editSupplierVO;
    }

    public void setEditSupplierVO(EditSupplierVO editSupplierVO) {
        this.editSupplierVO = editSupplierVO;
    }
}
