/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelCateServiceImpl.java
 * Author:   chenli
 * Date:     2016-03-23 18:06:46
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 18:06:46> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.exception.BizException;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.operation.manager.HotelCateManager;
import com.huazhu.hvip.operation.manager.HotelManager;
import com.huazhu.hvip.operation.model.Hotel;
import com.huazhu.hvip.operation.model.HotelCate;
import com.huazhu.hvip.operation.qo.HotelQO;
import com.huazhu.hvip.operation.service.HotelCateService;
import com.huazhu.hvip.operation.vo.HotelCateVO;
import com.huazhu.hvip.operation.vo.HotelVO;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 酒店开通分类信息相关接口api实现
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("hotelCateService")
public class HotelCateServiceImpl implements HotelCateService {

    private static Logger logger = LogManager.getLogger(HotelCateServiceImpl.class);

    private HotelManager hotelManager;

    @Autowired
    public void setHotelManager(HotelManager hotelManager) {
        this.hotelManager = hotelManager;
    }

    private HotelCateManager hotelCateManager;

    @Autowired
    public void setHotelCateManager(HotelCateManager hotelCateManager) {
        this.hotelCateManager = hotelCateManager;
    }

    /**
     * 根据酒店统一编号获取该酒店已开通的分类列表
     *
     * @param hotelUniqueNo 酒店统一编号
     * @return dataList 分类列表
     */
    @Override
    public ReturnObject<HotelCateVO> searchOpenCateByHotelUniqueNo(String hotelUniqueNo) {
        logger.info("call searchOpenCateByHotelUniqueNo({\"hotelUniqueNo:\"" + hotelUniqueNo + "})");

        ReturnObject<HotelCateVO> ret = new ReturnObject<>();
        List<HotelCateVO> hotelCateVOList = new ArrayList<>();
        HotelCateVO hotelCateVO = null;

        try {
            //根据酒店统一编号查询酒店信息
            ParamObject paramObject = new ParamObject();
            paramObject.add("hotelUniqueNo", hotelUniqueNo);
            Hotel hotel = hotelManager.getHotelByParam(paramObject);

            if (hotel != null) {
                //根据酒店id查询该酒店已开通的分类列表
                QueryModel queryModel = new QueryModel();
                queryModel.addColumnValueCondition("hotelId", hotel.getHotelId());
                queryModel.addColumnValueCondition("deleteFlag", Constants.DELETE_FLAG_FALSE);

                List<HotelCate> list = hotelCateManager.search(queryModel);

                for (HotelCate hotelCate : list) {
                    hotelCateVO = new HotelCateVO();

                    BeanUtils.copyProperties(hotelCate, hotelCateVO);

                    hotelCateVOList.add(hotelCateVO);
                }

                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                ret.setReturnMsg("查询成功");
            } else {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到该酒店信息");
            }
        } catch (Exception e) {
            logger.error("查询该酒店已开通的分类列表失败", e);

            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        ret.setDataList(hotelCateVOList);

        return ret;
    }

    /**
     * 根据用户勾选，修改酒店开通分类列表
     *
     * @param hotelId 酒店id
     * @param cateMap 用户勾选的分类
     * @param appendFlag 是否追加
     * @return
     */
    @Override
    public ReturnObject saveOpenCateByHotelId(Long hotelId, Map<Long,String> cateMap , boolean appendFlag) {
        logger.info("call saveOpenCateByHotelId({},{},{})",hotelId,JsonUtil.JSON_List2String(cateMap),appendFlag);
        ReturnObject ret = new ReturnObject();
        ParamObject paramObject = new ParamObject();
        paramObject.add("hotelId", hotelId);
        paramObject.add("cateMap",cateMap);
        paramObject.add("appendFlag",appendFlag);
        try {
            ret = hotelCateManager.updateOpenCateByHotelId(paramObject);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }


        return ret;
    }
}
