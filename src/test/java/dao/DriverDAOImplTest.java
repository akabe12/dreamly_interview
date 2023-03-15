package test.java.dao;

import junit.framework.TestCase;
import main.java.service_system.common.hibernate.dao.DriverDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests database queries for the "driver" table using an in-memory H2 database.
 *
 * Created by skeane on 3/3/2023.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "../../resources/test-context.xml")
public class DriverDAOImplTest extends TestCase {

    @Autowired
    private DriverDAO driverDAO;

    @Before
    public void init() {

    }

    @Test
    public void testFindByCompanyId() {

    }

    @Test
    public void deleteById() {

    }

    @Test
    public void update() {

    }
}
