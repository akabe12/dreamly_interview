package main.java.service_system.common.hibernate.dao.impl;

import main.java.service_system.common.hibernate.User;
import main.java.service_system.common.hibernate.dao.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by skeane on 3/2/2023.
 */
public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {

    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer findIdByUsername(String username) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] getPassword(int userId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);

        Root<User> root = query.from(User.class);
        query.where(builder.equal(root.get("id"), userId));
        query.select(root.get("password"));

        TypedQuery typedQuery = manager.createQuery(query);
        return new byte[0]; // TODO Fix
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int userId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);


    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPassword(int userId, byte[] hashedPassword) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User save(User entity) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(User user) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaDelete<User> delete = builder.createCriteriaDelete(User.class);

        Root<User> root = delete.from(User.class);
        delete.where();

        manager.getTransaction().begin();
        manager.createQuery(delete).executeUpdate();
        manager.getTransaction().commit();

        logger.debug("User {} was removed from the database.", user.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer findByEmail(String email) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Integer> query = builder.createQuery(Integer.class);

        Root<User> root = query.from(User.class);
        query.where(builder.equal(root.get("email"), email));
        query.select(root.get("id"));

        TypedQuery<Integer> typedQuery = manager.createQuery(query);
        return typedQuery.getFirstResult();
    }

}
