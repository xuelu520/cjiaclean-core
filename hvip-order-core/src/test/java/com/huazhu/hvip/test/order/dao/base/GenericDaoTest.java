package com.huazhu.hvip.test.order.dao.base;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class GenericDaoTest extends BaseDaoTestCase {
    Log log = LogFactory.getLog(GenericDaoTest.class);
    //GenericDao<OpUser, Long> genericDao;
    @Autowired
    SessionFactory sessionFactory;

//    @Before
//    public void setUp() {
//        genericDao = new GenericDaoHibernate<OpUser, Long>(OpUser.class, sessionFactory);
//    }
//
//    @Test
//    public void getUser() {
//        OpUser user = genericDao.get(-1L);
//        assertNotNull(user);
//        assertEquals("user", user.getUsername());
//    }
}
