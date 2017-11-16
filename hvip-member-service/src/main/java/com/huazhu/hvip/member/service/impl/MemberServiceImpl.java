/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberServiceImpl.java
 * Author:   lijing
 * Date:     2016-03-21 10:09:52
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-21 10:09:52> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.service.impl;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.member.manager.MemberAddressManager;
import com.huazhu.hvip.member.manager.MemberLevelManager;
import com.huazhu.hvip.member.manager.MemberManager;
import com.huazhu.hvip.member.model.Member;
import com.huazhu.hvip.member.model.MemberAddress;
import com.huazhu.hvip.member.model.MemberLevel;
import com.huazhu.hvip.member.model.extend.MemberInfo;
import com.huazhu.hvip.member.qo.MemberQO;
import com.huazhu.hvip.member.service.MemberService;
import com.huazhu.hvip.member.vo.HMemberInfoVO;
import com.huazhu.hvip.member.vo.MemberAddressVO;
import com.huazhu.hvip.member.vo.MemberLevelVO;
import com.huazhu.hvip.member.vo.MemberVO;
import com.huazhu.hvip.util.CheckUtil;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class MemberServiceImpl implements MemberService {

    private static Logger logger = LogManager.getLogger(MemberServiceImpl.class);

    private MemberManager memberManager;

    @Autowired
    private MemberAddressManager memberAddressManager;
    @Autowired
    private MemberLevelManager memberLevelManager;

    @Autowired
    public void setMemberManager(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    /**
     * 保存会员信息
     *
     * @param hMemberInfoVO
     * @return
     */
    @Override
    public ReturnObject<MemberVO> saveMember(HMemberInfoVO hMemberInfoVO) {
        logger.info("call saveMember({\"memberInfoVO:\"" + JsonUtil.JSON_Bean2String(hMemberInfoVO) + "})");
        ReturnObject<MemberVO> returnObject = new ReturnObject<>();
        MemberVO memberVO = null;

        //校验数据
        ReturnObject ret = verifyData(hMemberInfoVO);

        if (!ret.getReturnCode().equals(Constants.RETURN_CODE_SUCCESS)) {
            returnObject.setReturnCode(ret.getReturnCode());
            returnObject.setReturnMsg(ret.getReturnMsg());
            return returnObject;
        }

        try {
            MemberInfo memberInfo = new MemberInfo();
            CopyBeanUtil.copyPropertiesIgnoreNull(hMemberInfoVO, memberInfo);

            Member member = memberManager.saveOrUpdateMember(memberInfo);

            if (member == null || member.getMemberId() == null) {

                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("保存会员信息失败");
                return returnObject;
            }

            memberVO = new MemberVO();

            BeanUtils.copyProperties(member, memberVO);

            returnObject.setData(memberVO);

            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("保存会员信息成功");

        } catch (Exception e) {
            logger.error("保存会员信息失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("保存会员信息失败");
        }

        return returnObject;
    }

    /**
     * 根据华住会员id获取本地会员信息详情
     *
     * @param outerMemberId
     * @return
     */
    @Override
    public ReturnObject<MemberVO> getMemberDetailByOuterMemberId(String outerMemberId) {
        logger.info("call getMemberDetailByOuterMemberId({\"outerMemberId:\"" + outerMemberId + "})");

        ReturnObject<MemberVO> returnObject = new ReturnObject<>();
        MemberVO memberVO = null;

        try {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("outerMemberId", outerMemberId);

            Member member = memberManager.getUniqueResult(queryModel);

            if (member != null) {
                memberVO = new MemberVO();
                BeanUtils.copyProperties(member, memberVO);
            }
            returnObject.setData(memberVO);

            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("查询会员信息成功");

        } catch (Exception e) {
            logger.error("查询会员信息失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询会员信息失败");
        }

        return returnObject;
    }

    /**
     * 根据会员id获取本地会员信息详情
     *
     * @param memberId
     * @return
     */
    @Override
    public ReturnObject<MemberVO> getMemberDetailByMemberId(Long memberId) {
        logger.info("call getMemberDetailByMemberId({\"memberId:\"" + memberId + "})");

        ReturnObject<MemberVO> returnObject = new ReturnObject<>();
        MemberVO memberVO = null;

        try {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("memberId", memberId);

            Member member = memberManager.getUniqueResult(queryModel);

            memberVO = new MemberVO();

            BeanUtils.copyProperties(member, memberVO);

            returnObject.setData(memberVO);

            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("查询会员信息成功");

        } catch (Exception e) {
            logger.error("查询会员信息失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询会员信息失败");
        }

        return returnObject;
    }


    /**
     * 校验数据
     *
     * @param memberInfoVO
     * @return
     */
    private ReturnObject verifyData(HMemberInfoVO memberInfoVO) {
        ReturnObject ret = new ReturnObject();
        if (memberInfoVO == null) {
            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
            ret.setReturnMsg("memberInfoVO is null");
        }
        ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        return ret;
    }

    /**
     * （op）根据会员姓名或者手机号模糊查询，或者全查询会员列表
     *
     * @param memberQO
     * @param pageCondition
     * @return
     */
    @Override
    public ReturnObject<MemberVO> searchMemberListForOp(MemberQO memberQO, PageCondition pageCondition) {
        logger.info("call searchOrderList({\"memberQO\":" + JsonUtil.JSON_Bean2String(memberQO) + "},{\"pageCondition\":" + JsonUtil.JSON_Bean2String(pageCondition) + "})");
        ReturnObject<MemberVO> ret = new ReturnObject<>();
        ParamObject paramObject = new ParamObject();

        MemberVO memberVO = null;
        List<MemberVO> memberVOList = new ArrayList<>();
        List<Member> memberList = new ArrayList<>();

        String keyword = memberQO.getKeyword();
        Integer pageNo = pageCondition.getPageNo();
        Integer pageSize = pageCondition.getPageSize();

        paramObject.setPageNo(pageNo);
        paramObject.setPageSize(pageSize);
        paramObject.add("keyword", keyword);

        try {
            memberList = memberManager.searchMemberListForOp(paramObject);

            for (Member member : memberList) {
                memberVO = new MemberVO();
                BeanUtils.copyProperties(member, memberVO);
                memberVOList.add(memberVO);
            }

            ret.setTotalSize(paramObject.getTotalNum());
            ret.setDataList(memberVOList);
            ret.setReturnMsg("查询会员列表成功");
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("根据会员姓名或者手机号模糊查询，或者全查询查找会员列表失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询会员列表失败");
        }

        return ret;
    }


    /**
     * 微信会员信息保存
     *
     * @param memberVO
     * @return
     */
    @Override
    public ReturnObject<MemberVO> saveWechatMember(MemberVO memberVO) {
        logger.info("call searchOrderList({" + JsonUtil.JSON_Bean2String(memberVO) + "})");
        ReturnObject returnObject = new ReturnObject();
        try {
            Member member = new Member();
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("openid", memberVO.getOpenid());
            List<Member> memberList = memberManager.search(queryModel);
            if (CheckUtil.checkListIsNull(memberList)) {
                member = memberList.get(0);
            }
            if (StringUtils.isNotBlank(member.getIsAdmin())) {
                memberVO.setIsAdmin(member.getIsAdmin());
            }
            CopyBeanUtil.copyPropertiesIgnoreNull(memberVO, member);
            if (member.getPoint() == null) {
                member.setPoint(0);
            }
            List<MemberLevel> memberLevelList = memberLevelManager.getAll();
            if (CheckUtil.checkListIsNull(memberLevelList)) {
                for (MemberLevel memberLevel : memberLevelList) {
                    if (member.getPoint() != null && member.getPoint() >= memberLevel.getPoint()) {
                        memberVO.setLevelId(memberLevel.getLevelId());
                    }
                }
            }
            member = memberManager.save(member);
            CopyBeanUtil.copyPropertiesIgnoreNull(member, memberVO);
            queryModel = new QueryModel();
            queryModel.addColumnValueCondition("memberId", memberVO.getMemberId());
            List<MemberAddress> memberAddressList = memberAddressManager.search(queryModel);
            List<MemberAddressVO> memberAddressVOs = new ArrayList<>();
            if (CheckUtil.checkListIsNull(memberAddressList)) {
                for (MemberAddress memberAddress : memberAddressList) {
                    MemberAddressVO memberAddressVO = new MemberAddressVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(memberAddress, memberAddressVO);
                    memberAddressVOs.add(memberAddressVO);
                }
            }
            if (memberVO.getLevelId() != null) {
                MemberLevel memberLevel = memberLevelManager.get(memberVO.getLevelId());
                if (memberLevel != null) {
                    MemberLevelVO memberLevelVO = new MemberLevelVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(memberLevel, memberLevelVO);
                    memberVO.setMemberLevelVO(memberLevelVO);
                }
            }
            memberVO.setMemberAddressVOs(memberAddressVOs);
            returnObject.setData(memberVO);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call searchOrderList error({})", e);
        }
        return returnObject;
    }


    /**
     * 查询会员及会员的地址
     *
     * @param memberQO
     * @return
     */
    @Override
    public ReturnObject<MemberVO> getMemberInfoAndAddress(MemberQO memberQO) {
        logger.info("call getMemberInfoAndAddress({" + JsonUtil.JSON_Bean2String(memberQO) + "})");
        ReturnObject returnObject = new ReturnObject();
        try {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("memberId", memberQO.getMemberId());
            queryModel.addColumnValueCondition("openid", memberQO.getOpenid());
            Member member = memberManager.getUniqueResult(queryModel);
            MemberVO memberVO = new MemberVO();
            if (member!=null) {
                queryModel = new QueryModel();
                queryModel.addColumnValueCondition("memberId", member.getMemberId());
                List<MemberAddress> memberAddressList = memberAddressManager.search(queryModel);
                CopyBeanUtil.copyPropertiesIgnoreNull(member, memberVO);
                if (CheckUtil.checkListIsNull(memberAddressList)) {
                    List<MemberAddressVO> memberAddressVOs = new ArrayList<>();
                    for (MemberAddress memberAddress : memberAddressList) {
                        MemberAddressVO memberAddressVO = new MemberAddressVO();
                        CopyBeanUtil.copyPropertiesIgnoreNull(memberAddress, memberAddressVO);
                        memberAddressVOs.add(memberAddressVO);
                    }
                    memberVO.setMemberAddressVOs(memberAddressVOs);
                }
                if (memberVO.getLevelId() != null) {
                    MemberLevel memberLevel = memberLevelManager.get(memberVO.getLevelId());
                    MemberLevelVO memberLevelVO = new MemberLevelVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(memberLevel, memberLevelVO);
                    memberVO.setMemberLevelVO(memberLevelVO);
                }
            }
            returnObject.setData(memberVO);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call searchOrderList error({})", e);
        }
        return returnObject;
    }

    /**
     * 查询会员及会员的地址
     * @param memberQO
     * @return
     */
    @Override
    public ReturnObject<MemberVO> serchMemberInfoByQO(MemberQO memberQO) {
        logger.info("call serchMemberInfoByQO({" + JsonUtil.JSON_Bean2String(memberQO) + "})");
        ReturnObject returnObject = new ReturnObject();
        try {
            List<MemberVO> memberVOList = new ArrayList<>();
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("isAdmin", memberQO.getIsAdmin());
            List<Member> memberList = memberManager.search(queryModel);
            if (CheckUtil.checkListIsNull(memberList)) {
                for (Member member : memberList) {
                    MemberVO memberVO = new MemberVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(member, memberVO);
                    memberVOList.add(memberVO);
                }
            }
            returnObject.setDataList(memberVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.info("call serchMemberInfoByQO error({})", e);
        }
        return returnObject;
    }


    /**
     * 获取所有会员
     *
     * @return
     */
    @Override
    public ReturnObject<MemberVO> searchAllMember() {
        logger.info("call searchAllMember({})");
        ReturnObject returnObject = new ReturnObject();
        try {
            List<MemberVO> memberVOList = CopyBeanUtil.copyList(memberManager.getAll(), MemberVO.class);
            returnObject.setDataList(memberVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("call searchAllMember error({})", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }

    /**
     * 保存会员
     *
     * @return
     */
    @Override
    public ReturnObject<MemberVO> saveMemberList(List<MemberVO> memberVOList) {
        logger.info("call searchAllMember({})");
        ReturnObject returnObject = new ReturnObject();
        try {
            if (CheckUtil.checkListIsNull(memberVOList)) {
                List<Member> memberList = CopyBeanUtil.copyList(memberVOList, Member.class);
                if (CheckUtil.checkListIsNull(memberList)) {
                    memberManager.saveMemberList(memberList);
                }
            }
            returnObject.setDataList(memberVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("call saveMemberList error({})", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }
}
