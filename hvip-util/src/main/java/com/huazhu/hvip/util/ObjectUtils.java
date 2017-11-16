/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ObjectUtils.java
 * Author:   admin
 * Date:     2016-03-10 17:03:23
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-10 17:03:23><version><desc><source>
 */

package com.huazhu.hvip.util;

/**
 * 对象判断常用方法
 *
 * @author HUQIANBO
 * @since cjia-commons-base-api-1.0.0
 */
public class ObjectUtils {
    /**
     * 判断String对象是否是为Null或者为""
     * @param str String对象
     * @return 判断结果
     */
    public static boolean isEmpty(String str){
        if (str == null || "".equals(str.trim())){
            return true;
        }

        return false;
    }

    /**
     * 判断Integer对象是否是为Null或者为0
     * @param i Integer对象
     * @return 判断结果
     */
    public static boolean isEmpty(Integer i){
        if(i == null || i == 0){
            return true;
        }

        return false;
    }

    /**
     * 判断Long对象是否是为Null或者为0
     * @param l Long对象
     * @return 判断结果
     */
    public static boolean isEmpty(Long l){
        if (l == null || l == 0L){
            return true;
        }

        return false;
    }

    /**
     * 判断Double对象是否是为Null或者为0
     * @param d Double对象
     * @return 判断结果
     */
    public static boolean isEmpty(Double d){
        if(d == null || d == 0D){
            return true;
        }

        return false;
    }
}
