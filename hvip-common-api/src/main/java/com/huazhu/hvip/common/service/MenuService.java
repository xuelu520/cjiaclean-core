/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: DictCodeService.java
 * Author:   admin
 * Date:     2016-03-20 17:28:32
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 17:28:32><version><desc>
 */

package com.huazhu.hvip.common.service;


import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.vo.MenuVO;

/**
 * 菜单
 *
 * @author cqm
 */
public interface MenuService {

    /**
     * 查询菜单
     * @return
     */
    public ReturnObject<MenuVO> searchMenuList();

}
