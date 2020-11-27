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

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId")
    private Client client;

    @ManyToOne(targetEntity = OrderStatus.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "statusId")
    private OrderStatus status;

    public Order() {

    }

    public Order(long id, Client client, OrderStatus status) {
        this.id = id;
        this.client = client;
        this.status = status;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
