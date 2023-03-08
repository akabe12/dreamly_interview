package org.example.hibernate.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.example.hibernate.dao.GenericDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * Created by skeane on 3/3/2023.
 */
@Repository
public abstract class GenericDAOImpl<T extends Serializable> implements GenericDAO<T> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected abstract Class<T> getEntityClass();

    public EntityManager getEntityManager() {
        return
    }

    @Override
    public T save(T entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public T findById(Long id) {
        return getSession().get(getEntityClass(), id);
    }

    @Override
    public List<T> findAll() {
        return getSession().createQuery("from " + getEntityClass().getName(), getEntityClass()).list();
    }
}