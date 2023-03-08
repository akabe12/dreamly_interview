package service_system.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contains contact information and availability of a company.
 *
 * Created by skeane on 3/2/2023.
 */
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    /**
     * Username of the company's account.
     */
    @Column(name = "username", nullable = false)
    private String username;

    /**
     * Hashed password for the company's account.
     */
    @Column(name = "hash_password", nullable = false)
    private String password;

    /**
     * Name of the company.
     */
    @Column(name = "name")
    private String name;

    /**
     * Phone number of the company.
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * Address of the company office.
     */
    @Column(name = "address")
    private String address;

    /**
     * Email address of the company.
     */
    @Column(name = "email")
    private String email;

    /**
     * Whether the company is available to take requests (true = available, false = closed).
     */
    @Column(name = "available")
    private boolean available = false;

    public Company(String name, String phoneNumber, String address, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}