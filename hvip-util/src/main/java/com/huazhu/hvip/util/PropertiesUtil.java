/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: PropertiesUtil.java
 * Author:   admin
 * Date:     2016-03-08 15:33:15
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:33:15><version><desc><source>
 *
 */

package com.huazhu.hvip.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author wuliang
 * This allow to access other Java classes call {@link #getProperty(String)}  to get properties from spring load properties,
 * Need to replace org.springframework.beans.factory.config.PropertyPlaceholderConfigurer with com.lsk.api.util.PropertiesUtil
 * in spring xml.
 */
public class PropertiesUtil extends PropertyPlaceholderConfigurer {
    private static Map<String, String> propertiesMap;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory,
              Properties props) throws BeansException {
         super.processProperties(beanFactory, props);

         propertiesMap = new HashMap<String, String>();
         for (Object key : props.keySet()) {
             String keyStr = key.toString();
             propertiesMap.put(keyStr, resolvePlaceholder(keyStr,
                 props, SYSTEM_PROPERTIES_MODE_FALLBACK));
         }
     }

     public static String getProperty(String name) {
         return propertiesMap.get(name);
     }
     
     public static void setProperty(String name, String value) {
         propertiesMap.put(name, value);
     }
}
