package com.huazhu.hvip.user.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.user.vo.MenuVO;

/**
 * @author cmy
 * @create 2017-07-24 10:46
 **/
public interface MenuService {
    /**
     * 查询菜单
     * @return
     */
    ReturnObject<MenuVO> searchMenuList();

    /**
     * 树形菜单
     * @return
     */
    ReturnObject searchMenuTree(Long  authId) ;

    /**
     * 读取某菜单列表并形成Tree格式
     *要读取的顶级菜单id ,0为读取所有菜单
     * @return
     * @since 2.1.3
     * @author kingapex
     */
    ReturnObject<MenuVO> getMenuTree(Long menuId);

    /**
     * 保存菜单信息
     */
    ReturnObject<MenuVO> saveMenu(MenuVO menuVO);

    /**
     * 根据id查询菜单信息
     */
    ReturnObject<MenuVO> getMenuById(Long id);

    /**
     * 删除菜单信息
     * @param id
     * @return
     */
    ReturnObject<MenuVO> deleteMenu(Long id);
}
