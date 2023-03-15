package test.java.dao;

import junit.framework.TestCase;
import main.java.service_system.common.hibernate.RequestRecord;
import main.java.service_system.common.hibernate.dao.RequestRecordDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests database queries for the "record" table using an in-memory H2 database.
 *
 * Created by skeane on 3/3/2023.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "../../resources/test-context.xml")
public class RequestRecordDAOImplTest extends TestCase {

    @Autowired
    private RequestRecordDAO requestRecordDAO;

    @Before
    private void init() {
        RequestRecord record1 = createRecord();
        RequestRecord record2 = createRecord();
        RequestRecord record3 = createRecord();
        RequestRecord record4 = createRecord();

        requestRecordDAO.save(record1);
        requestRecordDAO.save(record2);
        requestRecordDAO.save(record3);
        requestRecordDAO.save(record4);
    }

    @Test
    public void testGetUserRecords() {
        int userId = 19;

        //requestRecordDAO.getUserRecords();

    }

    @Test
    public void testGetCompanyRecords() {
        int companyId = 678;

        //requestRecordDAO.getCompanyRecords();
    }

    @Test
    public void testRemoveUser() {
        int userId = 15;



        //requestRecordDAO.removeUser(userId);



    }

    @Test
    public void testRemoveCompany() {
        int companyId = 333;

        //requestRecordDAO.removeCompany();



    }

    /**
     * Generate a request record object to save in the mocked database.
     *
     * @return
     */
    private RequestRecord createRecord() {
return null;
    }

}
