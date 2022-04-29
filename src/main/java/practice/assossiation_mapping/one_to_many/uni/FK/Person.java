package practice.assossiation_mapping.one_to_many.uni;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    //Foreighn key model
    @OneToMany
    @JoinColumn(name = "person_id")
    private Collection<Car> cars = new ArrayList<>();
}
