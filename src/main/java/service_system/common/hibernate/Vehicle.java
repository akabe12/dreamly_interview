package main.java.service_system.common.hibernate;

import main.java.service_system.common.Make;
import main.java.service_system.common.VehicleType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contains vehicle information of a user.
 *
 * Created by skeane on 3/2/2023.
 */
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    /**
     * ID of user that owns the vehicle.
     */
    @Column(name = "user_id", nullable = false)
    private final int userId;

    /**
     * Vehicle information.
     */
    @Column(name = "year", nullable = false)
    private int year;
    @Column(name = "make", nullable = false)
    private Make make;
    @Column(name = "model", nullable = false)
    private String model;

    /**
     * Transmission type, whether it is an automatic (auto = true, manual = false).
     */
    @Column(name = "automatic", nullable = false)
    private boolean auto;

    /**
     * (OPTIONAL) Vehicle color.
     */
    @Column(name = "color")
    private String color;

    /**
     * (OPTIONAL) Vehicle type.
     */
    @Column(name = "type")
    private VehicleType type;

    /**
     * (OPTIONAL) License plate number.
     */
    @Column(name = "number")
    private String number;

    public Vehicle(int userId, int year, Make make, String model, boolean auto) {
        this.userId = userId;
        this.year = year;
        this.make = make;
        this.model = model;
        this.auto = auto;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAuto() {
        return auto;
    }

    public void setAuto(boolean auto) {
        this.auto = auto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}