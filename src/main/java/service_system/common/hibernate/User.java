package main.java.service_system.common.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contains information for a user.
 *
 * Created by skeane on 3/2/2023.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    /**
     * Username of the user's account.
     */
    @Column(name = "username", nullable = false)
    private String username;

    /**
     * Hashed password for the user's account.
     */
    @Column(name = "hash_password", nullable = false)
    private byte[] password;

    /**
     * Name of the user.
     */
    @Column(name = "user")
    private String name;

    /**
     * Phone number of the user.
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * Email address of the user.
     */
    @Column(name = "email")
    private String email;

    /**
     * Constructor for a user. Only used in initial creation of a user acount.
     *
     * @param username      Username of the account.
     * @param password      Hashed password of the account.
     * @param name          Name of the user.
     * @param phoneNumber   Phone number of the user.
     * @param email         Email address of the user.
     */
    public User(String username, byte[] password, String name, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
