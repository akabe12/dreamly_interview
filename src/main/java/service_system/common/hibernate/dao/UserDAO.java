package main.java.service_system.common.hibernate.dao;

import main.java.service_system.common.hibernate.User;

/**
 * Created by skeane on 3/2/2023.
 */
public interface UserDAO extends GenericDAO<User> {

    /**
     * Find the ID of the user with the matching account username;
     *
     * @param username      Username of the user account.
     * @return              ID of a matching user, null if nothing was found.
     */
    Integer findIdByUsername(String username);

    /**
     * Delete the user from the database.
     *
     * @param userId    ID of the user.
     */
    void delete(int userId);

    /**
     * Get the hashed password for a user account.
     *
     * @param userId    ID of the user.
     * @return          Hashed password of the account.
     */
    byte[] getPassword(int userId);

    /**
     * Replace the existing password with a new one.
     *
     * @param userId            ID of the user.
     * @param hashedPassword    Hashed password to replace the original.
     */
    void setPassword(int userId, byte[] hashedPassword);

}
