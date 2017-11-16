package com.huazhu.hvip.company.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.company.qo.ProgramQO;
import com.huazhu.hvip.company.vo.ProgramVO;

/**
 * @author cmy
 * @create 2017-10-31 16:28
 **/
public interface ProgramService  {

    /**
     * 项目页面查询
     * @param programQO
     * @return
     */
    ReturnObject programlistJson(ProgramQO programQO);

    /**
     * 保存修改项目
     * @param programVO
     * @return
     */
    ReturnObject saveProgramVO(ProgramVO programVO);

    /**
     * 根据id查询项目
     *
     * @param id
     * @return
     */
    ReturnObject getProgramById(Long id);
}
