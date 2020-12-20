package org.autoservice.dao;

import org.autoservice.dao.api.GenericDao;
import org.autoservice.model.AbstractPersistableEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractDao<T extends AbstractPersistableEntity> implements GenericDao<T> {
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
    public void saveOrUpdate(T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public List<T> list() {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> rootEntry = criteriaQuery.from(clazz);
        CriteriaQuery<T> list = criteriaQuery.select(rootEntry);

        TypedQuery<T> listQuery = sessionFactory.getCurrentSession().createQuery(list);

        return listQuery.getResultList();
    }
}
