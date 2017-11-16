package com.huazhu.hvip.user.opUser.dao;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.user.opUser.model.Cleaner;

/**
 * @author cmy
 * @create 2017-08-08 16:30
 **/
public interface CleanerDao extends GenericDao<Cleaner,Long> {
    Cleaner getUserByUserName(String userName);
}
