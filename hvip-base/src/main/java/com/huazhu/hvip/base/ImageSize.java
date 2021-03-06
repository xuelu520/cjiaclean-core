/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ImageSize.java
 * Author:   admin
 * Date:     2016-03-08 15:32:55
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:32:55><version><desc><source>
 *
 */

package com.huazhu.hvip.base;
public class ImageSize {

	private int srcX; // 原图片宽

	private int srcY; // 原图片高

	private int fitX; // 适配宽

	private int fitY; // 适配高

	private int destX; // 目标宽

	private int destY; // 目标高

	private int startX; // 截图坐标x轴开始点

	private int startY; // 截图坐标y轴开始点




	public ImageSize(int srcX, int srcY, int destX, int destY) {
		super();
		this.srcX = srcX;
		this.srcY = srcY;
		this.destX = destX;
		this.destY = destY;
	}

	public ImageSize(int destX, int destY) {
		super();

		this.destX = destX;
		this.destY = destY;
	}


	public int getSrcX() {
		return srcX;
	}

	public void setSrcX(int srcX) {
		this.srcX = srcX;
	}

	public int getSrcY() {
		return srcY;
	}

	public void setSrcY(int srcY) {
		this.srcY = srcY;
	}

	public int getFitX() {
		return fitX;
	}

	public void setFitX(int fitX) {
		this.fitX = fitX;
	}

	public int getFitY() {
		return fitY;
	}

	public void setFitY(int fitY) {
		this.fitY = fitY;
	}

	public int getDestX() {
		return destX;
	}

	public void setDestX(int destX) {
		this.destX = destX;
	}



	public int getDestY() {
		return destY;
	}

	public void setDestY(int destY) {
		this.destY = destY;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

}
