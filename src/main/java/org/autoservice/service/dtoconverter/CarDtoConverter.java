package org.autoservice.service.dtoconverter;

import org.autoservice.model.Car;
import org.autoservice.service.dto.CarDto;
import org.springframework.stereotype.Service;

@Service
public class CarDtoConverter extends AbstractDtoConverter<Car, CarDto> {
    public CarDtoConverter() {
        super(Car.class, CarDto.class);
    }
}
