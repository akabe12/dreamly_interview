package main.java.service_system.common.restservice.input;

import java.time.Instant;

/**
 * Wrapper class that transfers the user input through the REST call to enter it into the database.
 *
 * Created by skeane on 3/12/2023.
 */
public class RequestInfoWS {

    private final int userId;
    private final int companyId;
    private final String vehicleInfo;
    private final Instant pickupTime;
    private final String pickupLocation;
    private final String destination;

    public RequestInfoWS(int userId, int companyId, String vehicleInfo, Instant pickupTime, String pickupLocation, String destination) {
        this.userId = userId;
        this.companyId = companyId;
        this.vehicleInfo = vehicleInfo;
        this.pickupTime = pickupTime;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
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

    public Instant getPickupTime() {
        return pickupTime;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDestination() {
        return destination;
    }
}
