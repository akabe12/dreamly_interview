package org.example.hibernate.dao;

import java.util.List;

/**
 * Generic DAO class to base all database query classes on.
 *
 * Created by skeane on 3/3/2023.
 */
public interface GenericDAO<T> {

    T save(T entity);

    void delete(T entity);

    T findById(Long id);

    List<T> findAll();
}
