package lab03._02_one_to_many_bi;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor @Getter @Setter @ToString
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

    public Employee(Department department) {
        this.department = department;
        this.department.addEmployee(this);
    }
}
