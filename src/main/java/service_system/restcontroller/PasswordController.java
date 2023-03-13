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
 * Rest service controller for all service calls related to entering a password for both users and companies.
 *
 * Created by skeane on 3/12/2023.
 */
@RestController
@RequestMapping("/password")
public class PasswordController {

    private static final Logger logger = LoggerFactory.getLogger(PasswordController.class);

    private UserDAO userDAO;
    private CompanyDAO companyDAO;

    /**
     * Verifies if a user's password matches what is saved in the database.
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
        logger.debug("Started [resetUserPassword] rest call for user Id {}", userId);
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
        userDAO.setPassword(companyId, hashPass);
        logger.debug("Started [resetCompanyPassword] rest call for company Id {}", companyId);
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
