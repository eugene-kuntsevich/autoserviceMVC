package org.autoservice.service.impl;

import org.autoservice.dao.api.OrderDao;
import org.autoservice.model.entity.Order;
import org.autoservice.service.AbstractService;
import org.autoservice.service.api.OrderService;
import org.autoservice.service.dto.OrderDto;
import org.autoservice.service.dtoconverter.OrderDtoConverter;
import org.autoservice.service.validators.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends AbstractService<Order, OrderDto> implements OrderService {

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, OrderDtoConverter orderDtoConverter, OrderValidator orderValidator) {
        super(orderDao, orderDtoConverter, orderValidator);
    }
}
