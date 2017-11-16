package com.huazhu.hvip.inventory.service;

import com.huazhu.hvip.base.model.ReturnObject;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.inventory.qo.MeasureUnitQO;
import com.huazhu.hvip.inventory.vo.MeasureUnitVO;

/**
 * Created by DINGQIANQIAN on 2016/9/18.
 */
public interface MeasureUnitService {
    ReturnObject getAllMeasureUnit();


    /**
     * 获取列表
     * @return ReturnObject
     */
    public ReturnObject<MeasureUnitVO> getAll();

    /**
     * 保存单位
     * @param measureUnitVO
     * @return ReturnObject
     */
    public ReturnObject<MeasureUnitVO> saveMeasureUnit(MeasureUnitVO measureUnitVO);

    /**
     * 查询单位列表
     * @param measureUnitQO
     * @return
     */
    public ReturnObject<MeasureUnitVO> searchMeasureUnitList(MeasureUnitQO measureUnitQO);

    /**
     * 查询单个计量单位
     * @param Id
     * @return
     */
    public ReturnObject<MeasureUnitVO> getMeasureUnitById(Long Id);

    /**
     * 删除计量单位
     * @param ids
     * @return
     */
    public ReturnObject deleteMeasureUnit(Long[] ids);


}
