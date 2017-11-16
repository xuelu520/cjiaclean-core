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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huazhu.hvip.common.dao.AreaDao;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.common.manager.AreaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.common.model.Area;

@Service("areaManager")
public class AreaManagerImpl extends GenericManagerImpl<Area, Long> implements AreaManager {
    AreaDao areaDao;

    @Autowired
    public AreaManagerImpl(AreaDao areaDao) {
        super(areaDao);
        this.areaDao = areaDao;
    }

    public List getAreaList(QueryModel queryModel) {
        return areaDao.getAreaList(queryModel);
    }

    public List getSubwayWithStationName(QueryModel queryModel) {
        queryModel.setSortHql(" parentId asc ");
        List<Area> list = areaDao.search(queryModel);
         List<Area> areaList = new ArrayList();
         Map areaMap = new HashMap();
         for(Area area : list){
             if(area.getParentId() != null){

             }else{

             }
         }

        return list;
    }

    @Override
    public Area createArea(Area area) {
        return areaDao.createArea(area);
    }
}