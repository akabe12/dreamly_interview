package test.java.dao;

import junit.framework.TestCase;
import main.java.service_system.common.hibernate.dao.CompanyDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests database queries for the "company" table using an in-memory H2 database.
 *
 * Created by skeane on 3/3/2023.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "../../resources/test-context.xml")
public class CompanyDAOImplTest extends TestCase {

    @Autowired
    private CompanyDAO companyDAO;

    @Before
    public void init() {

    }

    @Test
    public void testFindIdByUsername() {

    }

    @Test
    public void testGetPassword() {

    }

    @Test
    public void testSetPassword() {

    }
}
