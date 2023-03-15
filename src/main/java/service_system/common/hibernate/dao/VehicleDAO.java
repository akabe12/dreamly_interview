package main.java.service_system.common.hibernate.dao;

import main.java.service_system.common.hibernate.Vehicle;
import main.java.service_system.common.restservice.input.VehicleInfoWS;

import java.util.List;

/**
 * Created by skeane on 3/2/2023.
 */
public interface VehicleDAO extends GenericDAO<Vehicle> {

    /**
     * Get all the vehicles for a provided user.
     *
     * @param userId    ID of the user.
     * @return          All the vehicles for a provided user, empty list if nothing is found.
     */
    List<Vehicle> findByUserId(int userId);

    /**
     * Updates the non-null fields in the wrapper object in the vehicle object stored in the database.
     *
     * @param vehicleInfoWS     Vehicle information wrapper object.
     */
    void update(VehicleInfoWS vehicleInfoWS);

    /**
     * Delete the vehicle by the provided ID.
     *
     * @param vehicleId     ID of the vehicle to be deleted from the database.
     */
    void deleteById(int vehicleId);

    /**
     * Delete all vehicles for a user.
     *
     * @param userId    ID of the user to delete all vehicles for.
     */
    void deleteByUserId(int userId);

    /**
     * Deletes the vehicle information from the database.
     *
     * @param userId        ID of the user associated with the vehicle.
     * @param vehicleId     ID of the vehicle to be deleted.
     */
    void deleteVehicle(int userId, int vehicleId);

    /**
     * Determine the number of vehicles saved in the database for the user.
     *
     * @param userId    ID of the user.
     * @return          Number of vehicles assigned to the user.
     */
    int count(int userId);
}
