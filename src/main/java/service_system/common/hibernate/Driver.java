package main.java.service_system.common.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Contains driver contact information.
 *
 * Created by skeane on 3/2/2023.
 */
@Entity
@Table(name = "driver")
public class Driver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    /**
     * ID of the company the driver is affiliated with.
     */
    @Column(name = "company_id", nullable = false)
    private final int companyId;

    /**
     * Name of the driver.
     */
    @Column(name = "driver")
    private String name;

    /**
     * Driver's phone number.
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    public Driver(int companyId, String name, String phoneNumber) {
        this.companyId = companyId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}