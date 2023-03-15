package main.java.service_system.restcontroller;

import main.java.service_system.common.Status;
import main.java.service_system.common.hibernate.Request;
import main.java.service_system.common.hibernate.RequestRecord;
import main.java.service_system.common.hibernate.dao.LocationDAO;
import main.java.service_system.common.hibernate.dao.RequestDAO;
import main.java.service_system.common.hibernate.dao.RequestRecordDAO;
import main.java.service_system.common.hibernate.dao.UserDAO;
import main.java.service_system.common.hibernate.dao.VehicleDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

/**
 * Rest service controller for all service calls related to account services on the user side.
 *
 * Created by skeane on 3/14/2023.
 */
@RestController
@RequestMapping("/account/user")
public class UserAccountController {

    private static final Logger logger = LoggerFactory.getLogger(UserAccountController.class);

    private UserDAO userDAO;
    private LocationDAO locationDAO;
    private VehicleDAO vehicleDAO;
    private RequestDAO requestDAO;
    private RequestRecordDAO requestRecordDAO;

    /**
     *
     *
     * @return              Internal database ID of the user's account information.
     */
    @GetMapping("/create")
    public Integer createAccount() {

    }


    public void updateAccount() {

    }

    /**
     * Deletes the user and related data from the database.
     *
     * @param userId    ID of the user's account to be deleted.
     */
    @PostMapping("/delete/{id}")
    public void deleteAccount(@PathVariable(name = "id") int userId) {
        logger.debug("Started [deleteAccount] rest call for user ID {}", userId);

        // Remove all instances of objects related to the user from user-based tables.
        locationDAO.deleteByUserId(userId);
        vehicleDAO.deleteByUserId(userId);
        userDAO.delete(userId);

        // Check for any open requests. If there is an active request, cancel it and record it.
        Request active = requestDAO.findByUserId(userId);
        if (active != null) {
            RequestRecord record = new RequestRecord(Status.CANCELED, Instant.now(), active);
            requestRecordDAO.save(record);

            requestDAO.deleteByUserId(userId);
            logger.debug("Transferred active request for user ID {} to request records.", userId);
        }

        // Remove all instances of the user's ID from the records saved in the database.
        requestRecordDAO.removeUser(userId);
        logger.debug("Completed [deleteAccount] rest call for user ID {}", userId);
    }

    /**
     * Return the user ID for an account to assist account recovery service.
     *
     * @param email     Email address of the user.
     * @return          ID of the user who has a matching email address, null if no account is found.
     */
    @GetMapping("/recover/{email}")
    public Integer recoverAccount(@PathVariable(name = "email") String email) {
        logger.debug("Started [recoverAccount] rest call for email address {}", email);

        return userDAO.findByEmail(email);
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setLocationDAO(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    @Autowired
    public void setVehicleDAO(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    @Autowired
    public void setRequestDAO(RequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    @Autowired
    public void setRequestRecordDAO(RequestRecordDAO requestRecordDAO) {
        this.requestRecordDAO = requestRecordDAO;
    }
}
