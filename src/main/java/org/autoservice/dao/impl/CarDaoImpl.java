package org.autoservice.dao.impl;

import org.autoservice.dao.AbstractDao;
import org.autoservice.dao.api.CarDao;
import org.autoservice.model.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

        criteriaQuery.where(criteriaBuilder.notEqual(rootEntry.get("warranty"), null));

        TypedQuery<Car> getCarsWithWarrantyQuery = sessionFactory.getCurrentSession().createQuery(criteriaQuery);

        return getCarsWithWarrantyQuery.getResultList();
    }
}
