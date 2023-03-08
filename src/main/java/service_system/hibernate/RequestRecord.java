package service_system.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.Instant;

/**
 * Historical record of submitted requests.
 *
 * Created by skeane on 3/2/2023.
 */
@Entity
@Table(name = "records")
public class RequestRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    /**
     * ID of user who created the request.
     *
     * Nullable if user account is deleted.
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * ID of the company who accepted the request, if no company accepted it is null.
     *
     * Nullable if company account is deleted.
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * Request status upon closing (CANCELED, COMPLETED).
     */
    @Column(name = "request_status")
    private final String requestStatus;

    /**
     * Time when request was closed.
     */
    @Column(name = "time")
    private final Instant completionTime;

    /**
     * Condensed request information (vehicle information, pickup time, pickup address, destination address).
     */
    @Column(name = "info")
    private final String requestInfo;

    public RequestRecord(int userId, int companyId, String requestStatus, Instant completionTime, String requestInfo) {
        this.userId = userId;
        this.companyId = companyId;
        this.requestStatus = requestStatus;
        this.completionTime = completionTime;
        this.requestInfo = requestInfo;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public Instant getCompletionTime() {
        return completionTime;
    }

    public String getRequestInfo() {
        return requestInfo;
    }
}