package com.huazhu.hvip.product.goods.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.product.goods.dao.GoodsCommentDao;
import com.huazhu.hvip.product.goods.model.GoodsComment;
import org.springframework.stereotype.Repository;

/**
 * @author cmy
 * @create 2017-08-25 15:54
 **/
@Repository("goodsCommentDao")
public class GoodsCommentDaoHibernate extends GenericDaoHibernate<GoodsComment,Long> implements GoodsCommentDao {
    public GoodsCommentDaoHibernate() {
        super(GoodsComment.class);
    }
}
