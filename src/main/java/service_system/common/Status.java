package main.java.service_system.common;

/**
 * Enum class to standardize the different statuses for a request.
 *
 * Created by skeane on 3/12/2023.
 */
public enum Status {

    /**
     * Status values for request records.
     */
    COMPLETED,
    CANCELED,

    /**
     * Status values for active requests.
     */
    OPEN,
    REJECTED,
    ACCEPTED

}
