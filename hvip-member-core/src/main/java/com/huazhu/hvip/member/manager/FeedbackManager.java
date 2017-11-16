package com.huazhu.hvip.member.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.member.model.Feedback;

import java.util.List;

/**
 * @author cmy
 * @create 2017-08-10 13:48
 **/
public interface FeedbackManager extends GenericManager<Feedback,Long> {
    /**
     * op根据条件查询会员信息
     *
     * @param paramObject
     * @return
     */
    List<Feedback> searchMemberListForOp(ParamObject paramObject);

    /**
     * 根据id查询会员信息
     *
     * @param feedbackId
     * @return
     */
    List<Feedback> searchFeedbackListForOp(Long feedbackId);

    /**
     * 根据memberid查询用户反馈信息
     *
     * @param memberId
     * @return
     */
    List<Feedback> searchFeedbackListById(Long memberId);

    /**
     * 保存或修改会员信息
     *
     * @param feedbackInfo
     * @return
     */
    Feedback saveOrUpdateMember(Feedback feedbackInfo);


}
