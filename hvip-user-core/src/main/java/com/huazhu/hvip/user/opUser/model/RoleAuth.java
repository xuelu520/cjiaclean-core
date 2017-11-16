package com.huazhu.hvip.user.opUser.model;/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: RoleAuth.java
 * Author:   HUQIANBO
 * Date:     2016-03-20 12:02:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO>  <2016-03-20 12:02:40> <version>   <desc>
 *
 */


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Entity
@Table(name = "roleauth")
public class RoleAuth implements Serializable {

    private ComposeIdPK composeIdPK;

    @Id
    public ComposeIdPK getComposeIdPK() {
        return composeIdPK;
    }

    public void setComposeIdPK(ComposeIdPK composeIdPK) {
        this.composeIdPK = composeIdPK;
    }
}
