package main.java.service_system.common.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contains parking information for a location saved by a user.
 *
 * Created by skeane on 3/2/2023.
 */
@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    /**
     * ID of user that saved the location.
     */
    @Column(name = "user_id", nullable = false)
    private final int userId;

    /**
     * Name assigned to the location by the user.
     */
    @Column(name = "name")
    private String name;

    /**
     * Address of the location.
     */
    @Column(name = "address")
    private String address;

    /**
     * Details about the location (such as which parking spot).
     */
    @Column(name = "details")
    private String details;

    public Location(int userId, String name, String address, String details) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.details = details;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}