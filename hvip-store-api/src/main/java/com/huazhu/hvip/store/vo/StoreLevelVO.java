/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: StoreLevel.java
 * Author:   chenli
 * Date:     2016-03-23 15:55:36
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 15:55:36> <version>   <desc>
 *
 */

package com.huazhu.hvip.store.vo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class StoreLevelVO implements Serializable{
    private Long levelId;
    private String levelName;

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
