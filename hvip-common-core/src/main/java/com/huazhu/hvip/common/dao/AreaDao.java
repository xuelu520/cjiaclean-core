/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: AreaDao.java
 * Author:   admin
 * Date:     2016-03-08 15:32:23
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:32:23><version><desc><source>
 *
 */

package com.huazhu.hvip.common.dao;

import java.util.List;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.common.model.Area;


/**
 * An interface that provides a data management interface to the DictCode table.
 */

public interface AreaDao extends GenericDao<Area, Long> {

	public List getAreaList(QueryModel queryModel);

	public Area createArea(Area area);

//	public List<Area> getSubwayWithStationName(QueryModel queryModel);
}
