/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsTypeServiceImpl.java
 * Author:   chenli
 * Date:     2016-03-17 11:21:42
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-17 11:21:42> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.service.FinanceSubjectService;
import com.huazhu.hvip.common.service.SysParamService;
import com.huazhu.hvip.common.vo.FinanceSubjectVO;
import com.huazhu.hvip.product.goods.manager.GoodsTypeManager;
import com.huazhu.hvip.product.goods.model.GoodsType;
import com.huazhu.hvip.product.goods.model.GoodsTypeBrand;
import com.huazhu.hvip.product.service.GoodsTypeService;
import com.huazhu.hvip.product.vo.*;
import com.huazhu.hvip.util.JsonUtil;
import net.sf.json.JSONArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    private static Logger logger = LogManager.getLogger(GoodsTypeServiceImpl.class);

    @Autowired
    private GoodsTypeManager goodsTypeManager;
    @Autowired
    private SysParamService sysParamService;
    @Autowired
    private FinanceSubjectService financeSubjectService;

    /**
     * 获取商品类型
     * @return List
     */
    @Override
    public ReturnObject<GoodsTypeVO> getAll() {
        ReturnObject<GoodsTypeVO> ret = new ReturnObject<GoodsTypeVO>();
        try {
            List<GoodsTypeVO> goodsTypeVOList = new ArrayList<GoodsTypeVO>();
            List<GoodsType> goodsTypeList = goodsTypeManager.getAll();
            GoodsTypeVO goodsTypeVO = null;
            for(GoodsType goodsType : goodsTypeList) {
                goodsTypeVO = new GoodsTypeVO();
                BeanUtils.copyProperties(goodsType, goodsTypeVO);
                goodsTypeVOList.add(goodsTypeVO);
            }
            ret.setDataList(goodsTypeVOList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }

        return ret;
    }

    /**
     * 根据id获取商品类型
     * @param typeId 类型id
     * @return ret 通用返回参数
     */
    @Override
    public ReturnObject<GoodsTypeVO> getGoodsTypeById(Long typeId) {
        logger.info("call getGoodsTypeById({\"typeId:\"" + typeId + "})");
        ReturnObject<GoodsTypeVO> ret = new ReturnObject<GoodsTypeVO>();

        try {
            GoodsType goodsType = goodsTypeManager.get(typeId);
            GoodsTypeVO goodsTypeVO = new GoodsTypeVO();
            BeanUtils.copyProperties(goodsType,goodsTypeVO);
            ret.setData(goodsTypeVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败",e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return ret;
    }

    /**
     * 保存商品类型
     * @param goodsTypeVO
     * @return ReturnObject
     */
    @Override
    public ReturnObject<GoodsTypeVO> saveGoodsType(GoodsTypeVO goodsTypeVO) {
        ReturnObject<GoodsTypeVO> ret = new ReturnObject<GoodsTypeVO>();

        try {
            GoodsType goodsType = new GoodsType();
            BeanUtils.copyProperties(goodsTypeVO, goodsType);
            GoodsType goodsType1 = goodsTypeManager.save(goodsType);
            GoodsTypeVO goodsTypeVO1 = new GoodsTypeVO();
            BeanUtils.copyProperties(goodsType1, goodsTypeVO1);
            ret.setData(goodsTypeVO1);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }

        return ret;

    }

    @Override
    public ReturnObject removeGoodsType(GoodsTypeVO goodsTypeVO) {
        ReturnObject ret = new ReturnObject();

        try {
            GoodsType goodsType = new GoodsType();
            BeanUtils.copyProperties(goodsTypeVO, goodsType);
            goodsTypeManager.remove(goodsType);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

    /**
     * 根据id批量删除商品类型
     * @param ids 类型ID
     * @return ret 通用返回参数
     */
    @Override
    public ReturnObject deleteGoodsType(Long[] ids) {
        logger.info("call deleteGoodsType({\"ids:\"" + ids.toString() + "})");

        ReturnObject ret = new ReturnObject();

        try {
            int deleteCount=goodsTypeManager.deleteGoodsType(ids);
            if (deleteCount>0) {
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                ret.setReturnMsg("删除商品类型成功");
            }else{
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("删除商品类型失败");
            }
        } catch (Exception e) {
            logger.error("删除商品类型失败",e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("删除商品类型失败");
        }

        return ret;
    }

    /**
     * 将一个ParamGroup 对像的List 生成json字串 <br/> 此字串将会保存在数据库goods_type的params字段 或
     * js_goods中的params字段
     * 不同的是：goods_type字段中的参数信息无参数值信息，而js_goods表中的params字段有参数值信息。 <br/> List
     * 是根据是根据客户端页面用户输入的参数信息生成的
     *
     * @param paramnums
     * @param groupnames
     * @param paramnames
     * @return
     */
    @Override
    public ReturnObject<String> getParamString(String[] paramnums, String[] groupnames, String[] paramnames, String[] paramvalues) {
        logger.info("call getParamString()");
        ReturnObject<String> ret = new ReturnObject<String>();
        try {
            List list = toParamList(paramnums, groupnames, paramnames, paramvalues);
            JSONArray jsonarray = JSONArray.fromObject(list);
            ret.setData(jsonarray.toString());
        } catch (Exception e) {
            logger.error(e);
        }
        return ret;
    }

    /**
     * 查询类型列表
     * @param para
     * @return
     */
    @Override
    public ReturnObject<GoodsTypeVO> searchGoodsTypeList(ParamObject para) {
        logger.info("call searchGoodsTypeList()");
        ReturnObject<GoodsTypeVO> ret = new ReturnObject<GoodsTypeVO>();

        try {
            List<GoodsType> list = goodsTypeManager.searchGoodsTypeList(para);
            Map<Long, String> subMap = getFinanceSubjectMap();

            List<GoodsTypeVO> voList = new ArrayList<GoodsTypeVO>();
            for (GoodsType goods : list) {
                GoodsTypeVO goodsTypeVO = new GoodsTypeVO();
                BeanUtils.copyProperties(goods, goodsTypeVO);
                goodsTypeVO.setJoinSubject(subMap.get(goods.getSubjectId()));
                voList.add(goodsTypeVO);
            }
            ret.setDataList(voList);
            ret.setTotalSize(para.getTotalNum());
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }
        return ret;
    }

    private Map<Long,String> getFinanceSubjectMap() {
        Map<Long, String> map = new HashMap<>();
        FinanceSubInfoVO financeSubjectVO = null;

        //ReturnObject<GoodsFinanceSubjectVO> subRet = sysParamService.getGoodsFinanceSubjectList();
        //ReturnObject<com.huazhu.hvip.common.vo.FinanceSubInfoVO> subRet = sysParamService.getFinanceSubjectList();
        ReturnObject<FinanceSubjectVO> subRet = financeSubjectService.searchFinanceSubjectList();
        logger.info("getFinanceSubjectMap----{}",JsonUtil.JSON_Bean2String(subRet));
        List<FinanceSubjectVO> list = subRet.getDataList();
        if(list!=null&&list.size()!=0){
            for (FinanceSubjectVO sub : list){
                StringBuffer bf=new StringBuffer();
                bf.append(sub.getSubjectName());
                bf.append("(科目："+sub.getSubjectCode()+" || ");
                bf.append("调整："+sub.getSubjectAdjustCode()+")");
                map.put(sub.getSubjectId(),bf.toString());
            }
        }

        return map;
    }

    /**
     * 创建类型品牌关联表数据
     * @param typeId
     * @param brandIds
     * @return
     */
    @Override
    public ReturnObject<GoodsTypeBrandVO> createTypeBrand(Long typeId, List<Long> brandIds) {
        logger.info("call createTypeBrand({\"typeId:\"" + typeId + "\"brandIds:\""+ JsonUtil.JSON_List2String(brandIds)+ "})");
        ReturnObject<GoodsTypeBrandVO> ret = new ReturnObject<>();

        try {
            List<GoodsTypeBrand> list  = goodsTypeManager.createTypeBrand(typeId,brandIds);
            List<GoodsTypeBrandVO> voList = null;
            if(list!=null&&list.size()>0){
                voList = new ArrayList<GoodsTypeBrandVO>();
                GoodsTypeBrandVO typeBrandVO= null;
                for(GoodsTypeBrand typeBrand : list){
                    typeBrandVO = new GoodsTypeBrandVO();
                    BeanUtils.copyProperties(typeBrand,typeBrandVO);
                    voList.add(typeBrandVO);
                }
            }else{
                ret.setReturnCode(Constants.RETURN_CODE_ERROR);
                ret.setReturnMsg("保存失败");
            }
            ret.setDataList(voList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("保存成功");
        } catch (Exception e) {
            logger.error("保存失败",e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("保存失败");
        }

        return ret;
    }

    /**
     * 根据页面用户的参数信息 生成 ParamGroup 实体的List
     *
     * @param ar_paramnum
     * @param groupnames
     * @param paramnames
     * @return
     */
    private List<ParamGroup> toParamList(String[] ar_paramnum,
                                         String[] groupnames, String[] paramnames, String[] paramvalues) {

        List<ParamGroup> list = new ArrayList<ParamGroup>();
        if (groupnames != null) {
            for (int i = 0; i < groupnames.length; i++) {
                ParamGroup paramGroup = new ParamGroup();
                paramGroup.setName(groupnames[i]);
                List<ParamItem> paramList = getParamList(ar_paramnum,
                        paramnames, paramvalues, i);
                paramGroup.setParamList(paramList);
                list.add(paramGroup);
            }
        }
        return list;
    }

    /**
     * 根据页面用户输入信息生成GoodsParam 对象的List,此list将被保存在相应的ParamGroup对象中 <br/>
     * GoodsParam对象只有name 属性会被赋值,value属性不会被处理.
     *
     * @param ar_paramnum
     * @param paramnames
     * @param groupindex
     * @return
     */
    private List<ParamItem> getParamList(String[] ar_paramnum,
                                          String[] paramnames, String[] paramvalues, int groupindex) {
        int[] pos = this.countPos(groupindex, ar_paramnum);
        List<ParamItem> list = new ArrayList<ParamItem>();
        for (int i = pos[0]; i < pos[1]; i++) {
            ParamItem paramItem = new ParamItem();

            paramItem.setName(paramnames[i]);

            if (paramvalues != null) {
                String value = paramvalues[i];
                paramItem.setValue(value);
            }

            list.add(paramItem);
        }
        return list;
    }

    /**
     * 计算 某个参数组 的参数 在 从页面传递过来的paramnames 数组的位置
     *
     * @param groupindex
     * @param ar_paramnum
     * @return
     */
    private int[] countPos(int groupindex, String[] ar_paramnum) {

        int index = 0;
        int start = 0;
        int end = 0;
        int[] r = new int[2];
        for (int i = 0; i <= groupindex; i++) {
            int p_num = Integer.valueOf(ar_paramnum[i]);

            index = index + p_num;
            if (i == groupindex - 1) { // 上一个参数组的参数 结束
                start = index;
            }

            if (i == groupindex) { // 当前的 本参数组的参数开始
                end = index;
            }

        }

        r[0] = start;
        r[1] = end;

        return r;
    }
}
