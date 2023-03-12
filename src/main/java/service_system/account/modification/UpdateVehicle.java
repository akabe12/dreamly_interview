package main.java.service_system.account.modification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import main.java.service_system.common.Make;
import main.java.service_system.common.VehicleType;
import service_system.hibernate.Vehicle;
import service_system.hibernate.dao.VehicleDAO;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * Modify vehicle information for a user's account.
 *
 * Created by skeane on 3/8/2023.
 */
public class UpdateVehicle {

    private static final Logger logger = LoggerFactory.getLogger(UpdateVehicle.class);

    /**
     * Database queries.
     */
    @Autowired
    private VehicleDAO vehicleDAO;

    /**
     * Vehicle limit per user that can be stored.
     */
    private int vehicleLimit;

    /**
     * Add a new vehicle to the database for the user.
     *
     * @param year      Model year of the vehicle.
     * @param make      Make of the vehicle.
     * @param model     Model name of the vehicle.
     * @param auto      Whether the transmission is an automatic (true - automatic, false - manual).
     * @return          Whether a vehicle was successfully added to the database (true - successful, false - failed).
     */
    public boolean addVehicle(int userId, int year, String make, String model, boolean auto) {

        // Check that the maximum limit of vehicles has not been reached.
        int numCar = vehicleDAO.count(userId);
        if (numCar == vehicleLimit) {
            logger.warn("Vehicle limit was reached.");
            return false;
        }

        // Validate that model year is possible.
        if (!validateYear(year)) {
            logger.warn("Invalid model year {} was provided.", year);
            return false;
        }

        // Determine vehicle make.
        Make vehicleMake = verifyMake();

        // Check that the model field is not empty.
        if (model == null || model.equals(""))


        Vehicle vehicle = new Vehicle(userId, year, vehicleMake, model, auto);
        vehicleDAO.save(vehicle);
        return true;
    }

    /**
     * Update an existing vehicle information.
     *
     * @param userId        ID of the user account.
     * @param vehicleId     ID of the vehicle to be modified.
     */
    public void updateVehicle(int userId, int vehicleId) {

    }

    /**
     * Remove the provided vehicle from the database.
     *
     * @param userId        ID of the user account.
     * @param vehicleId     ID of the vehicle to be removed.
     */
    public void removeVehicle(int userId, int vehicleId) {
        vehicleDAO.deleteVehicle(userId, vehicleId);
    }

    /**
     * Check the model year of the vehicle and confirms it is between the years of 1960 and the latest model year.
     *
     * @param year  Model year of the vehicle.
     * @return      Whether model year passes check (true - passes, false - fails).
     */
    private boolean validateYear(int year) {
        Instant current = Instant.now();
        ZoneId zone = ZoneId.of("Japan/Tokyo");
        LocalDate date = LocalDate.ofInstant(current, zone);
        int latestModelYear = date.getYear() + 1;

        return (year < 1960  && year <= latestModelYear);
    }

    /**
     * Verify the make of the vehicle, replacing it with a standardized Enum value. If no matching make exists, will be
     * assigned OTHER.
     *
     * @param make  User inputted make of the vehicle.
     * @return      Standardized enum value of the vehicle make.
     */
    private Make verifyMake(String make) {
        make = make.toUpperCase().replaceAll("[^a-zA-Z]+", " ");

        if(VehicleType != null && string != null ) {
            try {
                return Enum.valueOf(c, string.trim().toUpperCase());
            } catch(IllegalArgumentException ex) {
            }
        }
        return null;
    }

    public void setVehicleLimit(int vehicleLimit) {
        this.vehicleLimit = vehicleLimit;
    }
}
