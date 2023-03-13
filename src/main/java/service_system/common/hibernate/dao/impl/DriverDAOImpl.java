package main.java.service_system.common.hibernate.dao.impl;

import main.java.service_system.common.hibernate.Driver;
import main.java.service_system.common.hibernate.dao.DriverDAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by skeane on 3/2/2023.
 */
public class DriverDAOImpl extends GenericDAOImpl implements DriverDAO {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Driver> findByCompanyId(int companyId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Driver> query = builder.createQuery(Driver.class);

        Root<Driver> root = query.from(Driver.class);
        query.where(builder.equal(Driver_.company_id, companyId));
        query.select(Driver);

        TypedQuery<Driver> typedQuery = manager.createQuery(query);
        return typedQuery.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(int driverId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Driver> query = builder.createQuery(Driver.class);



    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Driver> query = builder.createQuery(Driver.class);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Driver save(Driver entity) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Driver> query = builder.createQuery(Driver.class);


    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Driver driver) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Driver> query = builder.createQuery(Driver.class);
    }

}
