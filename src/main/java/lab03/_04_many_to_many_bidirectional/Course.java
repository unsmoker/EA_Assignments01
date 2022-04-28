package lab03._04_many_to_many_bidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String courseNumber;
    @Column
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST}, mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
}
