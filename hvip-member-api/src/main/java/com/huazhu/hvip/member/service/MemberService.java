/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberService.java
 * Author:   lijing
 * Date:     2016-03-21 10:05:14
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-21 10:05:14> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.service;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.member.qo.MemberQO;
import com.huazhu.hvip.member.vo.HMemberInfoVO;
import com.huazhu.hvip.member.vo.MemberVO;

import java.util.List;

/**
 * 会员相关api接口
 *
 * @author HUQIANBO
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface MemberService {

    /**
     * 保存会员信息
     *
     * @param hMemberInfoVO
     * @return
     */
    public ReturnObject<MemberVO> saveMember(HMemberInfoVO hMemberInfoVO);

    /**
     * 根据华住会员id获取本地会员信息详情
     *
     * @param outerMemberId
     * @return
     */
    public ReturnObject<MemberVO> getMemberDetailByOuterMemberId(String outerMemberId);

    /**
     * 根据会员id获取本地会员信息详情
     *
     * @param memberId
     * @return
     */
    public ReturnObject<MemberVO> getMemberDetailByMemberId(Long memberId);

    /**
     * （op）根据会员姓名或者手机号模糊查询，或者全查询会员列表
     *
     * @param memberQO
     * @param pageCondition
     * @return
     */
    public ReturnObject<MemberVO> searchMemberListForOp(MemberQO memberQO, PageCondition pageCondition);

    /**
     * 微信会员信息保存
     *
     * @param memberVO
     * @return
     */
    public ReturnObject<MemberVO> saveWechatMember(MemberVO memberVO);

    /**
     * 查询会员及会员的地址
     * @param memberQO
     * @return
     */
    public ReturnObject<MemberVO> getMemberInfoAndAddress(MemberQO memberQO);


    /**
     * 查询会员及会员的地址
     * @param memberQO
     * @return
     */
    public ReturnObject<MemberVO> serchMemberInfoByQO(MemberQO memberQO);


    /**
     * 查询所有会员
     * @return
     */
    public ReturnObject<MemberVO> searchAllMember();


    /**
     *保存会员
     * @param memberVOList
     * @return
     */
    public ReturnObject<MemberVO> saveMemberList(List<MemberVO> memberVOList);

}
