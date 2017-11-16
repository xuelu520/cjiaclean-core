/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: EnumUtils.java
 * Author:   admin
 * Date:     2016-03-10 17:03:58
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-10 17:03:58><version><desc><source>
 */

package com.huazhu.hvip.util;

import java.lang.reflect.Field;

/**
 * 枚举工具类。<br/>
 *
 * @author HUQIANBO
 * @since [产品/模块版本] （可选）
 */
public class EnumUtils {

    /**
     * 该方法可以根据枚举的名称（name）获取枚举对象。<br/>
     * 通过反射进行获取。
     *
     * @param enumType 枚举类型
     * @param str      枚举名称
     * @param <T>      泛型定义枚举类型
     * @return 指定类型的枚举对象，如果内部错误则返回null
     */
    public static <T extends Enum<T>> T getEnumInstance(Class<T> enumType, String str) {
        T enumClass = null;
        try {
            enumClass = Enum.valueOf(enumType, str);
        } catch (Exception e) {
            try {
                T[] enums = enumType.getEnumConstants();
                for (T instance : enums) {
                    if (enumClass != null)
                        break;
                    Field[] fields = instance.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if (str.equalsIgnoreCase(field.get(instance).toString())) {
                            enumClass = instance;
                            break;
                        }
                    }
                }
            } catch (Exception ex) {
                enumClass = null;
            }
        }
        return enumClass;
    }

    /**
     * 根据枚举名称（name）获取指定字段的值。
     *
     * @param enumType  枚举类型
     * @param enumName  枚举名称
     * @param fieldName 字段名
     * @param <T>       泛型定义枚举类型
     * @return 指定字段的值，如果内部错误则返回null
     */
    public static <T extends Enum<T>> Object getFieldValue(Class<T> enumType, String enumName, String fieldName) {
        Object value = null;
        Object enumClass = null;
        try {
            T[] enums = enumType.getEnumConstants();
            for (T instance : enums) {
                if (enumName.equalsIgnoreCase(instance.name())) {
                    enumClass = instance;
                    break;
                }
            }
            Field[] fields = enumClass.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (fieldName.equalsIgnoreCase(field.getName())) {
                    value = field.get(enumClass);
                    break;
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return value;
    }

}
