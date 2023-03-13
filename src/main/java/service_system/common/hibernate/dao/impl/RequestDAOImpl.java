package main.java.service_system.common.hibernate.dao.impl;

import main.java.service_system.common.Status;
import main.java.service_system.common.hibernate.Request;
import main.java.service_system.common.hibernate.dao.RequestDAO;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by skeane on 3/2/2023.
 */
public class RequestDAOImpl extends GenericDAOImpl<Request> implements RequestDAO {

    /**
     * {@inheritDoc}
     */
    @Override
    public Request findByUserId(int userId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();;
        CriteriaQuery<Request> query = builder.createQuery(Request.class);

        return null;
    }

    /**
     * {@inheritDoc}
     */
    public void deleteByUserId(int userId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();;
        CriteriaQuery<Request> query = builder.createQuery(Request.class);


    }

    /**
     * {@inheritDoc}
     */
    public Status getStatus(int userId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();;
        CriteriaQuery<Request> query = builder.createQuery(Request.class);

        return null;
    }

    /**
     * {@inheritDoc}
     */
    public List<Request> getOpenRequests(int companyId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();;
        CriteriaQuery<Request> query = builder.createQuery(Request.class);

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Request save(Request entity) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();;
        CriteriaQuery<Request> query = builder.createQuery(Request.class);

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Request entity) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();;
        CriteriaQuery<Request> query = builder.createQuery(Request.class);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Request findById(Long id) {

        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();;
        CriteriaQuery<Request> query = builder.createQuery(Request.class);

        return null;
    }
}
