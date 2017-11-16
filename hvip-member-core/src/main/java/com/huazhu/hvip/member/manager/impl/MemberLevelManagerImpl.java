/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberLevelManagerImpl.java
 * Author:   lijing
 * Date:     2016-03-20 14:32:47
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 14:32:47> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.manager.impl;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.member.dao.MemberLevelDao;
import com.huazhu.hvip.member.manager.MemberLevelManager;
import com.huazhu.hvip.member.model.MemberLevel;
import com.huazhu.hvip.member.vo.MemberLevelVO;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import com.huazhu.hvip.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("memberLevelManager")
public class MemberLevelManagerImpl extends GenericManagerImpl<MemberLevel,Long> implements MemberLevelManager {

    private static Logger logger = LogManager.getLogger(MemberManagerImpl.class);
    MemberLevelDao memberLevelDao;

    @Autowired
    public MemberLevelManagerImpl(MemberLevelDao memberLevelDao){
        super(memberLevelDao);
        this.memberLevelDao = memberLevelDao;
    }

    /**
     * op根据条件查询等级信息
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<MemberLevelVO> searchMemberListForOp(ParamObject paramObject) {
        logger.info("call searchOrderList({\"paramObject:\"" + JsonUtil.JSON_Bean2String(paramObject) + "})");

        Integer pageSize = (Integer) paramObject.getPageSize();

        Integer pageNo = (Integer) paramObject.getPageNo();

        String orderBy = paramObject.getStringParam("orderBy"); //排序

        String keyword = paramObject.getStringParam("keyword");//模糊查询关键字

        QueryModel queryModel = new QueryModel();

        queryModel.setPageNo(pageNo);

        queryModel.setPageSize(pageSize);

        if (StringUtils.isNotBlank(orderBy)) {
            queryModel.setSortHql(orderBy);
        } else {
            //queryModel.setSortHql(" createTime DESC ");
        }

        if(!StringUtil.isEmpty(keyword)){
            queryModel.addHqlCondition(" (levelName like '%"+keyword+"%') ");
        }

        List<MemberLevel> memberLevelList = memberLevelDao.search(queryModel);
        paramObject.setTotalNum(queryModel.getTotalNum());
        List<MemberLevelVO> memberLevelVOList = new ArrayList<>();

        for (MemberLevel memberLevel : memberLevelList) {
            MemberLevelVO memberLevelVO = new MemberLevelVO();
            CopyBeanUtil.copyPropertiesIgnoreNull(memberLevel,memberLevelVO);
            memberLevelVOList.add(memberLevelVO);
        }


        return memberLevelVOList;
    }


    /**
     * 保存或修改会员信息
     *
     * @param memberLevelVO
     * @return
     */
    @Override
    public MemberLevelVO saveOrUpdateMember(MemberLevelVO memberLevelVO) {
        logger.info("call saveOrUpdateMember({\"memberLevelVO:\"" + JsonUtil.JSON_Bean2String(memberLevelVO) + "})");

        MemberLevel memberLevel = new MemberLevel();

        CopyBeanUtil.copyPropertiesIgnoreNull(memberLevelVO,memberLevel);

        //保存会员信息
        memberLevel = memberLevelDao.save(memberLevel);
        CopyBeanUtil.copyPropertiesIgnoreNull(memberLevel,memberLevelVO);

        return memberLevelVO;
    }
}
