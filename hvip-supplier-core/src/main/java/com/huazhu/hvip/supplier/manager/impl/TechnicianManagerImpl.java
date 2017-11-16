/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: TechnicianManagerImpl.java
 * Author:   lijing
 * Date:     2016-05-04 10:00:10
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-05-04 10:00:10> <version>   <desc>
 *
 */

package com.huazhu.hvip.supplier.manager.impl;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.supplier.dao.TechnicianDao;
import com.huazhu.hvip.supplier.manager.TechnicianManager;
import com.huazhu.hvip.supplier.model.Technician;
import org.apache.commons.lang.StringUtils;
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
@Service("technicianManager")
public class TechnicianManagerImpl extends GenericManagerImpl<Technician,Long> implements TechnicianManager{

    private TechnicianDao technicianDao;

    @Autowired
    public TechnicianManagerImpl(TechnicianDao technicianDao){
        super(technicianDao);
        this.technicianDao = technicianDao;
    }

    /**
     * 保存技师信息
     * @param technician
     * @return
     */
    @Override
    public Technician saveTechnician(Technician technician) {

        //技师编号已存在的数据替换ID
        Long technicianId = technician.getTechnicianId();
        if(technicianId!=null){
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("technicianId",technicianId);
            List<Technician> list = technicianDao.searchTechnicianList(queryModel,new ParamObject());
            if(list!=null&&list.size()>0){
                technician.setId(list.get(0).getId());
            }
        }
        return technicianDao.save(technician);
    }

    /**
     * 批量保存技师信息
     * @param list
     * @return
     */
    @Override
    public List<Technician> saveTechnicians(List<Technician> list) {

        List<Technician> retList = new ArrayList<Technician>();
        List<Technician> list1 = null;
        for(Technician technician : list){
            //技师编号已存在的数据替换ID
            Long technicianId = technician.getTechnicianId();
            if(technicianId!=null){
                QueryModel queryModel = new QueryModel();
                queryModel.addColumnValueCondition("technicianId",technicianId);
                list1 = technicianDao.searchTechnicianList(queryModel,new ParamObject());
                if(list1!=null&&list1.size()>0){
                    technician.setId(list1.get(0).getId());
                }
            }
            technician = technicianDao.save(technician);
            retList.add(technician);
        }
        return retList;
    }

    /**
     * 查询技师列表
     * @param param
     * @return
     */
    @Override
    public List<Technician> searchTechnicianList(ParamObject param) {

        List<Technician> list = null;

        List<Long> technicianIds = (List<Long>) param.getParam("technicianIds");
        QueryModel queryModel = new QueryModel();

        if(technicianIds!=null&&technicianIds.size()>0){
            String str = StringUtils.join(technicianIds,",");
            queryModel.addColumnValueCondition("t.technicianId",QueryModel.OPERATOR_IN,"("+str+")");
        }

        list = technicianDao.searchTechnicianList(queryModel,param);

        return list;
    }
}
