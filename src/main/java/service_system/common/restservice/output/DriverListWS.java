package main.java.service_system.common.restservice.output;

import main.java.service_system.common.hibernate.Driver;

import java.util.ArrayList;
import java.util.List;

/**
 * Serializable class to transfer drivers as a list through a REST call.
 *
 * Created by skeane on 3/12/2023.
 */
public class DriverListWS {

    private final List<Driver> drivers = new ArrayList<>();

    public DriverListWS(List<Driver> driverList) {
        this.drivers.addAll(driverList);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }
}
