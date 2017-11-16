package com.huazhu.hvip.company.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.company.dao.ProgramDao;
import com.huazhu.hvip.company.manager.ProgramManager;
import com.huazhu.hvip.company.model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmy
 * @create 2017-10-31 16:33
 **/
@Service("programManager")
public class ProgramManagerImpl extends GenericManagerImpl<Program,Long> implements ProgramManager {

    private ProgramDao programDao;

    @Autowired
    public ProgramManagerImpl(ProgramDao programDao) {
        super(programDao);
        this.programDao = programDao;
    }
}
