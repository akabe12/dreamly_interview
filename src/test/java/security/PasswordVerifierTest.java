package test.java.security;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import main.java.mock_frontend.code_bits.PasswordVerifier;
import main.java.service_system.common.hibernate.dao.UserDAO;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for the methods in the PasswordVerifier class.
 *
 * Created by skeane on 3/8/2023.
 */
@RunWith()
public class PasswordVerifierTest extends TestCase {

    private PasswordVerifier passwordVerifier;

    /**
     * Database queries required for the test case.
     */
    private UserDAO userDAO;

    @Before
    public void setup() {
        userDAO = mock(UserDAO.class);
    }

    /**
     * Examines a success and a failure.
     */
    @Test
    public void testVerifyUser() {
        when(userDAO.getPassword()).thenReturn();

        boolean verified = passwordVerifier.verifyUser();
        assertTrue(verified);

        boolean failed = passwordVerifier.verifyUser();
        assertFalse(failed);
    }

    /**
     * Examines a success and a failure.
     */
    @Test
    public void testHashString() {
        byte[] success = passwordVerifier.hashString("Dr3@m1y");
        System.out.println(success);

        byte[] failed = passwordVerifier.hashString("");
        assertArrayEquals(new byte[0], failed);
    }
}
