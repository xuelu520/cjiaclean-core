/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: WebUserManagerImpl.java
 * Author:   lijing
 * Date:     2016-03-20 15:02:36
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 15:02:36> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.manager.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.exception.BizException;
import com.huazhu.hvip.base.exception.UserExistsException;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.member.manager.CrmManager;
import com.huazhu.hvip.member.dao.WebRoleDao;
import com.huazhu.hvip.member.dao.WebUserDao;
import com.huazhu.hvip.member.manager.WebUserManager;
import com.huazhu.hvip.member.manager.WebUserService;
import com.huazhu.hvip.member.model.WebUser;
import com.huazhu.hvip.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("webUserManager")
public class WebUserManagerImpl extends GenericManagerImpl<WebUser, Long> implements WebUserManager, WebUserService {

    private PasswordEncoder passwordEncoder;
    private WebUserDao webUserDao;
    @Autowired(required = false)
    private SaltSource saltSource;

//    @Autowired
//    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    @Autowired
    public void setWebUserDao(WebUserDao webUserDao) {
        this.dao = webUserDao;
        this.webUserDao = webUserDao;
    }

    private WebRoleDao webRoleDao;

    @Autowired
    public void setWebRoleDao(WebRoleDao webRoleDao) {
        this.webRoleDao = webRoleDao;
    }


    private CrmManager crmManager;

    @Autowired
    public void setCrmManager(CrmManager crmManager) {
        this.crmManager = crmManager;
    }

//    private SmsSendManager smsSendManager;
//
//    @Autowired
//    public void setSmsSendManager(SmsSendManager smsSendManager) {
//        this.smsSendManager = smsSendManager;
//    }
    //private SmsService

    /**
     * {@inheritDoc}
     */
    public WebUser getWebUser(String userId) {
        return webUserDao.get(new Long(userId));
    }

    /**
     * {@inheritDoc}
     */
    public List<WebUser> getWebUsers() {
        return webUserDao.getAllDistinct();
    }

    /**
     * {@inheritDoc}
     */
    public WebUser saveWebUser(WebUser user) throws UserExistsException {

        // Get and prepare password management-related artifacts
        boolean passwordChanged = false;
        if (passwordEncoder != null) {

            user.setUsername(user.getUsername().toLowerCase());
            // Check whether we have to encrypt (or re-encrypt) the password
            if (user.getVersion() == null) {
                // New user, always encrypt
                passwordChanged = true;
            } else {
                // Existing user, check password in DB
                String currentPassword = webUserDao.getUserPassword(user.getWebUserId());
                if (currentPassword == null) {
                    passwordChanged = true;
                } else {
                    if (!currentPassword.equals(user.getPassword())) {
                        passwordChanged = true;
                    }
                }
            }

            // If password was changed (or new user), encrypt it
            if (passwordChanged) {
                if (saltSource == null) {
                    // backwards compatibility
                    user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
                    log.warn("SaltSource not set, encrypting password w/o salt");
                } else {
                    //user.setPassword(passwordEncoder.encodePassword(user.getPassword(), saltSource.getSalt(user)));
                }
            }
        } else {
            log.warn("PasswordEncoder not set, skipping password encryption...");
        }

        try {

            WebUser webUser = webUserDao.saveUser(user);

            return webUser;
        } catch (Exception e) {
            e.printStackTrace();
            log.warn(e.getMessage());
            throw new UserExistsException("User '" + user.getUsername() + "' already exists!");
        }
    }

    /**
     * {@inheritDoc}
     */
    public void removeWebUser(WebUser user) {
        log.debug("removing user: " + user);
        webUserDao.remove(user);
    }

    /**
     * {@inheritDoc}
     */
    public void removeWebUser(String userId) {
        log.debug("removing user: " + userId);
        webUserDao.remove(new Long(userId));
    }

    /**
     * {@inheritDoc}
     *
     * @param username
     *            the login name of the human
     * @return User the populated user object
     * @throws UsernameNotFoundException
     *             thrown when username not found
     */
    public WebUser getUserByUsername(String username) throws UsernameNotFoundException {
        return (WebUser) webUserDao.getUserByUsername(username);
    }

    /**
     * {@inheritDoc}
     */
    public List<WebUser> search(String searchTerm) {
        return super.search(searchTerm, WebUser.class);
    }

    @Override
    public WebUser saveSecurityInfo(WebUser webUser) {
        WebUser user = this.getWebUser(webUser.getWebUserId() + "");
        user.setSecurityQuestion(webUser.getSecurityQuestion());
        user.setSecurityAnswer(webUser.getSecurityAnswer());
        user.setFirstName(webUser.getFirstName());
        user.setLastName(webUser.getLastName());

//        user.setSecurityFlag(Constants.USER_SECURITYFLAG_YES);

        return save(user);
    }

    @Override
    public boolean cleckAvailableUserField(QueryModel q) {
        List<WebUser> userList = super.search(q);
        return ((userList == null) || (userList != null && userList.size() == 0)) ? true : false;
    }

    /**
     * {@inheritDoc}
     */
    public WebUser getWebUserByDepositIndentity(String depositIndentity) {
        QueryModel queryModel = new QueryModel();
        queryModel.setPageNo(0);
        queryModel.setPageSize(1);
        queryModel.addColumnValueCondition("depositIdentity", depositIndentity);

        List<WebUser> webUserList = webUserDao.search(queryModel);
        WebUser webUser = new WebUser();
        if (!webUserList.isEmpty()) {
            webUser = webUserList.get(0);

        }
        return webUser;
    }

    /**
     * {@inheritDoc}
     */
    public void changePwd(WebUser user) {

//        String oldPassword = user.getOldPassword();
//        String oldPasswordEncode = null;
//        String newPassword = user.getPassword();
//        String newPasswordEncode = null;
//
//        if (saltSource == null) {
//            oldPasswordEncode = passwordEncoder.encodePassword(oldPassword, null);
//            newPasswordEncode = passwordEncoder.encodePassword(newPassword, null);
//        } else {
//            oldPasswordEncode = passwordEncoder.encodePassword(oldPassword, saltSource.getSalt(user));
//            newPasswordEncode = passwordEncoder.encodePassword(newPassword, saltSource.getSalt(user));
//        }
//
//        WebUser dbUser = webUserDao.get(user.getWebUserId());
//
//        if (!dbUser.getPassword().equals(oldPasswordEncode)) {
//
//            throw new BizException("oldpassword.notcrected", "Current Password not correct!");
//        }
//        try {
//            dbUser.setPassword(newPasswordEncode);
//            webUserDao.saveUser(dbUser);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.warn(e.getMessage());
//        }
    }



    @Override
    public ReturnObject<WebUser> login(String username, String password, String verifyCode, boolean isPreLogin) {

        ReturnObject<WebUser> ret = new ReturnObject<WebUser>();

        WebUser user = null;

        try {
            user = (WebUser) webUserDao.getUserByUsername(username);
            if (user != null) {
                boolean checkUserFlag = false;
//                if (!user.isEnabled()) {
//                    ret.setReturnCode(Constants.RETURN_CODE_ACCOUNTDISABLE);
//                    ret.setReturnMsg("无效账号.");
//
//                } else if (user.isAccountLocked()) {
//                    ret.setReturnCode(Constants.RETURN_CODE_ACCOUNTLOCKED);
//                    ret.setReturnMsg("账号已锁定.");
//                }

                /*
                 * else if(user.getLoginCount()>2){ ret.setReturnCode(Constants.RETURN_CODE_NEEDHUMANCODE);
                 * ret.setReturnMsg("Over Three times login request,Please input human code."); checkUserFlag=true; }
                 */

//                else {
                    checkUserFlag = true;

                    ReturnObject<String> crmRet = crmManager.login(username, password);

                    String memeberId = crmRet.getData();
                    if (!Constants.RETURN_CODE_SUCCESS.equals(crmRet.getReturnCode())) {
                        ret.setReturnCode(Constants.RETURN_CODE_PASSWORDERROR);
                        ret.setReturnMsg("账号或密码错误，请重试！");

                        //user.setLoginCount(user.getLoginCount() + 1);

//                        if (user.getLoginCount() > 3) {
//                            ret.setReturnCode(Constants.RETURN_CODE_NEEDHUMANCODE);
//                            ret.setReturnMsg("错误输入超过三次,请输入验证码.");
//                        }
//
//                        if (user.getLoginCount() > 4) {
                            //ret.setReturnCode(Constants.RETURN_CODE_NEEDHUMANCODE);
                            //ret.setReturnMsg("账号或密码错误，请重试！");
//                        }

//	                    if (user.getLoginCount() > 5) {
//	                        user.setAccountLocked(true);
//	                    }

//                    } else if(memeberId!=null && user.getMemberId()!=null ){
                    	 //user.setStatus(1); //老用户无效
//                    	 user.setAccountEnabled(false);
//                    	 webUserDao.save(user);
//
//                    	 String memberId=crmRet.getData();
//                         WebUser user1 = slientRegistWebUser(username, password,memberId);
//
//                         ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
//                         ret.setReturnMsg("登陆成功!");
//                         ret.setData(user1);

                    }else{

                        ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                        ret.setReturnMsg("登陆成功!");
                        //user.setLoginCount(0);
                        ret.setData(user);
                        if (saltSource == null) {
                            // backwards compatibility
                            user.setPassword(passwordEncoder.encodePassword(password, null));
                            log.warn("SaltSource not set, encrypting password w/o salt");
                        } else {
                            //user.setPassword(passwordEncoder.encodePassword(password, saltSource.getSalt(user)));
                        }
                        user.setLastLoginTime(new Date());
                        user.setLastLoginIp("");
                        //user.setStatus(0); //有效
                        //user.setMemberId(memeberId);

                    }

                    webUserDao.save(user);

               // }

            } else {

                // 判断是否在城家存在，如果不存在则，静默注册为会员

                ReturnObject<String> crmRet = crmManager.login(username, password);

                if (!Constants.RETURN_CODE_SUCCESS.equals(crmRet.getReturnCode())) {
                    ret.setReturnCode(Constants.RETURN_CODE_PASSWORDERROR);
                    ret.setReturnMsg("账号或密码错误，请重试！");
                } else {

                    ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                    ret.setReturnMsg("登陆成功!");
                    String memberId=crmRet.getData();
                    user = slientRegistWebUser(username, password,memberId);
                    ret.setData(user);
                }

            }

        } catch (Exception e) {
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("系统错误!");
        }
        return ret;
    }

    public ReturnObject<WebUser> login_bak(String username, String password, String verifyCode, boolean isPreLogin) {

        ReturnObject<WebUser> ret = new ReturnObject<WebUser>();

        WebUser user = null;

        try {

            user = (WebUser) webUserDao.getUserByUsername(username);
            boolean checkUserFlag = false;
//            if (!user.isEnabled()) {
//                ret.setReturnCode(Constants.RETURN_CODE_ACCOUNTDISABLE);
//                ret.setReturnMsg("无效账号.");
//
//            } else if (user.isAccountLocked()) {
//                ret.setReturnCode(Constants.RETURN_CODE_ACCOUNTLOCKED);
//                ret.setReturnMsg("账号已锁定.");
//            }

            /*
             * else if(user.getLoginCount()>2){ ret.setReturnCode(Constants.RETURN_CODE_NEEDHUMANCODE);
             * ret.setReturnMsg("Over Three times login request,Please input human code."); checkUserFlag=true; }
             */

             //else {
                checkUserFlag = true;
            //}

            if (checkUserFlag) {
                String inputPassword = null;

                if (saltSource == null) {
                    inputPassword = passwordEncoder.encodePassword(password, null);
                } else {
                    //inputPassword = passwordEncoder.encodePassword(password, saltSource.getSalt(user));
                }

                if (inputPassword.equals(user.getPassword())) {
                    ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                    //user.setLoginCount(0);

                    ret.setData(user);
                } else {
                    ret.setReturnCode(Constants.RETURN_CODE_PASSWORDERROR);

                    ret.setReturnMsg("账号或密码错误，请重试！");
                    //user.setLoginCount(user.getLoginCount() + 1);

//                    if (user.getLoginCount() > 3) {
//                        ret.setReturnCode(Constants.RETURN_CODE_NEEDHUMANCODE);
//                        ret.setReturnMsg("错误输入超过三次,请输入验证码.");
//                    }
//
//                    if (user.getLoginCount() > 5) {
//                        user.setAccountLocked(true);
//                    }

                }
                user.setLastLoginTime(new Date());
                //user.setLastLoginIP("");
                webUserDao.save(user);

            }

        } catch (UsernameNotFoundException u) {
            ret.setReturnCode(Constants.RETURN_CODE_USERNOTEXIST);
            ret.setReturnMsg("错误的用户名密码!");

        } catch (Exception e) {
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("系统错误!");
        }
        return ret;
    }



    // 静默注册,只生成本地用户，用在华住官网成功登陆后，注册
    public WebUser slientRegistWebUser(String mobileUsername, String password,String memberid) {

//        QueryModel queryModel = new QueryModel();
//        queryModel.addColumnValueCondition("userName", mobileUsername);
//        List<WebUser> userList = search(queryModel);
//        for (WebUser usr : userList) {
//            remove(usr);
//        }

        WebUser webuser = new WebUser();
        webuser.setUsername(mobileUsername);

        webuser.setPassword(password);
        //webuser.setMemberId(memberid);
        webuser = createUser(webuser);

        return webuser;

    }

    // 静默注册,用在订单生成等无账号场合，同时注册为huazhu账号
    public WebUser slientRegistUser(String mobileUsername,String certNo) throws UserExistsException {

        WebUser webuser = new WebUser();
        webuser.setUsername(mobileUsername);
        String password = CommonUtil.getCharAndNumr(6);
        webuser.setPassword(password);

        // 发送静默注册成功短信

        ReturnObject<String> ret = crmManager.regist(mobileUsername, password, "", "", certNo);
        if (Constants.RETURN_CODE_SUCCESS.equals(ret.getReturnCode())) {

        	 String memberId=ret.getData();
        	 //webuser.setMemberId(memberId);

            webuser = createUser(webuser);
            Map paramMap = new HashMap();
            paramMap.put("username", mobileUsername);
            paramMap.put("passwd", password);

            //smsSendManager.smsSend("registOk", mobileUsername, paramMap);
        }
        // webuser = createUser(webuser);
        // smsSendManager.smsSend("registOk", mobileUsername, paramMap);
        return webuser;

    }

    /**
     * 注册
     *
     * @throws UserExistsException
     */
    public WebUser registWebUser(WebUser user) throws UserExistsException {

        user.setAccountEnabled(true);

        user.setRegTime(new Date());

        user.setLastLoginTime(new Date());
        // Set the default user role on this new user
        //user.setRole(webRoleDao.getRoleByName(Constants.USER_ROLE));

//        user.setMailVerified(UserConstants.USER_MAILVERIFIED_NO);
//        user.setIdentityStatus(UserConstants.USER_INDENTITY_STATUS_NEW);
//        user.setSkipVerifyFlag(UserConstants.USER_SKIP_FLAG_NO);
//        user.setSecurityFlag(UserConstants.USER_SECURITYFLAG_NO);
        // user.setDepositIdentity(user.getUsername()+"_"+RandomStringUtils.randomAlphabetic(6));
        //user.setLoginCount(0);


        ReturnObject<String> ret = crmManager.regist(user.getUsername(), user.getPassword(), "", "", "");
        if (Constants.RETURN_CODE_SUCCESS.equals(ret.getReturnCode())) {
            // 发送静默注册成功短信
            Map paramMap = new HashMap();
            paramMap.put("username", user.getUsername());
            paramMap.put("passwd", user.getPassword());

            //smsSendManager.smsSend("registOk", user.getUsername(), paramMap);
            String memberId=ret.getData();
            //user.setMemberId(memberId);
            user = saveWebUser(user);
        } else if (Constants.RETURN_CODE_USEREXISTED.equals( ret.getReturnCode())) {

            throw new BizException(Constants.RETURN_CODE_ISHUAZHUUSER, "已是华住官网用户,无需注册!");
        } else {

            throw new BizException(Constants.RETURN_CODE_FAIL, "未能成功注册用户!");

        }

        return user;
    }

    /**
     * 创建用户
     */
    public WebUser createUser(WebUser user) {

        try {

            user.setAccountEnabled(true);

            user.setRegTime(new Date());

            user.setLastLoginTime(new Date());
            // Set the default user role on this new user
            //user.setRole(webRoleDao.getRoleByName(Constants.USER_ROLE));

//            user.setMailVerified(UserConstants.USER_MAILVERIFIED_NO);
//            user.setIdentityStatus(UserConstants.USER_INDENTITY_STATUS_NEW);
//            user.setSkipVerifyFlag(UserConstants.USER_SKIP_FLAG_NO);
//            user.setSecurityFlag(UserConstants.USER_SECURITYFLAG_NO);
            //user.setLoginCount(0);
            //user.setStatus(0);
            user = saveWebUser(user);

        } catch (UserExistsException e) {
            log.warn(e.getMessage());

        }

        return user;
    }

    @Override
    public ReturnObject<String> checkExistUser(ParamObject paramObject) {

        ReturnObject<String> ret = new ReturnObject<String>();

        WebUser user = null;

        try {

            String mobile = paramObject.getStringParam("mobile");


            if (crmManager.validateMobile(mobile)) {
                ret.setReturnCode(Constants.RETURN_CODE_ISHUAZHUUSER);
                ret.setReturnMsg("手机号码已经在华住网注册!");

            } else{
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                ret.setReturnMsg("手机号码可以注册!");

            }

        } catch (Exception e) {
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("系统错误!");
        }
        return ret;
    }



}
