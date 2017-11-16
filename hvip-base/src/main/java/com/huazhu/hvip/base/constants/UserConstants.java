/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: UserConstants.java
 * Author:   admin
 * Date:     2016-03-08 15:32:55
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:32:55><version><desc><source>
 *
 */

package com.huazhu.hvip.base.constants;


public final class UserConstants {

    private UserConstants() {
        // hide me
    }

    //01 前台用户  02 后台用户 03 系统自动程序

    public static final String USER_TYPE_WEBUSER = "01";
    public static final String USER_TYPE_OPUSER = "02";
    public static final String USER_TYPE_SYSTEM = "03";



    /**
     * 用户认证状态
     */
    public static final String USER_INDENTITY_STATUS_NEW = "01";
    public static final String USER_INDENTITY_STATUS_APPLY = "02";
    public static final String USER_INDENTITY_STATUS_PASS = "03";
    public static final String USER_INDENTITY_STATUS_REJECT = "04";


    /**
     * 用户认证状态文件啊类型
     */
    public static final String USER_INDENTITY_FILETYPE_INDENTITY = "01";
    public static final String USER_INDENTITY_FILETYPE_ADDRESS = "02";


    /**
     * 用户跳过验证标志
     */
    public static final String USER_SKIP_FLAG_NO = "0";
    public static final String USER_SKIP_FLAG_YES = "1";


    /**
     * 用户邮件验证标志
     */
    public static final String USER_MAILVERIFIED_NO = "0";
    public static final String USER_MAILVERIFIED_YES = "1";

    /**
     * 安全设置标志
     */
    public static final String USER_SECURITYFLAG_NO = "0";
    public static final String USER_SECURITYFLAG_YES = "1";


    /**
     * 密码找回状态
     */
    public static final String USER_RETRIEVEPWD_STATUS_FAIL = "01";
    public static final String USER_RETRIEVEPWD_STATUS_PASS = "02";
    public static final String USER_RETRIEVEPWD_STATUS_FINISH = "03";


    /**
     * 密码类型
     */
    public static final String USER_PASSWORD_TYPE_LOGIN = "01";
    public static final String USER_PASSWORD_TYPE_TRADE = "02";

    /**
     * GA安全设置标志
     */
    public static final String USER_GAAUTHFLAG_NO = "0";
    public static final String USER_GAAUTHFLAG_YES = "1";


    /**
     *安全验证类型标志
     */
    public static final String USER_PASSWORD_TYPE_NO = "0";
    public static final String USER_PASSWORD_TYPE_GAAUTH = "1";
    public static final String USER_PASSWORD_TYPE_TRADEPASSWORD = "2";

    /**
     * 用户状态类型
     */
    public static final Integer USER_TYPE_NORMAL = 0;
    public static final Integer USER_TYPE_TEST = 1;
}
