/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: PictureDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-08 15:32:23
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:32:23><version><desc><source>
 *
 */

package com.huazhu.hvip.common.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.common.dao.PictureDao;
import com.huazhu.hvip.common.model.Picture;
import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;

@Repository("pictureDao")
public class PictureDaoHibernate extends GenericDaoHibernate<Picture, Long> implements PictureDao {

    public PictureDaoHibernate() {
        super(Picture.class);
    }



	//public List<Picture> searchPicture(PictureCriteria pictureCriteria) {

		//return getSqlMapClientTemplate().queryForList("searchPicture", pictureCriteria);

	//	 List<Picture> list=null;

	//}

	@SuppressWarnings( { "unchecked", "rawtypes" })
	public void updateOtherToNotDefault(String picId, String bizType, String bizId) {
		/*
		Map paraMap = new HashMap();
		paraMap.put("picId", picId);
		paraMap.put("bizType", bizType);
		paraMap.put("bizId", bizId);

		getSqlMapClientTemplate().update("updateOtherToNotDefault", paraMap);*/

	}


	public List<Picture> getPictureOfHotelAndRooomType(String hotelId) {
		//return (List<Picture>) getSqlMapClientTemplate().queryForList("getPictureOfHotelAndRooomType", hotelId);
		return null;
	}


	public List<Picture> getPictureByBizTypeBizId(String bizType, String bizId) {

		/*Map paraMap = new HashMap();
		paraMap.put("bizType", bizType);
		paraMap.put("bizId", bizId);

		return (List<Picture>) getSqlMapClientTemplate().queryForList("searchPicture", paraMap);*/
		return null;
	}

	@SuppressWarnings( { "unchecked", "rawtypes" })
	@Override
	public List<Picture> getNeedCutPictures() {
		/*Map paraMap = new HashMap();
		paraMap.put("cutFlag", "0");
		paraMap.put("srcFlag", "1");

		//return (List<Picture>) getSqlMapClientTemplate().queryForList("searchPicture", paraMap);

		return (List<Picture>) getSqlMapClientTemplate().queryForList("searchPictureForCut", paraMap,0,50);*/
		return null;

	}

	@SuppressWarnings("unchecked")
	public Picture getDefaultPic(String bizId) {
		/*
		PictureCriteria pc = new PictureCriteria();
		pc.setBizType(PictureType.ROOM_TYPE);
		pc.setSrcFlag("0");
		pc.setSpecName(PictureSpecEnum.WEBCUT_60X40.getName());
		pc.setBizId(bizId);
		pc.setDefaultFlag("1");
		List<Picture> picList = getSqlMapClientTemplate().queryForList("searchPicture", pc);
		if (picList != null && picList.size() > 0) {
			return picList.get(0);
		} else {
			return null;
		}*/
		return null;
	}

	/**
	 *
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Integer getPictureCountByBizTypeBizId(String bizType, String bizId) {
	/*
		Map paraMap = new HashMap();
		paraMap.put("bizType", bizType);
		paraMap.put("bizId", bizId);
		return (Integer)getSqlMapClientTemplate().queryForObject("getPictureCountByBizTypeBizId", paraMap);
		*/
		return 0;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Picture> getPictureByBizTypeBizIdList(String bizType,
			List<String> bizIdList) {
		/*Map paraMap = new HashMap();
		paraMap.put("bizType", bizType);
		paraMap.put("bizIdList", bizIdList);
		return getSqlMapClientTemplate().queryForList("getPictureByBizTypeBizIdList", paraMap);*/
		return null;
	}

	@SuppressWarnings("unchecked")
	 public List<Map<String, String>> getPictureNameAndUrl(Map<String, String> paramMap) {
		//List<Map<String, String>> picList = getSqlMapClientTemplate().queryForList("getPictureNameAndUrl",paramMap);
		//return picList;
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> getDefPicture(Map<String, String> paramMap) {
		//List<Map<String, String>> list = getSqlMapClientTemplate().queryForList("getDefPicture",paramMap);
		//return list != null && list.size() > 0 ? list.get(0) : null;
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Picture> getDefPicture(String bizType, List<String> bizIdList, String specName,
			String pictureUrlContext) {
	  /*
		if (bizIdList == null || bizIdList.size() == 0) {
			return new ArrayList<PictureVO>();
		}

		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bizType", bizType);
		paramMap.put("bizIdList",bizIdList);
		paramMap.put("specName", specName);

		paramMap.put("pictureUrlContext",pictureUrlContext);

		List<PictureVO> voList = getSqlMapClientTemplate().queryForList("getDefPicturelist",paramMap);

		return voList;*/
		return null;
	}

	@Override
	public List<Picture> queryPicture(Picture picture) {

		/*Map paraMap = new HashMap();
		paraMap.put("bizType", picture.getBizType());
		paraMap.put("bizId",picture.getBizId());
		paraMap.put("specName", picture.getSpecName());
		paraMap.put("picSysName", picture.getPicSysName());
		return getSqlMapClientTemplate().queryForList("queryPicture", paraMap);*/

		 return null;

	}

	@Override
	public void delCurrentFileCut(Picture picture) {
		/*Map paraMap = new HashMap();
		paraMap.put("bizType", picture.getBizType());
		paraMap.put("bizId",picture.getBizId());
		paraMap.put("picSysName", picture.getPicSysName());

		getSqlMapClientTemplate().delete("delCurrentFileCut", paraMap);*/
	}

    @Override
    public void updatePictureByDefaultFlag(String bizType, String bizId) {
       /* Map<String, String> map = new HashMap<String, String>();
        map.put("bizType", bizType);
        map.put("String", bizId);
        getSqlMapClientTemplate().update("updateDefaultFlag", map);*/
    }

    @Override
    public void updatePictureSetDefaultFlag(String picId) {
       // getSqlMapClientTemplate().update("updatePictureSetDefaultFlag", picId);
    }

	@Override
	public List<Picture> searchPictureList(QueryModel queryModel,ParamObject paramObject){

		List<Picture> list = new ArrayList();
		try {
			Session session = super.getSessionFactory().getCurrentSession();
			String conditionSql = queryModel.getQueryHqlStr();
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT p.* " );

			String sqlW = "";

			if(paramObject != null){

				Long goodsId = paramObject.getLongParam("goodsId");
				if(goodsId!=null){
					sqlW = "";
				}
			}


			sql.append(" FROM picture p ");
			sql.append(" WHERE");
			sql.append(conditionSql);
			sql.append(sqlW);

			boolean pageFlag = false;

			// 如果在分页模式下，则计算总数
			if (queryModel.getPageSize() != null && queryModel.getTotalNum() != null) {

				StringBuffer countSql = new StringBuffer();
				countSql.append(" select count(*)  ");
				countSql.append(" FROM (" + sql + ") aa ");
				//countSql.append(conditionSql);
				SQLQuery countQuery = session.createSQLQuery(countSql.toString());
				queryModel.assignValue(countQuery);
				List countList = countQuery.list();
				int totalNum = 0;
				if (!countList.isEmpty()) {
					String str = new String(countList.get(0).toString());
					totalNum = (Long.valueOf(str)).intValue();
				}
				queryModel.setTotalNum(totalNum);
				paramObject.setTotalNum(totalNum);
				pageFlag = true;
			}

			String queryString = sql.toString();

			SQLQuery query = session.createSQLQuery(queryString);

			query.addEntity(Picture.class);

			queryModel.assignValue(query);

			// 分页模式下只列当前页
			if (queryModel.getPageSize() !=null && queryModel.getPageSize() > 0) {
				list = query.setFirstResult(queryModel.getStartRecord()).setMaxResults(queryModel.getPageSize()).list();

			} else {
				list = query.list();

			}

			if (!pageFlag) {

				if (!list.isEmpty())
					queryModel.setTotalNum(list.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}
}
