package lab03._07_many_to_one_nested_bidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int roomNumber;
    @Column
    private String building;

    @OneToMany(mappedBy = "office")
    private List<Employee> employeeList;

    public void addEmployee(Employee emp) {
        emp.setOffice(this);
        this.employeeList.add(emp);
    }
}
