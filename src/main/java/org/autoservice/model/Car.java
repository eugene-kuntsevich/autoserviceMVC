package org.autoservice.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import java.sql.Timestamp;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "carNumber")
    private String carNumber;

    @Column(name = "warrantyDate", nullable = true)
    private Timestamp warrantyDate;

    @ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId")
    private Client client;

    public Car() {

    }

    public Car(long id, String carNumber, Timestamp warrantyDate, Client client) {
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

    public Client getClient() {
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

    public void setClient(Client client) {
        this.client = client;
    }
}
