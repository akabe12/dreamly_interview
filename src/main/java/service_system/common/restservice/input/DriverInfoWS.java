package main.java.service_system.common.restservice.input;

/**
 * Wrapper class that transfers the driver input through the REST call to enter it into the database.
 *
 * Created by skeane on 3/12/2023.
 */
public class DriverInfoWS {

    private final int companyId;
    private String name;
    private String phoneNumber;

    public DriverInfoWS(int companyId, String name, String phoneNumber) {
        this.companyId = companyId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
