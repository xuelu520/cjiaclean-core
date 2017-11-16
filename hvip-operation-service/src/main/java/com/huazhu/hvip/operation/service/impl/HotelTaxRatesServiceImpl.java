package com.huazhu.hvip.operation.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.operation.manager.HotelTaxRatesManager;
import com.huazhu.hvip.operation.model.HotelTaxRates;
import com.huazhu.hvip.operation.service.HotelTaxRatesService;
import com.huazhu.hvip.operation.vo.HotelTaxRatesVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("hotelTaxRatesService")
public class HotelTaxRatesServiceImpl implements HotelTaxRatesService {

    private static Logger logger = LogManager.getLogger(HotelTaxRatesServiceImpl.class);

    @Autowired
    private HotelTaxRatesManager hotelTaxRatesManager;

    /**
     * 批量保存酒店税率信息
     *
     * @param hotelTaxRatesVOList
     * @return
     */
    @Override
    public ReturnObject<HotelTaxRatesVO> saveHotelTaxRatesList(List<HotelTaxRatesVO> hotelTaxRatesVOList) {
        logger.info("call saveHotelTaxRatesList(hotelTaxRatesVOList.size:{})", hotelTaxRatesVOList.size());

        ReturnObject<HotelTaxRatesVO> ret = new ReturnObject();
        List<HotelTaxRatesVO> hotelTaxRatesList = new ArrayList<>();

        try {
            if (hotelTaxRatesVOList != null) {
                StringBuffer returnMsg = new StringBuffer();
                int pendingCount = hotelTaxRatesVOList.size(); //待处理数
                int existCount = 0; //已存在数
                int saveSuccCount = 0; //保存成功数
                int saveFailCount = 0; //保存失败数

                HotelTaxRates hotelTaxRates = null;
                QueryModel queryModel = null;

                for (HotelTaxRatesVO ratesVO : hotelTaxRatesVOList) {
                    //根据酒店编号、税率代码、税率、纳税人类型查询该税率信息是否存在
                    queryModel = new QueryModel();
                    queryModel.addColumnValueCondition("hotelNo", ratesVO.getHotelNo());
                    queryModel.addColumnValueCondition("hotelId", ratesVO.getHotelId());
                    queryModel.addColumnValueCondition("registName", ratesVO.getRegistName());
                    queryModel.addColumnValueCondition("taxCode", ratesVO.getTaxCode());
                    queryModel.addColumnValueCondition("taxName", ratesVO.getTaxName());
                    queryModel.addColumnValueCondition("rate", ratesVO.getRate());
                    queryModel.addColumnValueCondition("configModelId", ratesVO.getConfigModelId());
                    hotelTaxRates = hotelTaxRatesManager.getUniqueResult(queryModel);

                    if (hotelTaxRates != null) {
                        logger.info("该税率信息已经存在，无需保存");
                        existCount++;
                        BeanUtils.copyProperties(hotelTaxRates,ratesVO);
                        hotelTaxRatesList.add(ratesVO);
                        continue;
                    }

                    hotelTaxRates = new HotelTaxRates();
                    BeanUtils.copyProperties(ratesVO, hotelTaxRates);
                    hotelTaxRates = hotelTaxRatesManager.save(hotelTaxRates);

                    if (hotelTaxRates.getRateId() != null) {
                        saveSuccCount++;
                        BeanUtils.copyProperties(hotelTaxRates,ratesVO);
                        hotelTaxRatesList.add(ratesVO);
                    } else {
                        saveFailCount++;
                    }
                }

                returnMsg.append("操作结果：待处理数总数为[" + pendingCount + "]条。");
                returnMsg.append("其中税率信息已经存在数为[" + existCount + "]条，");
                returnMsg.append("保存成功数为[" + saveSuccCount + "]条,保存失败数为[" + saveFailCount + "]条。");

                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                ret.setReturnMsg(returnMsg.toString());
                ret.setDataList(hotelTaxRatesList) ;

            }
        } catch (Exception e) {
            logger.error("保存酒店税率信息失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("保存酒店税率信息失败");
        }

        return ret;
    }

}
