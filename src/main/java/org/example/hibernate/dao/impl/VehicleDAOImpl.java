package org.example.hibernate.dao.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.hibernate.Vehicle;
import org.example.hibernate.dao.VehicleDAO;

import javax.persistence.EntityManager;

/**
 * Created by skeane on 3/2/2023.
 */
public class VehicleDAOImpl extends GenericDAOImpl implements VehicleDAO  {

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

    public void help() {
        EntityManager manager = getEntityManager()
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Item> cr = cb.createQuery(Item.class);
        Root<Item> root = cr.from(Item.class);
        cr.select(root);

        Query<Item> query = session.createQuery(cr);
        List<Item> results = query.getResultList();
    }

    @Override
    public Object save(Object entity) {
        return null;
    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    protected Class getEntityClass() {
        return null;
    }
}
