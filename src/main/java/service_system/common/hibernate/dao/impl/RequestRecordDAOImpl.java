package main.java.service_system.common.hibernate.dao.impl;

import main.java.service_system.common.hibernate.RequestRecord;
import main.java.service_system.common.hibernate.dao.RequestRecordDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by skeane on 3/2/2023.
 */
public class RequestRecordDAOImpl extends GenericDAOImpl implements RequestRecordDAO {

    private static final Logger logger = LoggerFactory.getLogger(RequestRecordDAOImpl.class);

    /**
     * {@inheritDoc}
     */
    public void removeUser(int usedId) {
        EntityManager manager = ;
        CriteriaBuilder builder = new CriteriaBuilder(maneger);
        CriteriaQuery query = builder.createQuery(RequestRecord.class);


    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeCompany(int companyId) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RequestRecord> getUserRecords(int userId) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RequestRecord> getCompanyRecords(int companyId) {
        return null;
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
