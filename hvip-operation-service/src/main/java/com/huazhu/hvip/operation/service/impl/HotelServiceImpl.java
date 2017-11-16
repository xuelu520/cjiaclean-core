/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelServiceImpl.java
 * Author:   chenli
 * Date:     2016-03-23 18:04:39
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 18:04:39> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.operation.manager.HotelManager;
import com.huazhu.hvip.operation.model.Hotel;
import com.huazhu.hvip.operation.qo.HotelQO;
import com.huazhu.hvip.operation.service.HotelService;
import com.huazhu.hvip.operation.vo.HotelVO;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Service("hotelService")
public class HotelServiceImpl implements HotelService {

    private static Logger logger = LogManager.getLogger(HotelServiceImpl.class);

    private HotelManager hotelManager;

    @Autowired
    public void setHotelManager(HotelManager hotelManager) {
        this.hotelManager = hotelManager;
    }

    /**
     * 查询所有的有效酒店
     *
     * @return
     */
    public ReturnObject<HotelVO> seachHotelList(ParamObject paramObject) {
        ReturnObject ret = new ReturnObject<>();
        Object object = paramObject;
        try {
            ReturnObject<Hotel> returnObject = hotelManager.searchHotelList(paramObject);

            List<Hotel> list = returnObject.getDataList();

            List<HotelVO> voList = new ArrayList<HotelVO>();

            for (Hotel hotels : list) {
                HotelVO hotelVO = new HotelVO();
                BeanUtils.copyProperties(hotels, hotelVO);
                voList.add(hotelVO);
            }
            Integer totalNum = paramObject.getTotalNum();
            ret.setTotalSize(totalNum);
            ret.setDataList(voList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }

        return ret;
    }

    /**
     * 更新酒店私人定制状态
     *
     * @param openVipFlag
     * @param hotelId
     * @return
     */
    @Override
    public ReturnObject updateVipFlag(String openVipFlag, Long hotelId) {
        logger.info("call updateVipFlag({\"openVipFlag:\"" + openVipFlag + "\"hotelId:\"\" + hotelId + \"})");

        ReturnObject returnObject = new ReturnObject();

        try {
            ParamObject paramObject = new ParamObject();
            paramObject.add("openVipFlag", openVipFlag);
            paramObject.add("hotelId", hotelId);
            Integer changeNo = hotelManager.updateHotelVipFlag(paramObject);
            if (null == changeNo || changeNo == 0) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("更新失败");
            } else {
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                returnObject.setReturnMsg("更新成功");
            }
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("更新失败");
        }
        return returnObject;
    }

    /**
     * 根据酒店统一编号获取酒店信息
     *
     * @param hotelUniqueNo
     * @return
     */
    @Override
    public ReturnObject<HotelVO> getHotelByHotelUniqueNo(String hotelUniqueNo) {
        logger.info("call getHotelByHotelUniqueNo({\"hotelUniqueNo:\"" + hotelUniqueNo + "})");

        ReturnObject<HotelVO> returnObject = new ReturnObject<>();

        try {
            ParamObject paramObject = new ParamObject();
            paramObject.add("hotelUniqueNo", hotelUniqueNo);
            Hotel hotel = hotelManager.getHotelByParam(paramObject);

            if (hotel == null) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("未查询到该酒店信息");

                return returnObject;
            }

            HotelVO hotelVO = new HotelVO();

            BeanUtils.copyProperties(hotel, hotelVO);

            returnObject.setData(hotelVO);

            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("查询成功");
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询失败");
        }
        return returnObject;
    }

    /**
     * 根据查询条件获取酒店信息
     *
     * @param hotelQO
     * @return
     */
    @Override
    public ReturnObject<HotelVO> getHotelByHotelQO(HotelQO hotelQO) {
        logger.info("call getHotelByHotelQO({\"hotelQO:\"" + JsonUtil.JSON_Bean2String(hotelQO) + "})");

        ReturnObject<HotelVO> returnObject = new ReturnObject<>();

        try {
            ParamObject paramObject = new ParamObject();

            if (hotelQO == null || (StringUtils.isBlank(hotelQO.getHotelUniqueNo()) && StringUtils.isBlank(hotelQO.getHotelNo()))) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("查询失败,参数为空");
            }


            paramObject.add("hotelUniqueNo", hotelQO.getHotelUniqueNo());
            paramObject.add("hotelNo", hotelQO.getHotelNo());
            paramObject.add("hotelId", hotelQO.getHotelId());
            Hotel hotel = hotelManager.getHotelByParam(paramObject);

            if (hotel == null) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("未查询到该酒店信息");

                return returnObject;
            }

            HotelVO hotelVO = new HotelVO();

            BeanUtils.copyProperties(hotel, hotelVO);

            returnObject.setData(hotelVO);

            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("查询成功");
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询失败");
        }
        return returnObject;
    }

    /**
     * 保存公寓信息
     *
     * @param hotelVO
     * @return
     */
    @Override
    public ReturnObject<HotelVO> saveHotelVO(HotelVO hotelVO) {
        logger.info("call saveHotelVO({\"hotelVO:\"" + JsonUtil.JSON_Bean2String(hotelVO) + "})");
        ReturnObject<HotelVO> returnObject = new ReturnObject<>();
        Hotel hotel = new Hotel();
        try {
            if (hotelVO.getHotelId() != null) {
                hotel = hotelManager.get(hotelVO.getHotelId());
            }
            CopyBeanUtil.copyPropertiesIgnoreNull(hotelVO, hotel);
            hotel=hotelManager.save(hotel);
            CopyBeanUtil.copyPropertiesIgnoreNull(hotel, hotelVO);
            returnObject.setData(hotelVO);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error(" call saveHotelVO() error",e);
        }
        return returnObject;
    }
}
