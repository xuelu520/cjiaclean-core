/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: DictCodeService.java
 * Author:   admin
 * Date:     2016-03-20 17:28:32
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 17:28:32><version><desc>
 */

package com.huazhu.hvip.common.service;


import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.vo.*;

/**
 * 财务科目
 *
 * @author cqm
 */
public interface FinanceSubjectService {

    /**
     * 获取财务科目列表
     *
     * @return
     */
    ReturnObject<FinanceSubjectVO> searchFinanceSubjectList();

    /**
     * 获取财务科目详情
     *
     * @return
     */
    ReturnObject<FinanceSubjectVO> getFinanceSubjectById(Long subjectId);

}
