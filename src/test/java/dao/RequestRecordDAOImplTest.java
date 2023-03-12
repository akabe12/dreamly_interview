package test.java.dao;

import junit.framework.TestCase;
import main.java.service_system.common.hibernate.RequestRecord;
import main.java.service_system.common.hibernate.dao.RequestRecordDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit testing the Request Record database queries.
 *
 * Created by skeane on 3/3/2023.
 */
public class RequestRecordDAOImplTest extends TestCase {

    @Mock
    private RequestRecordDAO requestRecordDAO;

    @Before
    private void init() {
        MockitoAnnotations.initMocks(this);

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

        requestRecordDAO.getUserRecords();

    }

    @Test
    public void testGetCompanyRecords() {
        int companyId = 678;

        requestRecordDAO.getCompanyRecords();
    }

    @Test
    public void testRemoveUser() {
        int userId = 15;



        requestRecordDAO.removeUser(userId);



    }

    @Test
    public void testRemoveCompany() {
        int companyId = 333;

        requestRecordDAO.removeCompany();



    }

    /**
     * Generate a request record object to save in the mocked database.
     *
     * @return
     */
    private RequestRecord createRecord() {

    }

}
