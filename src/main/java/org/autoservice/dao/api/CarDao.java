package org.autoservice.dao.api;

import org.autoservice.model.Car;

import java.util.List;

public interface CarDao extends GenericDao<Car> {
    Car getCarByNumber(String number);
    List<Car> getCarsWithWarranty();
    List<Car> getCarsByStatusId(long id);
}
