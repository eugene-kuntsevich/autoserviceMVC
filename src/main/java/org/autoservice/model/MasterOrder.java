package org.autoservice.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "master_order")
public class MasterOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne(targetEntity = Master.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "masterId")
    private Master master;

    public MasterOrder() {

    }

    public MasterOrder(long id, Order order, Master master) {
        this.id = id;
        this.order = order;
        this.master = master;
    }

    public long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Master getMaster() {
        return master;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setMaster(Master master) {
        this.master = master;
    }
}
