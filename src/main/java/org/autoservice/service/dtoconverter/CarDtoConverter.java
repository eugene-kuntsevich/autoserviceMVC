package org.autoservice.service.dtoconverter;

import org.autoservice.model.entity.Car;
import org.autoservice.model.entity.Order;
import org.autoservice.model.entity.OrderStatus;
import org.autoservice.service.dto.CarDto;
import org.autoservice.service.dto.OrderStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CarDtoConverter extends AbstractDtoConverter<Car, CarDto> {
    private OrderStatusDtoConverter orderStatusDtoConverter;

    public CarDtoConverter() {
        super(Car.class, CarDto.class);
    }

    private Order getLastOrder(Set<Order> orders) {
        Order lastOrder = null;

        for (Order order: orders) {
            lastOrder = order;
        }

        return lastOrder;
    }

    @Override
    public CarDto convertToDto(Car entity) {
        CarDto carDto = super.convertToDto(entity);
        OrderStatus orderStatus = getLastOrder(entity.getOrders()).getStatus();
        OrderStatusDto orderStatusDto = orderStatusDtoConverter.convertToDto(orderStatus);
        carDto.setStatus(orderStatusDto);

        return carDto;
    }

    @Autowired
    public void setOrderStatusDtoConverter(OrderStatusDtoConverter orderStatusDtoConverter) {
        this.orderStatusDtoConverter = orderStatusDtoConverter;
    }
}
