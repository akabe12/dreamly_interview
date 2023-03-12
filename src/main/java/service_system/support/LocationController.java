package main.java.service_system.support;

import main.java.service_system.common.hibernate.Location;
import main.java.service_system.common.hibernate.dao.LocationDAO;
import main.java.service_system.common.restservice.LocationInfoWS;
import main.java.service_system.common.restservice.LocationListWS;
import main.java.service_system.common.restservice.RequestInfoWS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.annotation.TypeAnnotation;

import javax.ws.rs.Path;
import java.util.List;

/**
 * Rest service controller for all service calls related to updating saved locations for a user.
 *
 * Created by skeane on 3/12/2023.
 */
@RestController
@RequestMapping("/location")
public class LocationController {

    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationDAO locationDAO;

    /**
     * Grabs all locations for the user ID saved in the database.
     *
     * @param userId        ID of the user.
     * @return              List of locations the user previously saved in a wrapper class.
     */
    @GetMapping("/view/{id}")
    public LocationListWS getLocations(@PathVariable(name = "id") int userId) {
        logger.debug("Started [getLocations] rest call for user ID {}.", userId);

        List<Location> locationList = locationDAO.findByUserId(userId);
        return new LocationListWS(locationList);
    }

    @PostMapping("/modify/{id}")
    public void updateLocation(@RequestBody LocationInfoWS locationInfoWS) {
        logger.debug("Started [updateLocation] rest call for user ID {}.", locationInfoWS.getUserId());

        locationDAO.update();

        logger.debug("Completed [updateLocation] rest call for user ID {}.", locationInfoWS.getUserId());
    }

    @PostMapping("/add/{id}")
    public void addLocation(@RequestBody LocationInfoWS locationInfoWS) {
        logger.debug("Started [addLocation] rest call for user ID {}.", locationInfoWS.getUserId());

        Location location = new Location(locationInfoWS.getUserId(),
                locationInfoWS.getName(),
                locationInfoWS.getAddress(),
                locationInfoWS.getDetails());
        locationDAO.save(location);

        logger.debug("Completed [updateLocation] rest call for user ID {}.", locationInfoWS.getUserId());
    }

    /**
     * Delete the lo
     *
     * @param locationId    ID of the location to be deleted.
     */
    @PostMapping("/delete/{id}")
    public void deleteLocation(@PathVariable(name = "id") int locationId) {
        logger.debug("Started [deleteLocation] rest call for location ID {}.", locationId);

        locationDAO.deleteById(locationId);

        logger.debug("Completed [deleteLocation] rest call for location ID {}.", locationId);
    }
}
