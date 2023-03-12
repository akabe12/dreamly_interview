package main.java.service_system.common.hibernate.dao;

import main.java.service_system.common.Status;
import main.java.service_system.common.hibernate.Request;

import java.util.List;

/**
 * Created by skeane on 3/2/2023.
 */
public interface RequestDAO extends GenericDAO {

    /**
     * Get the request for a provided user.
     *
     * @param userId    ID of the user.
     * @return          Request object, if nothing is found returns null.
     */
    Request findByUserId(int userId);

    /**
     * Delete the request for a provided user.
     *
     * @param userId    ID of the user.
     */
    void deleteByUserId(int userId);

    /**
     * Get the status of the active request.
     *
     * @param userId    ID of the user who created the request.
     * @return          Status of the request (OPEN, REJECTED, ACCEPTED).
     */
    Status getStatus(int userId);

    /**
     * Get the available requests (OPEN) for a company.
     *
     * @param companyId     ID of the company.
     * @return              List of available requests for the company, empty list if nothing is found.
     */
    List<Request> getOpenRequests(int companyId);

}
