package com.huazhu.hvip.common.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.common.dao.WxMenuDao;
import com.huazhu.hvip.common.manager.WxMenuManager;
import com.huazhu.hvip.common.model.WxMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmy
 * @create 2017-08-03 10:40
 **/
@Service("wxMenuManager")
public class WxMenuManagerImpl extends GenericManagerImpl<WxMenu,Long> implements WxMenuManager {
    private WxMenuDao wxMenuDao;
    @Autowired
    public WxMenuManagerImpl(WxMenuDao wxMenuDao) {
        super(wxMenuDao);
        this.wxMenuDao = wxMenuDao;
    }
}
