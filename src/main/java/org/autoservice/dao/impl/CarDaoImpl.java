package org.autoservice.dao.impl;

import org.autoservice.dao.AbstractDao;
import org.autoservice.dao.api.CarDao;
import org.autoservice.model.entity.Car;
import org.autoservice.model.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class CarDaoImpl extends AbstractDao<Car> implements CarDao {
    public CarDaoImpl() {
        super(Car.class);
    }

    @Override
    public Car getCarByNumber(String number) {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
        Root<Car> rootEntry = criteriaQuery.from(Car.class);

        criteriaQuery.where(criteriaBuilder.equal(rootEntry.get("carNumber"), number));

        TypedQuery<Car> getCarByNumberQuery = sessionFactory.getCurrentSession().createQuery(criteriaQuery);

        return getCarByNumberQuery.getSingleResult();
    }

    @Override
    public List<Car> getCarsWithWarranty() {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
        Root<Car> rootEntry = criteriaQuery.from(Car.class);

        criteriaQuery.where(criteriaBuilder.lessThan(rootEntry.get("warranty"), new Timestamp(System.currentTimeMillis())));

        TypedQuery<Car> getCarsWithWarrantyQuery = sessionFactory.getCurrentSession().createQuery(criteriaQuery);

        return getCarsWithWarrantyQuery.getResultList();
    }

    @Override
    public List<Car> getCarsByStatusId(long id) {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
        Root<Car> rootEntry = criteriaQuery.from(Car.class);

        Subquery<Car> subQuery = criteriaQuery.subquery(Car.class);
        Root<Order> rootOrder = subQuery.from(Order.class);
        subQuery.select(rootOrder.get("car")).where(criteriaBuilder.equal(rootOrder.get("status").get("id"), id));

        criteriaQuery.select(rootEntry).where(criteriaBuilder.in(rootEntry).value(subQuery));

        TypedQuery<Car> getCarsByStatus = sessionFactory.getCurrentSession().createQuery(criteriaQuery);

        return getCarsByStatus.getResultList();
    }
}
