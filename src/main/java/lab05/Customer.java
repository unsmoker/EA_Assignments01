package lab05;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST})
    private Collection<Order> orders = new ArrayList<>();

    public boolean addOrder(Order order) {
        order.setCustomer(this);
        return this.orders.add(order);
    }

    public boolean removeOrder(Order order) {
        order.setCustomer(null);
        return this.orders.remove(order);
    }
}
