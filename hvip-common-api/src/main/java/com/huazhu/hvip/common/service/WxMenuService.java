package com.huazhu.hvip.common.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.vo.WxMenuVO;

/**
 * @author cmy
 * @create 2017-08-03 10:41
 **/
public interface WxMenuService {
    /**
     * 查询所有微信目录
     * @return
     */
    ReturnObject getWxMenuList();

    /**
     * 查询所有上级分类
     *
     * @return
     */
    ReturnObject addMenuListJson(Long id);

    /**
     * 新增微信菜单
     * @param wxMenuVO
     * @return
     */
    ReturnObject saveWxMenuVO(WxMenuVO wxMenuVO);


    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    ReturnObject searchMenuById(Long id);
}
