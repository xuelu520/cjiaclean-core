/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OpUserService.java
 * Author:   admin
 * Date:     2016-03-10 16:01:24
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-10 16:01:24><version><desc><source>
 */

package com.huazhu.hvip.user.service;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.user.request.LoginUserVO;
import com.huazhu.hvip.user.vo.MenuVO;
import com.huazhu.hvip.user.vo.OpUserVO;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface OpUserService {

    /**
     * 通过用户姓名获取单个后台用户
     *
     * @param paramObject
     * @return
     */
    public ReturnObject<OpUserVO> getUserByUsername(ParamObject paramObject);

    /**
     * 用户后台登陆,参数列表,String username, String password, String verifyCode, boolean preLogin
     *
     * @param paramObject
     * @return
     */
    public ReturnObject<OpUserVO> login(ParamObject paramObject);

    /**
     * 查询所有用户以及对应的员工列表
     *
     * @param pageCondition
     * @return
     */
    public ReturnObject<OpUserVO> searchOpUsers(PageCondition pageCondition);

    /**
     * 获取OP用户可用菜单
     * @param opUserVO
     * @return
     */
    public ReturnObject<MenuVO> getOpUserMenu(OpUserVO opUserVO);


    /**
     * op用户登录
     *
     * @param loginUserVO
     * @return
     */
    ReturnObject<OpUserVO> loginForOpUser(LoginUserVO loginUserVO);

    /**
     * 通过用户ID获取单个后台用户
     *
     * @param paramObject
     * @return
     */
    ReturnObject<OpUserVO> getOpUserDetail(ParamObject paramObject);

    /**
     * 保存用户
     *
     * @param opUserVo
     */
    ReturnObject saveOpUser(OpUserVO opUserVo);

    /**
     * 根据用户id删除用户
     *
     * @param userId
     */
    ReturnObject deleteOpUser(Long userId);


    /**
     * 修改密码
     * @param opUserVO
     * @return
     */
    ReturnObject<OpUserVO> saveOpUserInfo(OpUserVO opUserVO);
}
