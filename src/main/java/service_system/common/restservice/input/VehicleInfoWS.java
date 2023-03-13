package main.java.service_system.common.restservice.input;

import main.java.service_system.common.Make;
import main.java.service_system.common.VehicleType;

/**
 * Wrapper class that transfers the vehicle input through the REST call to enter it into the database.
 *
 * Created by skeane on 3/12/2023.
 */
public class VehicleInfoWS {

    private final int userId;
    private final Integer year;
    private final Make make;
    private final String model;
    private final Boolean auto;
    private final String color;
    private final VehicleType type;
    private final String number;

    public VehicleInfoWS(int userId, Integer year, Make make, String model, Boolean auto, String color, VehicleType type, String number) {
        this.userId = userId;
        this.year = year;
        this.make = make;
        this.model = model;
        this.auto = auto;
        this.color = color;
        this.type = type;
        this.number = number;
    }

    public int getUserId() {
        return userId;
    }

    public Integer getYear() {
        return year;
    }

    public Make getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Boolean getAuto() {
        return auto;
    }

    public String getColor() {
        return color;
    }

    public VehicleType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}
