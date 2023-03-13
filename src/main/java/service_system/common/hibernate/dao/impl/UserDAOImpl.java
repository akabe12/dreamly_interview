package main.java.service_system.common.hibernate.dao.impl;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import main.java.service_system.common.hibernate.User;
import main.java.service_system.common.hibernate.dao.UserDAO;

import javax.persistence.EntityManager;

/**
 * Created by skeane on 3/2/2023.
 */
public class UserDAOImpl extends GenericDAOImpl implements UserDAO {

    /**
     * {@inheritDoc}
     */
    byte[] String getPassword(int userId) {
        EntityManager manager = ;
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<String> cQuery = builder.createQuery(String.class);

        Root<User> root = cQuery.from(User.class);
        cQuery.where(builder.equal(User_.id, userId));
        cQuery.select(User_.password);

        Query query = manager.createQuery(cQuery);
        return query.getSingleResult(); // TODO Fix
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int userId) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] getPassword(int userId) {
        return new byte[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPassword(int userId, byte[] hashedPassword) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User save(User entity) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(User entity) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User findById(Long id) {
        return null;
    }
}
