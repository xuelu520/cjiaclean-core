/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: DictCodeVO.java
 * Author:   admin
 * Date:     2016-03-20 17:30:31
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 17:30:31><version><desc>
 */

package com.huazhu.hvip.common.vo;

import com.huazhu.hvip.base.model.BaseObject;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DictCodeVO implements Serializable {
    private static final long serialVersionUID = 7353327108534589381L;
    private Long codeId;
    private String codeLabel;
    private String codeNo;
    private String dictId;

    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    public String getCodeLabel() {
        return codeLabel;
    }

    public void setCodeLabel(String codeLabel) {
        this.codeLabel = codeLabel;
    }

    public String getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo;
    }

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }
}
