package com.huazhu.hvip.operation.manager.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.operation.dao.HotelControlPriceDao;
import com.huazhu.hvip.operation.dao.HotelControlPriceItemDao;
import com.huazhu.hvip.operation.dao.HotelOperateDao;
import com.huazhu.hvip.operation.manager.HotelOperateManager;
import com.huazhu.hvip.operation.model.HotelControlPrice;
import com.huazhu.hvip.operation.model.HotelControlPriceItem;
import com.huazhu.hvip.operation.model.extend.HotelControlPriceItemExt;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by cmy on 2016/6/14.
 */
@Service("HotelOperateManager")
public class HotelOperateManagerImpl extends GenericManagerImpl<HotelControlPrice, Long> implements HotelOperateManager {
    private HotelOperateDao hotelOperateDao;

    @Autowired
    public HotelOperateManagerImpl(HotelOperateDao hotelOperateDao) {
        super(hotelOperateDao);
        this.hotelOperateDao = hotelOperateDao;
    }

    @Autowired
    private HotelControlPriceItemDao hotelControlPriceItemDao;

    @Autowired
    private HotelControlPriceDao hotelControlPriceDao;

    /**
     * 取消申请
     *
     * @param paramObject
     * @return
     */
    @Override
    public void updateHotelControlPriceItemStatus(ParamObject paramObject) {
        String sql = "UPDATE hotelcontrolpriceitem hi set hi.status=" + Constants.HOTELCONTROLPRICEITEM_OPERATE_STATUS_CANCEL + " WHERE hi.itemId=" + paramObject.getLongParam("itemId") + " ";
        List<String> statusList = new ArrayList<>();
        hotelControlPriceItemDao.updateObject(sql);
        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("itemId", paramObject.getLongParam("itemId"));
        List<HotelControlPriceItem> hotelControlPriceItemList = hotelControlPriceItemDao.search(queryModel);
        HotelControlPriceItem hotelControlPriceItem1 = hotelControlPriceItemList.get(0);
        queryModel = new QueryModel();
        queryModel.addColumnValueCondition("ControlPriceId", hotelControlPriceItem1.getControlPriceId());
        List<HotelControlPriceItem> hotelControlPriceItems = hotelControlPriceItemDao.search(queryModel);
        List<HotelControlPrice> hotelControlPrices = hotelControlPriceDao.search(queryModel);
        HotelControlPrice hotelControlPrice = hotelControlPrices.get(0);
        for (HotelControlPriceItem hotelControlPriceItem : hotelControlPriceItems) {
            hotelControlPrice.setStatus(hotelControlPriceItem.getStatus());
            if (!statusList.contains(hotelControlPriceItem.getStatus())) {
                statusList.add(hotelControlPriceItem.getStatus());
            }
        }
        if (statusList.size() > 1) {
            if (statusList.contains(Constants.HOTELCONTROLPRICEITEM_OPERATE_STATUS_REJECT)) {
                hotelControlPrice.setStatus(Constants.HOTELCONTROLPRICE_OPERATE_STATUS_REJECT);
            } else if (statusList.contains(Constants.HOTELCONTROLPRICEITEM_OPERATE_STATUS_PASS)) {
                hotelControlPrice.setStatus(Constants.HOTELCONTROLPRICE_OPERATE_STATUS_SOMEPASS);
            } else if (statusList.contains(Constants.HOTELCONTROLPRICEITEM_OPERATE_STATUS_PASSING) || statusList.contains(Constants.HOTELCONTROLPRICEITEM_OPERATE_STATUS_REJECT)) {
                hotelControlPrice.setStatus(Constants.HOTELCONTROLPRICE_OPERATE_STATUS_PASSING);
            } else {
                hotelControlPrice.setStatus(Constants.HOTELCONTROLPRICE_OPERATE_STATUS_PASSING);
            }
        }
        hotelControlPriceDao.save(hotelControlPrice);
    }

    /**
     * 根据Id查询HotelControlPriceItem
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<HotelControlPriceItem> searchHotelControlPriceItem(ParamObject paramObject) {
        QueryModel queryModel = new QueryModel();
        List<HotelControlPriceItem> hotelControlPriceItems = new ArrayList<>();
        List<String> goodsIds = new ArrayList<>();
        queryModel.addColumnValueCondition("hotelNo", paramObject.getStringParam("hotelNo"));
        queryModel.addColumnValueCondition("controlPriceId", paramObject.getLongParam("controlPriceId"));
        queryModel.addColumnValueCondition("itemId", paramObject.getLongParam("itemId"));
        if (StringUtils.isNotBlank(paramObject.getStringParam("goodsId"))) {
            queryModel.addHqlCondition(" goodsId in (" + paramObject.getStringParam("goodsId") + ")");
        }
        if (StringUtils.isNotBlank(paramObject.getStringParam("status"))) {
            queryModel.addHqlCondition(" status in (" + paramObject.getStringParam("status") + ")");
        }
        queryModel.setSortHql(" createTime desc");
        List<HotelControlPriceItem> hotelControlPriceItemList = hotelControlPriceItemDao.search(queryModel);
        for (HotelControlPriceItem hotelControlPriceItem : hotelControlPriceItemList) {
            if (StringUtils.isNotBlank(paramObject.getStringParam("goodsId"))) {
                if (!goodsIds.contains(hotelControlPriceItem.getGoodsId().toString())) {
                    goodsIds.add(hotelControlPriceItem.getGoodsId().toString());
                    hotelControlPriceItems.add(hotelControlPriceItem);
                }
            } else {
                hotelControlPriceItems.add(hotelControlPriceItem);
            }
        }
        return hotelControlPriceItems;
    }

    /**
     * 保存酒店控制价格
     *
     * @param paramObject
     * @return
     */
    @Override
    public void saveControlitem(ParamObject paramObject) {
        List<String> statusList = new ArrayList<>();
        List<Long> itemList = new ArrayList<>();
        List<HotelControlPriceItem> hotelControlPriceItems = new ArrayList<>();
        List<HotelControlPriceItem> hotelControlPriceItemList = (List<HotelControlPriceItem>) paramObject.getParam("hotelControlPriceItem");
        HotelControlPriceItem hotelControlPriceItem = hotelControlPriceItemList.get(0);
        if (hotelControlPriceItem.getVerifierName() == null) {//HMS使用
            HotelControlPrice hotelControlPrice = new HotelControlPrice();
            for (HotelControlPriceItem hotelControlPriceItem1 : hotelControlPriceItemList) {
                BeanUtils.copyProperties(hotelControlPriceItem1, hotelControlPrice);
            }
            hotelControlPrice.setControlPriceId(null);
            hotelControlPrice.setCreateTime(new Date());
            HotelControlPrice hotelControlPrice1 = hotelControlPriceDao.save(hotelControlPrice);
            for (HotelControlPriceItem hotelControlPriceItem1 : hotelControlPriceItemList) {
                itemList.add(hotelControlPriceItem1.getItemId());
                hotelControlPriceItem1.setItemId(null);
                hotelControlPriceItem1.setControlPriceId(hotelControlPrice1.getControlPriceId());
                hotelControlPriceItemDao.save(hotelControlPriceItem1);
            }
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("hotelNo", hotelControlPriceItem.getHotelNo());
            List<HotelControlPriceItem> hotelControlPriceItemList1 = hotelControlPriceItemDao.search(queryModel);
            for (HotelControlPriceItem hotelControlPriceItem1 : hotelControlPriceItemList1) {
                if (hotelControlPriceItem1.getStatus().equals(Constants.HOTELCONTROLPRICEITEM_OPERATE_STATUS_BACK)) {
                    hotelControlPriceItem1.setStatus(Constants.HOTELCONTROLPRICEITEM_OPERATE_STATUS_BACKREJECT);
                    hotelControlPriceItemDao.save(hotelControlPriceItem1);
                }
            }
        } else {//OP使用
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("controlPriceId", hotelControlPriceItem.getControlPriceId());
            List<HotelControlPrice> hotelControlPriceList = hotelControlPriceDao.search(queryModel);
            for (HotelControlPriceItem hotelControlPriceItem1 : hotelControlPriceItemList) {
                hotelControlPriceItemDao.save(hotelControlPriceItem1);
            }
            List<HotelControlPriceItem> hotelControlPriceItems1 = hotelControlPriceItemDao.search(queryModel);
            for (HotelControlPriceItem hotelControlPriceItem1 : hotelControlPriceItems1) {
                if (!statusList.contains(hotelControlPriceItem1.getStatus())) {
                    statusList.add(hotelControlPriceItem1.getStatus());
                }
            }
            if (statusList != null && statusList.size() != 0 && statusList.size() == 1) {
                for (HotelControlPrice hotelControlPrice : hotelControlPriceList) {
                    hotelControlPrice.setVerifierName(hotelControlPriceItem.getVerifierName());
                    hotelControlPrice.setVerificationTime(new Date());
                    for (String status : statusList) {
                        hotelControlPrice.setStatus(status);
                    }
                    hotelControlPriceDao.save(hotelControlPrice);
                }
            } else if (statusList != null && statusList.size() != 0 && statusList.size() > 1) {
                for (HotelControlPrice hotelControlPrice : hotelControlPriceList) {
                    hotelControlPrice.setVerifierName(hotelControlPriceItem.getVerifierName());
                    hotelControlPrice.setVerificationTime(new Date());
                    if (statusList.contains(Constants.HOTELCONTROLPRICEITEM_OPERATE_STATUS_PASS) && !statusList.contains(Constants.HOTELCONTROLPRICEITEM_OPERATE_STATUS_REJECT)) {
                        hotelControlPrice.setStatus(Constants.HOTELCONTROLPRICE_OPERATE_STATUS_SOMEPASS);
                    } else if (statusList.contains(Constants.HOTELCONTROLPRICEITEM_OPERATE_STATUS_PASS) && statusList.contains(Constants.HOTELCONTROLPRICEITEM_OPERATE_STATUS_REJECT)) {
                        hotelControlPrice.setStatus(Constants.HOTELCONTROLPRICE_OPERATE_STATUS_PASSING);
                    } else {
                        hotelControlPrice.setStatus(Constants.HOTELCONTROLPRICE_OPERATE_STATUS_PASSING);
                    }
                    hotelControlPriceDao.save(hotelControlPrice);
                }
            }
        }
    }

    /**
     * 查询控制价格的操作记录
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<HotelControlPrice> searchHotelOperateListByHotelNo(ParamObject paramObject) {
        QueryModel queryModel = new QueryModel();
        String hotelNo = paramObject.getStringParam("hotelNo");
        queryModel.addColumnValueCondition("hotelNo", hotelNo);
        List<HotelControlPrice> hotelControlPriceList = hotelControlPriceDao.search(queryModel);
        return hotelControlPriceList;
    }
}
