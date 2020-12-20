package org.autoservice.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "carNumber")
    private String carNumber;

    @Column(name = "warrantyDate")
    private Timestamp warrantyDate;

    @OneToMany(mappedBy = "car")
    private Set<Order> orders;

    public Car() {

    }

    public Car(String carNumber, Timestamp warrantyDate, Set<Order> orders) {
        this.carNumber = carNumber;
        this.warrantyDate = warrantyDate;
        this.orders = orders;
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

    public Set<Order> getOrders() {
        return orders;
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

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
