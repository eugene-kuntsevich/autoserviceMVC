package org.autoservice.service.impl;

import org.autoservice.dao.api.CarDao;
import org.autoservice.model.Car;
import org.autoservice.service.AbstractService;
import org.autoservice.service.api.CarService;
import org.autoservice.service.dto.CarDto;
import org.autoservice.service.dtoconverter.CarDtoConverter;
import org.autoservice.service.validators.CarValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl extends AbstractService<Car, CarDto> implements CarService {
    private CarDao carDao;
    private CarDtoConverter carDtoConverter;

    @Autowired
    public CarServiceImpl(CarDao carDao, CarDtoConverter carDtoConverter, CarValidator carValidator) {
        super(carDao, carDtoConverter, carValidator);

        this.carDao = carDao;
        this.carDtoConverter = carDtoConverter;
    }

    @Override
    public CarDto getCarByNumber(String number) {
        return carDtoConverter.convertToDto(carDao.getCarByNumber(number));
    }

    @Override
    public List<CarDto> getCarsWithWarranty() {
        return carDtoConverter.convertListToDto(carDao.getCarsWithWarranty());
    }

    @Override
    public List<CarDto> getCarsByStatusId(long id) {
        return carDtoConverter.convertListToDto(carDao.getCarsByStatusId(id));
    }
}
