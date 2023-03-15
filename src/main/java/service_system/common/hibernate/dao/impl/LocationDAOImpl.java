package main.java.service_system.common.hibernate.dao.impl;

import main.java.service_system.common.hibernate.Location;
import main.java.service_system.common.hibernate.dao.LocationDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;

/**
 * Created by skeane on 3/2/2023.
 */
public class LocationDAOImpl extends GenericDAOImpl<Location> implements LocationDAO {

    private static final Logger logger = LoggerFactory.getLogger(LocationDAOImpl.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Location> findByUserId(int userId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Location> query = builder.createQuery(Location.class);

        Root<Location> root = query.from(Location.class);
        query.where(builder.equal(root.get("user_id"), userId));
        query.select(root);

        TypedQuery<Location> typedQuery = manager.createQuery(query);
        List<Location> result = typedQuery.getResultList();

        if (result == null) {
            return Collections.emptyList();
        } else {
            return result;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(int locationId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaDelete<Location> delete = builder.createCriteriaDelete(Location.class);

        Root<Location> root = delete.from(Location.class);
        delete.where(builder.equal(root.get("id"), locationId));

        manager.getTransaction().begin();
        manager.createQuery(delete).executeUpdate();
        manager.getTransaction().commit();

        logger.debug("Location {} was removed from the database.", locationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteByUserId(int userId) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaDelete<Location> delete = builder.createCriteriaDelete(Location.class);

        Root<Location> root = delete.from(Location.class);
        delete.where(builder.equal(root.get("user_id"), userId));

        manager.getTransaction().begin();
        manager.createQuery(delete).executeUpdate();
        manager.getTransaction().commit();

        logger.debug("Locations related to user {} have been removed from the database.", userId);
    }

}
