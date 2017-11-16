package com.huazhu.hvip.company.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.company.dao.ProgramDao;
import com.huazhu.hvip.company.model.Program;
import org.springframework.stereotype.Repository;

/**
 * @author cmy
 * @create 2017-10-31 16:38
 **/
@Repository("programDao")
public class ProgramDaoHibernate extends GenericDaoHibernate<Program,Long> implements ProgramDao {
    public ProgramDaoHibernate() {
        super(Program.class);
    }
}
