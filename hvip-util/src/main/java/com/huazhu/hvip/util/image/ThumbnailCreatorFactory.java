/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ThumbnailCreatorFactory.java
 * Author:   lijing
 * Date:     2016-04-14 10:56:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-14 10:56:40> <version>   <desc>
 *
 */

package com.huazhu.hvip.util.image;


import com.huazhu.hvip.util.image.impl.ImageMagickCreator;
import com.huazhu.hvip.util.image.impl.JavaImageIOCreator;

import java.io.IOException;

/**
 * 缩略图生成器工厂<br>
 * 
 * @author kingapex
 * 2010-7-10下午11:40:28
 */
public abstract class ThumbnailCreatorFactory {
	private ThumbnailCreatorFactory(){}
	public static String CREATORTYPE="javaimageio";
	
	/**
	 * 返回缩略图生成器
	 * @param source 图片原文件路径
	 * @param target 图片缩略图路径
	 * @return 
	 * 当{@link #CREATORTYPE} 为javaimageio时使用{@link JavaImageIOCreator }生成器<br>
	 * 当{@link #CREATORTYPE} 为imagemagick时使用{@link ImageMagickCreator }生成器<br>
	 */
	public static final IThumbnailCreator getCreator(String source,String target){
		if(CREATORTYPE.equals("javaimageio")){
			return new JavaImageIOCreator(source, target);
		}
		
		if(CREATORTYPE.equals("imagemagick")){
			try {
				return new ImageMagickCreator(source, target);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return new JavaImageIOCreator(source, target);
	}
}
