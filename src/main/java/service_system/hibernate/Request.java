package service_system.hibernate;

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
     * Whether there is a driver on their way (true = driver on the way, false = no driver/company assigned).
     */
    @Column(name = "status")
    private boolean status = false;

    public Request(int userId, String vehicleInfo, Instant pickupTime, String pickupLocation, String destination) {
        this.userId = userId;
        this.vehicleInfo = vehicleInfo;
        this.pickupTime = pickupTime;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
