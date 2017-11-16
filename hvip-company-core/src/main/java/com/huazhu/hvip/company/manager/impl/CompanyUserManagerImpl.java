package com.huazhu.hvip.company.manager.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.company.dao.CompanyUserDao;
import com.huazhu.hvip.company.manager.CompanyUserManager;
import com.huazhu.hvip.company.model.CompanyUser;
import com.huazhu.hvip.util.CheckUtil;
import com.huazhu.hvip.util.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author cmy
 * @create 2017-10-12 13:34
 **/
@Service("companyUserManager")
public class CompanyUserManagerImpl extends GenericManagerImpl<CompanyUser,Long> implements CompanyUserManager {
    private CompanyUserDao companyUserDao;

    @Autowired
    public CompanyUserManagerImpl(CompanyUserDao companyUserDao) {
        super(companyUserDao);
        this.companyUserDao = companyUserDao;
    }


    /**
     * 登录
     *
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject<CompanyUser> loginForOpUser(ParamObject paramObject) {
        ReturnObject ret = new ReturnObject();
        String mobile = (String) paramObject.getParam("mobile");
        String password = (String) paramObject.getParam("password");
        try {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("userName", mobile);
            List<CompanyUser> companyUserList = companyUserDao.search(queryModel);
            if (CheckUtil.checkListIsNull(companyUserList)) {
                CompanyUser companyUser = companyUserList.get(0);
                if (StringUtils.isBlank(password)
                        || StringUtils.isBlank(companyUser.getPassword())
                        || !password.equals(companyUser.getPassword())) {
                    ret.setReturnMsg("用户名或密码错误");
                    ret.setReturnCode(Constants.RETURN_CODE_PASSWORDERROR);
                } else {/**/
                    ret.setData(companyUser);
                    ret.setReturnMsg("登录成功");
                    ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                }
            }
        } catch (Exception e) {
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("用户名或密码错误");
        }

        return ret;
    }


    /**
     * 保存或修改信息
     *
     * @param companyUser
     * @return
     */
    @Transactional
    @Override
    public CompanyUser saveOrUpdateCompanyUser(CompanyUser companyUser) {
        ReturnObject ret = new ReturnObject();
        CompanyUser _companyUser = null;
        String userName = companyUser.getUserName();
        String password =  MD5Util.encode(companyUser.getPassword());
        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("userName", userName);
        List<CompanyUser> companyUserList = companyUserDao.search(queryModel);
        if (CheckUtil.checkListIsNull(companyUserList)) {
            _companyUser = companyUserList.get(0);
            _companyUser.setPassword(password);
            if (StringUtils.isBlank(userName)
                    || StringUtils.isBlank(_companyUser.getUserName())
                    || !userName.equals(_companyUser.getUserName())) {
                ret.setReturnMsg("用户名或密码错误");
                ret.setReturnCode(Constants.RETURN_CODE_PASSWORDERROR);
            } else {
               // ret.setData(companyUser);
               // ret.setReturnMsg("登录成功");
               // ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);

            }
        }


        //保存会员信息
        companyUser = companyUserDao.save(_companyUser);
        return companyUser;
    }
}
