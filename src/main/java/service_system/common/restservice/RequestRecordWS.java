package main.java.service_system.common.restservice;

import main.java.service_system.common.hibernate.RequestRecord;

import java.io.Serializable;
import java.time.Instant;

/**
 * Serializable class to transfer request record information through a REST call.
 *
 * Created by skeane on 3/11/2023.
 */
public class RequestRecordWS implements Serializable {

    private static final long serialVersionUID = -6251180347071423290L;

    /**
     * Fields are taken from the RequestRecord object stored in the database.
     */
    private final Integer userId;
    private final Integer companyId;
    private final String requestStatus;
    private final Instant completionTime;

    public RequestRecordWS(RequestRecord requestRecord) {
        this.userId = requestRecord.getUserId();
        this.companyId = requestRecord.getCompanyId();
        this.requestStatus = requestRecord.getRequestStatus();
        this.completionTime = requestRecord.getCompletionTime();
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public Instant getCompletionTime() {
        return completionTime;
    }
}
