package lab03._07_many_to_one_nested_bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @OneToMany(mappedBy = "department", cascade = {CascadeType.PERSIST})
    private List<Employee> employees = new LinkedList<>();

    public void addEmployee(Employee emp) {
        this.employees.add(emp);
    }
    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(this.employees);
    }
    private void setId(int id) {
        this.id = id;
    }
}
