package org.autoservice.service.dto;

import java.util.HashSet;
import java.util.Set;

public class OrderDto {
    private long id;
    private ClientDto client;
    private OrderStatusDto status;
    private Set<MasterDto> masters = new HashSet<>();

    public OrderDto() {

    }

    public OrderDto(long id, ClientDto client, OrderStatusDto status) {
        this.id = id;
        this.client = client;
        this.status = status;
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
}
