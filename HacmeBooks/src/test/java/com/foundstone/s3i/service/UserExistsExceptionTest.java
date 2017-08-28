package com.foundstone.s3i.service;

import java.util.ResourceBundle;

import com.foundstone.s3i.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.ObjectRetrievalFailureException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


public class UserExistsExceptionTest extends BaseManagerTestCase {
    private static ApplicationContext ctx = null;
    private UserManager manager = null;
    private ResourceBundle rb;
    
    // This static block ensures that Spring's BeanFactory is only loaded
    // once for all tests
    static {
        // the dao.type is written to the database.properties file
        // in properties.xml
        ResourceBundle db = ResourceBundle.getBundle("database");
        String daoType = db.getString("dao.type");
        String[] paths = {"/WEB-INF/applicationContext-resources.xml",
                          "/WEB-INF/applicationContext-" + daoType + ".xml",
                          "/WEB-INF/applicationContext-service.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
    }
    
    public void setUp() throws Exception {
        manager = (UserManager) ctx.getBean("userManager");

        // delete 'foo' in case it exists
        try {
            manager.removeUser("foo");
        } catch (ObjectRetrievalFailureException fe) {
            // ignore
        }
    }

    @Test
    public void testAddExistingUser() throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("entered 'testAddExistingUser' method");
        }

        User user = manager.getUser("draphael");
        // change unique keys
        user.setUsername("draphael");
        user.setEmail("bar");
        
        // first save should succeed
        //manager.saveUser(user);
        
        // set the version to null - this is the new record indicator
        user.setVersion(null);
        
        // try saving as new user, this should fail
        try {
            manager.saveUser(user);
            fail("Duplicate user didn't throw UserExistsException");
        } catch (UserExistsException uee) {
            assertNotNull(uee);
        }
    }
}
