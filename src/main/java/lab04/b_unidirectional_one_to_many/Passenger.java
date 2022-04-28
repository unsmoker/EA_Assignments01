package lab04.b_unidirectional_one_to_many;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "passanger")
    private List<Flight> flightList;
}
