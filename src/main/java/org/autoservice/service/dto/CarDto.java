package org.autoservice.service.dto;

import java.sql.Timestamp;

public class CarDto {
    private long id;
    private String carNumber;
    private Timestamp warrantyDate;

    public CarDto() {

    }

    public CarDto(long id, String carNumber, Timestamp warrantyDate) {
        this.id = id;
        this.carNumber = carNumber;
        this.warrantyDate = warrantyDate;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public void setWarrantyDate(Timestamp warrantyDate) {
        this.warrantyDate = warrantyDate;
    }
}
