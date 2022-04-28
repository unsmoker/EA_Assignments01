package lab03._06_many_to_many_nested_unidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "customer_reservation",
    joinColumns = {@JoinColumn(name = "customer_id")}, inverseJoinColumns = {@JoinColumn(name = "reservation_id")})
    private List<Reservation> reservationList = new ArrayList<>();
}
