package main.java.service_system.common.hibernate.dao.impl;

import service_system.hibernate.User;
import service_system.hibernate.dao.UserDAO;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import javax.persistence.EntityManager;

/**
 * Created by skeane on 3/2/2023.
 */
public class UserDAOImpl implements UserDAO {

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
}
