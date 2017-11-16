/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberAddressManagerImpl.java
 * Author:   lijing
 * Date:     2016-03-20 14:29:25
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 14:29:25> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.member.dao.MemberAddressDao;
import com.huazhu.hvip.member.manager.MemberAddressManager;
import com.huazhu.hvip.member.model.MemberAddress;
import com.huazhu.hvip.util.CheckUtil;
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
@Service("memberAddressManager")
public class MemberAddressManagerImpl extends GenericManagerImpl<MemberAddress,Long> implements MemberAddressManager {

    MemberAddressDao memberAddressDao;

    @Autowired
    public MemberAddressManagerImpl(MemberAddressDao memberAddressDao){
        super(memberAddressDao);
        this.memberAddressDao = memberAddressDao;
    }
    /**
     * 保存会员地址
     * @param memberAddressList
     * @return
     */
    @Transactional
    @Override
    public List<MemberAddress> saveAddress(List<MemberAddress> memberAddressList) {
        List<MemberAddress> memberAddresses=new ArrayList<>();
        if(CheckUtil.checkListIsNull(memberAddressList)){
            for(MemberAddress memberAddress:memberAddressList){
                memberAddresses.add(memberAddressDao.save(memberAddress));
            }
        }
        return memberAddresses;
    }
}
