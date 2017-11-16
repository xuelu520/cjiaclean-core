package com.huazhu.hvip.product.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.goods.manager.FrequencyManager;
import com.huazhu.hvip.product.goods.model.Frequency;
import com.huazhu.hvip.product.service.FrequencyService;
import com.huazhu.hvip.product.vo.FrequencyVO;
import com.huazhu.hvip.util.CheckUtil;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-08-09.
 */
public class FrequencyServiceImpl implements FrequencyService {
    private static Logger logger = LogManager.getLogger(ChannelGoodsPriceServiceImpl.class);

    @Autowired
    private FrequencyManager frequencyManager;

    /**
     * 根据商品id查询商品价格
     *
     * @param goodsId
     * @return
     */
    @Override
    public ReturnObject<FrequencyVO> searchFrequencyByGoodsId(Long goodsId) {
        logger.info("call searchChannelGoodsPriceByGoodsId({\"goodsId:\"" + goodsId + "})");

        ReturnObject<FrequencyVO> ret = new ReturnObject<FrequencyVO>();
        List<FrequencyVO> frequencyVOs = new ArrayList<>();
        try {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("goodsId", goodsId);
            List<Frequency> frequencyList = frequencyManager.search(queryModel);
            if (CheckUtil.checkListIsNull(frequencyList)) {
                for (Frequency frequency:frequencyList) {
                    FrequencyVO frequencyVO=new FrequencyVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(frequency,frequencyVO);
                    frequencyVOs.add(frequencyVO);
                }
            }
            ret.setDataList(frequencyVOs);
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
     * 保存商品价格信息
     *
     * @param frequencyVO
     * @return
     */
    @Override
    public ReturnObject<FrequencyVO> saveFrequencyPrice(FrequencyVO frequencyVO) {
        logger.info("call addGoodsPrice({\"list:\"" + JsonUtil.JSON_Bean2String(frequencyVO) + "})");
        ReturnObject<FrequencyVO> ret = new ReturnObject<FrequencyVO>();
        try {
            Frequency frequency = new Frequency();
            CopyBeanUtil.copyPropertiesIgnoreNull(frequencyVO, frequency);
            frequencyManager.save(frequency);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("保存成功");
        } catch (Exception e) {
            logger.error("保存失败");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("保存失败");
        }
        return ret;
    }

}
