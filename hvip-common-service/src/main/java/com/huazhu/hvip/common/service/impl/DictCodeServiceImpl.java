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
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.manager.DictCodeManager;
import com.huazhu.hvip.common.model.DictCode;
import com.huazhu.hvip.common.service.DictCodeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class DictCodeServiceImpl implements DictCodeService {

    private DictCodeManager dictCodeManager;

    @Autowired
    public void setDictCodeManager(DictCodeManager dictCodeManager) {
        this.dictCodeManager = dictCodeManager;
    }

    /**
     * 根据字典名称与代码找具体字典代码
     *
     * @param dictName
     * @param codeNo
     * @return
     */
    public ReturnObject<DictCode> searchByCodeNo(String dictName, String codeNo) {
        ReturnObject<DictCode> ret = new ReturnObject<DictCode>();
        try {
            DictCode dictCode = dictCodeManager.searchByCodeNo(dictName, codeNo);
            ret.setData(dictCode);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }


    /**
     * 根据字典名称与代码和国家找具体字典代码
     *
     * @param dictName
     * @param codeNo
     * @param country
     * @return
     */
    public ReturnObject<DictCode> searchByCodeNoCountry(String dictName, String codeNo, String country) {
        ReturnObject<DictCode> ret = new ReturnObject<DictCode>();
        try {
            DictCode dictCode = dictCodeManager.searchByCodeNoCountry(dictName, codeNo, country);
            ret.setData(dictCode);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

    /**
     * 根据字典名称找字典代码列表
     *
     * @param dictName
     * @return
     */
    public ReturnObject<DictCode> searchByDictName(String dictName) {
        ReturnObject<DictCode> ret = new ReturnObject<DictCode>();
        try {
            List<DictCode> dictCodeList = dictCodeManager.searchByDictName(dictName);
            ret.setDataList(dictCodeList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

    /**
     * 根据字典名称和国家找字典代码列表
     *
     * @param dictName
     * @param country
     * @return
     */
    public ReturnObject<DictCode> searchByDictNameLocal(String dictName, String country) {
        ReturnObject<DictCode> ret = new ReturnObject<DictCode>();
        try {
            List<DictCode> dictCodeList = dictCodeManager.searchByDictNameLocal(dictName, country);
            ret.setDataList(dictCodeList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

}