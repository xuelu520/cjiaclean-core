/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: loginUserVO.java
 * Author:   chenli
 * Date:     2016-04-26 17:28:54
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-04-26 17:28:54> <version>   <desc>
 *
 */

package com.huazhu.hvip.user.request;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class LoginUserVO implements Serializable {
    private String userName;                    // required

    private String password;                    // required

    private String validcode; //验证码

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidcode() {
        return validcode;
    }

    public void setValidcode(String validcode) {
        this.validcode = validcode;
    }
}
