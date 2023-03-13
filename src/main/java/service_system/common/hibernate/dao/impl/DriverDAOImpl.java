package main.java.service_system.common.hibernate.dao.impl;

import main.java.service_system.common.hibernate.Driver;
import main.java.service_system.common.hibernate.dao.DriverDAO;

import java.util.List;

/**
 * Created by skeane on 3/2/2023.
 */
public class DriverDAOImpl extends GenericDAOImpl implements DriverDAO {

    /**
     * {@inheritDoc}
     */
    @Override
    public Object save(Object entity) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Object entity) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class getEntityClass() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Driver> findByUserId(int companyId) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(int driverId) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {

    }
}
