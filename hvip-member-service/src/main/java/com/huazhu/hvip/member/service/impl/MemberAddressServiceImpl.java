/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberAddressServiceImpl.java
 * Author:   lijing
 * Date:     2016-03-21 10:26:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-21 10:26:40> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.member.manager.MemberAddressManager;
import com.huazhu.hvip.member.manager.MemberManager;
import com.huazhu.hvip.member.model.MemberAddress;
import com.huazhu.hvip.member.service.MemberAddressService;
import com.huazhu.hvip.member.vo.MemberAddressVO;
import com.huazhu.hvip.util.CheckUtil;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class MemberAddressServiceImpl implements MemberAddressService {

    private static Logger logger = LogManager.getLogger(MemberServiceImpl.class);

    @Autowired
    private MemberAddressManager memberAddressManager;
    @Autowired
    private MemberManager memberManager;


    /**
     * 保存地址信息
     *
     * @param memberAddressVO
     * @return
     */
    @Override
    public ReturnObject<MemberAddressVO> saveAddress(MemberAddressVO memberAddressVO) {
        logger.info("call saveMember({\"memberInfoVO:\"" + JsonUtil.JSON_Bean2String(memberAddressVO) + "})");
        ReturnObject<MemberAddressVO> returnObject = new ReturnObject<>();
        MemberAddressVO addressVO = null;
        //校验数据
        ReturnObject ret = verifyData(memberAddressVO);
        if (!ret.getReturnCode().equals(Constants.RETURN_CODE_SUCCESS)) {
            returnObject.setReturnCode(ret.getReturnCode());
            returnObject.setReturnMsg(ret.getReturnMsg());
            return returnObject;
        }
        try {
            MemberAddress memberAddress = new MemberAddress();
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("memberId", memberAddressVO.getMemberId());
            List<MemberAddress> memberAddressList = memberAddressManager.search(queryModel);
            for (MemberAddress address : memberAddressList) {//设为不是默认地址
                address.setDefaultFlag(Constants.COMMON_STATUS_1);
            }
            CopyBeanUtil.copyPropertiesIgnoreNull(memberAddressVO, memberAddress);
            memberAddressList.add(memberAddress);
            memberAddressList = memberAddressManager.saveAddress(memberAddressList);
            List<MemberAddressVO> memberAddressVOs = new ArrayList<>();
            if (CheckUtil.checkListIsNull(memberAddressList)) {
                for (MemberAddress address : memberAddressList) {
                    memberAddressVO = new MemberAddressVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(address,memberAddressVO);
                    memberAddressVOs.add(memberAddressVO);
                }
            }
            returnObject.setDataList(memberAddressVOs);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("保存地址信息成功");

        } catch (Exception e) {
            logger.error("保存地址信息失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("保存地址信息失败");
        }

        return returnObject;
    }

    /**
     * 校验数据
     *
     * @param memberInfoVO
     * @return
     */
    private ReturnObject verifyData(MemberAddressVO memberInfoVO) {

        ReturnObject ret = new ReturnObject();

        if (memberInfoVO == null) {
            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
            ret.setReturnMsg("memberInfoVO is null");
        } else if (StringUtils.isBlank(memberInfoVO.getMemberId().toString())) {
            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
            ret.setReturnMsg("memberId is null");
        } else if (StringUtils.isBlank(memberInfoVO.getContactName())) {
            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
            ret.setReturnMsg("name is null");
        } else if (StringUtils.isBlank(memberInfoVO.getMobile())) {
            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
            ret.setReturnMsg("mobile is null");
        } else {
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        }

        return ret;
    }
}
