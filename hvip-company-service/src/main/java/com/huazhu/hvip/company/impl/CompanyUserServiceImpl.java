package com.huazhu.hvip.company.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.company.manager.CompanyUserManager;
import com.huazhu.hvip.company.model.CompanyUser;
import com.huazhu.hvip.company.service.CompanyUserService;
import com.huazhu.hvip.company.vo.CompanyUserVO;
import com.huazhu.hvip.util.CheckUtil;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import com.huazhu.hvip.util.MD5Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cmy
 * @create 2017-10-13 11:34
 **/
@Service("companyUserService")
public class CompanyUserServiceImpl implements CompanyUserService {

    private static Logger logger = LogManager.getLogger(CompanyUserServiceImpl.class);

    @Autowired
    private CompanyUserManager companyUserManager;


    @Override
    public ReturnObject getCompanyServiceByCompanyId(Long companyId) {
        logger.info("call serviceListJson({\"companyId\":" + JsonUtil.JSON_Bean2String(companyId) + "})");
        ReturnObject returnObject = new ReturnObject();
        QueryModel queryModel = new QueryModel();
        List<CompanyUserVO> companyUserVOList = new ArrayList<>();
        queryModel.addColumnValueCondition("companyId", companyId);
        try {
                List<CompanyUser> companyUserList = companyUserManager.search(queryModel);
                if (CheckUtil.checkListIsNull(companyUserList)) {
                    for (CompanyUser companyUser : companyUserList) {
                        CompanyUserVO companyUserVO = new CompanyUserVO();
                        CopyBeanUtil.copyPropertiesIgnoreNull(companyUser, companyUserVO);
                        companyUserVOList.add(companyUserVO);
                    }
                }
            //}
            returnObject.setDataList(companyUserVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setTotalSize(queryModel.getTotalNum());
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call serviceListJson error({})", e);
        }
        return returnObject;
    }

    @Override
    public ReturnObject saveCompanyUserVO(CompanyUserVO companyUserVO) {
        logger.info(" call CompanyServiceImpl saveCompanyVO()", JsonUtil.JSON_Bean2String(companyUserVO));
        ReturnObject returnObject = new ReturnObject();
        try {
            CompanyUser companyUser = new CompanyUser();
            if (companyUserVO != null && companyUserVO.getUserId() != null) {
                companyUser = companyUserManager.get(companyUserVO.getUserId());
            }
            CopyBeanUtil.copyPropertiesIgnoreNull(companyUserVO, companyUser);
            companyUser = companyUserManager.save(companyUser);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.info(" call CompanyServiceImpl saveCompanyVO error()", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }


    /**
     * 用户登录
     *
     * @param companyUserVO
     * @return
     */
    @Override
    public ReturnObject<CompanyUserVO> loginForOpUser(CompanyUserVO companyUserVO) {

        ReturnObject<CompanyUserVO> ret = new ReturnObject();
        ParamObject paramObject = new ParamObject();

        String userName = companyUserVO.getUserName();
        String password = companyUserVO.getPassword();

        if(userName != null && password != null){
            paramObject.add("mobile",userName);
            paramObject.add("password", MD5Util.encode(password));
            ReturnObject<CompanyUser> uret = companyUserManager.loginForOpUser(paramObject);
            CompanyUser companyUser = uret.getData();
            CompanyUserVO _companyUserVO = new CompanyUserVO();
            BeanUtils.copyProperties(companyUser,_companyUserVO);
            ret.setData(_companyUserVO);
            ret.setReturnCode(uret.getReturnCode());
            ret.setReturnMsg(uret.getReturnMsg());
        }
        return ret;
    }


    /**
     * 更新后保存信息
     *
     * @param companyUserVO
     * @return
     */
    @Override
    public ReturnObject<CompanyUserVO> saveorUpdateCompanyUser(CompanyUserVO companyUserVO) {
        logger.info("call saveorUpdateCompanyUser({\"companyUserVO:\"" + JsonUtil.JSON_Bean2String(companyUserVO) + "})");
        ReturnObject<CompanyUserVO> returnObject = new ReturnObject<>();

        try {
            CompanyUser companyUser = new CompanyUser();
            CopyBeanUtil.copyPropertiesIgnoreNull(companyUserVO, companyUser);
            companyUser = companyUserManager.saveOrUpdateCompanyUser(companyUser);
            if (companyUser == null || companyUser.getUserId() == null) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("保存信息失败");
                return returnObject;
            }

            CompanyUserVO _companyUserVO = new CompanyUserVO();
            CopyBeanUtil.copyPropertiesIgnoreNull(companyUser, _companyUserVO);
            //BeanUtils.copyProperties(companyUser, companyUserVO);
            returnObject.setData(_companyUserVO);

            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("保存信息成功");

        } catch (Exception e) {
            logger.error("保存信息失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("保存信息失败");
        }

        return returnObject;
    }
}
