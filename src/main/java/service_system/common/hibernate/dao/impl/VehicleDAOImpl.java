package main.java.service_system.common.hibernate.dao.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import main.java.service_system.common.hibernate.Vehicle;
import main.java.service_system.common.hibernate.dao.VehicleDAO;
import main.java.service_system.common.restservice.input.VehicleInfoWS;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by skeane on 3/2/2023.
 */
public class VehicleDAOImpl extends GenericDAOImpl implements VehicleDAO {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Vehicle> findByUserId(int userId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(VehicleInfoWS vehicleInfoWS) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(int vehicleId) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteUser(int userId) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteVehicle(int userId, int vehicleId) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int count(int userId) {
        int count = 0;

        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.;
        CriteriaQuery<Integer> query = builder.createQuery(Integer.class);

        Root<Vehicle> root = ;
        query.select();


        return count;
    }

    /**
     * {@inheritDoc}
     */
    public void help() {
        EntityManager manager = getEntityManager()
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Item> cr = cb.createQuery(Item.class);
        Root<Item> root = cr.from(Item.class);
        cr.select(root);

        Query<Item> query = session.createQuery(cr);
        List<Item> results = query.getResultList();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Vehicle save(Vehicle entity) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Vehicle entity) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vehicle findById(Long id) {
        return null;
    }
}
