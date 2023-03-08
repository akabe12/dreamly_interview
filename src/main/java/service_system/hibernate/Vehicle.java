package service_system.hibernate;

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
    private int id;

    /**
     * ID of user that owns the vehicle.
     */
    @ForeignKey
    @Column(name = "user_id")
    private int userId;

    /**
     * Vehicle information.
     */
    @Column(name = "year")
    private int year;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;

    /**
     * Transmission type, whether it is an automatic (auto = true, manual = false).
     */
    @Column(name = "automatic")
    private boolean auto;

    public Vehicle(int userId, int year, String make, String model, boolean auto) {
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

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
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
}