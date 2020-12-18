package org.autoservice.service.dtoconverter;

import org.autoservice.model.Master;
import org.autoservice.model.Order;
import org.autoservice.service.dto.MasterDto;
import org.autoservice.service.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MasterDtoConverter extends AbstractDtoConverter<Master, MasterDto> {
    private OrderDtoConverter orderDtoConverter;

    public MasterDtoConverter() {
        super(Master.class, MasterDto.class);
    }

    @Override
    public MasterDto convertToDto(Master entity) {
        MasterDto masterDto = super.convertToDto(entity);
        Set<Order> orders = entity.getOrders();
        Set<OrderDto> orderDtos = new HashSet<>();

        for(Order order : orders) {
            order.setMasters(new HashSet<>());
            OrderDto orderDto = orderDtoConverter.convertToDto(order);
            orderDtos.add(new OrderDto(orderDto.getId(), orderDto.getClient(), orderDto.getStatus(), orderDto.getCar()));
        }

        masterDto.setOrders(orderDtos);

        return masterDto;
    }

    @Autowired
    public void setOrderDtoConverter(OrderDtoConverter orderDtoConverter) {
        this.orderDtoConverter = orderDtoConverter;
    }
}
