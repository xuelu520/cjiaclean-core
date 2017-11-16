/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CateCancelRuleServiceImpl.java
 * Author:   lijing
 * Date:     2016-04-20 09:56:14
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-20 09:56:14> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.channel.model.extend.ChannelGoodsPriceExt;
import com.huazhu.hvip.product.goods.manager.TagGoodsManager;
import com.huazhu.hvip.product.goods.manager.TagsManager;
import com.huazhu.hvip.product.goods.model.Goods;
import com.huazhu.hvip.product.goods.model.TagGoods;
import com.huazhu.hvip.product.goods.model.Tags;
import com.huazhu.hvip.product.goods.model.extend.GoodsExt;
import com.huazhu.hvip.product.goods.model.extend.TagGoodsExt;
import com.huazhu.hvip.product.goods.model.extend.TagsExt;
import com.huazhu.hvip.product.service.TagsService;
import com.huazhu.hvip.product.vo.ChannelGoodsPriceVO;
import com.huazhu.hvip.product.vo.GoodsVO;
import com.huazhu.hvip.product.vo.TagGoodsVO;
import com.huazhu.hvip.product.vo.TagsVO;
import com.huazhu.hvip.util.JsonUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author cmy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class TagsServiceImpl implements TagsService {
    private static org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(TagsServiceImpl.class);

    @Autowired
    private TagsManager tagsManager;

    @Autowired
    private TagGoodsManager tagGoodsManager;

    /**
     * 查询全部标签列表
     *
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject<TagsVO> searchTagsList(ParamObject paramObject) {
        ReturnObject<TagsVO> ret = new ReturnObject<>();
        logger.info("call searchTagsList()");
        try {
            List<TagsExt> tagsList = tagsManager.searchAllTagsList(paramObject);
            List<TagsVO> tagsVOList = new ArrayList<>();

            for (TagsExt tagsExt : tagsList) {
                TagsVO tagsVO = new TagsVO();
                BeanUtils.copyProperties(tagsExt, tagsVO);
                tagsVOList.add(tagsVO);
            }
            ret.setDataList(tagsVOList);
            ret.setTotalSize(paramObject.getTotalNum());
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (BeansException e) {
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
        }
        return ret;
    }

    /**
     * 查询标签商品设置
     *
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject<TagGoodsVO> searchTagGoodsList(ParamObject paramObject) {
        ReturnObject<TagGoodsVO> ret = new ReturnObject<>();
        logger.info("call searchTagGoodsList()");
        List<TagGoodsVO> voList = null;
        try {
            List<TagGoodsExt> extList = tagsManager.searchTagGoodsList(paramObject);
            voList = new ArrayList<>();
            for (TagGoodsExt tagGoodsExt : extList) {
                TagGoodsVO tagGoodsVO = new TagGoodsVO();
                BeanUtils.copyProperties(tagGoodsExt, tagGoodsVO);
                voList.add(tagGoodsVO);
            }
            ret.setDataList(voList);
            ret.setTotalSize(paramObject.getTotalNum());
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (BeansException e) {
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
        }
        return ret;
    }

    /**
     * 保存排序
     *
     * @param sortMap
     * @return
     */
    @Override
    public ReturnObject saveSort(Map<Long, Integer> sortMap) {
        logger.info("call saveSort({\"sortMap:\"" + JsonUtil.JSON_Bean2String(sortMap) + "})");
        ReturnObject ret = new ReturnObject();
        try {
            tagsManager.saveSort(sortMap);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("保存排序成功");
        } catch (Exception e) {
            logger.error("保存排序失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("保存排序成功");
        }
        return ret;
    }
    /**
     * 删除标签
     *
     * @param ids
     * @return
     */
    @Override
    public ReturnObject deleteTagsByIds(Long[] ids) {
        logger.info("call deleteGoods({\"ids:\"" + JsonUtil.JSON_List2String(ids) + "})");
        ReturnObject ret = new ReturnObject();
        try {
            tagsManager.deleteTagsByIds(ids);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("删除商品成功");
        } catch (Exception e) {
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

    /**
     * 保存标签
     *
     * @param tagsVO
     * @return
     */
    @Override
    public ReturnObject<TagsVO> saveTags(TagsVO tagsVO) {
        logger.info("call deleteGoods({\"tagsVO:\"" + JsonUtil.JSON_List2String(tagsVO) + "})");
        Tags tags = new Tags();
        ReturnObject ret = new ReturnObject();
        try {
            BeanUtils.copyProperties(tagsVO, tags);
            tags = tagsManager.save(tags);
            TagsVO tagsVO1 = new TagsVO();
            BeanUtils.copyProperties(tags, tagsVO1);
            ret.setData(tagsVO1);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (BeansException e) {
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

    /**
     * 根据Id查询标签
     *
     * @param tagsId
     * @return
     */
    @Override
    public TagsVO searchTagsById(Long tagsId) {
        logger.info("call searchTagsById({\"tagsId:\"" + JsonUtil.JSON_List2String(tagsId) + "})");
        TagsExt tagsExt = tagsManager.searchTagsById(tagsId);
        TagsVO tagsVO = new TagsVO();
        BeanUtils.copyProperties(tagsExt, tagsVO);
        return tagsVO;
    }

    /**
     * 保存更改标签
     *
     * @param tagsVO
     * @return
     */
    @Override
    public ReturnObject<TagsVO> saveEdit(TagsVO tagsVO) {
        logger.info("call saveEdit({\"tagsVO:\"" + JsonUtil.JSON_List2String(tagsVO) + "})");
        TagsExt tagsExt = new TagsExt();
        BeanUtils.copyProperties(tagsVO, tagsExt);
        tagsManager.saveEdit(tagsExt);
        ReturnObject ret = new ReturnObject();
        try {
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }


    /**
     * 查询标签下的商品
     *
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject<GoodsVO> listGoodsJsonByTagsId(ParamObject paramObject, Long tagsId) {
        ReturnObject<GoodsVO> ret = new ReturnObject();
        try {
            logger.info("call listGoodsJsonByTagsId()");
            List<Goods> list = tagsManager.listGoodsJsonByTagsId(paramObject, tagsId);
            List<GoodsVO> voList = new ArrayList<>();
            for (Goods good : list) {
                GoodsVO goodsVO = new GoodsVO();
                BeanUtils.copyProperties(good, goodsVO);
                voList.add(goodsVO);
            }
            ret.setDataList(voList);
            ret.setTotalSize(paramObject.getTotalNum());
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

    /**
     * 关联商品与标签
     *
     * @param tagGoodsVO
     * @return
     */
    @Override
    public ReturnObject addTagsGoods(TagGoodsVO tagGoodsVO) {
        ReturnObject ret = new ReturnObject();
        try {
            logger.info("call addTagsGoods()");
            TagGoods tagGoods = new TagGoods();
            BeanUtils.copyProperties(tagGoodsVO, tagGoods);
            tagGoodsManager.addTagsGoods(tagGoods);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg(e.getMessage());
        }
        return ret;
    }

    /**
     * 根据商品Id删除标签下的关联商品
     *
     * @param goodsId
     * @return
     */
    @Override
    public ReturnObject deleteGoods(Long goodsId,Long tagsId) {
        ReturnObject ret=new ReturnObject();
        logger.info("call deleteGoods()");
        try {
            tagGoodsManager.deleteGoods(goodsId,tagsId);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

}
