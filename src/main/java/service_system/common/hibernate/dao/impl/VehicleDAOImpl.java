package main.java.service_system.common.hibernate.dao.impl;

import main.java.service_system.common.hibernate.Vehicle;
import main.java.service_system.common.hibernate.dao.VehicleDAO;
import main.java.service_system.common.restservice.input.VehicleInfoWS;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by skeane on 3/2/2023.
 */
public class VehicleDAOImpl extends GenericDAOImpl<Vehicle> implements VehicleDAO {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Vehicle> findByUserId(int userId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(VehicleInfoWS vehicleInfoWS) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteByUserId(int vehicleId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(int userId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteVehicle(int userId, int vehicleId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int count(int userId) {
        int count = 0;

        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Integer> query = builder.createQuery(Integer.class);

        /**Root<Vehicle> root = ;
        query.select();*/


        return count;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vehicle save(Vehicle entity) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Vehicle entity) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = builder.createQuery(Vehicle.class);
    }

}
