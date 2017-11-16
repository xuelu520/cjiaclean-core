/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: SerialNumDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-08 15:32:23
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:32:23><version><desc><source>
 *
 */

package com.huazhu.hvip.common.dao.hibernate;

import java.util.HashMap;
import java.util.List;

import com.huazhu.hvip.common.dao.SerialNumDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.common.model.SerialNum;
import com.huazhu.hvip.util.SerialUtil;

@Repository("serialNumDao")
public class SerialNumDaoHibernate extends GenericDaoHibernate<SerialNum, Long> implements SerialNumDao {

    public SerialNumDaoHibernate() {
        super(SerialNum.class);
    }

     public List<SerialNum> searchSerialNumber(SerialNum serialNumber) {

    	StringBuffer hql = new StringBuffer();
        hql.append("from SerialNum ap ");

        if (serialNumber != null ){
        	if (serialNumber.getSerialName() != null && !serialNumber.getSerialName().equals("")){
        		hql.append("where ap.serialName like ").append("'").append("%").append(serialNumber.getSerialName()).append("%").append("'");
        	}

        	if (serialNumber.getSerialRule()!= null && !serialNumber.getSerialRule().equals("")){
        		hql.append("where ap.serialRule like ").append("'").append("%").append(serialNumber.getSerialRule()).append("%").append("'");
        	}
        }

        hql.append(" order by ap.serialId desc");

        Query query = this.getSession().createQuery(hql.toString());

        List<SerialNum> list = query.list();
        return list;
	}

	/*

	[{"value":"PO","type":"staticChar"},{"paramValueName":"billDate","format":"yyyyMMdd","type":"datetime"},{"length":2,"type":"randomChar"},{"length":2,"type":"randomNum"},{"paramValueName":"curValue","start":100,"length":4,"type":"serial"},{"paramValueName":"dept","type":"param"}]

	*/
       public String generateSerialNumber(String name) {

			//StringBuffer result = new StringBuffer();
    	   SerialNum serialNumber = (SerialNum)getSessionFactory().getCurrentSession().createQuery("select rc from SerialNum rc where rc.serialName = ?").setParameter(0, name).uniqueResult();
			if (serialNumber == null){
				return null;
			}

			String rule = serialNumber.getSerialRule();

			Integer curValue = serialNumber.getNextNum();
			HashMap paramMap = new HashMap();
			//paramMap.put("billDate", new Date());
			paramMap.put("curValue", curValue);
			//paramMap.put("dept", "IT");

			String result = SerialUtil.generateSerialNo(rule, paramMap);
		    serialNumber.setNextNum(curValue+1);

		    save(serialNumber);
		   // getHibernateTemplate().merge(serialNumber);
	        return result;
	}

	public SerialNum getSerialNumberByName(String serialName) {
		    String hql = "from SerialNum where serialName=:serialName";

		    Query query = this.getSession().createQuery(hql.toString());
		    query.setParameter("serialName", serialName);
		    List<SerialNum> list = query.list();

		    SerialNum serial=null;

		    if (list != null &&! list.isEmpty()) {
		    	serial =(SerialNum) list.get(0);
	        }
	        return serial;
	}
}
