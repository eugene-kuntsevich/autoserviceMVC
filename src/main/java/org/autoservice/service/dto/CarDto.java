package org.autoservice.service.dto;

import java.sql.Timestamp;

public class CarDto {
    private long id;
    private String carNumber;
    private Timestamp warrantyDate;
    private ClientDto client;

    public CarDto() {

    }

    public CarDto(long id, String carNumber, Timestamp warrantyDate, ClientDto client) {
        this.id = id;
        this.carNumber = carNumber;
        this.warrantyDate = warrantyDate;
        this.client = client;
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

    public ClientDto getClient() {
        return client;
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

    public void setClient(ClientDto client) {
        this.client = client;
    }
}
