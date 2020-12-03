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
public class OrderDtoConverter extends AbstractDtoConverter<Order, OrderDto>{
    @Autowired
    private MasterDtoConverter masterDtoConverter;

    public OrderDtoConverter() {
        super(Order.class, OrderDto.class);
    }

    @Override
    public OrderDto convertToDto(Order entity) {
        OrderDto orderDto = super.convertToDto(entity);
        Set<Master> masters = entity.getMasters();
        Set<MasterDto> masterDtos = new HashSet<>();

        for(Master master : masters) {
            master.setOrders(new HashSet<>());
            MasterDto masterDto = masterDtoConverter.convertToDto(master);
            masterDtos.add(new MasterDto(masterDto.getId(), masterDto.getFirstName(), masterDto.getLastName()));
        }

        orderDto.setMasters(masterDtos);

        return orderDto;
    }
}
