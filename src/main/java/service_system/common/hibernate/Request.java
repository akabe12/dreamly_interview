package main.java.service_system.common.hibernate;

import main.java.service_system.common.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.Instant;

/**
 * Contains fields for a request.
 *
 * Created by skeane on 3/2/2023.
 */
@Entity
@Table (name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    /**
     * ID of the user who created the request.
     */
    @Column(name = "user_id", nullable = false)
    private final int userId;

    /**
     * ID of the company to which the request was submitted.
     */
    @Column(name = "company_id", nullable = false)
    private final int companyId;

    /**
     * Vehicle information.
     */
    @Column(name = "vehicle_info")
    private String vehicleInfo;

    /**
     * Requested pickup time.
     */
    @Column(name = "time")
    private Instant pickupTime;

    /**
     * Requested pickup address.
     */
    @Column(name = "start")
    private String pickupLocation;

    /**
     * Requested destination address.
     */
    @Column(name = "destination")
    private String destination;

    /**
     * Response by the company to the active request (OPEN, REJECTED, ACCEPTED).
     *
     * Upon instantiation of the Request object, will be automatically set to "OPEN".
     */
    @Column(name = "status")
    private Status status = Status.OPEN;

    public Request(int userId, int companyId, String vehicleInfo, Instant pickupTime, String pickupLocation,
                   String destination) {
        this.userId = userId;
        this.companyId = companyId;
        this.vehicleInfo = vehicleInfo;
        this.pickupTime = pickupTime;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
    }

    /**
     * Converts the information stored in the active request to a String to be used in conversion to a Request Record.
     *
     * @return  String containing condensed request information (vehicle information, pickup time, pickup address, destination address).
     */
    public String convertToRecordInfo() {
        return getVehicleInfo() + "," + getPickupTime() + "," + getPickupLocation() + "," + getDestination();
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getVehicleInfo() {
        return vehicleInfo;
    }

    public void setVehicleInfo(String vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }

    public Instant getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Instant pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
