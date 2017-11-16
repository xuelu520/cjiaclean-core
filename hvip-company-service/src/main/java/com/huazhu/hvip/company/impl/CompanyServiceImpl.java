package com.huazhu.hvip.company.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.company.manager.CompanyManager;
import com.huazhu.hvip.company.model.Company;
import com.huazhu.hvip.company.qo.CompanyQO;
import com.huazhu.hvip.company.service.CompanyService;
import com.huazhu.hvip.company.vo.CompanyVO;
import com.huazhu.hvip.util.CheckUtil;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author cmy
 * @create 2017-10-11 17:01
 **/
public class CompanyServiceImpl implements CompanyService {

    private static Logger logger = LogManager.getLogger(CompanyServiceImpl.class);

    @Autowired
    private CompanyManager companyManager;

    /**
     * 查询公司信息
     *
     * @param companyQO
     * @return
     */
    public ReturnObject listJson(CompanyQO companyQO) {
        logger.info(" call CompanyServiceImpl listJson()", JsonUtil.JSON_Bean2String(companyQO));
        ReturnObject returnObject = new ReturnObject();
        try {
            QueryModel queryModel = new QueryModel();
            if (companyQO.getPageSize() != null && companyQO.getPageNo() != null) {
                queryModel.setPageNo(companyQO.getPageNo());
                queryModel.setPageSize(companyQO.getPageSize());
            }
            List<Company> companyList = companyManager.search(queryModel);
            if (CheckUtil.checkListIsNull(companyList)) {
                List<CompanyVO> companyVOList = CopyBeanUtil.copyList(companyList, CompanyVO.class);
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                returnObject.setDataList(companyVOList);
            }
            returnObject.setTotalSize(queryModel.getTotalNum());
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call CompanyServiceImpl listJson error()", e);
        }
        return returnObject;
    }

    /**
     * 保存
     *
     * @param companyVO
     * @return
     */
    @Override
    public ReturnObject saveCompanyVO(CompanyVO companyVO) {
        logger.info(" call CompanyServiceImpl saveCompanyVO()", JsonUtil.JSON_Bean2String(companyVO));
        ReturnObject returnObject = new ReturnObject();
        try {
            Company company = new Company();
            if (companyVO != null && companyVO.getCompanyId() != null) {
                company = companyManager.get(companyVO.getCompanyId());
            }
            CopyBeanUtil.copyPropertiesIgnoreNull(companyVO, company);
            company = companyManager.save(company);
            CopyBeanUtil.copyPropertiesIgnoreNull(company, companyVO);
            returnObject.setData(companyVO);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.info(" call CompanyServiceImpl saveCompanyVO error()", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }


    /**
     * 通过id查询公司
     *
     * @param companyId
     * @return
     */
    @Override
    public ReturnObject getCompanyById(Long companyId) {
        logger.info(" call CompanyServiceImpl getCompanyById()", companyId);
        ReturnObject returnObject = new ReturnObject();
        try {
            if (companyId != null) {
                CompanyVO companyVO=new CompanyVO();
                CopyBeanUtil.copyPropertiesIgnoreNull(companyManager.get(companyId),companyVO);
                returnObject.setData(companyVO);
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            }
        } catch (Exception e) {
            logger.error(" call CompanyServiceImpl getCompanyById error()",e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }
}
