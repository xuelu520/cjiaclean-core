/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: DictCodeManager.java
 * Author:   admin
 * Date:     2016-03-08 15:31:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:31:50><version><desc><source>
 *
 */

package com.huazhu.hvip.common.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.manager.MenuManager;
import com.huazhu.hvip.common.model.Menu;
import com.huazhu.hvip.common.service.MenuService;
import com.huazhu.hvip.common.vo.MenuVO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private static Logger logger = LogManager.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuManager menuManager;

    /**
     * 查询菜单
     * @return
     */
    @Override
    public ReturnObject<MenuVO> searchMenuList() {
        logger.info("call searchMenuList({})");
        ReturnObject<MenuVO> ret = new ReturnObject<MenuVO>();

        try {
            ParamObject para = new ParamObject();
            List<Menu> list = menuManager.searchMenuList(para);
            List<MenuVO> voList = null;
            if(list!=null&&list.size()>0){
                voList = new ArrayList<MenuVO>();
                MenuVO menuVO = null;
                for(Menu menu : list){
                    menuVO = new MenuVO();
                    BeanUtils.copyProperties(menu,menuVO);
                    voList.add(menuVO);
                }
            }
            ret.setDataList(voList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败",e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }
        return ret;
    }
}