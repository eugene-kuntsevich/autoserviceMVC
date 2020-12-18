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
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId")
    private Client client;

    @ManyToOne(targetEntity = Car.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "carId")
    private Car car;

    @ManyToOne(targetEntity = OrderStatus.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "statusId")
    private OrderStatus status;

    @ManyToMany(mappedBy = "orders")
    private Set<Master> masters = new HashSet<>();

    public Order() {

    }

    public Order(Client client, OrderStatus status, Car car) {
        this.client = client;
        this.status = status;
        this.car = car;
    }

    public long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Set<Master> getMasters() {
        return masters;
    }

    public Car getCar() {
        return car;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setMasters(Set<Master> masters) {
        this.masters = masters;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
