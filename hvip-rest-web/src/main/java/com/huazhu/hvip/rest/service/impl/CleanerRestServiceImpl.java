package com.huazhu.hvip.rest.service.impl;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONObject;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.rest.ReturnObjectForRest;
import com.huazhu.hvip.redis.RedisTemplate;
import com.huazhu.hvip.rest.service.CleanerRestService;
import com.huazhu.hvip.rest.vo.CleanerVOForApp;
import com.huazhu.hvip.user.request.LoginUserVO;
import com.huazhu.hvip.user.service.CleanerService;
import com.huazhu.hvip.user.vo.CleanerVO;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @author cmy
 * @create 2017-10-17 9:25
 **/
@Path("api/cleaner")
@Service
public class CleanerRestServiceImpl implements CleanerRestService {
    private static Logger logger = LogManager.getLogger(CleanerRestServiceImpl.class);

    @Autowired
    private CleanerService cleanerService;

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 根据酒店id返回商品信息
     *
     * @param paramJson
     * @return
     */
    @POST
    @Path("login")
    @Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
    /*@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})*/
    @Override
    public String cleanerLogin(String paramJson, @Context HttpServletRequest req) {
        logger.info("call cleanerLogin({},ip:{})", paramJson, req.getRemoteAddr());
        ReturnObjectForRest<CleanerVOForApp> ret = new ReturnObjectForRest<>();
        try {
            if (StringUtils.isBlank(paramJson)) {
                ret.setCode(Constants.RETURN_CODE_PARAMFAIL);
                ret.setMessage("参数request为空");
                return JsonUtil.JSON_Bean2String(ret);
            }
            CleanerVO cleanerVO=JSONObject.parseObject(paramJson, CleanerVO.class);
            if(StringUtils.isBlank(cleanerVO.getMobile())){
                ret.setCode(Constants.RETURN_CODE_PARAMFAIL);
                ret.setMessage("号码为空");
                return JsonUtil.JSON_Bean2String(ret);
            }
            if(StringUtils.isBlank(cleanerVO.getPassword())){
                ret.setCode(Constants.RETURN_CODE_PARAMFAIL);
                ret.setMessage("密码为空");
                return JsonUtil.JSON_Bean2String(ret);
            }
            LoginUserVO loginUserVO =new LoginUserVO();
            loginUserVO.setUserName(cleanerVO.getMobile());
            loginUserVO.setPassword(cleanerVO.getPassword());
            ReturnObject returnObject=cleanerService.loginForOpUser(loginUserVO);
            if(!Constants.RETURN_CODE_SUCCESS.equals(returnObject.getReturnCode())){
                ret.setCode(Constants.RETURN_CODE_ERROR);
                ret.setMessage("系统异常");
                return JsonUtil.JSON_Bean2String(ret);
            }
            cleanerVO= (CleanerVO) returnObject.getData();
            CleanerVOForApp cleanerVOForApp=new CleanerVOForApp();
            CopyBeanUtil.copyPropertiesIgnoreNull(cleanerVO,cleanerVOForApp);
            if(cleanerVO.getRealWorkTime()!=null){
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                cleanerVOForApp.setRealWorkTime(simpleDateFormat.format(cleanerVO.getRealWorkTime()));
            }
            String redisKey=UUID.randomUUID().toString();
            try {
                redisTemplate.set(Constants.REDIS_CJCLEAN_CLEAN + redisKey, JSONObject.toJSONString(cleanerVOForApp), 86400000);
            } catch (Exception e) {
                logger.error(" call cleanerLogin error()",e);
                ret.setCode(Constants.RETURN_CODE_ERROR);
                return JsonUtil.JSON_Bean2String(ret);
            }
            ret.setCode(Constants.RETURN_CODE_SUCCESS);
            ret.setData(cleanerVOForApp);
            ret.setToken(redisKey);
        } catch (Exception e) {
            ret.setCode(Constants.RETURN_CODE_ERROR);
            ret.setMessage("系统异常");
            return JsonUtil.JSON_Bean2String(ret);
        }
        return JsonUtil.JSON_Bean2String(ret);
    }
}
