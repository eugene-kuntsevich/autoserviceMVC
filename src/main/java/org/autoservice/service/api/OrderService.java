package org.autoservice.service.api;

import org.autoservice.model.Order;
import org.autoservice.service.dto.OrderDto;

import java.util.List;

public interface OrderService extends GenericService<Order, OrderDto>{
    List<OrderDto> getOrdersByCarId(long id);
    List<OrderDto> getOrdersByStatusId(long id);
}
