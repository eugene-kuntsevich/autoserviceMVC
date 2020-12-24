package org.autoservice.service.impl;

import org.autoservice.dao.api.OrderDao;
import org.autoservice.model.entity.Order;
import org.autoservice.service.AbstractService;
import org.autoservice.service.api.OrderService;
import org.autoservice.service.dto.OrderDto;
import org.autoservice.service.dto.OrderStatusDto;
import org.autoservice.service.dtoconverter.OrderDtoConverter;
import org.autoservice.service.exception.ValidatorException;
import org.autoservice.service.validators.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends AbstractService<Order, OrderDto> implements OrderService {
    private OrderDao orderDao;
    private OrderDtoConverter orderDtoConverter;
    private OrderValidator orderValidator;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, OrderDtoConverter orderDtoConverter, OrderValidator orderValidator) {
        super(orderDao, orderDtoConverter, orderValidator);

        this.orderDtoConverter = orderDtoConverter;
        this.orderDao = orderDao;
        this.orderValidator = orderValidator;
    }

    private boolean isStatusUpdateCorrect(long originalStatusId, long updateStatusId) {
        if (originalStatusId == 1 || originalStatusId == 4 && originalStatusId + 1 == updateStatusId) {
            return true;
        }

        if (originalStatusId == 2 && (updateStatusId == 3 || updateStatusId == 4)) {
            return true;
        }

        if (originalStatusId == 3 && updateStatusId == 2) {
            return true;
        }

        return false;
    }

    private OrderStatusDto getRightStatusForUpdate(Order original, OrderDto update) {
        OrderStatusDto result = orderDtoConverter.convertToDto(original).getStatus();

        if (isStatusUpdateCorrect(original.getStatus().getId(), update.getStatus().getId())) {
            result = update.getStatus();
        }

        return result;
    }

    @Override
    public void saveOrUpdate(OrderDto orderDto) throws ValidatorException {
        orderValidator.isValid(orderDto);
        Order order = orderDao.get(orderDto.getId());

        if (order != null) {
            orderDto.setStatus(getRightStatusForUpdate(order, orderDto));
        }

        Order updateOrder = orderDtoConverter.convertToEntity(orderDto);

        order.setMasters(updateOrder.getMasters());
        order.setClient(updateOrder.getClient());
        order.setCar(updateOrder.getCar());
        order.setStatus(updateOrder.getStatus());
    }
}
