/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SourceDefineVO.java
 * Author:   lijing
 * Date:     2016-03-21 10:16:22
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-21 10:16:22> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.vo;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SourceDefineVO implements Serializable{
    private Long sourceid;
    private String sourceName;
    private String description;
    private String category;

    public Long getSourceid() {
        return sourceid;
    }

    public void setSourceid(Long sourceid) {
        this.sourceid = sourceid;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
