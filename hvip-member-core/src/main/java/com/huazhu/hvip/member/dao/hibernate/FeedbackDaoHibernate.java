package com.huazhu.hvip.member.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.member.dao.FeedbackDao;
import com.huazhu.hvip.member.model.Feedback;
import org.springframework.stereotype.Repository;

/**
 * @author cmy
 * @create 2017-08-10 13:52
 **/
@Repository("feedbackDao")
public class FeedbackDaoHibernate extends GenericDaoHibernate<Feedback,Long> implements FeedbackDao {
    public FeedbackDaoHibernate() {
        super(Feedback.class);
    }
}
