package practice.assossiation_mapping.many_to_one.uni;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int year;
    private String model;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer owner;
}
