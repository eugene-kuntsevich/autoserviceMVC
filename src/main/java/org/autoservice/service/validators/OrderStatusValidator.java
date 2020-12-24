package org.autoservice.service.validators;

import org.autoservice.service.dto.OrderStatusDto;
import org.autoservice.service.exception.ValidatorException;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusValidator implements Validator<OrderStatusDto> {
    @Override
    public void isValid(OrderStatusDto entity) throws ValidatorException {
        if (entity != null) {
            if (entity.getName().equals("")) {
                throw new ValidatorException("Status has empty name");
            }
        } else {
            throw new ValidatorException("Status is null");
        }
    }
}