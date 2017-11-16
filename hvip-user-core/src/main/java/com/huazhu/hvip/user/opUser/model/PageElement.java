/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: PageElement.java
 * Author:   chenli
 * Date:     2016-03-20 12:02:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 12:02:40> <version>   <desc>
 *
 */

package com.huazhu.hvip.user.opUser.model;

import javax.persistence.*;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Entity
@Table(name = "pageelement")
public class PageElement {
    private long elementId;
    private String elementName;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "elementId")
    public long getElementId() {
        return elementId;
    }

    public void setElementId(long elementId) {
        this.elementId = elementId;
    }

    @Basic
    @Column(name = "elementName")
    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
