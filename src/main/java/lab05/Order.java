package lab05;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Data @NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDate data;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "order_id")
    private Collection<OrderLine> orderLines = new ArrayList<>();

    public boolean addOrderLine(OrderLine orderLine) {
        return this.orderLines.add(orderLine);
    }

    public boolean removeOrderLine(OrderLine orderLine) {
        return this.orderLines.remove(orderLine);
    }
}
