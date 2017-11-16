/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberLevelManager.java
 * Author:   lijing
 * Date:     2016-03-20 14:20:34
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 14:20:34> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.member.model.MemberLevel;
import com.huazhu.hvip.member.vo.MemberLevelVO;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface MemberLevelManager extends GenericManager<MemberLevel,Long>{
    /**
     * op根据条件查询会员信息
     *
     * @param paramObject
     * @return
     */
    List<MemberLevelVO> searchMemberListForOp(ParamObject paramObject);

    /**
     * 保存或修改等级信息
     *
     * @param memberLevelVO
     * @return
     */
    MemberLevelVO saveOrUpdateMember(MemberLevelVO memberLevelVO);
}
