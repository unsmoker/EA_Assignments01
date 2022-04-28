package lab04.c_unidirectional_one_to_many;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @OneToMany(mappedBy = "school")
//    @MapKey(name ="id")
//    private Map<Integer, Student> studentMap = new HashMap<>();
}
