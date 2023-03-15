package test.java.dao;

import junit.framework.TestCase;
import main.java.service_system.common.hibernate.dao.RequestDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests database queries for the "request" table using an in-memory H2 database.
 *
 * Created by skeane on 3/3/2023.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "../../resources/test-context.xml")
public class RequestDAOImplTest extends TestCase {

    @Autowired
    private RequestDAO requestDAO;

    @Before
    public void init() {

    }

    @Test
    public void testFindByUserId() {

    }

    @Test
    public void testDeleteByUserId() {

    }

    @Test
    public void testGetStatus() {

    }

    @Test
    public void testGetOpenRequests(){

    }
}
