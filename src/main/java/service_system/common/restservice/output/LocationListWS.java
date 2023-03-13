package main.java.service_system.common.restservice.output;

import main.java.service_system.common.hibernate.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Serializable class to transfer locations as a list through a REST call.
 *
 * Created by skeane on 3/12/2023.
 */
public class LocationListWS {

    private final List<Location> locations = new ArrayList<>();

    public LocationListWS(List<Location> locationList) {
        this.locations.addAll(locationList);
    }

    public List<Location> getLocations() {
        return locations;
    }
}
