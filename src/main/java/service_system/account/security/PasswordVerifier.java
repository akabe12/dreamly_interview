package service_system.account.security;

import service_system.hibernate.dao.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Arrays;

/**
 * Class takes a submitted password and compares it with the user's hashed password stored in the database.
 *
 * The password hashing function that will be used for this application is the PBKDF2 method as it is natively supported
 * by Java and is stronger than the traditional SHA-512 function.
 *
 * Created by skeane on 3/7/2023.
 */
public class PasswordVerifier {

    private static final Logger logger = LoggerFactory.getLogger(PasswordVerifier.class);

    /**
     * Algorithm used to create the hashed password.
     */
    private static final String HASH_ALG = "PBKDF2WithHmacSHA";

    /**
     * Database queries.
     */
    private UserDAO userDAO;

    /**
     * Verify a user's password with what is stored in the database.
     *
     * @param userId    ID of the user.
     * @param inputPass Password entered by the user.
     * @return          Whether the password matched (true - correct password, false - incorrect password).
     */
    public boolean verifyUser(int userId, String inputPass) {
        // Correct hashed password.
        byte[] dbHashPass = userDAO.getPassword(userId);

        // Hashing the inputted password.
        byte[] inputHash = hashString(inputPass);

        return Arrays.equals(dbHashPass, inputHash);
    }

    /**
     * Uses the PBKDF2 method to create a hashed byte array given a provided string.
     *
     * @param input Provided string to be hashed.
     * @return      Byte array, will return an empty array if provided string is empty or null or if an exception occurs.
     */
    public byte[] hashString(String input) {
        if (input == null || input.equals("")) {
            // TODO: Either have this check further upstream so it immediately notifies the user, or have a way back
            //  to the user here so they can change what they entered.

            logger.warn("Provided string {} could not be converted to a hashed byte array.", input);
            return new byte[0];
        }

        try {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            KeySpec spec = new PBEKeySpec(input.toCharArray(), salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance(HASH_ALG);

            return factory.generateSecret(spec).getEncoded();
        } catch (Exception ex) {
            // TODO: Need to have a way for a user to understand there is a fundamental flaw. If this error hits,
            //  nothing can be done by the user. Will need to be an operational bug fix by development team.

            logger.error("Failure occurred generating the hash for String {} with algorithm {}", input, HASH_ALG, ex);
            return new byte[0];
        }
    }

    @Autowired      // TODO: Need to create context files that can autowire the DAO dependency to the class.
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
