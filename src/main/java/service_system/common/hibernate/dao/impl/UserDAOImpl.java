package main.java.service_system.common.hibernate.dao.impl;

import main.java.service_system.common.hibernate.User;
import main.java.service_system.common.hibernate.dao.UserDAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by skeane on 3/2/2023.
 */
public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {

    /**
     * {@inheritDoc}
     */
    public byte[] getPassword(int userId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<String> cQuery = builder.createQuery(String.class);

        Root<User> root = cQuery.from(User.class);
        cQuery.where(builder.equal(root.get("id"), userId));
        cQuery.select(root.get("password"));

        TypedQuery typedQuery = manager.createQuery(cQuery);
        return new byte[0]; // TODO Fix
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int userId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<String> cQuery = builder.createQuery(String.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPassword(int userId, byte[] hashedPassword) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<String> cQuery = builder.createQuery(String.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User save(User entity) {

        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<String> cQuery = builder.createQuery(String.class);

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(User entity) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<String> cQuery = builder.createQuery(String.class);
    }

}
