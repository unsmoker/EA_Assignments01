package lab03._02_one_to_many_bi;

import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @OneToMany(mappedBy = "department", cascade = {CascadeType.PERSIST})
    private List<Employee> employees = new LinkedList<>();

    public boolean addEmployee(Employee emp) {
        emp.setDepartment(this);
        return this.employees.add(emp);
    }
    public boolean removeEmployee (Employee emp) {
        emp.setDepartment(null);
        return this.employees.remove(emp);
    }
    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(this.employees);
    }
    private void setId(int id) {
        this.id = id;
    }
}
