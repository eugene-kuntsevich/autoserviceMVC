package org.autoservice.service.dtoconverter;

import org.autoservice.model.entity.OrderStatus;
import org.autoservice.service.dto.OrderStatusDto;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusDtoConverter extends AbstractDtoConverter<OrderStatus, OrderStatusDto> {
    public OrderStatusDtoConverter() {
        super(OrderStatus.class, OrderStatusDto.class);
    }
}
