package org.autoservice.service.api;

import org.autoservice.model.entity.Car;
import org.autoservice.service.dto.CarDto;

import java.util.List;

public interface CarService extends GenericService<Car, CarDto> {
    CarDto getCarByNumber(String number);
    List<CarDto> getCarsWithWarranty();
    List<CarDto> getCarsByStatusId(long id);
    void setWarranty(long id);
}
