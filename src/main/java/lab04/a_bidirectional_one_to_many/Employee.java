package lab04.a_bidirectional_one_to_many;


import lab03._02_one_to_many_bi.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "laptop_id")
    private Laptop laptop;

    public Employee(Laptop laptop) {
        this.laptop = laptop;
        laptop.addEmployee(this);
    }
}