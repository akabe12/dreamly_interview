package main.java.service_system.restcontroller;

import main.java.service_system.common.hibernate.Driver;
import main.java.service_system.common.hibernate.dao.DriverDAO;
import main.java.service_system.common.restservice.input.DriverInfoWS;
import main.java.service_system.common.restservice.output.DriverListWS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest service controller for all service calls related to updating drivers for a company.
 *
 * Created by skeane on 3/12/2023.
 */
@RestController
@RequestMapping("/driver")
public class DriverController {

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    private DriverDAO driverDAO;

    /**
     * Grabs all drivers for the company ID saved in the database.
     *
     * @param companyId     ID of the company.
     * @return              List of drivers the company previously saved in a wrapper class.
     */
    @GetMapping("/view/{id}")
    public DriverListWS getDrivers(@PathVariable(name = "id") int companyId) {
        logger.debug("Started [getDrivers] rest call for company ID {}.", companyId);

        List<Driver> driverList = driverDAO.findByCompanyId(companyId);
        return new DriverListWS(driverList);
    }

    /**
     * Updates a driver's information for a company.
     *
     * @param driverInfoWS      Wrapper class containing the driver information to update.
     */
    @PostMapping("/modify")
    public void updateDriver(@RequestBody DriverInfoWS driverInfoWS) {
        logger.debug("Started [updateDriver] rest call for company ID {}.", driverInfoWS.getCompanyId());

        driverDAO.update();

        logger.debug("Completed [updateDriver] rest call for company ID {}.", driverInfoWS.getCompanyId());
    }

    @PostMapping("/add")
    public void addDriver(@RequestBody DriverInfoWS driverInfoWS) {
        logger.debug("Started [addDriver] rest call for company ID {}.", driverInfoWS.getCompanyId());

        Driver driver = new Driver(driverInfoWS.getCompanyId(),
                driverInfoWS.getName(),
                driverInfoWS.getPhoneNumber());
        driverDAO.save(driver);

        logger.debug("Completed [addDriver] rest call for company ID {}.", driverInfoWS.getCompanyId());
    }

    /**
     * Delete the driver from the company.
     *
     * @param driverId  ID of the driver to be deleted.
     */
    @PostMapping("/delete/{id}")
    public void deleteDriver(@PathVariable(name = "id") int driverId) {
        logger.debug("Started [deleteDriver] rest call for driver ID {}.", driverId);

        driverDAO.deleteById(driverId);

        logger.debug("Completed [deleteDriver] rest call for driver ID {}.", driverId);
    }

    @Autowired
    public void setDriverDAO(DriverDAO driverDAO) {
        this.driverDAO = driverDAO;
    }
}
