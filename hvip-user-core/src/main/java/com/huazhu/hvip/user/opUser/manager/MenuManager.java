package com.huazhu.hvip.user.opUser.manager;

/**
 * @author cmy
 * @create 2017-07-24 11:34
 **/

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.user.opUser.model.Menu;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface MenuManager extends GenericManager<Menu,Long> {

    /**
     * 查询菜单
     * @param para
     * @return
     */
    List<Menu> searchMenuList(ParamObject para);
}