package main.java.service_system.common.hibernate.dao.impl;

import main.java.service_system.common.hibernate.Location;
import main.java.service_system.common.hibernate.dao.LocationDAO;

import java.util.List;

/**
 * Created by skeane on 3/2/2023.
 */
public class LocationDAOImpl extends GenericDAOImpl implements LocationDAO {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Location> findByUserId(int userId) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(int locationId) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Location save(Location entity) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Location entity) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Location findById(Long id) {
        return null;
    }
}
