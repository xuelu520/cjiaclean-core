/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberLevelServiceImpl.java
 * Author:   lijing
 * Date:     2016-03-21 10:28:01
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-21 10:28:01> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.service.impl;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.member.manager.MemberLevelManager;
import com.huazhu.hvip.member.model.MemberLevel;
import com.huazhu.hvip.member.qo.MemberLevelQO;
import com.huazhu.hvip.member.service.MemberLevelService;
import com.huazhu.hvip.member.vo.MemberLevelVO;
import com.huazhu.hvip.util.JsonUtil;
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
public class MemberLevelServiceImpl implements MemberLevelService{

    private static Logger logger = LogManager.getLogger(MemberServiceImpl.class);

    @Autowired
    private MemberLevelManager memberLevelManager;

    /**
     * （op）根据等级名称模糊查询
     *
     * @param memberLevelQO
     * @param pageCondition
     * @return
     */
    @Override
    public ReturnObject<MemberLevelVO> searchMemberListForOp(MemberLevelQO memberLevelQO, PageCondition pageCondition) {
        logger.info("call searchOrderList({\"memberLevelQO\":" + JsonUtil.JSON_Bean2String(memberLevelQO) + "},{\"pageCondition\":" + JsonUtil.JSON_Bean2String(pageCondition) + "})");
        ReturnObject<MemberLevelVO> ret = new ReturnObject<>();
        ParamObject paramObject = new ParamObject();

        MemberLevelVO memberLevelVO = null;
        List<MemberLevelVO> memberLevelVOList = new ArrayList<>();
        //List<Member> memberList = new ArrayList<>();

        String keyword = memberLevelQO.getKeyword();
        Integer pageNo = pageCondition.getPageNo();
        Integer pageSize = pageCondition.getPageSize();

        paramObject.setPageNo(pageNo);
        paramObject.setPageSize(pageSize);
        paramObject.add("keyword", keyword);

        try {
            memberLevelVOList = memberLevelManager.searchMemberListForOp(paramObject);

        /*    for (Member member : memberList) {
                memberVO = new MemberVO();
                BeanUtils.copyProperties(member, memberVO);
                memberVOList.add(memberVO);
            }*/

            ret.setTotalSize(paramObject.getTotalNum());
            ret.setDataList(memberLevelVOList);
            ret.setReturnMsg("查询等级列表成功");
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("根据等级名称模糊查询，或者全查询查找等级列表失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询等级列表失败");
        }

        return ret;
    }


    /**
     * 保存等级信息
     *
     * @param memberLevelVO
     * @return
     */
    @Override
    public ReturnObject<MemberLevelVO> saveMemberLevel(MemberLevelVO memberLevelVO) {
        logger.info("call saveMemberLevel({\"memberLevelVO:\"" + JsonUtil.JSON_Bean2String(memberLevelVO) + "})");
        ReturnObject<MemberLevelVO> returnObject = new ReturnObject<>();
        //MemberLevelVO memberLevelVO = null;

        try {
            //MemberInfo memberInfo = new MemberInfo();
            //BeanUtils.copyProperties(hMemberInfoVO, memberInfo);

            MemberLevelVO memberlevel = memberLevelManager.saveOrUpdateMember(memberLevelVO);
            if (memberlevel == null || memberlevel.getLevelId() == null) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("保存等级信息失败");
                return returnObject;
            }

            //memberVO = new MemberVO();
            //BeanUtils.copyProperties(member, memberVO);

            returnObject.setData(memberlevel);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("保存等级信息成功");

        } catch (Exception e) {
            logger.error("保存等级信息失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("保存等级信息失败");
        }

        return returnObject;
    }


    /**
     * 根据等级id获取本地等级信息详情
     *
     * @param memberLevelId
     * @return
     */
    @Override
    public ReturnObject<MemberLevelVO> getMemberDetailByLevelId(Long memberLevelId) {
        logger.info("call getMemberDetailByLevelId({\"memberLevelId:\"" + memberLevelId + "})");

        ReturnObject<MemberLevelVO> returnObject = new ReturnObject<>();
        MemberLevelVO memberLevelVO = null;

        try {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("levelId", memberLevelId);

            MemberLevel memberLevel = memberLevelManager.getUniqueResult(queryModel);

            memberLevelVO = new MemberLevelVO();

            BeanUtils.copyProperties(memberLevel, memberLevelVO);

            returnObject.setData(memberLevelVO);

            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("查询等级信息成功");

        } catch (Exception e) {
            logger.error("查询等级信息失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询等级信息失败");
        }

        return returnObject;
    }



/*    *//**
     * 保存等级信息
     *
     * @param memberLevelVO
     * @return
     *//*
    @Override
    public ReturnObject<MemberLevelVO> saveMemberLevel(MemberLevelVO memberLevelVO) {
        logger.info("call saveMemberLevel({\"memberLevelVO:\"" + JsonUtil.JSON_Bean2String(memberLevelVO) + "})");
        ReturnObject<MemberLevelVO> returnObject = new ReturnObject<>();
        //MemberLevel memberLevel = null;

        try {
            MemberLevel memberLevel = new MemberLevel();
            BeanUtils.copyProperties(memberLevelVO, memberLevel);

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
    }*/

}
