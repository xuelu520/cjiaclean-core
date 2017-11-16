package com.huazhu.hvip.user.opUser.manager.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.user.opUser.dao.CleanerDao;
import com.huazhu.hvip.user.opUser.manager.CleanerManager;
import com.huazhu.hvip.user.opUser.model.Cleaner;
import com.huazhu.hvip.util.CheckUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cmy
 * @create 2017-08-08 16:27
 **/
@Service("cleanerManager")
public class CleanerManagerImpl extends GenericManagerImpl<Cleaner, Long> implements CleanerManager {
    private CleanerDao cleanerDao;

    @Autowired
    public CleanerManagerImpl(CleanerDao cleanerDao) {
        super(cleanerDao);
        this.cleanerDao = cleanerDao;
    }


    /**
     * 登录
     *
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject<Cleaner> loginForOpUser(ParamObject paramObject) {
        ReturnObject ret = new ReturnObject();
        String mobile = (String) paramObject.getParam("mobile");
        String password = (String) paramObject.getParam("password");

        try {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("mobile", mobile);
            List<Cleaner> cleanerList = cleanerDao.search(queryModel);
            if (CheckUtil.checkListIsNull(cleanerList)) {
                Cleaner cleaner = cleanerList.get(0);
                if (StringUtils.isBlank(password)
                        || StringUtils.isBlank(cleaner.getPassword())
                        || !password.equals(cleaner.getPassword())) {
                    ret.setReturnMsg("用户名或密码错误");
                    ret.setReturnCode(Constants.RETURN_CODE_PASSWORDERROR);
                } else {
                    ret.setData(cleaner);
                    ret.setReturnMsg("登录成功");
                    ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                }
            }
        } catch (Exception e) {
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("用户名或密码错误");
        }

        return ret;
    }
}
