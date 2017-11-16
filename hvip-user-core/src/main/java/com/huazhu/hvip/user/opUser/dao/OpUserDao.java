/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OpUserDao.java
 * Author:   admin
 * Date:     2016-03-10 14:03:24
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-10 14:03:24><version><desc><source>
 */

package com.huazhu.hvip.user.opUser.dao;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.user.opUser.model.OpUser;
import com.huazhu.hvip.user.opUser.model.extend.OpUserExt;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * User Data Access Object (GenericDao) interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface OpUserDao extends GenericDao<OpUser, Long> {

    /**
     * Gets users information based on login name.
     * @param username the user's username
     * @return userDetails populated userDetails object
     * @throws UsernameNotFoundException thrown when user not
     * found in database
     */
    OpUser loadUserByUsername(String username) throws UsernameNotFoundException;

	OpUser getUserByUserName(String userName);

    /**
     * 查询用户列表
     *
     * @param queryModel
     * @return
     */
    List<OpUserExt> searchUserList(QueryModel queryModel);

    /**
     * 根据用户名查询密码
     *
     * @param userName
     * @return
     */
    OpUser getPasswordByUserName(String userName);


    Set<Long> getOpUserRoleByUserId(Long userId);

    /**
     * Gets a list of users ordered by the uppercase version of their username.
     *
     * @return List populated list of users
     */
    List<OpUser> getUsers();

    /**
     * Saves a user's information.
     * @param user the object to be saved
     * @return the persisted User object
     */
    OpUser saveUser(OpUser user);

    /**
     * Retrieves the password in DB for a user
     * @param userId the user's id
     * @return the password in DB, if the user is already persisted
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    String getUserPassword(Long userId);


    /**
     * 查询用户列表
     *
     * @param queryModel
     * @param paramObject
     * @return
     */
    List<OpUserExt> searchUserList(QueryModel queryModel, ParamObject paramObject);

    /**
     * 根据用户名查询密码
     *
     * @param userName
     * @return
     */
}
