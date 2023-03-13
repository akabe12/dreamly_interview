package main.java.service_system.common.restservice.input;

/**
 * Wrapper class that transfers the location input through the REST call to enter it into the database.
 *
 * Created by skeane on 3/12/2023.
 */
public class LocationInfoWS {

    private final int userId;
    private String name;
    private String address;
    private String details;

    public LocationInfoWS(int userId, String name, String address, String details) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.details = details;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
