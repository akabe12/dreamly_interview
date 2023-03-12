package main.java.service_system.active_requests;

import main.java.service_system.common.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  Rest service controller for all service calls related to interacting with active requests from the user side.
 *
 * Created by skeane on 3/12/2023.
 */
@RestController
@RequestMapping("/user-request")
public class UserRequestController extends BaseRequestController{

    private static final Logger logger = LoggerFactory.getLogger(UserRequestController.class);

    /**
     * Submits the user created request to the database, to be viewable by the company that was requested.
     *
     * Note: Assumes that all fields in the submitted request are valid, having passed checks locally when the user
     *       submitted the information.
     *
     * @param
     */
    @PostMapping("/submit")
    public void submitRequest(@RequestBody ) {

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

}
