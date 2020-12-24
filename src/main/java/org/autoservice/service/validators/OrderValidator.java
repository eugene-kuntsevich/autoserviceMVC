package org.autoservice.service.validators;

import org.autoservice.service.dto.MasterDto;
import org.autoservice.service.dto.OrderDto;
import org.autoservice.service.exception.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator implements Validator<OrderDto> {
    private ClientValidator clientValidator;
    private OrderStatusValidator orderStatusValidator;
    private CarValidator carValidator;
    private MasterValidator masterValidator;

    @Autowired
    public OrderValidator(ClientValidator clientValidator, OrderStatusValidator orderStatusValidator, CarValidator carValidator, MasterValidator masterValidator) {
        this.clientValidator = clientValidator;
        this.orderStatusValidator = orderStatusValidator;
        this.carValidator = carValidator;
        this.masterValidator = masterValidator;
    }

    @Override
    public void isValid(OrderDto entity) throws ValidatorException {
        if (entity != null) {
            clientValidator.isValid(entity.getClient());
            orderStatusValidator.isValid(entity.getStatus());
            carValidator.isValid(entity.getCar());

            for (MasterDto master : entity.getMasters()) {
                masterValidator.isValid(master);
            }
        } else {
            throw new ValidatorException("Order is null");
        }
    }
}
