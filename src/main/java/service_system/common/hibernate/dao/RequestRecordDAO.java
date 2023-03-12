package main.java.service_system.common.hibernate.dao;

import main.java.service_system.common.hibernate.RequestRecord;

import java.util.List;

/**
 * Created by skeane on 3/2/2023.
 */
public interface RequestRecordDAO extends GenericDAO {

    /**
     * Removes the user ID from any request records that are in the database. If the request record does not have an
     * associated company ID, the request as a whole is removed.
     *
     * @param userId    ID of the user to be removed.
     */
    void removeUser(int userId);

    /**
     * Removes the company ID from any request records that are in the database. If the request record does not have an
     * associated user ID, the request as a whole is removed.
     *
     * @param companyId     ID of the company to be removed.
     */
    void removeCompany(int companyId);

    /**
     * Gets all request records saved in the database for a requested user.
     *
     * @param userId    ID of the user.
     * @return          List of associated request records, empty list if no records are found.
     */
    List<RequestRecord> getUserRecords(int userId);

    /**
     * Gets all request records saved in the database for a requested user.
     *
     * @param companyId     ID of the company.
     * @return              List of associated request records, empty list if no records are found.
     */
    List<RequestRecord> getCompanyRecords(int companyId);

}
