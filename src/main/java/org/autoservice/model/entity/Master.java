package org.autoservice.model.entity;

import org.autoservice.model.AbstractPersistableEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "master")
public class Master extends AbstractPersistableEntity {
    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "master_order",
            joinColumns = { @JoinColumn(name = "masterId") },
            inverseJoinColumns = { @JoinColumn(name = "orderId") }
    )
    private Set<Order> orders = new HashSet<>();

    public Master() {

    }

    public Master(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
