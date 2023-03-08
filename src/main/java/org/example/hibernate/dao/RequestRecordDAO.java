package org.example.hibernate.dao;

/**
 * Created by skeane on 3/2/2023.
 */
public interface RequestRecordDAO {

    /**
     * Removes the user ID from any request records that are in the database. If the request record does not have an
     * associated company ID, the request as a whole is removed.
     *
     * @param userId    ID of the user to be removed.
     */
    void removeUser(int userId);
}
