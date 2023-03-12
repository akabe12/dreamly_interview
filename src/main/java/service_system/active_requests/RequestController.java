package main.java.service_system.active_requests;

import main.java.service_system.common.Status;
import main.java.service_system.common.hibernate.Request;
import main.java.service_system.common.hibernate.RequestRecord;
import main.java.service_system.common.hibernate.dao.RequestDAO;
import main.java.service_system.common.hibernate.dao.RequestRecordDAO;
import main.java.service_system.common.restservice.RequestInfoWS;
import main.java.service_system.common.restservice.RequestListWS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

/**
 *  Rest service controller for all service calls related to interacting with active requests from the user side.
 *
 * Created by skeane on 3/12/2023.
 */
@RestController
@RequestMapping("/request")
public class RequestController {

    private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    private RequestDAO requestDAO;

    @Autowired
    private RequestRecordDAO requestRecordDAO;

    /**
     * Submits the user created request to the database, to be viewable by the company that was requested.
     *
     * Note: Assumes that all fields in the submitted request are valid, having passed checks locally when the user
     *       submitted the information.
     *
     * @param requestInfoWS     Wrapper class containing valid request fields.
     */
    @PostMapping("/submit")
    public void submitRequest(@RequestBody RequestInfoWS requestInfoWS) {
        logger.debug("Started [submitRequest] rest call for user ID {}.", requestInfoWS.getUserId());

        Request request = new Request(
                requestInfoWS.getUserId(),
                requestInfoWS.getCompanyId(),
                requestInfoWS.getVehicleInfo(),
                requestInfoWS.getPickupTime(),
                requestInfoWS.getPickupLocation(),
                requestInfoWS.getDestination());
        requestDAO.save(request);

        logger.debug("Completed [submitRequest] rest call for user ID {}.", requestInfoWS.getUserId());
    }

    /**
     * Cancels the user created request, updating the database.
     *
     * @param userId    ID of the user to cancel the active request for.
     */
    @PostMapping("/cancel/{id}")
    public void cancelRequest(@PathVariable(value = "id") int userId) {
        logger.debug("Started [cancelRequest] rest call for user ID {}.", userId);

        convertRequest(userId, Status.CANCELED);
        // TODO: Potential feature - Send cancellation notification to company.

        logger.debug("Completed [cancelRequest] rest call for user ID {}.", userId);
    }

    /**
     * Call to see if the request has been accepted by the company.
     *
     * @param userId    ID of the user who created the request.
     * @return          Whether the company has accepted the request (OPEN, REJECTED, ACCEPTED).
     */
    @GetMapping("/status/{id}")
    public Status getRequestStatus(@PathVariable(value = "id") int userId) {
        logger.debug("Started [getRequestStatus] rest call for user ID {}.", userId);

        return requestDAO.getStatus(userId);
    }

    /**
     * Completes the user created request, updating the database.
     *
     * @param userId    ID of the user to complete the active request for.
     */
    @PostMapping("completed/{id}")
    public void completeRequest(@PathVariable(value = "id") int userId) {
        logger.debug("Started [completeRequest] rest call for user ID {}.", userId);

        convertRequest(userId, Status.COMPLETED);

        logger.debug("Completed [completeRequest] rest call for user ID {}.", userId);
    }

    /**
     * Grabs the available requests for a company from the database.
     *
     * @param companyId     ID of the company.
     * @return              List of available requests for a company, in a wrapper class.
     */
    @GetMapping("/available/{id}")
    public RequestListWS availableRequests(@PathVariable(value = "id") int companyId) {
        logger.debug("Started [availableRequests] rest call for company ID {}.", companyId);

        List<Request> requests = requestDAO.getOpenRequests(companyId);
        return new RequestListWS(requests);
    }

    /**
     * Refuses the request and updates the database. TODO: SAME AS USER, CONDENSE???
     *
     * @param userId    ID of the user that created the request that was refused.
     */
    @PostMapping("/refuse/{id}")
    public void refuseRequest(@PathVariable(value = "id") int userId) {
        logger.debug("Started [refuseRequest] rest call for user ID {}.", userId);

        convertRequest(userId, Status.CANCELED);
        // TODO: Potential feature - Send cancellation notification to company.

        logger.debug("Completed [cancelRequest] rest call for user ID {}.", userId);
    }

    /**
     * Accepts the request and updates the database.
     *
     * @param userId    ID of the user that created the request that was accepted.
     */
    @PostMapping("/accept/{id}")
    public void acceptRequest(@PathVariable(value = "id") int userId) {
        logger.debug("Started [acceptRequest] rest call for user ID {}.", userId);

        //convertRequest(userId, Status.ACCEPTED);
        // TODO: Potential feature - Send cancellation notification to company.

        logger.debug("Completed [acceptRequest] rest call for user ID {}.", userId);
    }

    /**
     * Handles the transition of an active request becoming a record after the request is no longer open.
     *
     * @param userId    ID of the user that created the request.
     * @param status    Reason for closing of the request.
     */
    private void convertRequest(int userId, Status status) {
        Request request = requestDAO.findByUserId(userId);
        requestDAO.deleteByUserId(userId);
        RequestRecord record = new RequestRecord(Status.CANCELED, Instant.now(), request);
        requestRecordDAO.save(record);
    }

}
