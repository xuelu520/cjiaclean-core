package com.huazhu.hvip.user.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.user.qo.CleanerQO;
import com.huazhu.hvip.user.request.LoginUserVO;
import com.huazhu.hvip.user.vo.CleanerVO;

/**
 * @author cmy
 * @create 2017-08-08 16:14
 **/
public interface CleanerService {

    /**
     * 查询保洁员信息
     * @param cleanerQO
     * @return
     */
    ReturnObject<CleanerVO> listJson(CleanerQO cleanerQO);

    /**
     * 保存保洁员
     * @param cleanerVO
     * @return
     */
    ReturnObject<CleanerVO> saveClean(CleanerVO cleanerVO);


    /**
     *根据id查询保洁师
     * @param cleanId
     * @return
     */
    ReturnObject<CleanerVO> searchCleanerById(Long cleanId);

    /**
     * 用户登录
     *
     * @param loginUserVO
     * @return
     */
    ReturnObject<CleanerVO> loginForOpUser(LoginUserVO loginUserVO);
}
