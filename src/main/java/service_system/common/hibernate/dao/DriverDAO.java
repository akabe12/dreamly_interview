package main.java.service_system.common.hibernate.dao;

import main.java.service_system.common.hibernate.Driver;

import java.util.List;

/**
 * Created by skeane on 3/2/2023.
 */
public interface DriverDAO extends GenericDAO<Driver> {

    /**
     * Gets all drivers associated with the company.
     *
     * @param companyId     ID of the company.
     * @return              List of associated drivers, empty list if nothing is found.
     */
    List<Driver> findByCompanyId(int companyId);

    /**
     * Deletes the driver from the database.
     *
     * @param driverId      ID of the driver to be removed.
     */
    void deleteById(int driverId);

    /**
     *
     */
    void update();

    Driver save(Driver driver);
}
