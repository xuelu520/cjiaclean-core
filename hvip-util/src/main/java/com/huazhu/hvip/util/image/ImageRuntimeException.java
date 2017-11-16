/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ImageRuntimeException.java
 * Author:   lijing
 * Date:     2016-04-14 10:40:27
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-14 10:40:27> <version>   <desc>
 *
 */

package com.huazhu.hvip.util.image;

public class ImageRuntimeException extends RuntimeException {
	public ImageRuntimeException(String path, String proesstype){
		super("对图片"+path +"进行"  + proesstype +"出错" );
	}
}
