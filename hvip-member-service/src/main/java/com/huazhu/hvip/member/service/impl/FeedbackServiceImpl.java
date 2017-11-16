package com.huazhu.hvip.member.service.impl;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.member.manager.FeedbackManager;
import com.huazhu.hvip.member.model.Feedback;
import com.huazhu.hvip.member.service.FeedbackService;
import com.huazhu.hvip.member.vo.FeedbackVO;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017-08-13.
 */
public class FeedbackServiceImpl implements FeedbackService {

    private static Logger logger = LogManager.getLogger(FeedbackServiceImpl.class);

    @Autowired
    private FeedbackManager feedbackManager;

    /**
     * （op）根据会员姓名或者手机号模糊查询，或者全查询会员列表
     *
     * @param pageCondition
     * @return
     */
    @Override
    public ReturnObject<FeedbackVO> searchFeedbackList(PageCondition pageCondition) {
        logger.info("call searchOrderList({\"pageCondition\":" + JsonUtil.JSON_Bean2String(pageCondition) + "})");
        ReturnObject<FeedbackVO> ret = new ReturnObject<>();
        ParamObject paramObject = new ParamObject();

        FeedbackVO feedbackVO = null;
        List<Feedback> feedbackList = new ArrayList<>();
        List<FeedbackVO> feedbackVOList = new ArrayList<>();

        Integer pageNo = pageCondition.getPageNo();
        Integer pageSize = pageCondition.getPageSize();

        paramObject.setPageNo(pageNo);
        paramObject.setPageSize(pageSize);
        //paramObject.add("keyword", keyword);

        try {
            feedbackList = feedbackManager.searchMemberListForOp(paramObject);
            for (Feedback member : feedbackList) {
                feedbackVO = new FeedbackVO();
                //BeanUtils.copyProperties(member, feedbackVO);
                CopyBeanUtil.copyPropertiesIgnoreNull(member,feedbackVO);
                feedbackVOList.add(feedbackVO);
            }

            ret.setTotalSize(paramObject.getTotalNum());
            ret.setDataList(feedbackVOList);
            ret.setReturnMsg("查询反馈列表成功");
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("根据会员姓名或者手机号模糊查询，或者全查询查找会员列表失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询反馈列表失败");
        }

        return ret;
    }

    /**
     * 保存反馈处理信息
     *
     * @param feedbackVO
     * @return
     */
    @Override
    public ReturnObject<FeedbackVO> saveFeedback(FeedbackVO feedbackVO) {
        logger.info("call addGoodsPrice({\"list:\"" + JsonUtil.JSON_Bean2String(feedbackVO) + "})");
        ReturnObject<FeedbackVO> ret = new ReturnObject<FeedbackVO>();
        try {
            Feedback feedback = new Feedback();
            CopyBeanUtil.copyPropertiesIgnoreNull(feedbackVO, feedback);
            feedbackManager.saveOrUpdateMember(feedback);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("保存成功");
        } catch (Exception e) {
            logger.error("保存失败");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("保存失败");
        }
        return ret;
    }


    /**
     * 通过id获取用户反馈信息
     *
     * @param feedbackId
     * @return
     */
    @Override
    public ReturnObject<FeedbackVO> getFeedbackById(Long feedbackId) {
        logger.info("call getGoodsById({\"goodsId:\"" + feedbackId + "})");

        ReturnObject<FeedbackVO> ret = new ReturnObject<FeedbackVO>();

        try {
            List<Feedback> feedbackList = new ArrayList<>();


            feedbackList = feedbackManager.searchFeedbackListForOp(feedbackId);
            FeedbackVO feedbackVO = null;

            for (Feedback feedback : feedbackList) {
                feedbackVO = new FeedbackVO();
                org.springframework.beans.BeanUtils.copyProperties(feedback, feedbackVO);
                //feedbackVOList.add(feedbackVO);
            }
            ret.setData(feedbackVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return ret;
    }



    /**
     * 通过memberid获取用户反馈信息
     *
     * @param memberId
     * @return
     */
    @Override
    public ReturnObject<FeedbackVO> getFeedbackByMemberId(Long memberId) {
        logger.info("call getFeedbackByMemberId({\"memberId:\"" + memberId + "})");

        ReturnObject<FeedbackVO> ret = new ReturnObject<FeedbackVO>();

        try {
            List<Feedback> feedbackList = new ArrayList<>();

            feedbackList = feedbackManager.searchFeedbackListById(memberId);
            FeedbackVO feedbackVO = null;

            for (Feedback feedback : feedbackList) {
                feedbackVO = new FeedbackVO();
                org.springframework.beans.BeanUtils.copyProperties(feedback, feedbackVO);
                //feedbackVOList.add(feedbackVO);
            }
            ret.setData(feedbackVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return ret;
    }

}
