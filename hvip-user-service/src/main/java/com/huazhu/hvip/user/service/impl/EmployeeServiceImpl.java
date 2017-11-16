package com.huazhu.hvip.user.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.user.opUser.manager.EmployeeManager;
import com.huazhu.hvip.user.opUser.model.Employee;
import com.huazhu.hvip.user.qo.EmployeeQO;
import com.huazhu.hvip.user.service.EmployeeService;
import com.huazhu.hvip.user.vo.EmployeeVO;
import com.huazhu.hvip.util.CheckUtil;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cmy
 * @create 2017-08-29 14:49
 **/
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeManager employeeManager;
    private static Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);


    @Override
    public ReturnObject<EmployeeVO> getManagerListJson(EmployeeQO employeeQO) {
        logger.info("call getManagerListJson({})", JsonUtil.JSON_Bean2String(employeeQO));
        List<EmployeeVO> employeeVOList=new ArrayList<>();
        ReturnObject returnObject = new ReturnObject();
        try {
            QueryModel queryModel = new QueryModel();
            queryModel.addHqlCondition(" position like '%" + employeeQO.getPosition() + "%'");
            List<Employee> employeeList=employeeManager.search(queryModel);
            if(CheckUtil.checkListIsNull(employeeList)){
                for(Employee empl:employeeList){
                    EmployeeVO employeeVO=new EmployeeVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(empl,employeeVO);
                    employeeVOList.add(employeeVO);
                }
            }
            returnObject.setDataList(employeeVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.info("call getManagerListJson error({})", e);
        }
        return returnObject;
    }
}
