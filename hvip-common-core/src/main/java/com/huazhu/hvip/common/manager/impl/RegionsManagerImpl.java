/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: AreaManagerImpl.java
 * Author:   admin
 * Date:     2016-03-08 15:31:50
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:31:50><version><desc><source>
 *
 */

package com.huazhu.hvip.common.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.common.dao.RegionsDao;
import com.huazhu.hvip.common.manager.RegionsManager;
import com.huazhu.hvip.common.model.Regiongaode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("regionsManager")
public class RegionsManagerImpl extends GenericManagerImpl<Regiongaode, Long> implements RegionsManager {
    RegionsDao regionsDao;

    @Autowired
    public RegionsManagerImpl(RegionsDao regionsDao) {
        super(regionsDao);
        this.regionsDao = regionsDao;
    }

    public List<Regiongaode> searchRegionsVOList(Long parentId) {
        List<Regiongaode> regionsVOList = regionsDao.getRegionsList(parentId);
        return regionsVOList;
    }
}