package com.huazhu.hvip.product.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.request.ChannelGoodsPriceInfo;
import com.huazhu.hvip.product.vo.ChannelGoodsPriceVO;
import com.huazhu.hvip.product.vo.FrequencyVO;

import java.util.List;

/**
 * Created by Administrator on 2017-08-09.
 */
public interface FrequencyService {
    /**
     * 根据商品id查询商品价格
     * @param goodsId
     * @return
     */
    ReturnObject<FrequencyVO> searchFrequencyByGoodsId(Long goodsId);

    /**
     * 保存商品价格信息
     * @param frequencyVO
     * @return
     */
    ReturnObject<FrequencyVO> saveFrequencyPrice(FrequencyVO frequencyVO);
}
