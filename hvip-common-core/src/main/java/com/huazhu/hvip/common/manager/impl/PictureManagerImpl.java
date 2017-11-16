/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: PictureManagerImpl.java
 * Author:   admin
 * Date:     2016-03-08 15:31:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:31:50><version><desc><source>
 *
 */

package com.huazhu.hvip.common.manager.impl;

import java.util.*;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.common.dao.PictureDao;
import com.huazhu.hvip.common.model.Picture;
import com.huazhu.hvip.common.manager.PictureManager;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.hvip.base.model.QueryModel;

@Service("pictureManager")
public class PictureManagerImpl extends GenericManagerImpl<Picture, Long> implements PictureManager {
    PictureDao pictureDao;

  //  Autowired
//	private Properties projectProperties;

    @Autowired
    public PictureManagerImpl(PictureDao pictureDao) {
        super(pictureDao);
        this.pictureDao = pictureDao;
    }


	/**
	 * {@inheritDoc}
	 */
	public List<Picture> getBizPictureList(String bizType, String bizId) {

		 QueryModel queryModel = new QueryModel();
  		 queryModel.addColumnValueCondition("bizType", bizType);
  		 queryModel.addColumnValueCondition("bizId", bizId);
  		 queryModel.addColumnValueCondition("srcFlag", "1");
  		 return pictureDao.search(queryModel);
	}

	/**
	 * {@inheritDoc}
	 */
	public Picture uploadBizPicture(Picture picture) {


		//PictureCriteria pictureCriteria = new PictureCriteria();


		 QueryModel queryModel = new QueryModel();
  		 queryModel.addColumnValueCondition("bizType", picture.getBizType());
  		 queryModel.addColumnValueCondition("bizId", picture.getBizId());
  		 queryModel.addColumnValueCondition("srcFlag", "1");
  		 queryModel.addColumnValueCondition("defaultFlag", "1");



		List<Picture> picList = pictureDao.search(queryModel);

		//picture.setCreatedTime(new Date());

		picture.setCutFlag("0");


		if(picList!=null && picList.size()>0){
			picture.setDefaultFlag("0");
		}else{
			picture.setDefaultFlag("1");
		}

		picture.setSrcFlag("1");

		return pictureDao.save(picture);

	}

	/**
	 * {@inheritDoc}
	 */
	public void updateBizPicture(Long picId, String cateId, String picName) {

		Picture picture = pictureDao.get( picId );

		picture.setPicName(picName);

		//picture.setCateId(cateId);

		pictureDao.save(picture);

	}

	/**
	 * {@inheritDoc}
	 */
	public void setPictureAsDefault(Long picId, String bizType, String bizId) {
		Picture picture = pictureDao.get(picId);

		picture.setDefaultFlag("1");

		pictureDao.save(picture);
		 updateOtherToNotDefault(picId, bizType, bizId);
	}

	@Override
	public List<Picture> getPictureOfHotel(String hotelId) {

		Long fullStart = System.currentTimeMillis();

		//List<Picture> picList = pictureDao.getPictureOfHotelAndRooomType(hotelId);

//		List<Picture> picList = pictureDao.getPictureByBizTypeBizId(PictureType.HOTEL, hotelId);
//
//		List<RoomType> roomTypeList = roomTypeDao.getRoomTypeByHotelId(hotelId);
//		for (RoomType rt : roomTypeList) {
//			picList.addAll(getPictureOfRoomType(rt.getRoomTypeId()));
//		}

		Long fullEnd = System.currentTimeMillis();
		log.info("getPictureOfRoomType need " + (fullEnd - fullStart) + "ms "  + "hotelId:" + hotelId);

	//	return picList;
		return null;
	}




	//public static final String PictureType_COMPANY = "1";
	//public static final String PictureType_HOTEL = "2";
	//public static final String PictureType_ROOM_TYPE = "3";
	//public static final String PictureType_OTHER = "4";
	@Override
	public List<Picture> getPictureOfRoomType(String roomTypeId) {

		Long fullStart = System.currentTimeMillis();

		//List<Picture> pictureList = pictureDao.getPictureByBizTypeBizId( Constants.PictureType_ROOM_TYPE, roomTypeId);

		Long fullEnd = System.currentTimeMillis();
		log.info("getPictureOfRoomType need " + (fullEnd - fullStart) + "ms "  + "roomTypeId:" + roomTypeId);

		//return pictureList;

		return null;
	}

	public Picture getDefaultPic(String roomTypeId) {
		return pictureDao.getDefaultPic(roomTypeId);
	}

	@Override
	public List<Map<String,String>> getPictureNameAndUrl(String bizType,String bizId,String specName) {
		Map<String,String> paramMap = new HashMap<String, String>();
		paramMap.put("bizType", bizType);
		paramMap.put("bizId",bizId);
		paramMap.put("specName", specName);
		String pictureUrlContext = projectProperties.getProperty("pictureUrlContext");
		paramMap.put("pictureUrlContext",pictureUrlContext);
		//List<Map<String, String>> priList= pictureDao.getPictureNameAndUrl(paramMap);
		//return priList;
		return null;
	}


	@Override
	public Map<String, List<Picture>> getPictureOfRoomType(List<String> roomTypeIdList) {

		Map<String, List<Picture>> pictureMap = new HashMap<String, List<Picture>>();

//		List<Picture> pictureList = pictureDao.getPictureByBizTypeBizIdList( Constants.PictureType_ROOM_TYPE, roomTypeIdList);
//
//		for (Picture p : pictureList) {
//			List<Picture> pictures = pictureMap.get(p.getBizId());
//			if (pictures == null) {
//				pictures = new ArrayList<Picture>();
//				pictureMap.put(p.getBizId(), pictures);
//			}
//			pictures.add(p);
//		}

		return pictureMap;
	}


	@Override
	public Map<String, String> getDefPicture(String bizType, String bizId, String specName) {

		Map<String,String> paramMap = new HashMap<String, String>();
		paramMap.put("bizType", bizType);
		paramMap.put("bizId",bizId);
		paramMap.put("specName", specName);
		String pictureUrlContext = projectProperties.getProperty("pictureUrlContext");
		paramMap.put("pictureUrlContext",pictureUrlContext);
		Map<String, String> map= pictureDao.getDefPicture(paramMap);

		return map;
	}

	@Override
	public List<Picture> getDefPicture(String bizType, List<String> bizIdList, String specName) {
		String pictureUrlContext = projectProperties.getProperty("pictureUrlContext");
		List<Picture> voList = pictureDao.getDefPicture(bizType, bizIdList, specName, pictureUrlContext);
		return voList;
	}

        @Override
        public Picture getRoomTypeDefaultPciture(String roomTypeId, String specName) {
//            String pictureUrlContext = projectProperties.getProperty("pictureUrlContext");
//            List<String> roomTypeIdList = new ArrayList<String>();
//            roomTypeIdList.add(roomTypeId);
//            List<PictureVO> list = pictureDao.getDefPicture(Constants.PictureType_ROOM_TYPE, roomTypeIdList, specName, pictureUrlContext);
//            if(list !=null && list.size()>0){
//                return list.get(0);
//            }
            return null;
        }

	@Override
	public List<Picture> getHotelPictureOfHotelId(String hotelId) {

		Long fullStart = System.currentTimeMillis();

		//List<Picture> pList = pictureDao.getPictureByBizTypeBizId(Constants.PictureType_HOTEL , hotelId);

		Long fullEnd = System.currentTimeMillis();
		log.info("getHotelPictureOfHotelId need " + (fullEnd - fullStart) + "ms "  + "hotelId:" + hotelId);

		return null;
	}

	@Override
	public List<Picture> queryPicture(Picture picture) {

		 return pictureDao.queryPicture(picture);
	}

	@Override
	public Picture getPictureByPicSysNameAndSpecNameAndBizId(String picSysName,
			String specName, String bizId) {


		 QueryModel queryModel = new QueryModel();
  		 queryModel.addColumnValueCondition("picSysName", picSysName);
  		 queryModel.addColumnValueCondition("bizId", bizId);
  		 queryModel.addColumnValueCondition("specName", specName);

         List<Picture> list = pictureDao.search(queryModel);
		 if(list !=null && list.size()>0){
			 return list.get(0);
		 }
		return null;
	}
	/**
	 * 更新某一业务对象图片除picId指定的图片以外其他图片为非默认
	 *
	 * @param picId
	 * @param bizType
	 * @param bizId
	 */
	public void updateOtherToNotDefault(Long picId, String bizType, String bizId){
		 QueryModel queryModel = new QueryModel();

 		 queryModel.addColumnValueCondition("bizId", bizId);
 		 queryModel.addColumnValueCondition("bizType", bizType);
 		 queryModel.addHqlCondition( "picId != "+picId );

 		 queryModel.addColumnValueCondition("srcFlag", "1");

        List<Picture> list = pictureDao.search(queryModel);

        for(Picture pic:list){

        	pic.setDefaultFlag("0");

        	pictureDao.save(pic);

        }

	}


	@Override
	public List<Picture> getNeedCutPictures() {

		 QueryModel queryModel = new QueryModel();
		 int pageSize =50;
		 int pageNo =1;
		 queryModel.setPageNo(pageNo);
		 queryModel.setPageSize(pageSize);
 		 queryModel.addColumnValueCondition("cutFlag","0");
 		 queryModel.addColumnValueCondition("srcFlag","1");
 		 queryModel.addHqlCondition(" bizType in ('2','3') ");

 		 List<Picture> list = pictureDao.search(queryModel);

 		 return list;

		/*
		   select * from picture where 1=1 and bizType in ('2','3')
	         <dynamic prepend="AND">

	           <isNotEmpty prepend="AND" property="bizId">
	              bizId   = #bizId#
	           </isNotEmpty>

	           <isNotEmpty prepend="AND" property="cateId">
	              cateId   = #cateId#
	           </isNotEmpty>

	           <isNotEmpty prepend="AND" property="picSysName">
	              picSysName   = #picSysName#
	           </isNotEmpty>

	           <isNotEmpty prepend="AND" property="specName">
	              specName   = #specName#
	           </isNotEmpty>

	           <isNotEmpty prepend="AND" property="picName">
	             picName LIKE '%$picName$%'
	           </isNotEmpty>


	             <isNotEmpty prepend="AND" property="srcFlag">
	              srcFlag   = #srcFlag#
	           </isNotEmpty>

	             <isNotEmpty prepend="AND" property="cutFlag">
	              cutFlag   = #cutFlag#
	           </isNotEmpty>

	             <isNotEmpty prepend="AND" property="defaultFlag">
	              defaultFlag   = #defaultFlag#
	           </isNotEmpty>
	              */
		       //return (List<Picture>) getSqlMapClientTemplate().queryForList("searchPicture", paraMap);

	}


	@Override
	public void delCurrentFileCut(Picture picture) {



		 QueryModel queryModel = new QueryModel();

 		 queryModel.addColumnValueCondition("bizId",picture.getBizId());
 		 queryModel.addColumnValueCondition("bizType",picture.getBizType());
 		 queryModel.addColumnValueCondition("picSysName", picture.getPicSysName());
 		 queryModel.addColumnValueCondition("srcFlag","0");


        List<Picture> list = pictureDao.search(queryModel);

        for(Picture pic:list){

        	pic.setDefaultFlag("0");

        	pictureDao.remove(pic);

        }




	}

	/**
	 * 批量保存图片
	 * @param list
	 * @return
	 */
	@Override
	public List<Picture> savePictures(List<Picture> list) {
		List<Picture> returnList =  new ArrayList<Picture>();
		for (Picture pic : list){
			Picture picture = pictureDao.save(pic);
			returnList.add(picture);
		}
		return returnList;
	}

	/**
	 * 查询图片
	 * @param para
	 * @return
	 */
	@Override
	public List<Picture> searchPictureList(ParamObject para) {

		List<Long> picIds = (List<Long>) para.getParam("picIds");
		QueryModel queryModel = new QueryModel();
		if (picIds != null&&picIds.size()>0) {
			String str = StringUtils.join(picIds,",");
			queryModel.addColumnValueCondition("p.picId",QueryModel.OPERATOR_IN,"("+str+")");
		}
		List<Picture> pictureList = pictureDao.searchPictureList(queryModel, para);

		return pictureList;
	}

}