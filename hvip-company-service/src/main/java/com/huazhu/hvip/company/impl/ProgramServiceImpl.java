package com.huazhu.hvip.company.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.company.manager.ProgramManager;
import com.huazhu.hvip.company.model.Program;
import com.huazhu.hvip.company.qo.ProgramQO;
import com.huazhu.hvip.company.service.ProgramService;
import com.huazhu.hvip.company.vo.ProgramVO;
import com.huazhu.hvip.util.CheckUtil;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cmy
 * @create 2017-10-31 16:29
 **/
@Service("programService")
public class ProgramServiceImpl implements ProgramService {

    private static Logger logger = LogManager.getLogger(ProgramServiceImpl.class);

    @Autowired
    private ProgramManager programManager;

    /**
     * 查询项目列表
     *
     * @param programQO
     * @return
     */
    @Override
    public ReturnObject programlistJson(ProgramQO programQO) {
        logger.info("call programlistJson({" + JsonUtil.JSON_Bean2String(programQO) + "})");
        ReturnObject returnObject = new ReturnObject();
        try {
            QueryModel queryModel = new QueryModel();
            queryModel.setPageNo(programQO.getPageNo());
            queryModel.setPageSize(programQO.getPageSize());
            List<Program> programList = programManager.search(queryModel);
            List<ProgramVO> programVOList = new ArrayList<>();
            if (CheckUtil.checkListIsNull(programList)) {
                for (Program program : programList) {
                    ProgramVO programVO = new ProgramVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(program, programVO);
                    programVOList.add(programVO);
                }
            }
            returnObject.setTotalSize(queryModel.getTotalNum());
            returnObject.setDataList(programVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call programlistJson error()", e);
        }
        return returnObject;
    }


    /**
     * 保存修改项目
     *
     * @param programVO
     * @return
     */
    @Override
    public ReturnObject saveProgramVO(ProgramVO programVO) {
        logger.info("call saveProgramVO({" + JsonUtil.JSON_Bean2String(programVO) + "})");
        ReturnObject returnObject = new ReturnObject();
        try {
            Program program = new Program();
            if (programVO != null) {
                if (programVO.getId() != null) {
                    program = programManager.get(programVO.getId());
                    //todo 暂停逻辑等待订单
                }
                CopyBeanUtil.copyPropertiesIgnoreNull(programVO, program);
                program = programManager.save(program);
                CopyBeanUtil.copyPropertiesIgnoreNull(program, programVO);
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                returnObject.setData(programVO);
            } else {
                returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            }
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call saveProgramVO error({})", e);
        }
        return returnObject;
    }

    /**
     * 根据id查询项目
     *
     * @param id
     * @return
     */
    @Override
    public ReturnObject getProgramById(Long id) {
        logger.info("call getProgramById({" + id + "})");
        ReturnObject returnObject = new ReturnObject();
        try {
            if (id != null) {
                ProgramVO programVO=new ProgramVO();
                Program program=programManager.get(id);
                CopyBeanUtil.copyPropertiesIgnoreNull(program, programVO);
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                returnObject.setData(programVO);
            } else {
                returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            }
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call saveProgramVO error({})", e);
        }
        return returnObject;
    }
}
