package org.autoservice.dao;

import org.autoservice.dao.api.GenericDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractDao<T> implements GenericDao<T> {
    @Autowired
    protected SessionFactory sessionFactory;
    private Class<T> clazz;

    public AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T get(long id) {
        return sessionFactory.getCurrentSession().get(clazz, id);
    }

    @Override
    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public void save(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public List<T> list() {
        final String hql = "from " + clazz.getName();
        @SuppressWarnings("unchecked")
        TypedQuery<T> query = sessionFactory.getCurrentSession().createQuery(hql);

        return query.getResultList();
    }
}
