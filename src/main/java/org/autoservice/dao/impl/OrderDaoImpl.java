package org.autoservice.dao.impl;

import org.autoservice.dao.AbstractDao;
import org.autoservice.dao.api.OrderDao;
import org.autoservice.model.Car;
import org.autoservice.model.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    public OrderDaoImpl() {
        super(Order.class);
    }

    @Override
    public List<Order> getOrdersByCarId(long id) {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
        Root<Order> rootEntry = criteriaQuery.from(Order.class);

        criteriaQuery.where(criteriaBuilder.equal(rootEntry.get("car").get("id"), id));

        TypedQuery<Order> getOrdersByCar = sessionFactory.getCurrentSession().createQuery(criteriaQuery);

        return getOrdersByCar.getResultList();
    }

    @Override
    public List<Order> getOrdersByStatusId(long id) {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
        Root<Order> rootEntry = criteriaQuery.from(Order.class);

        criteriaQuery.where(criteriaBuilder.equal(rootEntry.get("status").get("id"), id));

        TypedQuery<Order> getOrdersByCar = sessionFactory.getCurrentSession().createQuery(criteriaQuery);

        return getOrdersByCar.getResultList();
    }
}
