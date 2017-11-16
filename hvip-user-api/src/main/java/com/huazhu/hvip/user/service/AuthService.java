/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OpRoleService.java
 * Author:   lijing
 * Date:     2016-03-10 20:27:53
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-10 20:27:53> <version>   <desc>
 *
 */

package com.huazhu.hvip.user.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.user.request.AuthQO;
import com.huazhu.hvip.user.vo.AuthVO;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface AuthService {

    /**
     * 获取权限列表
     *
     * @param authQO
     * @return
     */
    ReturnObject<AuthVO> searchAuthList(AuthQO authQO);

    /**
     * 查询所有权限点
     *
     * @return
     */
    ReturnObject<AuthVO> searchAllAuth();

    /**
     * 保存权限点
     */
    ReturnObject saveAuth(AuthVO authVO) ;

    /**
     * 删除权限点
     */
    ReturnObject deleteAuth(Long authId) ;

    /**
     * 查找某个权限点
     *
     * @return
     */
    ReturnObject<AuthVO> getUniqueAuth(Long authId);
}
