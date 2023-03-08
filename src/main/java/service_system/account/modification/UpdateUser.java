package service_system.account.modification;

import service_system.hibernate.dao.VehicleDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

public class UpdateUser {

    private static final Logger logger = LoggerFactory.getLogger(UpdateUser.class);



    @Autowired
    private VehicleDAO vehicleDAO;



    public void addVehicle(int year, String make, String model, boolean auto) {


        // Check that the maximum limit of vehicles has not been reached.
        int numCar = vehicleDAO.

        // Check that all vehicle fields are present.
        if (year < 1960 || year > Instant.now()) {

        }

        /
        if ()
    }

}
