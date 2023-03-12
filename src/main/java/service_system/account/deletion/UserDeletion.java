package main.java.service_system.account.deletion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDeletion {

    private static final Logger logger = LoggerFactory.getLogger(UserDeletion.class);

    public void delete(int userId) {


        // Delete user from historical records first. Prevents dependency issues when removing the user ID from the
        // database.



    }
}
