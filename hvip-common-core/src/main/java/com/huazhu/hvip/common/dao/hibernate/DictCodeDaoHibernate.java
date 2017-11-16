/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: DictCodeDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-08 15:32:23
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:32:23><version><desc><source>
 *
 */

package com.huazhu.hvip.common.dao.hibernate;

import java.util.List;

import com.huazhu.hvip.common.dao.DictCodeDao;
import com.huazhu.hvip.common.model.DictCode;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;

@Repository("dictCodeDao")
public class DictCodeDaoHibernate extends GenericDaoHibernate<DictCode, Long> implements DictCodeDao {

    public DictCodeDaoHibernate() {
        super(DictCode.class);
    }

    public DictCode searchByCodeNoCountry(String dictName, String codeNo,String country) {
		 if (StringUtils.isEmpty(dictName)
	        		|| StringUtils.isEmpty(codeNo) ){
	        	return null;
	        }

			StringBuffer hql = new StringBuffer();
			hql.append("select code from DictCode code ");
	        hql.append("left join code.dictionary as dict ");
	        hql.append("where dict.dictName = :dictName");
	    	hql.append(" and code.codeNo = :codeNo");
	    	hql.append(" and code.country=:country");


	    	  Query query = this.getSession().createQuery(hql.toString());
	    	  query.setParameter("dictName", dictName);
	          query.setParameter("codeNo", codeNo);
	          query.setParameter("country", country);
	          List<DictCode> codes = query.list();

	          /*ArrayList<Object> paramsList = new ArrayList<Object>();
		      paramsList.add(dictKey);
		      paramsList.add(codeNo);
	    	  List<DictCode> codes = this.getSessionFactory().find(hql.toString(),paramsList.toArray());*/
	    	if (codes != null && codes.size()>0){
	    		return codes.get(0);
	    	}else  {
	    		return null;
	    	}
	}
	public DictCode searchByCodeNo(String dictName, String codeNo) {
		 if (StringUtils.isEmpty(dictName)
	        		|| StringUtils.isEmpty(codeNo) ){
	        	return null;
	        }

			StringBuffer hql = new StringBuffer();
			hql.append("select code from DictCode code ");
	        hql.append("left join code.dictionary as dict ");
	        hql.append("where dict.dictName = :dictName");
	    	hql.append(" and code.codeNo = :codeNo");


	    	  Query query = this.getSession().createQuery(hql.toString());
	    	  query.setParameter("dictName", dictName);
	          query.setParameter("codeNo", codeNo);
	          List<DictCode> codes = query.list();

	          /*ArrayList<Object> paramsList = new ArrayList<Object>();
		      paramsList.add(dictKey);
		      paramsList.add(codeNo);
	    	  List<DictCode> codes = this.getSessionFactory().find(hql.toString(),paramsList.toArray());*/
	    	if (codes != null && codes.size()>0){
	    		return codes.get(0);
	    	}else  {
	    		return null;
	    	}
	}


	public List<DictCode> searchByDictName(String dictName, String sortKey) {
		if (StringUtils.isEmpty(dictName)){
        	return null;
        }
		StringBuffer hql = new StringBuffer();
		hql.append("select code from DictCode code ");
        hql.append(" left join code.dictionary as dict ");
        hql.append("where dict.dictName = :dictName");


        if (StringUtils.isNotEmpty(sortKey)){
        	hql.append(" and code.");
        	hql.append(sortKey);
        	hql.append(" is not null");
        	hql.append(" order by code.");
        	hql.append(sortKey);
        	hql.append(" asc");

        }else {
        	hql.append(" order by code.codeId asc");
        }
        Query query = this.getSession().createQuery(hql.toString());
  	    query.setParameter("dictName", dictName);
        //query.setParameter("codeNo", codeNo);
        List<DictCode> codes = query.list();
        return codes;
/*        ArrayList<Object> paramsList = new ArrayList<Object>();
        paramsList.add(dictName);
        return getHibernateTemplate().find(hql.toString(),paramsList.toArray());
*/	}


	@Override
	public List<DictCode> searchByDictNameLocal(String dictName, String country) {
		if (StringUtils.isEmpty(dictName)){
        	return null;
        }
		StringBuffer hql = new StringBuffer();
		hql.append("select code from DictCode code ");
        hql.append(" left join code.dictionary as dict ");
        hql.append("where dict.dictName = :dictName");
        hql.append(" and code.country=:country");
        hql.append(" order by code.codeId asc");

        Query query = this.getSession().createQuery(hql.toString());
  	    query.setParameter("dictName", dictName);
  	    query.setParameter("country",country);
        //query.setParameter("codeNo", codeNo);
        List<DictCode> codes = query.list();
        return codes;
	}
}
