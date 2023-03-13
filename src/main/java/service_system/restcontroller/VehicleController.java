package main.java.service_system.restcontroller;

import main.java.service_system.common.hibernate.Vehicle;
import main.java.service_system.common.hibernate.dao.VehicleDAO;
import main.java.service_system.common.restservice.input.VehicleInfoWS;
import main.java.service_system.common.restservice.output.VehicleListWS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest service controller for all service calls related to updating vehicles for a user.
 *
 * Created by skeane on 3/12/2023.
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    private VehicleDAO vehicleDAO;

    /**
     * Grabs all vehicles for the user ID saved in the database.
     *
     * @param userId        ID of the company.
     * @return              List of vehicles the user previously saved in a wrapper class.
     */
    @GetMapping("/view/{id}")
    public VehicleListWS getVehicles(@PathVariable(name = "id") int userId) {
        logger.debug("Started [getVehicles] rest call for user ID {}.", userId);

        List<Vehicle> vehicleList = vehicleDAO.findByUserId(userId);
        return new VehicleListWS(vehicleList);
    }

    /**
     * Updates a vehicle's information for a user.
     *
     * @param vehicleInfoWS     Wrapper class containing the vehicle information to update.
     */
    @PostMapping("/modify")
    public void updateVehicle(@RequestBody VehicleInfoWS vehicleInfoWS) {
        logger.debug("Started [updateVehicle] rest call for user ID {}.", vehicleInfoWS.getUserId());

        vehicleDAO.update();

        logger.debug("Completed [updateVehicle] rest call for user ID {}.", vehicleInfoWS.getUserId());
    }

    /**
     * Add a new vehicle to the database for the user.
     *
     * @param vehicleInfoWS     Wrapper class containing the vehicle information to update.
     */
    @PostMapping("/add")
    public void addVehicle(@RequestBody VehicleInfoWS vehicleInfoWS) {
        logger.debug("Started [addVehicle] rest call for user ID {}.", vehicleInfoWS.getUserId());

        Vehicle vehicle = new Vehicle(vehicleInfoWS.getUserId(),
                vehicleInfoWS.getYear(),
                vehicleInfoWS.getMake(),
                vehicleInfoWS.getModel(),
                vehicleInfoWS.getAuto());
        vehicleDAO.save(vehicle);

        logger.debug("Completed [addVehicle] rest call for user ID {}.", vehicleInfoWS.getUserId());
    }

    /**
     * Delete the vehicle for the user from the database.
     *
     * @param vehicleId     ID of the vehicle to be deleted.
     */
    @PostMapping("/delete/{id}")
    public void deleteVehicle(@PathVariable(name = "id") int vehicleId) {
        logger.debug("Started [deleteVehicle] rest call for vehicle ID {}.", vehicleId);

        vehicleDAO.deleteById(vehicleId);

        logger.debug("Completed [deleteVehicle] rest call for vehicle ID {}.", vehicleId);
    }
}
