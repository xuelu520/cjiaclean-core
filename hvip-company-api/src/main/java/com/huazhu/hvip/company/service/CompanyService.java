package com.huazhu.hvip.company.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.company.qo.CompanyQO;
import com.huazhu.hvip.company.vo.CompanyVO;

/**
 * @author cmy
 * @create 2017-10-11 16:57
 **/
public interface CompanyService {
    /**
     * 查询公司信息
     * @param companyQO
     * @return
     */
    ReturnObject listJson(CompanyQO companyQO);

    /**保存的公司
     *
     * @param companyVO
     * @return
     */
    ReturnObject saveCompanyVO(CompanyVO companyVO);

    /**
     * 通过id查询公司
     * @param companyId
     * @return
     */
    ReturnObject getCompanyById(Long companyId);
}
