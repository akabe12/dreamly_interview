package main.java.service_system.common.hibernate.dao.impl;

import main.java.service_system.common.hibernate.Company;
import main.java.service_system.common.hibernate.dao.CompanyDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Created by skeane on 3/2/2023.
 */
public class CompanyDAOImpl extends GenericDAOImpl<Company> implements CompanyDAO {

    private static final Logger logger = LoggerFactory.getLogger(CompanyDAOImpl.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer findIdByUsername(String username) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<String> cQuery = builder.createQuery(String.class);

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] getPassword(int companyId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        //CriteriaQuery<byte[]> query = builder.createQuery(byte[]);

        return new byte[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPassword(int companyId, byte[] hashedPassword) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Company save(Company entity) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Company> query = builder.createQuery(Company.class);

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Company entity) {

    }

}
