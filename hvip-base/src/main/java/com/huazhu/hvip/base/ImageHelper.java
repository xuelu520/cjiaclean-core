/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: ImageHelper.java
 * Author:   admin
 * Date:     2016-03-08 15:32:55
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:32:55><version><desc><source>
 *
 */

package com.huazhu.hvip.base;

import org.apache.commons.lang.StringUtils;

public class ImageHelper {
    public static String getImageUrl(String url, String type) {
        String pre = StringUtils.substringBeforeLast(url, ".");// aaa
        String suf = StringUtils.substringAfterLast(url, ".");// jpg
        return pre + "/" + type + "." + suf;
    }
}
