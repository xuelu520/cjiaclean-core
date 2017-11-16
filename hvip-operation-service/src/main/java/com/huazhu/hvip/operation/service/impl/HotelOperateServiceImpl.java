package com.huazhu.hvip.operation.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.constants.DicMap;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.operation.manager.HotelControlPriceManager;
import com.huazhu.hvip.operation.manager.HotelOperateManager;
import com.huazhu.hvip.operation.model.HotelControlPrice;
import com.huazhu.hvip.operation.model.HotelControlPriceItem;
import com.huazhu.hvip.operation.service.HotelOperateService;
import com.huazhu.hvip.operation.vo.HotelControlPriceVO;
import com.huazhu.hvip.operation.vo.HotelDataVO;
import com.huazhu.hvip.operation.vo.HotelOperateVO;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmy on 2016/6/14.
 */
@Service("hotelOperateService")
public class HotelOperateServiceImpl implements HotelOperateService {
    @Autowired
    private HotelOperateManager hotelOperateManager;

    @Autowired
    private HotelControlPriceManager hotelControlPriceManager;

    private static Logger logger = LogManager.getLogger(HotelOperateServiceImpl.class);

    /**
     * 查询hotel操作商品价格的数据
     *
     * @param hotelOperateVO
     * @return
     */
    @Override
    public ReturnObject searchHotelOperateList(HotelOperateVO hotelOperateVO) {
        logger.info("call searchHotelOperateList", JsonUtil.JSON_Bean2String(hotelOperateVO));
        ReturnObject ret = new ReturnObject();
        List<HotelOperateVO> hotelOperateVOList = new ArrayList<>();
        try {
            ParamObject paramObject = new ParamObject();
            paramObject.add("hotelNo", hotelOperateVO.getHotelNo());
            List<HotelControlPriceItem> hotelControlPriceItemList = hotelOperateManager.searchHotelControlPriceItem(paramObject);
            if (hotelControlPriceItemList.size() != 0 && hotelControlPriceItemList != null) {
                for (HotelControlPriceItem hotelControlPriceItem : hotelControlPriceItemList) {
                    HotelOperateVO hotelOperateVO1 = new HotelOperateVO();
                    BeanUtils.copyProperties(hotelControlPriceItem, hotelOperateVO1);
                    hotelOperateVO1.setStatusName(DicMap.getDicValue(Constants.HOTELCONTROLPRICEITEM_OPEARTE_STATUS_PREFIX + hotelControlPriceItem.getStatus()));
                    hotelOperateVOList.add(hotelOperateVO1);
                }
                ret.setDataList(hotelOperateVOList);
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            } else {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("没有查到数据");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
        }
        return ret;
    }

    /**
     * 取消申请
     *
     * @param hotelOperateVO
     * @return
     */
    @Override
    public ReturnObject updateHotelControlPriceItemStatus(HotelOperateVO hotelOperateVO) {
        logger.info("call cancelApplication", JsonUtil.JSON_Bean2String(hotelOperateVO));
        ParamObject paramObject = new ParamObject();
        ReturnObject ret = new ReturnObject();
        try {
            paramObject.add("hotelNo", hotelOperateVO.getHotelNo());
            paramObject.add("itemId", hotelOperateVO.getItemId());
            hotelOperateManager.updateHotelControlPriceItemStatus(paramObject);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("取消申请失败");
        }
        return ret;
    }

    /**
     * 查询HotelControlPriceItem
     *
     * @param hotelOperateVO
     * @return
     */
    @Override
    public ReturnObject searchHotelControlPriceItem(HotelOperateVO hotelOperateVO) {
        logger.info("call searchHotelControlPriceItem", JsonUtil.JSON_Bean2String(hotelOperateVO));
        List<HotelOperateVO> hotelOperateVOList = new ArrayList<>();
        ParamObject paramObject = new ParamObject();
        ReturnObject ret = new ReturnObject();
        paramObject.add("itemId", hotelOperateVO.getItemId());
        paramObject.add("controlPriceId",hotelOperateVO.getControlPriceId());
        paramObject.add("hotelNo", hotelOperateVO.getHotelNo());
        List<String> goodIdList = hotelOperateVO.getGoodsIdList();
        String goodsId = StringUtils.join(goodIdList, ",");
        paramObject.add("goodsId", goodsId);
        List<String> statusList = hotelOperateVO.getStatusList();
        String status = StringUtils.join(statusList, ",");
        paramObject.add("status", status);
        List<HotelControlPriceItem> hotelControlPriceItemList = hotelOperateManager.searchHotelControlPriceItem(paramObject);
        if (hotelControlPriceItemList != null && hotelControlPriceItemList.size() != 0) {
            for (HotelControlPriceItem hotelControlPriceItem : hotelControlPriceItemList) {
                HotelOperateVO hotelOperateVO1 = new HotelOperateVO();
                BeanUtils.copyProperties(hotelControlPriceItem, hotelOperateVO1);
                hotelOperateVO1.setStatusName(DicMap.getDicValue(Constants.HOTELCONTROLPRICEITEM_OPEARTE_STATUS_PREFIX + hotelControlPriceItem.getStatus()));
                hotelOperateVO1.setOpenChannelName(DicMap.getDicValue(Constants.HOTELCONTROLPRICEITEM_OPERATE_OPENCHANNEL_PREFIX + hotelControlPriceItem.getOpenChannel()));
                hotelOperateVOList.add(hotelOperateVO1);
            }
        }
        ret.setDataList(hotelOperateVOList);
        ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        return ret;
    }

    /**
     * 保存酒店控制价格
     *
     * @param hotelDataVO
     * @return
     */
    @Override
    public ReturnObject saveControlitem(HotelDataVO hotelDataVO) {
        logger.info("call saveControlitem param(" + JsonUtil.JSON_Bean2String(hotelDataVO) + ")");
        ParamObject paramObject = new ParamObject();
        ReturnObject ret = new ReturnObject();
        try {
            List<HotelOperateVO> hotelOperateVOList = hotelDataVO.getHotelOperateVOList();
            List<HotelControlPriceItem> hotelControlPriceItemList = new ArrayList<>();
            HotelControlPrice hotelControlPrice = new HotelControlPrice();
            for (HotelOperateVO hotelOperateVO : hotelOperateVOList) {
                HotelControlPriceItem hotelControlPriceItem = new HotelControlPriceItem();
                BeanUtils.copyProperties(hotelOperateVO, hotelControlPriceItem);
                BeanUtils.copyProperties(hotelOperateVO, hotelControlPrice);
                hotelControlPriceItemList.add(hotelControlPriceItem);
            }
            paramObject.add("hotelControlPriceItem", hotelControlPriceItemList);
            hotelOperateManager.saveControlitem(paramObject);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
            ret.setReturnMsg("保存失败");
            logger.error(e);
        }
        return ret;
    }

    /**
     * OP查询门店申请表格数据
     *
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject searchApplyManagerList(ParamObject paramObject) {
        logger.info("call searchApplyManagerList param(" + JsonUtil.JSON_Bean2String(paramObject) + ")");
        ReturnObject returnObject = new ReturnObject();
        List<HotelControlPriceVO> hotelControlPriceVOList = new ArrayList<>();
        List<HotelControlPrice> hotelControlPriceList = hotelControlPriceManager.searchApplyManagerList(paramObject);
        if (hotelControlPriceList != null && hotelControlPriceList.size() != 0) {
            for (HotelControlPrice hotelControlPrice : hotelControlPriceList) {
                HotelControlPriceVO hotelControlPriceVO = new HotelControlPriceVO();
                BeanUtils.copyProperties(hotelControlPrice, hotelControlPriceVO);
                hotelControlPriceVO.setStatusName(DicMap.getDicValue(Constants.HOTELCONTROLPRICE_OPEARTE_STATUS_PREFIX + hotelControlPriceVO.getStatus()));
                hotelControlPriceVOList.add(hotelControlPriceVO);
            }
            returnObject.setTotalSize(paramObject.getTotalNum());
            returnObject.setDataList(hotelControlPriceVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } else {
            returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
        }
        return returnObject;
    }

    /**
     * 保存hotelControlPrice状态
     *
     * @param hotelControlPriceVO
     * @return
     */
    @Override
    public ReturnObject saveHotelControlPrice(HotelControlPriceVO hotelControlPriceVO) {
        logger.info("call saveHotelControlPrice param(" + JsonUtil.JSON_Bean2String(hotelControlPriceVO) + ")");
        ReturnObject returnObject=new ReturnObject();
        try {
            HotelControlPrice hotelControlPrice=new HotelControlPrice();
            BeanUtils.copyProperties(hotelControlPriceVO,hotelControlPrice);
            hotelControlPriceManager.save(hotelControlPrice);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (BeansException e) {
            e.printStackTrace();
            returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
            returnObject.setReturnMsg("操作失败");
        }
        return returnObject;
    }
    /**
     * 根据酒店No去查询CrontrolPrice
     * @param hotelControlPriceVO
     * @return
     */
    @Override
    public ReturnObject searchHotelCrontrolPriceByHotelNo(HotelControlPriceVO hotelControlPriceVO) {
        logger.info("call searchHotelCrontrolPriceByHotelNo param(" + JsonUtil.JSON_Bean2String(hotelControlPriceVO) + ")");
        ReturnObject returnObject=new ReturnObject();
        List<HotelControlPriceVO> hotelControlPriceVOList=new ArrayList<>();
        try {
            ParamObject paramObject =new ParamObject();
            paramObject.add("hotelNo",hotelControlPriceVO.getHotelNo());
            List<HotelControlPrice> hotelControlPriceList=hotelOperateManager.searchHotelOperateListByHotelNo(paramObject);
            if(hotelControlPriceList!=null &&hotelControlPriceList.size()!=0){
                for(HotelControlPrice hotelControlPrice:hotelControlPriceList){
                    HotelControlPriceVO hotelControlPriceVO1=new HotelControlPriceVO();
                    BeanUtils.copyProperties(hotelControlPrice,hotelControlPriceVO1);
                    hotelControlPriceVOList.add(hotelControlPriceVO1);
                }
            }
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setDataList(hotelControlPriceVOList);
        } catch (BeansException e) {
            e.printStackTrace();
            returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
            returnObject.setReturnMsg("操作失败");
        }
        return returnObject;
    }
}
