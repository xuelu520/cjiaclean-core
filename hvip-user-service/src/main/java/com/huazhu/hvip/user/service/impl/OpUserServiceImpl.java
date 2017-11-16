/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OpUserServiceImpl.java
 * Author:   admin
 * Date:     2016-03-10 16:05:31
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-10 16:05:31><version><desc><source>
 */

package com.huazhu.hvip.user.service.impl;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.service.SerialNumService;
import com.huazhu.hvip.user.opUser.manager.*;
import com.huazhu.hvip.user.opUser.model.Auth;
import com.huazhu.hvip.user.opUser.model.Cleaner;
import com.huazhu.hvip.user.opUser.model.OpRole;
import com.huazhu.hvip.user.opUser.model.OpUser;
import com.huazhu.hvip.user.request.LoginUserVO;
import com.huazhu.hvip.user.service.MenuService;
import com.huazhu.hvip.user.service.OpUserService;
import com.huazhu.hvip.user.vo.CleanerVO;
import com.huazhu.hvip.user.vo.MenuVO;
import com.huazhu.hvip.user.vo.OpUserVO;
import com.huazhu.hvip.util.*;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("opUserService")
public class OpUserServiceImpl implements OpUserService {

    private static Logger logger = LogManager.getLogger(OpUserServiceImpl.class);


    @Autowired
    private OpUserManager opUserManager;
    @Autowired
    private AuthManager authManager;
    @Autowired
    private EmployeeManager employeeManager;
    @Autowired
    private MenuService menuService;
    @Autowired
    private OpRoleManager opRoleManager;
    @Autowired
    private SerialNumService serialNumService;
    @Autowired
    private CleanerManager cleanerManager;

    /**
     * 通过用户姓名查询用户
     *
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject<OpUserVO> getUserByUsername(ParamObject paramObject) {
        ReturnObject<OpUserVO> ret = new ReturnObject<OpUserVO>();

        try {
            String username = paramObject.getStringParam("username");
            OpUser opUser = opUserManager.getUserByUsername(username);
            OpUserVO opUserVo = new OpUserVO();
            BeanUtils.copyProperties(opUser, opUserVo);

            ret.setData(opUserVo);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg("用户查询失败");
        }
        return ret;
    }

    /**
     * 后台用户登陆,String username, String password, String verifyCode, boolean preLogin
     *
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject<OpUserVO> login(ParamObject paramObject) {
        ReturnObject<OpUserVO> ret = new ReturnObject<OpUserVO>();
        String username = null;
        String password = null;
        String verifyCode = null;
        boolean preLogin = false;
        try {
            Map paramMap = paramObject.getParamMap();
            username = (String) paramMap.get("username");
            password = (String) paramMap.get("password");
            verifyCode = (String) paramMap.get("verifyCode");
//            preLogin = (Boolean) paramMap.get("preLogin");
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg("获取参数失败");
        }
        try {
            ReturnObject ret2 = opUserManager.login(username, password, verifyCode, preLogin);
            ret.setReturnCode(ret2.getReturnCode());
            ret.setReturnMsg(ret2.getReturnMsg());
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg("登陆失败");
        }
        return ret;

    }

    /**
     * 查询所有用户以及对应的员工列表
     *
     * @param pageCondition
     * @return
     */
    @Override
    public ReturnObject<OpUserVO> searchOpUsers(PageCondition pageCondition) {
        logger.info("call searchOpUsers({})", JsonUtil.JSON_Bean2String(pageCondition));
        ReturnObject<OpUserVO> ret = new ReturnObject<OpUserVO>();
        List<OpUserVO> opUserVOList = new ArrayList<>();
        ParamObject paramObject = new ParamObject();
        try {
            List<OpUser> opUsers = opUserManager.getAll();
            OpUserVO opUserVO = null;
            for (OpUser opUser : opUsers) {
                opUserVO = new OpUserVO();
                BeanUtils.copyProperties(opUser, opUserVO);
                opUserVOList.add(opUserVO);
            }

            ret.setTotalSize(paramObject.getTotalNum());
            ret.setDataList(opUserVOList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询管理员用户成功");
        } catch (Exception e) {
            logger.error("call searchOpUsers() error", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询管理员列表失败");
        }
        return ret;
    }

    /**
     * 获取OP用户可用菜单
     *
     * @param opUserVO
     * @return
     */
    @Override
    public ReturnObject<MenuVO> getOpUserMenu(OpUserVO opUserVO) {
        logger.info("call getOpUserMenu({\"opUserVO:\"" + JsonUtil.JSON_Bean2String(opUserVO) + "})");

        ReturnObject<MenuVO> ret = new ReturnObject<MenuVO>();
        try {
            ParamObject para = new ParamObject();
            para.add("userId", opUserVO.getUserId());

            //查询OP用户权限列表
            List<Auth> authList = authManager.searchAuth(para);

            //查询菜单列表
            List<MenuVO> menuVOList = menuService.searchMenuList().getDataList();

            //根据权限获取可用菜单
            if (authList != null && authList.size() > 0 && menuVOList != null && menuVOList.size() > 0) {
                menuVOList = getAuthMenu(authList, menuVOList);
            } else {
                menuVOList = null;
            }

            ret.setDataList(menuVOList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("获取菜单成功");
        } catch (Exception e) {
            logger.error("获取菜单失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("获取菜单失败");
        }


        return ret;
    }


    /**
     * op用户登录
     *
     * @param loginUserVO
     * @return
     */
    @Override
    public ReturnObject<OpUserVO> loginForOpUser(LoginUserVO loginUserVO) {

        ReturnObject<OpUserVO> ret = new ReturnObject();
        ParamObject paramObject = new ParamObject();

        String userName = loginUserVO.getUserName();
        String password = loginUserVO.getPassword();

        if (userName != null && password != null) {
            paramObject.add("userName", userName);
            paramObject.add("password", MD5Util.encode(password));
            ReturnObject<OpUser> uret = opUserManager.loginForOpUser(paramObject);
            OpUser opUser = uret.getData();
            OpUserVO opUserVO = new OpUserVO();
            BeanUtils.copyProperties(opUser, opUserVO);
            ret.setData(opUserVO);
            ret.setReturnCode(uret.getReturnCode());
            ret.setReturnMsg(uret.getReturnMsg());
        }
        return ret;
    }

    @Override
    public ReturnObject<OpUserVO> getOpUserDetail(ParamObject paramObject) {
        logger.info("call getOpUserDetail({})", JsonUtil.JSON_Bean2String(paramObject));

        ReturnObject<OpUserVO> ret = new ReturnObject<OpUserVO>();
        try {
            Long userId = paramObject.getLongParam("userId");
            OpUserVO opUserVo = new OpUserVO();
            CleanerVO cleanerVO = new CleanerVO();
            OpUser opUser = opUserManager.getOpUser(userId);
            if(opUser.getCleanerId()!=null){
                Cleaner cleaner = cleanerManager.get(opUser.getCleanerId());
                BeanUtils.copyProperties(cleaner, cleanerVO);
            }
            Set<Long> opUserRoleList = opUserManager.getOpUserRoleByUserId(userId);
            BeanUtils.copyProperties(opUser, opUserVo);
            if (opUserRoleList != null && opUserRoleList.size() != 0) {
                Long[] roleArray = new Long[opUserRoleList.size()];
                Iterator it = opUserRoleList.iterator();
                int i = 0;
                while (it.hasNext()) {
                    roleArray[i] = new Long(it.next().toString());
                    i++;
                }
                opUserVo.setRoleArray(roleArray);
            }
            opUserVo.setCleanerVO(cleanerVO);
            ret.setData(opUserVo);
        } catch (Exception e) {
            logger.error("call getOpUserDetail() error", e);
            ret.setReturnMsg("用户查询失败");
        }
        return ret;
    }

    @Override
    public ReturnObject saveOpUser(OpUserVO opUserVo) {
        logger.info("call saveOpUser({})", JsonUtil.JSON_Bean2String(opUserVo));

        ReturnObject<OpUserVO> ret = new ReturnObject<OpUserVO>();

        try {
            OpUserVO returnOpUserVo = new OpUserVO();

            CleanerVO cleanerVO = opUserVo.getCleanerVO();
            Cleaner cleaner = null;
            if (cleanerVO != null && cleanerVO.getCleanId()!=null) {
                cleaner = cleanerManager.get(cleanerVO.getCleanId());
            }
            if(cleaner==null){
                cleaner=new Cleaner();
                cleaner.setPassword(DMD5.md5Encode(StringUtils.substring(cleanerVO.getMobile(),7,11)));
                cleaner.setEmployeeNo(serialNumService.generateCleanNo());
                cleaner.setLeadId(0L);
                Date nowDate=new Date();
                cleaner.setCreateTime(nowDate);
                cleaner.setUpdateTime(nowDate);
                cleaner.setUpdateUser("sysAdmin");
                cleaner.setUpdateUser("sysAdmin");
            }
            CopyBeanUtil.copyPropertiesIgnoreNull(cleanerVO, cleaner);
            OpUser user = new OpUser();
            if (opUserVo != null && opUserVo.getUserId() != null) {
                user = opUserManager.get(opUserVo.getUserId());
                if (opUserVo.getMobile() != null) {
                    user.setMobile(opUserVo.getMobile());
                }
            } else {
                BeanUtils.copyProperties(opUserVo, user);
                user.setAccountEnabled(true);
                user.setRemark(opUserVo.getName());
            }

            Long[] roleArray = opUserVo.getRoleArray();
            Set<OpRole> roles = new HashSet<OpRole>();
            Set<String> roleNameList = new HashSet<>();
            boolean flag=false;
            if (roleArray != null && roleArray.length != 0) {
                for (Long roleId : roleArray) {
                    OpRole opRole=opRoleManager.get(roleId);
                    roles.add(opRole);
                    roleNameList.add(opRole.getRoleName());
                }
            }
            user.setRoles(roles);
            user.setName(cleaner.getName());
            if(CheckUtil.checkListIsNull(roleNameList)){
                cleaner.setPosition(StringUtils.join(roleNameList,","));
            }
            for (OpRole opRole:roles){
                if(opRole.getRoleName().equals(Constants.CLEANER_POSITION_PRODUCTMANAGER)
                        ||opRole.getRoleName().equals(Constants.CLEANER_POSITION_AREAMANAGER)
                        ||opRole.getRoleName().equals(Constants.CLEANER_POSITION_STEERING)){
                    cleaner.setCleanTypeSn(Constants.CLEANER_CLEANER_BUSINESS);
                    flag=true;
                    break;
                }
            }
            if(flag){
                user = opUserManager.saveOpUserAndEmployee(user, cleaner);
            }else {
                user.setPassword(DMD5.md5Encode(user.getUserName()));
                user=opUserManager.save(user);
            }
            BeanUtils.copyProperties(user, returnOpUserVo);
            ret.setData(returnOpUserVo);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("call saveOpUser() error", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("保存用户失败");
        }
        return ret;
    }

    @Override
    public ReturnObject deleteOpUser(Long userId) {
        logger.info("call deleteOpUser({})", userId);

        ReturnObject<OpUserVO> ret = new ReturnObject<OpUserVO>();
        try {
            opUserManager.removeOpUser(userId);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("删除用户成功");
        } catch (Exception e) {
            logger.error("call deleteOpUser() error", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("删除用户失败");
        }
        return ret;
    }

    /**
     * 修改密码
     *
     * @param opUserVO
     * @return
     */
    @Override
    public ReturnObject<OpUserVO> saveOpUserInfo(OpUserVO opUserVO) {
        logger.info("call saveOpUserInfo({})", JsonUtil.JSON_Bean2String(opUserVO));

        ReturnObject ret = new ReturnObject();
        try {
            OpUser opUser = opUserManager.get(opUserVO.getUserId());
            opUser.setPassword(StringUtil.md5(opUserVO.getNewPassword()));
            opUserManager.save(opUser);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("保存成功");
        } catch (Exception e) {
            logger.error("数据保存失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("保存失败");
        }
        return ret;
    }


    /**
     * 构建树形菜单列表
     *
     * @param list
     * @return
     */
    public List<MenuVO> getMenuTree(List<MenuVO> list) {
        List<MenuVO> menuTree = null;
        if (list != null && list.size() > 0) {
            menuTree = new ArrayList<MenuVO>();
            for (MenuVO menuVO : list) {
                if (menuVO.getParentId() == 0) {
                    List children = getChildrenMenu(list, menuVO);
                    menuVO.setChildren(children);
                    menuTree.add(menuVO);
                }
            }
        }

        return menuTree;
    }

    /**
     * 获取子菜单
     *
     * @param list
     * @param parent
     * @return
     */
    public List<MenuVO> getChildrenMenu(List<MenuVO> list, MenuVO parent) {
        List<MenuVO> a = null;
        if (list != null && list.size() > 0) {
            a = new ArrayList<MenuVO>();
            for (MenuVO menuVO : list) {
                if (menuVO.getParentId() == parent.getMenuId()) {
                    List children = getChildrenMenu(list, menuVO);
                    menuVO.setChildren(children);
                    a.add(menuVO);
                }
            }
        }
        return a;
    }

    /**
     * 获取权限菜单
     *
     * @param authList
     * @param menuVOList
     * @return
     */
    public List<MenuVO> getAuthMenu(List<Auth> authList, List<MenuVO> menuVOList) {

        List<Long> ids = new ArrayList<Long>();
        for (Auth auth : authList) {
            if (Constants.AUTHTYPE_MENU.equals(auth.getAuthType())) {
                if (auth.getAuthValue() != null) {
                    String[] values = auth.getAuthValue().split(",");
                    for (String value : values) {
                        ids.add(Long.valueOf(value));
                    }
                }
            }
        }

        List<MenuVO> list = new ArrayList<MenuVO>();
        ;
        if (ids != null && ids.size() > 0) {
            for (Long id : ids) {
                for (MenuVO menuVO : menuVOList) {
                    if (id.equals(menuVO.getMenuId())) {
                        if (!list.contains(menuVO)) {
                            list.add(menuVO);
                        }
                    }
                }
            }
        }

        return getMenuTree(list);
    }


}
