/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: PictureManager.java
 * Author:   admin
 * Date:     2016-03-08 15:31:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:31:50><version><desc><source>
 *
 */

package com.huazhu.hvip.common.manager;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.common.model.Picture;
import com.huazhu.hvip.base.service.GenericManager;

@WebService
public interface PictureManager extends GenericManager<Picture, Long> {
	/**
	 * 根据业务类型(房型，酒店，商家）列出具体业务对象关联的的原始图片（未切图）
	 *
	 * @param bizType
	 *            业务类型
	 * @param bizId
	 *            业务ID
	 * @return
	 */
	public List<Picture> getBizPictureList(String bizType, String bizId);

	/**
	 * 图片上传
	 *
	 * @param picture
	 * @return
	 */
	public Picture uploadBizPicture(Picture picture);

	/**
	 * 根据图片id更新图片的基本信息（类别,图片业务名称)
	 *
	 * @param picId
	 * @param cateId
	 * @param picName
	 */
	public void updateBizPicture(Long picId, String cateId, String picName);

	/**
	 * 设置图片为默认图片,同时将其他图片未非默认
	 *
	 * @param picId
	 * @param bizType
	 * @param bizId
	 */
	public void setPictureAsDefault(Long picId, String bizType, String bizId);

	/**
	 * 获取酒店+所有房型图片
	 * @return
	 */
	public List<Picture> getPictureOfHotel(String hotelId);

	/**
	 * 获取酒店图片
	 * @return
	 */
	public List<Picture> getHotelPictureOfHotelId(String hotelId);
	/**
	 *
	 * @return
	 */
	public List<Picture> getPictureOfRoomType(String roomTypeId);

	public Picture getDefaultPic(String roomTypeId);

	public List<Map<String, String>> getPictureNameAndUrl(String bizType, String bizId, String specName) ;

	public Map<String, String> getDefPicture(String bizType, String bizId, String specName);

	/**
	 *
	 * @param roomTypeIdList
	 * @return
	 */
	public Map<String, List<Picture>> getPictureOfRoomType(List<String> roomTypeIdList);

	public List<Picture> getDefPicture(String bizType, List<String> bizIdList, String specName);

    public Picture getRoomTypeDefaultPciture(String roomTypeId, String specName);

	/**
	 * 通用图片查询
	 * @param picture
	 * @return
	 */
	public List<Picture> queryPicture(Picture picture);

	/**
	 * 根据
	 * @param picSysName
	 * @param specName
	 * @param bizId
	 * @return
	 */
	public Picture getPictureByPicSysNameAndSpecNameAndBizId(String picSysName, String specName, String bizId);


	/**
	 * 获取需要切图的图片
	 * @return
	 */
	public List<Picture> getNeedCutPictures();

	/**
	 * 删除该图片的切图
	 * @param picture
	 */
	public void delCurrentFileCut(Picture picture);

	/**
	 * 批量保存图片
	 * @param list
	 * @return
	 */
	public List<Picture> savePictures(List<Picture> list);

	/**
	 * 查询图片
	 * @param para
	 * @return
	 */
	public List<Picture> searchPictureList(ParamObject para);

}