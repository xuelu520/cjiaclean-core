/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberManagerImpl.java
 * Author:   lijing
 * Date:     2016-03-20 14:35:11
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 14:35:11> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.manager.impl;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.member.dao.MemberDao;
import com.huazhu.hvip.member.dao.WebUserDao;
import com.huazhu.hvip.member.manager.MemberManager;
import com.huazhu.hvip.member.model.Member;
import com.huazhu.hvip.member.model.extend.MemberInfo;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import com.huazhu.hvip.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("memberManager")
public class MemberManagerImpl extends GenericManagerImpl<Member, Long> implements MemberManager {


    private static Logger logger = LogManager.getLogger(MemberManagerImpl.class);
    private MemberDao memberDao;

    @Autowired
    public MemberManagerImpl(MemberDao memberDao) {
        super(memberDao);
        this.memberDao = memberDao;
    }

    private WebUserDao webUserDao;

    @Autowired
    public void setWebUserDao(WebUserDao webUserDao) {
        this.webUserDao = webUserDao;
    }

    /**
     * 添加会员
     *
     * @param member
     * @return
     */
    @Override
    public Member add(Member member) {

        return memberDao.save(member);
    }

    /**
     * 保存或修改会员信息
     *
     * @param memberInfo
     * @return
     */
    @Transactional
    @Override
    public Member saveOrUpdateMember(MemberInfo memberInfo) {
        logger.info("call saveOrUpdateMember({\"memberInfo:\"" + JsonUtil.JSON_Bean2String(memberInfo) + "})");

        //根据华住会员ID查询本地数据会员信息
        Long hzMemberId = memberInfo.getMemberId();
        Member member=memberDao.get(hzMemberId);
        CopyBeanUtil.copyPropertiesIgnoreNull(memberInfo, member);
        //保存会员信息
        member = memberDao.save(member);
        return member;
    }

    private Member saveMember(Member member, MemberInfo memberInfo) {
        member.setEmail(memberInfo.getEmail());
        member.setMobile(memberInfo.getMobile());
        member.setTelNo(memberInfo.getTelNo());
        member.setName(memberInfo.getName());
        member.setSex(memberInfo.getSex());
        member.setBirthday(memberInfo.getBirthday());
        member.setProvince(memberInfo.getProvince());
        member.setCity(memberInfo.getCity());
        member.setAddress(memberInfo.getAddress());
        member.setZipCode(memberInfo.getZipCode());
        member.setIdType(memberInfo.getIdType());
        member.setIdNo(memberInfo.getIdNo());
        member.setRemark(memberInfo.getRemark());
        member.setLevelId(memberInfo.getLevelId());
        //member.setMemberLevelDesc(memberInfo.get);
        member.setPoint(memberInfo.getPoint());

        member.setOuterMemberId(memberInfo.getOuterMemberId());

        if (member.getMemberId() == null) {
            member.setCreateTime(new Date());
            member.setCreateUser(member.getMobile());
        }
        member.setUpdateTime(new Date());
        member.setUpdateUser(member.getMobile());

        return member;
    }

    /**
     * op根据条件查询会员信息
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<Member> searchMemberListForOp(ParamObject paramObject) {
        logger.info("call searchOrderList({\"paramObject:\"" + JsonUtil.JSON_Bean2String(paramObject) + "})");

        Integer pageSize = (Integer) paramObject.getPageSize();

        Integer pageNo = (Integer) paramObject.getPageNo();

        String orderBy = paramObject.getStringParam("orderBy"); //排序

        String keyword = paramObject.getStringParam("keyword");//模糊查询关键字

        QueryModel queryModel = new QueryModel();

        queryModel.setPageNo(pageNo);

        queryModel.setPageSize(pageSize);

        if (StringUtils.isNotBlank(orderBy)) {
            queryModel.setSortHql(orderBy);
        } else {
            queryModel.setSortHql(" createTime DESC ");
        }

        if (!StringUtil.isEmpty(keyword)) {
            queryModel.addHqlCondition(" (name like '%" + keyword + "%' or mobile like '%" + keyword + "%') ");
        }

        List<Member> memberList = memberDao.search(queryModel);
        paramObject.setTotalNum(queryModel.getTotalNum());

        return memberList;
    }

    @Override
    @Transactional
    public List<Member> saveMemberList(List<Member> memberList) {
        logger.info("call saveMemberList({\"memberList:\"" + JsonUtil.JSON_List2String(memberList) + "})");
        for(Member member:memberList){
            memberDao.save(member);
        }
        return memberList;
    }
}
