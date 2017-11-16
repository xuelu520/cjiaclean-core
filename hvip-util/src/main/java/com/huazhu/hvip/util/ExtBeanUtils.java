package com.huazhu.hvip.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ExtBeanUtils extends BeanUtils {
    static {
        ConvertUtils.register(new DateConvert(), java.util.Date.class);
        ConvertUtils.register(new DateConvert(), java.sql.Date.class);
        ConvertUtils.register(new DateConvert(), java.sql.Timestamp.class);
    }

    public static void populate(Object bean, Map properties) throws IllegalAccessException, InvocationTargetException {
        BeanUtils.populate(bean, properties);
    }


}