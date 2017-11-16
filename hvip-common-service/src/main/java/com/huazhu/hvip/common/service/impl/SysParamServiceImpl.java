/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: DictCodeService.java
 * Author:   admin
 * Date:     2016-03-20 17:28:32
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 17:28:32><version><desc>
 */

package com.huazhu.hvip.common.service.impl;


import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.manager.SysParamManager;
import com.huazhu.hvip.common.model.SysParam;
import com.huazhu.hvip.common.service.SysParamService;
import com.huazhu.hvip.common.vo.*;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("sysParamService")
public class SysParamServiceImpl implements SysParamService {

    private static Logger logger = LogManager.getLogger(SmsSendServiceImpl.class);

    @Autowired
    private SysParamManager sysParamManager;

    /**
     * 根据酒店城市名称获取第三方(点到)城市信息
     *
     * @param cityName
     * @return
     */
    @Override
    public ReturnObject<ThirdPartyCityVO> getDiandaoCityInfoByName(String cityName) {
        logger.info("call getDiandaoCityInfoByName({})", cityName);

        ReturnObject<ThirdPartyCityVO> ret = new ReturnObject<>();

        try {
            if (StringUtils.isBlank(cityName)) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("查询失败，酒店城市名称为空");
                return ret;
            }

            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("paramType", Constants.SYSPARAM_TYPE_DIANDAO);
            queryModel.addColumnValueCondition("deleteFlag", Constants.DELETE_FLAG_FALSE);
            SysParam sysParam = sysParamManager.getUniqueResult(queryModel);

            if (sysParam == null || StringUtils.isBlank(sysParam.getParamValue())) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到系统参数或参数值为空");
                return ret;
            }

            String paramValue = sysParam.getParamValue();

            List<ThirdPartyCityVO> cityVOList = new ArrayList<>();
            cityVOList = JsonUtil.JSON_String2List(paramValue, ThirdPartyCityVO.class);

            if (cityVOList.size() < 1) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到点到城市信息");
                return ret;
            }

            Map<String,ThirdPartyCityVO> cityMap = new HashMap<>();

            for (ThirdPartyCityVO thirdPartyCityVO : cityVOList){
                cityMap.put(thirdPartyCityVO.getCityName(),thirdPartyCityVO);
            }

            String cityStr = cityName;
            String lastStr = cityName.substring(cityName.length() - 1, cityName.length());
            if(lastStr.equals("市")){
                cityStr = cityName.substring(0,cityName.length()-1);
            }

            ThirdPartyCityVO thirdPartyCityVO = cityMap.get(cityStr);

            logger.info("{}的点到城市信息：{}",cityName,JsonUtil.JSON_Bean2String(thirdPartyCityVO));

            ret.setData(thirdPartyCityVO);

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
     * 获取财务科目列表
     *
     * @return
     */
    @Override
    public ReturnObject<FinanceSubInfoVO> getFinanceSubjectList() {
        logger.info("call getFinanceSubjectList()");

        ReturnObject<FinanceSubInfoVO> ret = new ReturnObject<>();

        try {

            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("paramType", Constants.SYSPARAM_TYPE_FINANCESUBJECT);
            queryModel.addColumnValueCondition("deleteFlag", Constants.DELETE_FLAG_FALSE);
            SysParam sysParam = sysParamManager.getUniqueResult(queryModel);

            if (sysParam == null || StringUtils.isBlank(sysParam.getParamValue())) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到系统参数或参数值为空");
                return ret;
            }

            String paramValue = sysParam.getParamValue();

            List<FinanceSubInfoVO> subjectList = new ArrayList<>();
            subjectList = JsonUtil.JSON_String2List(paramValue, FinanceSubInfoVO.class);

            if (subjectList.size() < 1) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到财务科目列表");
                return ret;
            }

            ret.setDataList(subjectList);

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
     * 获取百宝箱商品对应财务科目列表
     *
     * @return
     */
    @Override
    public ReturnObject<GoodsFinanceSubjectVO> getGoodsFinanceSubjectList() {
        logger.info("call getGoodsFinanceSubjectList()");

        ReturnObject<GoodsFinanceSubjectVO> ret = new ReturnObject<>();

        try {

            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("paramType", Constants.SYSPARAM_TYPE_GOODSFINANCESUBJECT);
            queryModel.addColumnValueCondition("deleteFlag", Constants.DELETE_FLAG_FALSE);
            SysParam sysParam = sysParamManager.getUniqueResult(queryModel);

            if (sysParam == null || StringUtils.isBlank(sysParam.getParamValue())) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到系统参数或参数值为空");
                return ret;
            }

            String paramValue = sysParam.getParamValue();

            List<GoodsFinanceSubjectVO> subjectList = new ArrayList<>();
            subjectList = JsonUtil.JSON_String2List(paramValue, GoodsFinanceSubjectVO.class);

            if (subjectList.size() < 1) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到百宝箱商品对应财务科目列表");
                return ret;
            }

            ret.setDataList(subjectList);

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
     * 根据店铺id获取分成比例
     *
     * @param storeId
     * @return
     */
    @Override
    public ReturnObject<StoreSplitProportionVO> getStoreSplitProportionByStoreId(Long storeId) {
        logger.info("call getStoreSplitProportionByStoreId({})", storeId);

        ReturnObject<StoreSplitProportionVO> ret = new ReturnObject<>();

        try {
            if (storeId == null) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("查询失败，店铺id为空");
                return ret;
            }

            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("paramType", Constants.SYSPARAM_TYPE_SPLITPROPORTION);
            queryModel.addColumnValueCondition("deleteFlag", Constants.DELETE_FLAG_FALSE);
            SysParam sysParam = sysParamManager.getUniqueResult(queryModel);

            if (sysParam == null || StringUtils.isBlank(sysParam.getParamValue())) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到系统参数或参数值为空");
                return ret;
            }

            String paramValue = sysParam.getParamValue();

            List<StoreSplitProportionVO> splitProportionVOList = new ArrayList<>();
            splitProportionVOList = JsonUtil.JSON_String2List(paramValue, StoreSplitProportionVO.class);

            if (splitProportionVOList.size() < 1) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到分成比例信息");
                return ret;
            }

            Map<Long,StoreSplitProportionVO> splitMap = new HashMap<>();

            for (StoreSplitProportionVO storeSplitProportionVO : splitProportionVOList){
                splitMap.put(storeSplitProportionVO.getStoreId(),storeSplitProportionVO);
            }

            StoreSplitProportionVO split = splitMap.get(storeId);

            logger.info("{}的分成比例信息：{}",storeId,JsonUtil.JSON_Bean2String(split));

            ret.setData(split);

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
     * 根据商品类型id获取相关毛利率及毛利额，用于控制门店调价
     *
     * @param goodsTypeId
     * @return
     */
    @Override
    public ReturnObject<GoodsProfitRateVO> getGoodsProfitRateByTypeId(Long goodsTypeId) {
        logger.info("call getGoodsProfitRateByTypeId({})", goodsTypeId);

        ReturnObject<GoodsProfitRateVO> ret = new ReturnObject<>();

        try {
            if (goodsTypeId == null) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("查询失败，goodsTypeId为空");
                return ret;
            }

            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("paramType", Constants.SYSPARAM_TYPE_PROFITRATE);
            queryModel.addColumnValueCondition("deleteFlag", Constants.DELETE_FLAG_FALSE);
            SysParam sysParam = sysParamManager.getUniqueResult(queryModel);

            if (sysParam == null || StringUtils.isBlank(sysParam.getParamValue())) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到系统参数或参数值为空");
                return ret;
            }

            String paramValue = sysParam.getParamValue();

            List<GoodsProfitRateVO> goodsProfitRateVOList = new ArrayList<>();
            goodsProfitRateVOList = JsonUtil.JSON_String2List(paramValue, GoodsProfitRateVO.class);

            if (goodsProfitRateVOList.size() < 1) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到相关毛利率及毛利额");
                return ret;
            }

            Map<Long,GoodsProfitRateVO> rateMap = new HashMap<>();

            for (GoodsProfitRateVO goodsProfitRateVO : goodsProfitRateVOList){
                rateMap.put(goodsProfitRateVO.getGoodsTypeId(),goodsProfitRateVO);
            }

            GoodsProfitRateVO rate = rateMap.get(goodsTypeId);

            ret.setData(rate);

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
     * 获取百宝箱服务奖励提成比例
     *
     * @return
     */
    @Override
    public ReturnObject<Double> getRewadRate() {
        logger.info("call getRewadRate()");

        ReturnObject<Double> ret = new ReturnObject<>();

        try {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("paramType", Constants.SYSPARAM_TYPE_REWADRATE);
            queryModel.addColumnValueCondition("deleteFlag", Constants.DELETE_FLAG_FALSE);
            SysParam sysParam = sysParamManager.getUniqueResult(queryModel);

            if (sysParam == null || StringUtils.isBlank(sysParam.getParamValue())) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到系统参数或参数值为空");
                return ret;
            }

            String paramValue = sysParam.getParamValue();

            Double rewadRate = null;

            if(StringUtils.isNotBlank(paramValue)){
                rewadRate = Double.valueOf(paramValue);
            }

            ret.setData(rewadRate);
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
