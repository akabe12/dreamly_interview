package main.java.service_system.common.hibernate.dao.impl;

import main.java.service_system.common.Status;
import main.java.service_system.common.hibernate.Request;
import main.java.service_system.common.hibernate.dao.RequestDAO;

import java.util.List;

/**
 * Created by skeane on 3/2/2023.
 */
public class RequestDAOImpl extends GenericDAOImpl implements RequestDAO {

    /**
     * {@inheritDoc}
     */
    @Override
    public Request findByUserId(int userId) {

    }

    /**
     * {@inheritDoc}
     */
    public void deleteByUserId(int userId) {

    }

    /**
     * {@inheritDoc}
     */
    public Status getStatus(int userId) {

    }

    /**
     * {@inheritDoc}
     */
    public List<Request> getOpenRequests(int companyId) {

    }

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
}
