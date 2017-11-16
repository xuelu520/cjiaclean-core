package com.huazhu.hvip.company.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.company.model.CompanyUser;

/**
 * @author cmy
 * @create 2017-10-12 13:33
 **/
public interface CompanyUserManager extends GenericManager<CompanyUser,Long> {
    /**
     * 后台用户登录
     *
     * @param paramObject
     * @return
     */
    ReturnObject<CompanyUser> loginForOpUser(ParamObject paramObject);

    /**
     * 更新后保存信息
     *
     * @param companyUser
     * @return
     */
    CompanyUser saveOrUpdateCompanyUser(CompanyUser companyUser);
}
