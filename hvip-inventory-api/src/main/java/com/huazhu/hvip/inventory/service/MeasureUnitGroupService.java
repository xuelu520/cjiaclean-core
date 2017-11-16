package com.huazhu.hvip.inventory.service;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.inventory.qo.MeasureUnitGroupQO;
import com.huazhu.hvip.inventory.vo.MeasureUnitGroupVO;

/**
 * Created by DINGQIANQIAN on 2016/9/18.
 */
public interface MeasureUnitGroupService {


    /**
     * 获取列表
     * @return ReturnObject
     */
    public ReturnObject<MeasureUnitGroupVO> getAll();

    /**
     * 保存单位
     * @param measureUnitGroupVO
     * @return ReturnObject
     */
    public ReturnObject<MeasureUnitGroupVO> saveMeasureUnitGroup(MeasureUnitGroupVO measureUnitGroupVO);

    /**
     * 查询单位列表
     * @param measureUnitGroupQO
     * @return
     */
    public ReturnObject<MeasureUnitGroupVO> searchMeasureUnitGroupList(MeasureUnitGroupQO measureUnitGroupQO);

    /**
     * 查询单个计量单位
     * @param groupId
     * @return
     */
    public ReturnObject<MeasureUnitGroupVO> getMeasureUnitGroupById(Long groupId);

    /**
     * 删除计量单位
     * @param ids
     * @return
     */
    public ReturnObject deleteMeasureUnitGroup(Long[] ids);


}
