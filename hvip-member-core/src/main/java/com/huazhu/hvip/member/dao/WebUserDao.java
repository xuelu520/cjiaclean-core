/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: WebUserDao.java
 * Author:   lijing
 * Date:     2016-03-20 13:54:53
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 13:54:53> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.dao;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.member.model.WebUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface WebUserDao extends GenericDao<WebUser,Long>{

    /**
     * Gets users information based on login name.
     * @param username the user's username
     * @return userDetails populated userDetails object
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException thrown when user not
     * found in database
     */
    @Transactional
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    /**
     * Gets a list of users ordered by the uppercase version of their username.
     *
     * @return List populated list of users
     */
    List<WebUser> getUsers();

    /**
     * Saves a user's information.
     * @param user the object to be saved
     * @return the persisted User object
     */
    WebUser saveUser(WebUser user);

    /**
     * Retrieves the password in DB for a user
     * @param userId the user's id
     * @return the password in DB, if the user is already persisted
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    String getUserPassword(Long userId);

	WebUser getUserByUsername(String username);

}
