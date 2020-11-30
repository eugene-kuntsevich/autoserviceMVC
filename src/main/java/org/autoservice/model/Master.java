package org.autoservice.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "master")
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "master_order",
            joinColumns = { @JoinColumn(name = "masterId") },
            inverseJoinColumns = { @JoinColumn(name = "orderId") }
    )
    private Set<Order> orders = new HashSet<>();

    public Master() {

    }

    public Master(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
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

    public void setId(long id) {
        this.id = id;
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
