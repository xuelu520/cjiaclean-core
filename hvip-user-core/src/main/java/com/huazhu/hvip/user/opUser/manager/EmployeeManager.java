/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: EmployeeManager.java
 * Author:   chenli
 * Date:     2016-04-25 15:13:31
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-04-25 15:13:31> <version>   <desc>
 *
 */

package com.huazhu.hvip.user.opUser.manager;

import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.user.opUser.model.Employee;


/**
 * Business Service Interface to handler communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface EmployeeManager extends GenericManager<Employee, Long> {


}
