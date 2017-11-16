/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: EmployeeManagerImpl.java
 * Author:   chenli
 * Date:     2016-04-25 15:14:24
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-04-25 15:14:24> <version>   <desc>
 *
 */

package com.huazhu.hvip.user.opUser.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.user.opUser.dao.EmployeeDao;
import com.huazhu.hvip.user.opUser.manager.EmployeeManager;
import com.huazhu.hvip.user.opUser.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Implementation of RoleManager interface.
 *
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 */
@Service("employeeManager")
public class EmployeeManagerImpl extends GenericManagerImpl<Employee, Long> implements EmployeeManager {
    EmployeeDao employeeDao;

    @Autowired
    public EmployeeManagerImpl(EmployeeDao employeeDao) {
        super(employeeDao);
        this.employeeDao = employeeDao;
    }


}