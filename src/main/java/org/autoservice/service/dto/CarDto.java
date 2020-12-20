package org.autoservice.service.dto;

import java.sql.Timestamp;

public class CarDto {
    private long id;
    private String carNumber;
    private Timestamp warrantyDate;
    private OrderStatusDto status;

    public CarDto() {

    }

    public CarDto(long id, String carNumber, Timestamp warrantyDate, OrderStatusDto status) {
        this.id = id;
        this.carNumber = carNumber;
        this.warrantyDate = warrantyDate;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public Timestamp getWarrantyDate() {
        return warrantyDate;
    }

    public OrderStatusDto getStatus() {
        return status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public void setWarrantyDate(Timestamp warrantyDate) {
        this.warrantyDate = warrantyDate;
    }

    public void setStatus(OrderStatusDto status) {
        this.status = status;
    }
}
