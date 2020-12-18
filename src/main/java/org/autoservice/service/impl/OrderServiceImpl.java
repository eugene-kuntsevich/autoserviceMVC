package org.autoservice.service.impl;

import org.autoservice.dao.api.OrderDao;
import org.autoservice.model.Order;
import org.autoservice.service.AbstractService;
import org.autoservice.service.api.OrderService;
import org.autoservice.service.dto.OrderDto;
import org.autoservice.service.dtoconverter.OrderDtoConverter;
import org.autoservice.service.validators.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends AbstractService<Order, OrderDto> implements OrderService {
    private OrderDao orderDao;
    private OrderDtoConverter orderDtoConverter;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, OrderDtoConverter orderDtoConverter, OrderValidator orderValidator) {
        super(orderDao, orderDtoConverter, orderValidator);

        this.orderDao = orderDao;
        this.orderDtoConverter = orderDtoConverter;
    }

    @Override
    public List<OrderDto> getOrdersByCarId(long id) {
        return orderDtoConverter.convertListToDto(orderDao.getOrdersByCarId(id));
    }

    @Override
    public List<OrderDto> getOrdersByStatusId(long id) {
        return orderDtoConverter.convertListToDto(orderDao.getOrdersByStatusId(id));
    }
}
