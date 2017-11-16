/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: AreaManager.java
 * Author:   admin
 * Date:     2016-03-08 15:31:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:31:50><version><desc><source>
 *
 */

package com.huazhu.hvip.common.manager;


import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.common.model.Regiongaode;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface RegionsManager extends GenericManager<Regiongaode, Long> {

    public List<Regiongaode> searchRegionsVOList(Long parentId);
}