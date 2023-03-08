package security;

import org.junit.Before;
import org.junit.Test;
import service_system.account.security.PasswordVerifier;

/**
 * Test class for the methods in the PasswordVerifier class.
 *
 * Created by skeane on 3/8/2023.
 */
public class PasswordVerifierTest {

    // TODO: Need to stand up a mock User table with mockito.

    private PasswordVerifier passwordVerifier;

    @Before
    public void setup() {

    }

    /**
     * Examines a failure and a success.
     */
    @Test
    public void testVerifyUser() {
        passwordVerifier.verifyUser();
    }

    /**
     * Examines a success and a failure.
     */
    @Test
    public void testHashString() {
        passwordVerifier.hashString();
    }
}
