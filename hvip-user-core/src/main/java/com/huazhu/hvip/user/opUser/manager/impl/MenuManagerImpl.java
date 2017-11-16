package com.huazhu.hvip.user.opUser.manager.impl;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.user.opUser.dao.MenuDao;
import com.huazhu.hvip.user.opUser.manager.MenuManager;
import com.huazhu.hvip.user.opUser.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cmy
 * @create 2017-07-24 11:35
 **/
@Service("menuManager")
public class MenuManagerImpl extends GenericManagerImpl<Menu,Long> implements MenuManager {
    MenuDao menuDao;

    @Autowired
    public MenuManagerImpl(MenuDao menuDao){
        super(menuDao);
        this.menuDao = menuDao;
    }

    /**
     * 查询菜单
     * @param para
     * @return
     */
   /* @Override
    public List<Menu> searchMenuList(ParamObject para) {
        QueryModel queryModel = new QueryModel();
        Long parentId = para.getLongParam("parentId");
        if(parentId!=null){
            queryModel.addColumnValueCondition("parentId",parentId);
        }
        return menuDao.search(queryModel);
    }*/

    /**
     * 查询菜单
     * @param para
     * @return
     */
    @Override
    public List<Menu> searchMenuList(ParamObject para) {
        QueryModel queryModel = new QueryModel();
        Long parentId = para.getLongParam("parentId");
        String deleteFlag = para.getStringParam("deleteFlag");
        if(parentId!=null){
            queryModel.addColumnValueCondition("parentId",parentId);
        }
        if (deleteFlag!=null){
            queryModel.addColumnValueCondition("deleteFlag",deleteFlag);
        }
        return menuDao.search(queryModel);
    }
}