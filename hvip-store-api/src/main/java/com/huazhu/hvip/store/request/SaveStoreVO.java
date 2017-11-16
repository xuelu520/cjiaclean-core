/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SaveStoreVO.java
 * Author:   chenli
 * Date:     2016-04-11 14:12:14
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-04-11 14:12:14> <version>   <desc>
 *
 */

package com.huazhu.hvip.store.request;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class SaveStoreVO implements Serializable {
    private AddStoreVO addStoreVO;//添加店铺时所需VO

    private EditStoreVO editStoreVO;//编辑店铺时所需VO

    public EditStoreVO getEditStoreVO() {
        return editStoreVO;
    }

    public void setEditStoreVO(EditStoreVO editStoreVO) {
        this.editStoreVO = editStoreVO;
    }

    public AddStoreVO getAddStoreVO() {
        return addStoreVO;
    }

    public void setAddStoreVO(AddStoreVO addStoreVO) {
        this.addStoreVO = addStoreVO;
    }
}
