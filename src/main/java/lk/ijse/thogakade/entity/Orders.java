package lk.ijse.thogakade.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "id")
    private String id;
    @CreationTimestamp
    private Timestamp date;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;


    public Orders() {
    }

    public Orders(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", customer=" + customer +
                '}';
    }
}
