package main.java.service_system.active_requests;

import jdk.jfr.internal.consumer.RecordingInternals;
import main.java.service_system.common.Status;
import main.java.service_system.common.hibernate.Request;
import main.java.service_system.common.hibernate.dao.RequestDAO;
import main.java.service_system.common.restservice.RequestListWS;
import main.java.service_system.common.restservice.RequestRecordListWS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  Rest service controller for all service calls related to interacting with active requests from the company side.
 *
 * Created by skeane on 3/12/2023.
 */
@RestController
@RequestMapping("/company-request")
public class CompanyRequestController extends BaseRequestController {

    private static final Logger logger = LoggerFactory.getLogger(CompanyRequestController.class);

    /**
     * Grabs the available requests for a company from the database.
     *
     * @param companyId     ID of the company.
     * @return              List of available requests for a company, in a wrapper class.
     */
    @GetMapping("/available/{id}")
    public RequestListWS submitRequest(@PathVariable(value = "id") int companyId) {
        logger.debug("Started [submitRequest] rest call for company ID {}.", companyId);

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

}
