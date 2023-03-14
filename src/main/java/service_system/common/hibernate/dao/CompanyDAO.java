package main.java.service_system.common.hibernate.dao;

import main.java.service_system.common.hibernate.Company;

/**
 * Created by skeane on 3/2/2023.
 */
public interface CompanyDAO extends GenericDAO<Company> {

    /**
     * Find the ID of the company with the matching account username;
     *
     * @param username      Username of the company account.
     * @return              ID of a matching company, null if nothing was found.
     */
    Integer findIdByUsername(String username);

    /**
     * Get the hashed password for a company from the database.
     *
     * @param companyId     ID of the company.
     * @return              Hashed password, empty array if nothing is found.
     */
    byte[] getPassword(int companyId);

    /**
     * Replace the existing password with a new one.
     *
     * @param companyId         ID of the user.
     * @param hashedPassword    Hashed password to replace the original.
     */
    void setPassword(int companyId, byte[] hashedPassword);

}
