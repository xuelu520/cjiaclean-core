package com.huazhu.hvip.user.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.constants.DicMap;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.service.SerialNumService;
import com.huazhu.hvip.user.opUser.manager.CleanerManager;
import com.huazhu.hvip.user.opUser.manager.EmployeeManager;
import com.huazhu.hvip.user.opUser.model.Cleaner;
import com.huazhu.hvip.user.opUser.model.Employee;
import com.huazhu.hvip.user.qo.CleanerQO;
import com.huazhu.hvip.user.request.LoginUserVO;
import com.huazhu.hvip.user.service.CleanerService;
import com.huazhu.hvip.user.vo.CleanerVO;
import com.huazhu.hvip.util.CheckUtil;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import com.huazhu.hvip.util.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cmy
 * @create 2017-08-08 16:15
 **/
@Service("cleanerService")
public class CleanerServiceImpl implements CleanerService {

    private static Logger logger = LogManager.getLogger(CleanerServiceImpl.class);

    @Autowired
    private CleanerManager cleanerManager;

    @Autowired
    private SerialNumService serialNumService;
    @Autowired
    private EmployeeManager employeeManager;

    /**
     * 查询保洁员信息
     *
     * @param cleanerQO
     * @return
     */
    @Override
    public ReturnObject<CleanerVO> listJson(CleanerQO cleanerQO) {
        logger.info("call listJson({\"cleanerQO:\"" + JsonUtil.JSON_Bean2String(cleanerQO) + "})");
        ReturnObject returnObject = new ReturnObject();
        List<CleanerVO> cleanerVOList = new ArrayList<>();
        try {
            QueryModel queryModel = new QueryModel();
            if (cleanerQO != null) {
                if (StringUtils.isNotBlank(cleanerQO.getKeyWord())) {
                    queryModel.addHqlCondition(" employeeNo like '%" + cleanerQO.getKeyWord() + "%' or mobile like '%" + cleanerQO.getKeyWord() + "%' or name like '%" + cleanerQO.getKeyWord() + "%'");
                }
                queryModel.addColumnValueCondition("entryType", cleanerQO.getEntryType());
                queryModel.addColumnValueCondition("workType", cleanerQO.getWorkType());
                if (StringUtils.isNotBlank(cleanerQO.getBeginTime()) && StringUtils.isNotBlank(cleanerQO.getEndTime())) {
                    queryModel.addHqlCondition(" realWorkTime>= '" + cleanerQO.getBeginTime() + "'");
                    queryModel.addHqlCondition(" realWorkTime<= '" + cleanerQO.getEndTime() + "'");
                }
                if (cleanerQO.getPageNo() != null && cleanerQO.getPageSize() != null) {
                    queryModel.setPageNo(cleanerQO.getPageNo());
                    queryModel.setPageSize(cleanerQO.getPageSize());
                }
                if (CheckUtil.checkListIsNull(cleanerQO.getCleanIdList())) {
                    String cleanIds = StringUtils.join(cleanerQO.getCleanIdList(), ",");
                    if (StringUtils.isNotBlank(cleanIds)) {
                        queryModel.addHqlCondition(" cleanId in(" + cleanIds + ")");
                    }
                }
                queryModel.addColumnValueCondition("position",cleanerQO.getPosition());
                queryModel.addColumnValueCondition("mobile",cleanerQO.getMobile());
                queryModel.addColumnValueCondition("status", cleanerQO.getStatus());
                queryModel.addColumnValueCondition("workStatus", cleanerQO.getWorkStatus());
                queryModel.addColumnValueCondition("leadName", cleanerQO.getWorkManagerName());
                queryModel.addColumnValueCondition("cleanTypeSn",cleanerQO.getCleanTypeSn());
                List<Cleaner> cleanerList = cleanerManager.search(queryModel);
                if (CheckUtil.checkListIsNull(cleanerList)) {
                    for (Cleaner cleaner : cleanerList) {
                        CleanerVO cleanerVO = new CleanerVO();
                        CopyBeanUtil.copyPropertiesIgnoreNull(cleaner, cleanerVO);
                        cleanerVO.setStatusName(DicMap.getDicValue(Constants.CLEANER_STATUS_WROKING_PREFIX + cleanerVO.getStatus()));
                        cleanerVOList.add(cleanerVO);
                    }
                }
                returnObject.setTotalSize(queryModel.getTotalNum());
                returnObject.setDataList(cleanerVOList);
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            }
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call listJson({})", e);
        }
        return returnObject;
    }


    /**
     * 保存员工
     *
     * @param cleanerVO
     * @return
     */
    @Override
    public ReturnObject<CleanerVO> saveClean(CleanerVO cleanerVO) {
        logger.info("call saveClean({\"cleanerVO:\"" + JsonUtil.JSON_Bean2String(cleanerVO) + "})");
        ReturnObject returnObject = new ReturnObject();
        try {
            if (cleanerVO != null) {
                Cleaner cleaner = null;
                if (cleanerVO.getCleanId() != null) {
                    cleaner= cleanerManager.get(cleanerVO.getCleanId());
                    if(cleaner.getLeadId()!=null&&cleaner.getLeadId()!=cleanerVO.getLeadId()||StringUtils.isBlank(cleanerVO.getLeadName())){
                        Cleaner leadCleaner=cleanerManager.get(cleanerVO.getLeadId());
                        if (leadCleaner!=null) {
                            cleaner.setLeadName(leadCleaner.getName());
                        }
                    }
                }else {
                    cleaner=new Cleaner();
                    String employeeNo = serialNumService.generateCleanNo();
                    cleaner.setEmployeeNo(employeeNo);
                    if(cleanerVO.getLeadId()!=null){
                        Cleaner leadCleaner=cleanerManager.get(cleanerVO.getLeadId());
                        if (leadCleaner!=null) {
                            cleaner.setLeadName(leadCleaner.getName());
                        }
                    }
                }
                CopyBeanUtil.copyPropertiesIgnoreNull(cleanerVO, cleaner);
                cleaner = cleanerManager.save(cleaner);
                CopyBeanUtil.copyPropertiesIgnoreNull(cleaner, cleanerVO);
                returnObject.setData(cleanerVO);
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            } else {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("保存信息不完整");
            }
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("保存信息出错");
            logger.error("call saveClean error()", e);
        }
        return returnObject;
    }

    /**
     * 根据id查询保洁师
     *
     * @param cleanId
     * @return
     */
    @Override
    public ReturnObject<CleanerVO> searchCleanerById(Long cleanId) {
        ReturnObject returnObject = new ReturnObject();
        try {
            if (cleanId != null) {
                Cleaner cleaner = cleanerManager.get(cleanId);
                CleanerVO cleanerVO = new CleanerVO();
                CopyBeanUtil.copyPropertiesIgnoreNull(cleaner, cleanerVO);
                returnObject.setData(cleanerVO);
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            } else {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("用户id为空");
            }
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询失败");
        }
        return returnObject;
    }


    /**
     * 用户登录
     *
     * @param loginUserVO
     * @return
     */
    @Override
    public ReturnObject<CleanerVO> loginForOpUser(LoginUserVO loginUserVO) {

        ReturnObject<CleanerVO> ret = new ReturnObject();
        ParamObject paramObject = new ParamObject();

        String userName = loginUserVO.getUserName();
        String password = loginUserVO.getPassword();

        if(userName != null && password != null){
            paramObject.add("mobile",userName);
            paramObject.add("password", password);
            ReturnObject<Cleaner> uret = cleanerManager.loginForOpUser(paramObject);
            Cleaner cleaner = uret.getData();
            CleanerVO cleanerVO = new CleanerVO();
            BeanUtils.copyProperties(cleaner,cleanerVO);
            ret.setData(cleanerVO);
            ret.setReturnCode(uret.getReturnCode());
            ret.setReturnMsg(uret.getReturnMsg());
        }
        return ret;
    }
}
