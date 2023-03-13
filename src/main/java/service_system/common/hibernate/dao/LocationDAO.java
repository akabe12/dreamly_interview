package main.java.service_system.common.hibernate.dao;

import main.java.service_system.common.hibernate.Location;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by skeane on 3/2/2023.
 */
@Repository
public interface LocationDAO extends GenericDAO<Location> {

    /**
     * Gets all locations associated with the user.
     *
     * @param userId        ID of the user.
     * @return              List of associated locations, empty list if nothing is found.
     */
    List<Location> findByUserId(int userId);

    /**
     * Deletes the location from the database.
     *
     * @param locationId    ID of the location to be removed.
     */
    void deleteById(int locationId);
}
