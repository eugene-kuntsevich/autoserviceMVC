package org.autoservice.service.validators;

import org.autoservice.service.dto.OrderDto;
import org.autoservice.service.exception.ValidatorException;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator implements Validator<OrderDto> {
    @Override
    public void isValid(OrderDto entity) throws ValidatorException {
        if (entity == null) {
            throw new ValidatorException("Order is null");
        }
    }
}
