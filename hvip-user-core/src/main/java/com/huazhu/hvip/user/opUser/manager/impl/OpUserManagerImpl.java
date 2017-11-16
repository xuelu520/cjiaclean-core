
package com.huazhu.hvip.user.opUser.manager.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.user.opUser.dao.CleanerDao;
import com.huazhu.hvip.user.opUser.dao.EmployeeDao;
import com.huazhu.hvip.user.opUser.dao.OpUserDao;
import com.huazhu.hvip.user.opUser.dao.OpUserRoleDao;
import com.huazhu.hvip.user.opUser.manager.OpUserManager;
import com.huazhu.hvip.user.opUser.manager.UserExistsException;
import com.huazhu.hvip.user.opUser.model.Cleaner;
import com.huazhu.hvip.user.opUser.model.Employee;
import com.huazhu.hvip.user.opUser.model.OpUser;
import com.huazhu.hvip.user.opUser.model.OpUserRole;
import com.huazhu.hvip.user.opUser.model.extend.OpUserExt;
import com.huazhu.hvip.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("opUserManager")
public class OpUserManagerImpl extends GenericManagerImpl<OpUser, Long> implements OpUserManager{
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    private OpUserDao opUserDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CleanerDao cleanerDao;

    @Autowired
    private OpUserRoleDao opUserRoleDao;


    @Autowired
    public void setOpUserDao(OpUserDao opUserDao) {
        this.dao = opUserDao;
        this.opUserDao = opUserDao;
    }

    /**
     * {@inheritDoc}
     *
     * @param username the login name of the human
     * @return User the populated user object
     */
    public OpUser getUserByUsername(String username){
        return (OpUser) opUserDao.loadUserByUsername(username);
    }

	/**
     * {@inheritDoc}
     */
    @Override
    public OpUser getOpUser(Long userId) {
        return opUserDao.get(userId);
    }


	@Override
	public ReturnObject<OpUser> login(String username, String password,String verifyCode, boolean preLogin) {
        return null;
	}

    /**
     * 查询查询所有用户以及对应的员工
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<OpUserExt> searchOpUsers(ParamObject paramObject) {
        QueryModel queryModel=new QueryModel();
        List<OpUserExt> opUserExtList = opUserDao.searchUserList(queryModel);

        paramObject.setTotalNum(queryModel.getTotalNum());

        return opUserExtList;
    }


   /* *//**
     * 获取用户信息
     *
     * @param userId
     * @return
     *//*
    @Override
    public ReturnObject<OpUserExt> getOpUserDetail(Long userId) {

        ReturnObject ret = new ReturnObject();
        OpUserExt opUserExt = null;
        try {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("opu.userId",userId);
            List<OpUserExt> opUserExtList = opUserDao.searchUserList(queryModel);
            if(opUserExtList!=null && opUserExtList.size()>0){
                opUserExt = opUserExtList.get(0);
            }

            OpUser opUser = opUserDao.get(userId);

            QueryModel qModel = new QueryModel();
            qModel.addColumnValueCondition("userId",opUser.getUserId());
            List<OpUserRole> userRoleList = opUserRoleDao.search(qModel);

            List<Long> opRoleIdList = new ArrayList<>();

            if(userRoleList != null && userRoleList.size() > 0){
                for(OpUserRole userRole : userRoleList){
                    opRoleIdList.add(userRole.getRoleId());
                }
            }

            opUserExt.setRoleIdList(opRoleIdList);

            ret.setData(opUserExt);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            log.error(e);
            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
            ret.setReturnMsg("获取信息失败");
        }

        return ret;
    }*/

    /**
     * saveUserAdmin保存
     *
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject saveUserAdmin(ParamObject paramObject) {
        ReturnObject ret = new ReturnObject();
        Employee employee = (Employee) paramObject.getParam("employee");
        OpUser opUser = (OpUser) paramObject.getParam("opUser");
        List<Long> roleIdList = (List<Long>) paramObject.getParam("roleIdList");

        employeeDao.save(employee);

        opUser = opUserDao.save(opUser);

        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("userId",opUser.getUserId());
        List<OpUserRole> userRoleList = opUserRoleDao.search(queryModel);
        for (OpUserRole userRole : userRoleList) {
            opUserRoleDao.remove(userRole.getUserRoleId());
        }

        OpUserRole userRole = null;
        for (Long roleId : roleIdList){
            userRole = new OpUserRole();
            userRole.setUserId(opUser.getUserId());
            userRole.setRoleId(roleId);
            opUserRoleDao.save(userRole);
        }

        ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        ret.setReturnMsg("保存失败");

        return ret;
    }

    /**
     * 登录
     *
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject<OpUser> loginForOpUser(ParamObject paramObject) {
        ReturnObject ret = new ReturnObject();
        String userName = (String) paramObject.getParam("userName");
        String  password = (String) paramObject.getParam("password");

        try {
            OpUser user = opUserDao.getUserByUserName(userName);

            if(user != null){
                if(user.getPassword().equals(password)){
                    ret.setData(user);
                    ret.setReturnMsg("登录成功");
                    ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                }else {
                    ret.setReturnMsg("用户名或密码错误");
                    ret.setReturnCode(Constants.RETURN_CODE_PASSWORDERROR);
                }
            }else {
                ret.setReturnCode(Constants.RETURN_CODE_USERNOTEXIST);
                ret.setReturnMsg("用户名或密码错误");
            }
        } catch (Exception e) {
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("用户名或密码错误");
        }

        return ret;
    }


    @Override
    public OpUser saveOpUser(OpUser user) throws UserExistsException {
        try {
            user.setPassword(passwordEncoder.encodePassword(user.getPassword(), user.getUserName()));
            return opUserDao.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn(e.getMessage());
            throw new UserExistsException("User '" + user.getUserName() + "' already exists!");
        }
    }

    @Override
    public List<OpUser> getOpUsers() {
        return opUserDao.getAllDistinct();
    }

    @Override
    public Set<Long> getOpUserRoleByUserId(Long userId) {
        return opUserDao.getOpUserRoleByUserId(userId);
    }

    @Override
    public void removeOpUser(Long userId) {
        log.debug("removing user: " + userId);

        //Long delUserId=new Long(userId);
        OpUser opUser=opUserDao.get(userId);
        if(opUser.getCleanerId()!=null){
            cleanerDao.remove(opUser.getCleanerId());
        }
        opUserDao.remove(userId);
    }

    @Override
    public OpUser saveOpUserAndEmployee(OpUser user, Cleaner cleaner) throws UserExistsException {
        boolean isEdit=user.getUserId()!=null?true:false;
        cleaner=cleanerDao.save(cleaner);
        user.setCleanerId(cleaner.getCleanId());
        if(isEdit){
            user.setUpdateTime(new Date());
        }else{
            user.setPassword(MD5Util.encode(user.getUserName()));
            user.setCreateTime(new Date());
        }
        return opUserDao.save(user);
    }
}
