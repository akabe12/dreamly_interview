package main.java.service_system.common.hibernate.dao;

/**
 * Created by skeane on 3/2/2023.
 */
public interface UserDAO {

    void delete(int userId);

    /**
     * Get the hashed password for a user account.
     *
     * @param userId    ID of the user.
     * @return          Hashed password of the account.
     */
    byte[] getPassword(int userId);
}
