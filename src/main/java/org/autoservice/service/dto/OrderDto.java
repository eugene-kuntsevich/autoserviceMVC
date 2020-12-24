package org.autoservice.service.dto;

import org.autoservice.service.dto.CarDto;
import org.autoservice.service.dto.ClientDto;
import org.autoservice.service.dto.MasterDto;
import org.autoservice.service.dto.OrderStatusDto;

import java.util.HashSet;
import java.util.Set;

public class OrderDto {
    private long id;
    private ClientDto client;
    private OrderStatusDto status;
    private CarDto car;
    private Set<MasterDto> masters = new HashSet<>();

    public OrderDto() {

    }

    public OrderDto(long id, ClientDto client, OrderStatusDto status, CarDto car) {
        this.id = id;
        this.client = client;
        this.status = status;
        this.car = car;
    }

    public long getId() {
        return id;
    }

    public ClientDto getClient() {
        return client;
    }

    public OrderStatusDto getStatus() {
        return status;
    }

    public Set<MasterDto> getMasters() {
        return masters;
    }

    public CarDto getCar() {
        return car;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public void setStatus(OrderStatusDto status) {
        this.status = status;
    }

    public void setMasters(Set<MasterDto> masters) {
        this.masters = masters;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }
}
