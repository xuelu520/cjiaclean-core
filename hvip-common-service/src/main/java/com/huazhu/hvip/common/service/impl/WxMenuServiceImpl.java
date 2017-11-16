package com.huazhu.hvip.common.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.manager.WxMenuManager;
import com.huazhu.hvip.common.model.WxMenu;
import com.huazhu.hvip.common.service.WxMenuService;
import com.huazhu.hvip.common.vo.WxMenuVO;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cmy
 * @create 2017-08-03 10:42
 **/
@Service("wxMenuService")
public class WxMenuServiceImpl implements WxMenuService {

    private static Logger logger = LogManager.getLogger(WxMenuServiceImpl.class);

    @Autowired
    private WxMenuManager wxMenuManager;

    /**
     * 查询所有微信目录
     *
     * @return
     */
    @Override
    public ReturnObject getWxMenuList() {
        ReturnObject returnObject = new ReturnObject();
        List<WxMenuVO> wxMenuVOList = new ArrayList<>();
        Map<Long, List<WxMenuVO>> listHashMap = new HashMap<>();
        List<WxMenuVO> wxMenuVOs = new ArrayList<>();
        try {
            List<WxMenu> wxMenuList = wxMenuManager.getAll();
            if (wxMenuList != null && wxMenuList.size() > 0) {
                for (WxMenu wxMenu : wxMenuList) {
                    wxMenuVOs = listHashMap.get(wxMenu.getParentId());
                    if (wxMenuVOs != null && wxMenuVOs.size() > 0) {
                        WxMenuVO wxMenuVO = new WxMenuVO();
                        CopyBeanUtil.copyPropertiesIgnoreNull(wxMenu, wxMenuVO);
                        wxMenuVOs.add(wxMenuVO);
                        listHashMap.put(wxMenu.getParentId(), wxMenuVOs);
                    } else {
                        wxMenuVOs = new ArrayList<>();
                        WxMenuVO wxMenuVO = new WxMenuVO();
                        CopyBeanUtil.copyPropertiesIgnoreNull(wxMenu, wxMenuVO);
                        wxMenuVOs.add(wxMenuVO);
                        listHashMap.put(wxMenu.getParentId(), wxMenuVOs);
                    }
                }
            }
            if (listHashMap.size() > 0) {
                for (Map.Entry<Long, List<WxMenuVO>> entry : listHashMap.entrySet()) {
                    if (entry.getKey() == 0L) {
                        List<WxMenuVO> wxMenusVos = entry.getValue();
                        for (WxMenuVO wxMenuVO : wxMenusVos) {
                            wxMenuVOList.add(wxMenuVO);
                        }
                    }
                }
                for (WxMenuVO wxMenuVO : wxMenuVOList) {
                    List<WxMenuVO> wxMenusVos = listHashMap.get(wxMenuVO.getWxMenuId());
                    if (wxMenusVos != null && wxMenusVos.size() > 0) {
                        wxMenuVO.setChildren(wxMenusVos);
                    }
                }
            }
            returnObject.setDataList(wxMenuVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("call getWxMenuList error()", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询失败");
        }
        return returnObject;
    }


    /**
     * 查询所有上级分类
     *
     * @return
     */
    @Override
    public ReturnObject addMenuListJson(Long id) {
        logger.info(" call addMenuListJson({})", id);
        ReturnObject returnObject = new ReturnObject();
        try {
            QueryModel queryModel = new QueryModel();
            List<WxMenuVO> wxMenuVOList = new ArrayList<>();
            queryModel.addColumnValueCondition("parentId", id);
            List<WxMenu> wxMenuList = wxMenuManager.search(queryModel);
            if (wxMenuList != null && wxMenuList.size() > 0) {
                for (WxMenu wxMenu : wxMenuList) {
                    WxMenuVO wxMenuVO = new WxMenuVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(wxMenu, wxMenuVO);
                    wxMenuVOList.add(wxMenuVO);
                }
            }
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setDataList(wxMenuVOList);
        } catch (Exception e) {
            logger.error(" call addMenuListJson error({})", e);
        }
        return returnObject;
    }


    /**
     * 新增菜单
     *
     * @param wxMenuVO
     * @return
     */
    @Override
    public ReturnObject saveWxMenuVO(WxMenuVO wxMenuVO) {
        logger.info(" call addMenuListJson({})", JsonUtil.JSON_Bean2String(wxMenuVO));
        ReturnObject returnObject = new ReturnObject();
        try {
            WxMenu wxMenu = new WxMenu();
            if (wxMenuVO != null && wxMenuVO.getWxMenuId() != null) {
                wxMenu = wxMenuManager.get(wxMenuVO.getWxMenuId());
                CopyBeanUtil.copyPropertiesIgnoreNull(wxMenuVO, wxMenu);
            } else {
                wxMenu = new WxMenu();
                CopyBeanUtil.copyPropertiesIgnoreNull(wxMenuVO, wxMenu);
            }
            wxMenu = wxMenuManager.save(wxMenu);
            CopyBeanUtil.copyPropertiesIgnoreNull(wxMenu, wxMenuVO);
            returnObject.setData(wxMenuVO);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("call addMenuListJson({}) error", e);
        }
        return returnObject;
    }


    /**
     * 根据id查询信息
     *
     * @param id
     * @return
     */
    @Override
    public ReturnObject searchMenuById(Long id) {
        logger.info(" call searchMenuById({})", id);
        ReturnObject returnObject = new ReturnObject();
        try {
            WxMenu wxMenu = wxMenuManager.get(id);
            WxMenuVO wxMenuVO = new WxMenuVO();
            CopyBeanUtil.copyPropertiesIgnoreNull(wxMenu, wxMenuVO);
            returnObject.setData(wxMenuVO);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("call searchMenuById error()", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }
}
