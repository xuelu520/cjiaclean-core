package com.huazhu.hvip.member.manager;


import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.GenericManager;

public interface CrmManager extends GenericManager<String, Long> {


    /**
     * 授权
     *
     */
    public String auth();

    /**
     * 注册
     * @return
     */
    public ReturnObject<String> regist(String mobile, String password, String name, String mail, String idno);

    /**
     * 登录
     */
    public ReturnObject<String> login(String mobile, String password);

    /**
     * 检查手机是否存在
     */
    public Boolean validateMobile(String mobile);

    /**
     * 更改手机号码
     */
    public ReturnObject<String> changeMobile(String crmId, String mobile);

    /**
     * 会员修改密码
     */
    public ReturnObject<String> changePassword(String crmId, String oldPassword, String newPassword);

    /**
     * 管理员重置会员密码
     */
    public ReturnObject<String> resetPassword(String crmId, String mobile);

    /**
     * 会员的基本信息更新
     */
    public ReturnObject<String> memberInfoUpdate(String crmId, String idNo, String name);

    /**
     * 会员的基本信息更新
     */
    public ReturnObject<String> memberInfoUpdate(String crmId, String idNo, String idType, String gender, String email);

    /**
     * 获取CRM系统的会员信息
     */
    public ReturnObject<String> getMemberInfo(String crmId);

}