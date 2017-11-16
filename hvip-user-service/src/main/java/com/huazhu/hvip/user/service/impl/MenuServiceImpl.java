package com.huazhu.hvip.user.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.user.opUser.manager.AuthManager;
import com.huazhu.hvip.user.opUser.manager.MenuManager;
import com.huazhu.hvip.user.opUser.model.Auth;
import com.huazhu.hvip.user.opUser.model.Menu;
import com.huazhu.hvip.user.service.MenuService;
import com.huazhu.hvip.user.vo.MenuVO;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author cmy
 * @create 2017-07-24 10:49
 **/
@Service
public class MenuServiceImpl implements MenuService {
    private static Logger logger = LogManager.getLogger(AuthServiceImpl.class);
    @Autowired
    private MenuManager menuManager;
    @Autowired
    private AuthManager authManager;
    @Override
    public ReturnObject<com.huazhu.hvip.user.vo.MenuVO> searchMenuList() {
        logger.info("call searchMenuList()");
        ReturnObject<MenuVO> ret = new ReturnObject<MenuVO>();

        try {
            ParamObject para = new ParamObject();
            List<Menu> list = menuManager.searchMenuList(para);
            List<MenuVO> voList = null;
            if (list != null && list.size() > 0) {
                voList = new ArrayList<MenuVO>();
                MenuVO menuVO = null;
                for (Menu menu : list) {
                    menuVO = new MenuVO();
                    BeanUtils.copyProperties(menu, menuVO);
                    voList.add(menuVO);
                }
            }
            ret.setDataList(voList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("call searchMenuList() error", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }
        return ret;
    }

    @Override
    public ReturnObject searchMenuTree(Long authId) {
        logger.info("call searchMenuTree({})", authId);
        ReturnObject ret = new ReturnObject();

        StringBuffer data = new StringBuffer();
        data.append("[");
        try {
            ReturnObject<MenuVO> menuVOReturnObject = searchMenuList();
            if (Constants.RETURN_CODE_SUCCESS.equals(menuVOReturnObject.getReturnCode())) {
                List<MenuVO> menuVOList = menuVOReturnObject.getDataList();
                Map<Long, List<MenuVO>> menuMap = new TreeMap<Long, List<MenuVO>>();
                Map<Long, List<MenuVO>> topMenuMap = new TreeMap<Long, List<MenuVO>>();
                if (menuVOList != null && menuVOList.size() != 0) {
                    for (MenuVO menuVO : menuVOList) {
                        List<MenuVO> tempMenuVO = null;
                        if (menuMap.containsKey(menuVO.getParentId())) {
                            tempMenuVO = menuMap.get(menuVO.getParentId());
                        } else {
                            tempMenuVO = new ArrayList<MenuVO>();
                        }
                        tempMenuVO.add(menuVO);
                        menuMap.put(menuVO.getParentId(), tempMenuVO);
                        if ((new Long(0L)).equals(menuVO.getParentId())) {
                            topMenuMap.put(menuVO.getParentId(), tempMenuVO);
                        }
                    }
                }

                List<String> menuIdList = null;
                if (authId > 0) {
                    Auth auth = authManager.get(authId);
                    if (auth.getAuthValue() != null) {
                        menuIdList = Arrays.asList(auth.getAuthValue().split(","));
                    }
                }

                Iterator it = topMenuMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    List<MenuVO> childMenuVOList = (List<MenuVO>) entry.getValue();
                    for (int i = 0; i < childMenuVOList.size(); i++) {
                        MenuVO childMenuVO = childMenuVOList.get(i);
                        data.append(menutoJson(childMenuVO, menuIdList, menuMap));
                        if (i != childMenuVOList.size() - 1) {
                            data.append(",");
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("查询树形菜单失败", e);
        }
        data.append("]");
        ret.setData(data.toString());
        return ret;
    }

    @Override
    public ReturnObject<com.huazhu.hvip.user.vo.MenuVO> getMenuTree(Long menuId) {
        logger.info("call getMenuTree({})", menuId);

        ReturnObject<MenuVO> ret = new ReturnObject<>();

        try {
            ParamObject paramObject = new ParamObject();
            paramObject.add("deleteFlag", Constants.DELETE_FLAG_FALSE);//0未删除，1已删除
            List<Menu> menuList = menuManager.searchMenuList(paramObject);
            List<MenuVO> topMenuList = new ArrayList<MenuVO>();
            topMenuList = CopyBeanUtil.copyList(menuList, MenuVO.class);
            List<MenuVO> mv = new ArrayList<>();

            for (MenuVO menu : topMenuList) {
                if (menu.getParentId().compareTo(menuId) == 0) {
                    List<MenuVO> children = this.getChildren(topMenuList, menu.getMenuId());
                    menu.setChildren(children);
                    menu.setState("closed");//菜单是否展开
                    mv.add(menu);
                }
            }
            ret.setDataList(mv);
        } catch (Exception e) {
            logger.error("call getMenuTree() error", e);
        }
        return ret;
    }

    @Override
    public ReturnObject<com.huazhu.hvip.user.vo.MenuVO> saveMenu(com.huazhu.hvip.user.vo.MenuVO menuVO) {
        logger.info("call saveMenu({})", JsonUtil.JSON_Bean2String(menuVO));
        ReturnObject<MenuVO> ret = new ReturnObject<MenuVO>();
        try {
            if (menuVO.getMenuName() == null)
                throw new IllegalArgumentException("menuName argument is null");
            if (menuVO.getParentId() == null)
                throw new IllegalArgumentException("parentId argument is null");
            if (menuVO.getUrl() == null)
                throw new IllegalArgumentException("url argument is null");
            if (menuVO.getSort() == null)
                throw new IllegalArgumentException("sort argument is null");

            menuVO.setDeleteFlag(Constants.DELETE_FLAG_FALSE);//设置默认删除状态未删除0已删除1

            Menu menu = new Menu();
            CopyBeanUtil.copyPropertiesIgnoreNull(menuVO, menu);
            menu = menuManager.save(menu);
            MenuVO menuVO1 = new MenuVO();
            menuVO1.setMenuId(menu.getMenuId());

            ret.setData(menuVO1);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("保存成功");
        } catch (Exception e) {
            logger.error("call saveMenu() error", e);
            ret.setReturnMsg("保存失败");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

    @Override
    public ReturnObject<com.huazhu.hvip.user.vo.MenuVO> getMenuById(Long id) {
        logger.info("call getMenuById({})", id);
        ReturnObject<MenuVO> ret = new ReturnObject<MenuVO>();
        try {
            MenuVO menuVO = new MenuVO();
            Menu menu = menuManager.get(id);
            BeanUtils.copyProperties(menu, menuVO);

            ret.setData(menuVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("call getMenuById() error", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询菜单信息失败");
        }
        return ret;
    }

    @Override
    public ReturnObject<com.huazhu.hvip.user.vo.MenuVO> deleteMenu(Long id) {
        logger.info("call deleteMenu({})", id);
        ReturnObject<MenuVO> returnObject = new ReturnObject<MenuVO>();
        try {

            Menu menu = menuManager.get(id);
            menu.setDeleteFlag(Constants.DELETE_FLAG_TRUE);//删除状态为已删除
            menuManager.save(menu);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("删除成功");
        } catch (Exception e) {
            logger.error("call deleteMenu() error", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("删除菜单信息失败");
        }
        return returnObject;
    }

    /**
     * 在一个集合中查找子
     *
     * @param menuList 所有菜单集合
     * @param parentId 父id
     * @return 找到的子集合
     */
    private List<MenuVO> getChildren(List<MenuVO> menuList, Long parentId) {
        List<MenuVO> children = new ArrayList<MenuVO>();
        for (MenuVO menu : menuList) {
            if (menu.getParentId().compareTo(parentId) == 0) {
                menu.setChildren(this.getChildren(menuList, menu.getMenuId()));
                children.add(menu);
            }
        }
        return children;
    }
    private String menutoJson(MenuVO menuVO, List<String> menuIdList, Map<Long, List<MenuVO>> menuMap) {
        StringBuffer data = new StringBuffer();
        data.append("{\"id\":" + menuVO.getMenuId() + ", \"text\":\"" + menuVO.getMenuName() + "\"");
        if (menuIdList != null) {
            for (int i = 0; i < menuIdList.size(); i++) {
                if (menuVO.getMenuId().equals(Long.parseLong(menuIdList.get(i)))) {
                    data.append(",\"checked\":true");
                }
            }
        }
        if (menuMap.containsKey(menuVO.getMenuId())) { //如果有子，继续
            data.append(",\"children\":[");
            int i = 0;
            List<MenuVO> menuList = menuMap.get(menuVO.getMenuId());
            for (MenuVO child : menuList) {
                if (i != 0) {
                    data.append(",");
                }
                if (menuIdList != null) {
                    data.append(menutoJson(child, menuIdList, menuMap));
                } else {
                    data.append(menutoJson(child, null, menuMap));
                }
                i++;
            }
            data.append("]");
        }
        data.append("} ");
        return data.toString();
    }
}
