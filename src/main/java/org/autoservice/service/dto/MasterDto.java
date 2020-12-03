package org.autoservice.service.dto;

import java.util.HashSet;
import java.util.Set;

public class MasterDto {
    private long id;
    private String firstName;
    private String lastName;
    private Set<OrderDto> orders = new HashSet<>();

    public MasterDto() {

    }

    public MasterDto(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<OrderDto> getOrders() {
        return orders;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setOrders(Set<OrderDto> orders) {
        this.orders = orders;
    }
}
