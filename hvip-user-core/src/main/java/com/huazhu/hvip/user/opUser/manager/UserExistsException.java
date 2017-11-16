/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: UserExistsException.java
 * Author:   admin
 * Date:     2016-03-10 14:07:05
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-10 14:07:05><version><desc><source>
 */

package com.huazhu.hvip.user.opUser.manager;


/**
 * An exception that is thrown by classes wanting to trap unique
 * constraint violations.  This is used to wrap Spring's
 * DataIntegrityViolationException so it's checked in the web layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class UserExistsException extends Exception {
    private static final long serialVersionUID = 4050482305178810162L;

    /**
     * Constructor for UserExistsException.
     *
     * @param message exception message
     */
    public UserExistsException(final String message) {
        super(message);
    }
}
