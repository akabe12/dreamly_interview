package main.java.service_system.restcontroller;

import main.java.service_system.common.hibernate.dao.CompanyDAO;
import main.java.service_system.common.hibernate.dao.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Rest service controller for all service calls related to logging into an account for both users and companies.
 *
 * Created by skeane on 3/13/2023.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private UserDAO userDAO;
    private CompanyDAO companyDAO;

    /**
     * Verify login credentials against what is stored in the database for users.
     *
     * @param username          Username of the account.
     * @param hashedPassword    Hashed password for the account.
     * @return                  Return the internal database ID of the user, null if no matching username and password combination was found.
     */
    @GetMapping("/user/{username}/{hashPass}")
    public Integer verifyUser(@PathVariable(name = "username") String username,
                              @PathVariable(name = "hashPass") byte[] hashedPassword) {
        logger.debug("Started [verifyUser] rest call for username {}", username);
        Integer id = userDAO.findIdByUsername(username);

        if (id == null) {
            logger.debug("Completed [verifyUser] rest call for username {}\n\tNo matching username was found", username);
            return null;
        }

        byte[] dbHashPass = userDAO.getPassword(id);
        if (Arrays.equals(dbHashPass, hashedPassword)) {
            logger.debug("Completed [verifyUser] rest call for username {}", username);
            return id;
        } else {
            logger.debug("Completed [verifyUser] rest call for username {}\n\tIncorrect password.", username);
            return null;
        }
    }

    /**
     * Verify login credentials against what is stored in the database for companies.
     *
     * @param username          Username of the account.
     * @param hashedPassword    Hashed password for the account.
     * @return                  Return the internal database ID of the company, null if no matching username and password combination was found.
     */
    @GetMapping("/company/{username}/{hashPass}")
    public Integer verifyCompany(@PathVariable(name = "username") String username,
                                 @PathVariable(name = "hashPass") byte[] hashedPassword) {
        logger.debug("Started [verifyCompany] rest call for username {}", username);
        Integer id = companyDAO.findIdByUsername(username);

        if (id == null) {
            logger.debug("Completed [verifyCompany] rest call for username {}\n\tNo matching username was found", username);
            return null;
        }

        byte[] dbHashPass = companyDAO.getPassword(id);
        if (Arrays.equals(dbHashPass, hashedPassword)) {
            logger.debug("Completed [verifyCompany] rest call for username {}", username);
            return id;
        } else {
            logger.debug("Completed [verifyCompany] rest call for username {}\n\tIncorrect password.", username);
            return null;
        }
    }

    /**
     * Verifies if a user's password matches what is saved in the database.
     *
     * Note: Planned to be used for account deletion feature.
     *
     * @param userId        ID of the user.
     * @param hashPass      Hashed password to check against the database (WILL BE ALREADY HASHED LOCALLY, BEFORE BEING SENT FOR SECURITY).
     * @return              Whether the password was correct (true - correct, false - incorrect).
     */
    @GetMapping("/verify/user/{id}/{hashPass}")
    public boolean verifyUserPassword(@PathVariable(name = "id") int userId,
                                      @PathVariable(name = "hashPass") byte[] hashPass) {
        logger.debug("Started [verifyUserPassword] rest call for user ID {}.", userId);

        byte[] dbHashPass = userDAO.getPassword(userId);
        return Arrays.equals(dbHashPass, hashPass);
    }

    /**
     * Verifies if a company's password matches what is saved in the database.
     *
     * Note: Planned to be used for account deletion feature.
     *
     * @param companyId     ID of the company.
     * @param hashPass      Hashed password to check against the database (WILL BE ALREADY HASHED LOCALLY, BEOFRE BEING SENT FOR SECURITY).
     * @return              Whether the password was correct (true - correct, false - incorrect).
     */
    @GetMapping("/verify/company/{id}/{hashPass}")
    public boolean verifyCompanyPassword(@PathVariable(name = "id") int companyId,
                                         @PathVariable(name = "hashPass") byte[] hashPass) {
        logger.debug("Started [verifyCompanyPassword] rest call for company ID {}.", companyId);

        byte[] dbHashPass = companyDAO.getPassword(companyId);
        return Arrays.equals(dbHashPass, hashPass);
    }

    /**
     * Sets the hashed password (only to be used when password is reset).
     *
     * @param userId        ID of the user.
     * @param hashPass      Hashed password to save to the database and replace the old password.
     */
    @PostMapping("/reset/user/{id}/{hashPass}")
    public void resetUserPassword(@PathVariable(name = "id") int userId,
                                  @PathVariable(name = "hashPass") byte[] hashPass) {
        logger.debug("Started [resetUserPassword] rest call for user Id {}", userId);
        userDAO.setPassword(userId, hashPass);
        logger.debug("Completed [resetUserPassword] rest call for user Id {}", userId);
    }

    /**
     * Sets the hashed password (only to be used when password is reset).
     *
     * @param companyId     ID of the password.
     * @param hashPass      Hashed password to save to the database and replace the old password.
     */
    @PostMapping("/reset/company/{id}/{hashPass}")
    public void resetCompanyPassword(@PathVariable(name = "id") int companyId,
                                     @PathVariable(name = "hashPass") byte[] hashPass) {
        logger.debug("Started [resetCompanyPassword] rest call for company Id {}", companyId);
        companyDAO.setPassword(companyId, hashPass);
        logger.debug("Completed [resetCompanyPassword] rest call for company Id {}", companyId);
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setCompanyDAO(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }
}
