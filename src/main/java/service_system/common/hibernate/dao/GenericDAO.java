package main.java.service_system.common.hibernate.dao;

import java.util.List;

/**
 * Generic DAO class to base all database query classes on.
 *
 * Created by skeane on 3/3/2023.
 */
public interface GenericDAO<T> {

    void setClazz(final Class<T> clazzToSet);

    T findOne(final long id);

    List<T> findAll();

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);

}
