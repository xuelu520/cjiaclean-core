/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: PromptMsg.java
 * Author:   HUQIANBO001
 * Date:     2016-04-12 13:14:31
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-12 13:14:31><version><desc>
 */

package com.huazhu.hvip.product.vo;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class PromptMsg implements Serializable {

    private String promptName; //名称

    private String promptText; //内容

    public String getPromptName() {
        return promptName;
    }

    public void setPromptName(String promptName) {
        this.promptName = promptName;
    }

    public String getPromptText() {
        return promptText;
    }

    public void setPromptText(String promptText) {
        this.promptText = promptText;
    }
}
