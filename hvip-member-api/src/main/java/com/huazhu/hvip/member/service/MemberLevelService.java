/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberLevelService.java
 * Author:   lijing
 * Date:     2016-03-21 10:23:36
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-21 10:23:36> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.service;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.member.qo.MemberLevelQO;
import com.huazhu.hvip.member.vo.MemberLevelVO;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface MemberLevelService {

    /**
     * （op）根据等级名称模糊查询
     *
     * @param memberLevelQO
     * @param pageCondition
     * @return
     */
    public ReturnObject<MemberLevelVO> searchMemberListForOp(MemberLevelQO memberLevelQO, PageCondition pageCondition);

    /**
     * 保存等级信息
     *
     * @param memberLevelVO
     * @return
     */
    public ReturnObject<MemberLevelVO> saveMemberLevel(MemberLevelVO memberLevelVO);

    /**
     * 根据等级id获取本地等级信息详情
     *
     * @param memberLevelId
     * @return
     */
    public ReturnObject<MemberLevelVO> getMemberDetailByLevelId(Long memberLevelId);


}
