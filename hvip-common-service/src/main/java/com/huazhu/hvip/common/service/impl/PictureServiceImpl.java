/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: DictCodeManager.java
 * Author:   admin
 * Date:     2016-03-08 15:31:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:31:50><version><desc><source>
 *
 */

package com.huazhu.hvip.common.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.manager.PictureManager;
import com.huazhu.hvip.common.model.Picture;
import com.huazhu.hvip.common.service.PictureService;
import com.huazhu.hvip.common.vo.PictureVO;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    private static Logger logger = LogManager.getLogger(PictureServiceImpl.class);

    @Autowired
    private PictureManager pictureManager;

    /**
     * 批量保存图片
     * @param voList
     * @return
     */
    @Override
    public ReturnObject<PictureVO> savePictures(List<PictureVO> voList) {
        logger.info("call searchStoreGoodsByCateId({\"voList:\"" + JsonUtil.JSON_List2String(voList) + "})");
        ReturnObject ret =  new ReturnObject();

        try {
            List<Picture> list = new ArrayList<Picture>();
            for (PictureVO picVO : voList){
                Picture pic = new Picture();
                BeanUtils.copyProperties(picVO,pic);
                list.add(pic);
            }

            List<Picture> list2 = pictureManager.savePictures(list);

            List<PictureVO> voList2 = new ArrayList<PictureVO>();
            for (Picture pic : list2){
                PictureVO picVO = new PictureVO();
                BeanUtils.copyProperties(pic,picVO);
                voList2.add(picVO);
            }

            ret.setDataList(voList2);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("保存图片成功");
        } catch (Exception e) {
            logger.error("保存图片失败",e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("保存图片成功");
        }

        return  ret;
    }

    /**
     * 根据图片id查询图片
     * @param picIds
     * @return
     */
    @Override
    public ReturnObject<PictureVO> searchPictureList(List<Long> picIds) {
        logger.info("call searchPictureList({\"picIds:\"" + JsonUtil.JSON_List2String(picIds) + "})");
        ReturnObject<PictureVO> ret = new ReturnObject<PictureVO>();

        try {
            ParamObject para = new ParamObject();
            para.add("picIds",picIds);
            List<Picture> list = pictureManager.searchPictureList(para);
            List<PictureVO> voList = new ArrayList<PictureVO>();
            for (Picture pic : list) {
                PictureVO picVO = new PictureVO();
                BeanUtils.copyProperties(pic, picVO);
                voList.add(picVO);
            }
            ret.setDataList(voList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败",e);
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }

        return ret;
    }

    /**
     * 保存图片
     * @param pictureVO
     * @return
     */
    @Override
    public ReturnObject<PictureVO> savePicture(PictureVO pictureVO) {
        logger.info("call savePicture({\"picture:\"" + pictureVO.toString() + "})");

        ReturnObject<PictureVO> ret = new ReturnObject<PictureVO>();

        try {
            Picture picture = new Picture();
            BeanUtils.copyProperties(pictureVO, picture);
            picture = pictureManager.save(picture);
            BeanUtils.copyProperties(picture, pictureVO);
            ret.setData(pictureVO);
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