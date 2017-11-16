/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: WebUserManager.java
 * Author:   lijing
 * Date:     2016-03-20 14:23:01
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 14:23:01> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.manager;

import com.huazhu.hvip.base.exception.UserExistsException;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.member.dao.WebUserDao;
import com.huazhu.hvip.member.model.WebUser;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
/**
 * Business Service Interface to handler communication between web and persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Modified by <a href="mailto:dan@getrolling.com">Dan
 *         Kibler </a>
 */
public interface WebUserManager extends GenericManager<WebUser, Long> {
    /**
     * Convenience method for testing - allows you to mock the DAO and set it on an interface.
     *
     * @param userDao
     *            the UserDao implementation to use
     */
    void setWebUserDao(WebUserDao userDao);

    /**
     * Retrieves a user by userId. An exception is thrown if user not found
     *
     * @param userId
     *            the identifier for the user
     * @return User
     */
    WebUser getWebUser(String userId);

    /**
     * Finds a user by their username.
     *
     * @param username
     *            the user's username used to login
     * @return User a populated user object
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     *             exception thrown when user not found
     */
    WebUser getUserByUsername(String username) throws UsernameNotFoundException;

    /**
     * Retrieves a list of all users.
     *
     * @return List
     */
    List<WebUser> getWebUsers();

    /**
     * Saves a user's information.
     *
     * @param user
     *            the user's information
     * @throws UserExistsException
     *             thrown when user already exists
     * @return user the updated user object
     */
    WebUser saveWebUser(WebUser user) throws UserExistsException;

    /**
     * Removes a user from the database
     *
     * @param user
     *            the user to remove
     */
    void removeWebUser(WebUser user);

    /**
     * Removes a user from the database by their userId
     *
     * @param userId
     *            the user's id
     */
    void removeWebUser(String userId);

    /**
     * Search a user for search terms.
     *
     * @param searchTerm
     *            the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<WebUser> search(String searchTerm);

    WebUser saveSecurityInfo(WebUser webUser);

    boolean cleckAvailableUserField(QueryModel q);

    /**
     * 根据充值ID找用户
     *
     * @param depositIndentity
     * @return
     */
    public WebUser getWebUserByDepositIndentity(String depositIndentity);

    /**
     * 修改登陆密码
     *
     * @param webuser
     */
    public void changePwd(WebUser webuser);



    /**
     * 登录，包含GA 验证，密码，过期等
     *
     * @param username
     * @param password
     * @return
     */
    ReturnObject<WebUser> login(String username, String password, String verifyCode, boolean isPreLogin);


    // 静默注册
    public WebUser slientRegistUser(String mobileUsername,String certNo) throws UserExistsException;

    // 静默注册,用在已是华住会员,但是非城家会员
    public WebUser slientRegistWebUser(String mobileUsername, String password,String memberid);

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    WebUser registWebUser(WebUser user) throws UserExistsException;

    /**
     * 注册
     */
    // public WebUser createUser(WebUser user) ;

    /**
     * 判断用户是否存在
     *
     * @param paramObject
     * @return
     */
	ReturnObject checkExistUser(ParamObject paramObject);

}

