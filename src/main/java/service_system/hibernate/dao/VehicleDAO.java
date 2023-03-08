package service_system.hibernate.dao;

/**
 * Created by skeane on 3/2/2023.
 */
public interface VehicleDAO extends GenericDAO {


    /**
     * Delete all vehicles for a user.
     *
     * @param userId    ID of the user to delete all vehicles for.
     */
    void deleteUser(int userId);

    /**
     * Deletes the
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
