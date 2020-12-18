package org.autoservice.service.validators;

import org.autoservice.service.dto.CarDto;
import org.autoservice.service.exception.ValidatorException;
import org.springframework.stereotype.Component;

@Component
public class CarValidator implements Validator<CarDto> {
    @Override
    public void isValid(CarDto entity) throws ValidatorException {
        if (entity != null) {
            if (entity.getCarNumber().equals("")) {
                throw new ValidatorException("Car number is empty");
            }
        } else {
            throw new ValidatorException("Car is null");
        }
    }
}
