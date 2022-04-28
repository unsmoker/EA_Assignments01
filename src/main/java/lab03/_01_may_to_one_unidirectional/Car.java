package lab03._01_may_to_one_unidirectional;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String model;
    @Column
    private String brand;
    @Column
    private int year;
    @Column
    private double price;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="owner_id")
    private Owner owner;


    public Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

}