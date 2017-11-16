/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: JavaImageIOCreator.java
 * Author:   lijing
 * Date:     2016-04-14 10:57:07
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-14 10:57:07> <version>   <desc>
 *
 */

package com.huazhu.hvip.util.image.impl;

import com.huazhu.hvip.util.image.IThumbnailCreator;
import com.huazhu.hvip.util.FileUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用javax image io生成缩略图
 * @author kingapex
 * 2010-7-10下午11:43:05
 */
public class JavaImageIOCreator implements IThumbnailCreator {
	private String srcFile;
	private String destFile;

	private static Map<String, String> extMap;
	static {
		extMap = new HashMap<String, String>(5);
		extMap.put("jpg", "JPEG");
		extMap.put("jpeg", "JPEG");
		extMap.put("gif", "GIF");
		extMap.put("png", "PNG");
		extMap.put("bmp", "BMP");

	}

	public JavaImageIOCreator(String sourcefile, String targetFile) {
		this.srcFile =sourcefile;
		this.destFile = targetFile;
	}

	public void resize(int w, int h) {
		String ext = FileUtil.getFileExt(srcFile).toLowerCase();
		
		BufferedImage image;
		try {
			Image img = Toolkit.getDefaultToolkit().getImage(srcFile);
			//image = ImageIO.read(new File(srcFile));
			image=FileUtil.toBufferedImage(img);
			ImageIO.write(Lanczos.resizeImage(image, w, h), ext, new File(destFile));
		} catch (IOException e) {
			 throw new RuntimeException("生成缩略图错误",e);
		}
	}

	public static void main(String args[]){
		JavaImageIOCreator creator = new JavaImageIOCreator("d:/1.jpg", "d:/1_j_180.jpg");
		creator.resize(180, 180);
	}
	
}
