package lab03._07_many_to_one_nested_bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor @Getter @Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int empoyeeNumber;
    @Column
    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="office_id")
    private Office office;

    public Employee(Department department) {
        this.department = department;
        this.department.addEmployee(this);
    }
    public Employee(Office office) {
        this.office = office;
        this.office.addEmployee(this);
    }
}
