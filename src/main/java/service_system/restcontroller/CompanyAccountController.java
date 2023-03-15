package main.java.service_system.restcontroller;

import main.java.service_system.common.hibernate.dao.CompanyDAO;
import main.java.service_system.common.hibernate.dao.DriverDAO;
import main.java.service_system.common.hibernate.dao.RequestDAO;
import main.java.service_system.common.hibernate.dao.RequestRecordDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest service controller for all service calls related to account services on the company side.
 *
 * Created by skeane on 3/14/2023.
 */
@RestController
@RequestMapping("/account/company")
public class CompanyAccountController {

    private static final Logger logger = LoggerFactory.getLogger(CompanyAccountController.class);

    private CompanyDAO companyDAO;
    private DriverDAO driverDAO;
    private RequestDAO requestDAO;
    private RequestRecordDAO requestRecordDAO;


    public Integer createAccount() {

    }

    public void updateAccount() {

    }

    public void deleteAccount() {

    }

    public Integer recoverAccount() {

    }

    @Autowired
    public void setCompanyDAO(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Autowired
    public void setDriverDAO(DriverDAO driverDAO) {
        this.driverDAO = driverDAO;
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
