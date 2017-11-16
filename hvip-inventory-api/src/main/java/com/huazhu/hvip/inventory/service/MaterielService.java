package com.huazhu.hvip.inventory.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.inventory.qo.MaterielQO;
import com.huazhu.hvip.inventory.vo.MaterielVO;

/**
 * Created by DINGQIANQIAN on 2016/9/18.
 */
public interface MaterielService {

    /**
     * 获取列表
     * @return ReturnObject
     */
    public ReturnObject<MaterielVO> getAll();

    /**
     * 查询物料列表
     * @return ReturnObject
     */
    public ReturnObject<MaterielVO> searchMaterielList(MaterielQO materielQO);

    /**
     * 添加物料
     * @return
     */
    public ReturnObject<MaterielVO> saveMateriel(MaterielVO materielVO);

    /**
     * 删除物料
     * @param ids
     * @return
     */
    public ReturnObject deleteMateriel(Long[] ids);

    /**
     * 查询单个物料id
     * @param id
     * @return
     */
    public ReturnObject<MaterielVO> getMaterielById(Long id);
}
