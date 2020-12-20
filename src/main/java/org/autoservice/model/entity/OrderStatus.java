package org.autoservice.model.entity;

import org.autoservice.model.AbstractPersistableEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "order_status")
public class OrderStatus extends AbstractPersistableEntity {
    @Column(name = "name")
    private String name;

    public OrderStatus() {

    }

    public OrderStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
