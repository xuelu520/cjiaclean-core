package com.huazhu.hvip.member.service;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.member.vo.FeedbackVO;

/**
 * Created by Administrator on 2017-08-13.
 */
public interface FeedbackService {
    /**
     * （op）根据会员姓名或者手机号模糊查询，或者全查询会员列表
     *
     * @param pageCondition
     * @return
     */
    public ReturnObject<FeedbackVO> searchFeedbackList(PageCondition pageCondition);

    /**
     * 保存用户反馈信息
     * @param feedbackVO
     * @return
     */
    ReturnObject<FeedbackVO> saveFeedback(FeedbackVO feedbackVO);

    /**
     * 根据id获取用户反馈意见
     *
     * @param feedbackId
     * @return
     */
    ReturnObject<FeedbackVO> getFeedbackById(Long feedbackId);

    /**
     * 根据id获取用户反馈意见
     *
     * @param memberId
     * @return
     */
    ReturnObject<FeedbackVO> getFeedbackByMemberId(Long memberId);
}
