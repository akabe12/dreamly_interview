package main.java.service_system.common.hibernate.dao.impl;

import main.java.service_system.common.hibernate.RequestRecord;
import main.java.service_system.common.hibernate.dao.RequestRecordDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by skeane on 3/2/2023.
 */
public class RequestRecordDAOImpl extends GenericDAOImpl<RequestRecord> implements RequestRecordDAO {

    private static final Logger logger = LoggerFactory.getLogger(RequestRecordDAOImpl.class);

    /**
     * {@inheritDoc}
     */
    public void removeUser(int usedId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(RequestRecord.class);


    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeCompany(int companyId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(RequestRecord.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RequestRecord> getUserRecords(int userId) {

        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(RequestRecord.class);

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RequestRecord> getCompanyRecords(int companyId) {

        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(RequestRecord.class);

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RequestRecord save(RequestRecord entity) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(RequestRecord.class);

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(RequestRecord entity) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(RequestRecord.class);
    }

}
