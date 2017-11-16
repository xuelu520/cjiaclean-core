/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsPictureVO.java
 * Author:   HUQIANBO001
 * Date:     2016-04-07 19:30:48
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-07 19:30:48><version><desc>
 */

/**
 *
 */
package com.huazhu.hvip.product.vo;


import com.huazhu.hvip.base.constants.Constants;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.Date;

public class GoodsPictureVO implements Serializable{

	private Long galleryId;
    private Long goodsId;
    private Long picId;
    private String defaultFlag;

	private String typeId;
	private String srcFileName;
	private String picSysName;
	private String specName;
	private String url;
	private String picName;
	private String bizId;
	private String bizType;
	private String srcFlag;
	private String cutFlag;
	private Integer height;
	private Integer width;
	private Date createTime;
	private String defaultSize;
	private String picUrlView;
	private String picPrefixView;
	private String picSuffixView;

	public String getPicUrlView() {
		return picUrlView;
	}

	public void setPicUrlView(String picUrlView) {
		this.picUrlView = picUrlView;
	}

	public String getPicPrefixView() {
		return picPrefixView;
	}

	public void setPicPrefixView(String picPrefixView) {
		this.picPrefixView = picPrefixView;
	}

	public String getPicSuffixView() {
		return picSuffixView;
	}

	public void setPicSuffixView(String picSuffixView) {
		this.picSuffixView = picSuffixView;
	}

	public Long getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(Long galleryId) {
		this.galleryId = galleryId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getPicId() {
		return picId;
	}

	public void setPicId(Long picId) {
		this.picId = picId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getSrcFileName() {
		return srcFileName;
	}

	public void setSrcFileName(String srcFileName) {
		this.srcFileName = srcFileName;
	}

	public String getPicSysName() {
		return picSysName;
	}

	public void setPicSysName(String picSysName) {
		this.picSysName = picSysName;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getSrcFlag() {
		return srcFlag;
	}

	public void setSrcFlag(String srcFlag) {
		this.srcFlag = srcFlag;
	}

	public String getCutFlag() {
		return cutFlag;
	}

	public void setCutFlag(String cutFlag) {
		this.cutFlag = cutFlag;
	}

	public String getDefaultFlag() {
		return defaultFlag;
	}

	public void setDefaultFlag(String defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDefaultSize() {
		return defaultSize;
	}

	public void setDefaultSize(String defaultSize) {
		this.defaultSize = defaultSize;
	}
}
