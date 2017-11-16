/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberManager.java
 * Author:   lijing
 * Date:     2016-03-20 14:15:13
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 14:15:13> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.member.model.Member;
import com.huazhu.hvip.member.model.extend.MemberInfo;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface MemberManager extends GenericManager<Member,Long>{

    /**
     * 添加会员
     * @param member
     * @return
     */
    public Member add(Member member);

    /**
     * 保存或修改会员信息
     *
     * @param memberInfo
     * @return
     */
    Member saveOrUpdateMember(MemberInfo memberInfo);

    /**
     * op根据条件查询会员信息
     *
     * @param paramObject
     * @return
     */
    List<Member> searchMemberListForOp(ParamObject paramObject);

    /**
     * 保存用户
     * @param memberList
     */
    List<Member> saveMemberList(List<Member> memberList);
}
