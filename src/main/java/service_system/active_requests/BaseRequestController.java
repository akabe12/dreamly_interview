package main.java.service_system.active_requests;

import main.java.service_system.common.Status;
import main.java.service_system.common.hibernate.Request;
import main.java.service_system.common.hibernate.RequestRecord;
import main.java.service_system.common.hibernate.dao.RequestDAO;
import main.java.service_system.common.hibernate.dao.RequestRecordDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

/**
 * Base controller class for the company and user applications.
 *
 * Created by skeane on 3/12/2023.
 */
public class BaseRequestController {

    @Autowired
    protected RequestDAO requestDAO;

    @Autowired
    protected RequestRecordDAO requestRecordDAO;

    /**
     * Handles the transition of an active request becoming a record after the request is no longer open.
     *
     * @param userId    ID of the user that created the request.
     * @param status    Reason for closing of the request.
     */
    protected void convertRequest(int userId, Status status) {
        Request request = requestDAO.findByUserId(userId);
        requestDAO.deleteByUserId(userId);
        RequestRecord record = new RequestRecord(Status.CANCELED, Instant.now(), request);
        requestRecordDAO.save(record);
    }

}
