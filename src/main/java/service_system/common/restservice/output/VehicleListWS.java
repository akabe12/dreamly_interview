package main.java.service_system.common.restservice.output;

import main.java.service_system.common.hibernate.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 *  Serializable class to transfer vehicles as a list through a REST call.
 *
 * Created by skeane on 3/12/2023.
 */
public class VehicleListWS {

    private final List<Vehicle> vehicles = new ArrayList<>();

    public VehicleListWS(List<Vehicle> vehicleList) {
        this.vehicles.addAll(vehicleList);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
