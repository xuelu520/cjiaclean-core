/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: PictureDao.java
 * Author:   admin
 * Date:     2016-03-08 15:32:23
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:32:23><version><desc><source>
 *
 */

package com.huazhu.hvip.common.dao;

import java.util.List;
import java.util.Map;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.common.model.Picture;

/**
 * An interface that provides a data management interface to the Picture table.
 */
public interface PictureDao extends GenericDao<Picture, Long> {
	/**
	 * 查询图片
	 *
	 * @param pictureCriteria
	 *            图片查询bean
	 * @return
	 */
	//public List<Picture> searchPicture(PictureCriteria pictureCriteria);

	/**
	 * 更新某一业务对象图片除picId指定的图片以外其他图片为非默认
	 *
	 * @param picId
	 * @param bizType
	 * @param bizId
	 */
	public void updateOtherToNotDefault(String picId, String bizType, String bizId);

	/**
	 * 获得某特定物品的所有图片
	 *
	 * @param hotelId
	 * @return
	 */
	//public List<Picture> getPictureByBizTypeBizId(String bizType, String bizId);

	/**
	 * 获取未处理过的图片
	 *
	 * @return
	 */
	public List<Picture> getNeedCutPictures();

	/**
	 * 根据房型ID获取默认图片
	 *
	 * @param bizId
	 * @return
	 */
	public Picture getDefaultPic(String bizId);

	/**
	 *
	 * @param roomType
	 * @param roomTypeId
	 * @return
	 */
	public Integer getPictureCountByBizTypeBizId(String roomType, String roomTypeId);

	//public List<Map<String, String>> getPictureNameAndUrl(Map<String, String> paramMap);



	/**
	 *
	 * @param roomType
	 * @param roomTypeIdList
	 * @return
	 */
	public List<Picture> getPictureByBizTypeBizIdList(String roomType,
													  List<String> roomTypeIdList);

	public Map<String, String> getDefPicture(Map<String, String> paramMap);

	/**
	 *
	 * @param bizType
	 * @param
	 * @param specName
	 * @param pictureUrlContext
	 * @return
	 */
	List<Picture> getDefPicture(String bizType, List<String> bizIdList, String specName,
								  String pictureUrlContext);

	/**
	 * 通用图片查询
	 * @param picture
	 * @return
	 */
	public List<Picture> queryPicture(Picture picture);
    /**
     * 删除当前图片的切图纪录
     * @param picture
     */
	public void delCurrentFileCut(Picture picture);

	/**
	 * 得到当前酒店的所有照片，包括酒店照片和房型照片
	 * @param
	 * @return
	 */
	//public List<Picture> getPictureOfHotelAndRooomType(String hotelId);

	void updatePictureByDefaultFlag(String bizType, String bizId);

	void updatePictureSetDefaultFlag(String picId);

	/**
	 * 查询图片
	 * @param queryModel
	 * @param paramObject
	 * @return
	 */
	public List<Picture> searchPictureList(QueryModel queryModel,ParamObject paramObject);

}