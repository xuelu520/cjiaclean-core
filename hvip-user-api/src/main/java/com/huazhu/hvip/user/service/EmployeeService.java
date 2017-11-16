package com.huazhu.hvip.user.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.user.qo.EmployeeQO;
import com.huazhu.hvip.user.vo.EmployeeVO;

/**
 * @author cmy
 * @create 2017-08-29 14:48
 **/
public interface EmployeeService {

    /**
     * 查询所有经理
     * @param employeeQO
     * @return
     */
    ReturnObject<EmployeeVO> getManagerListJson(EmployeeQO employeeQO);
}
