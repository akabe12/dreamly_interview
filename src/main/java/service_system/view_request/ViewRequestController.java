package main.java.service_system.view_request;

import main.java.service_system.common.hibernate.RequestRecord;
import main.java.service_system.common.hibernate.dao.RequestRecordDAO;
import main.java.service_system.common.restservice.RequestRecordListWS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest service controller for all service calls related to viewing previous requests.
 *
 * Created by skeane on 3/11/2023.
 */
@RestController
@RequestMapping(path = "/records")
public class ViewRequestController {

    private static final Logger logger = LoggerFactory.getLogger(ViewRequestController.class);

    @Autowired
    private RequestRecordDAO requestRecordDAO;

    /**
     * Grabs all request records for the user ID saved in the database. Will be used to show the user all of their
     * previous requests.
     *
     * @param userId    ID of the user.
     * @return          List of request records in a wrapper class.
     */
    @GetMapping("/user/{id}")
    public RequestRecordListWS getUserRecordList(@PathVariable(value = "id") int userId) {
        logger.debug("Started [getUserRecordList] rest call for user ID {}.", userId);
        List<RequestRecord> dbRecords = requestRecordDAO.getUserRecords(userId);

        return new RequestRecordListWS(dbRecords);
    }

    /**
     * Grabs all request records for the company ID saved in the database. Will be used to show the company all of their
     * previous requests.
     *
     * @param companyId     ID of the company.
     * @return              List or request records in a wrapper class.
     */
    @GetMapping("/company/{id}")
    public RequestRecordListWS getCompanyRecordList(@PathVariable(value = "id") int companyId) {
        logger.debug("Started [getCompanyRecordList] rest call for company ID {}.", companyId);
        List<RequestRecord> dbRecords = requestRecordDAO.getCompanyRecords(companyId);

        return new RequestRecordListWS(dbRecords);
    }
}
