package com.huazhu.hvip.company.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.company.vo.CompanyUserVO;

/**
 * @author cmy
 * @create 2017-10-13 11:32
 **/
public interface CompanyUserService {


    /**
     * 获取公司下面的账号
     * @param companyId
     * @return
     */
    ReturnObject getCompanyServiceByCompanyId(Long companyId);

    /**
     * 保存
     * @return
     */
    ReturnObject saveCompanyUserVO(CompanyUserVO companyUserVO);

    /**
     * 用户登录
     *
     * @param companyUserVO
     * @return
     */
    ReturnObject<CompanyUserVO> loginForOpUser(CompanyUserVO companyUserVO);


    /**
     * 更新后保存
     *
     * @param companyUserVO
     * @return
     */
    public ReturnObject<CompanyUserVO> saveorUpdateCompanyUser(CompanyUserVO companyUserVO);
}
