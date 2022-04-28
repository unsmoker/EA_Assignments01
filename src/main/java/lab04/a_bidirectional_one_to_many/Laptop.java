package lab04.a_bidirectional_one_to_many;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table
@EqualsAndHashCode
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String brand;
    @Column
    private String type;

    @OneToMany(mappedBy = "laptop", cascade = {CascadeType.PERSIST})
    private Set<Employee> employeeSet;

    public void addEmployee(Employee emp) {
        emp.setLaptop(this);
        this.employeeSet.add(emp);
    }
    public void removeEmployee(Employee emp) {
        emp.setLaptop(null);
        this.employeeSet.remove(emp);
    }
}
