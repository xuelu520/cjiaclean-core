/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OpUserManager.java
 * Author:   admin
 * Date:     2016-03-10 14:05:52
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-10 14:05:52><version><desc><source>
 */

package com.huazhu.hvip.user.opUser.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.user.opUser.model.Cleaner;
import com.huazhu.hvip.user.opUser.model.OpUser;
import com.huazhu.hvip.user.opUser.model.extend.OpUserExt;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Set;


/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *  Modified by <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface OpUserManager extends GenericManager<OpUser, Long> {

    /**
     * Finds a user by their username.
     * @param username the user's username used to login
     * @return User a populated user object
     * @throws UsernameNotFoundException
     *         exception thrown when user not found
     */
    OpUser getUserByUsername(String username);

    /**
     * Retrieves a user by userId.  An exception is thrown if user not found
     *
     * @param userId the identifier for the user
     * @return User
     */
    OpUser getOpUser(Long userId);


	/**
	 * 后台用户登陆
	 * @param username
	 * @param password
	 * @param verifyCode
	 * @param preLogin
	 * @return
	 */
	ReturnObject<OpUser> login(String username, String password, String verifyCode, boolean preLogin);

    /**
     * 查询查询所有用户以及对应的员工
     *
     * @param paramObject
     * @return
     */
    List<OpUserExt> searchOpUsers(ParamObject paramObject);

    /**
     * 根据条件保存对员工，用户以及关联角色的修改
     *
     * @param paramObject
     * @return
     */
    ReturnObject saveUserAdmin(ParamObject paramObject);


    /**
     * 后台用户登录
     *
     * @param paramObject
     * @return
     */
    ReturnObject<OpUser> loginForOpUser(ParamObject paramObject);


    /**
     * Saves a user's information.
     *
     * @param user the user's information
     * @throws UserExistsException thrown when user already exists
     * @return user the updated user object
     */
    OpUser saveOpUser(OpUser user) throws UserExistsException;

    /**
     * Retrieves a list of all users.
     * @return List
     */
    List<OpUser> getOpUsers();

    Set<Long> getOpUserRoleByUserId(Long userId);

    void removeOpUser(Long userId);

    OpUser saveOpUserAndEmployee(OpUser user,Cleaner cleaner) throws UserExistsException;
}
