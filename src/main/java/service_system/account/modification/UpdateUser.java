package service_system.account.modification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Focuses on providing the user account update services.
 *    - Modifying contact information.
 *    - Modifying saved location information.
 *
 * Created 3/7/2023 by skeane.
 */
public class UpdateUser {

    private static final Logger logger = LoggerFactory.getLogger(UpdateUser.class);


    /**
     * Update the phone number of the user account in the database.
     *
     * @param userId        ID of the user account.
     * @param phoneNumber   Phone number of the user.
     * @return              Whether the update of the information was successful (true - successful, false - failed).
     */
    public boolean updatePhoneNumber(int userId, String phoneNumber) {

    }

}
