package com.huazhu.hvip.product.goods.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.goods.dao.GoodsCommentDao;
import com.huazhu.hvip.product.goods.manager.GoodsCommentManager;
import com.huazhu.hvip.product.goods.model.GoodsComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmy
 * @create 2017-08-25 15:53
 **/
@Service("goodsCommentManager")
public class GoodsCommentManagerImpl extends GenericManagerImpl<GoodsComment,Long> implements GoodsCommentManager {
    private GoodsCommentDao goodsCommentDao;

    @Autowired
    public GoodsCommentManagerImpl(GoodsCommentDao goodsCommentDao) {
        super(goodsCommentDao);
        this.goodsCommentDao = goodsCommentDao;
    }
}
