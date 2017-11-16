package com.huazhu.hvip.member.manager.impl;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.member.dao.FeedbackDao;
import com.huazhu.hvip.member.manager.FeedbackManager;
import com.huazhu.hvip.member.model.Feedback;
import com.huazhu.hvip.member.model.Member;
import com.huazhu.hvip.util.JsonUtil;
import com.huazhu.hvip.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @author cmy
 * @create 2017-08-10 13:48
 **/
@Service("feedbackManager")
public class FeedbackManagerImpl extends GenericManagerImpl<Feedback,Long> implements FeedbackManager {

    private static Logger logger = LogManager.getLogger(FeedbackManagerImpl.class);
    private FeedbackDao feedbackDao;

    @Autowired
    public FeedbackManagerImpl(FeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }

    /**
     * op根据条件查询会员信息
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<Feedback> searchMemberListForOp(ParamObject paramObject) {
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

        if(!StringUtil.isEmpty(keyword)){
            queryModel.addHqlCondition(" (name like '%"+keyword+"%' or mobile like '%"+keyword+"%') ");
        }

        List<Feedback> memberList = feedbackDao.search(queryModel);
        paramObject.setTotalNum(queryModel.getTotalNum());

        return memberList;
    }


    /**
     * op根据条件查询会员信息
     *
     * @param feedbackId
     * @return
     */
    @Override
    public List<Feedback> searchFeedbackListForOp(Long feedbackId) {
        logger.info("call searchOrderList({\"paramObject:\"" + JsonUtil.JSON_Bean2String(feedbackId) + "})");

        QueryModel queryModel = new QueryModel();

        queryModel.addHqlCondition(" (feedbackId like '%"+feedbackId+"%') ");

        List<Feedback> memberList = feedbackDao.search(queryModel);

        return memberList;
    }


    /**
     * op根据条件查询会员信息
     *
     * @param memberId
     * @return
     */
    @Override
    public List<Feedback> searchFeedbackListById(Long memberId) {
        logger.info("call searchOrderList({\"paramObject:\"" + JsonUtil.JSON_Bean2String(memberId) + "})");

        QueryModel queryModel = new QueryModel();

        queryModel.addHqlCondition(" (memberId like '%"+memberId+"%') ");

        List<Feedback> feedbackList = feedbackDao.search(queryModel);

        return feedbackList;
    }


    /**
     * 保存或修改会员信息
     *
     * @param feedbackInfo
     * @return
     */
    @Override
    public Feedback saveOrUpdateMember(Feedback feedbackInfo) {
        logger.info("call saveOrUpdateMember({\"memberInfo:\"" + JsonUtil.JSON_Bean2String(feedbackInfo) + "})");
        Feedback feedback = new Feedback();
        try {

            //保存会员信息
            feedback = feedbackDao.save(feedbackInfo);
        }
        catch (Exception e) {}


        return feedback;
    }
}
