package lab03._04_many_to_many_bidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "student_courses",
                joinColumns = {@JoinColumn(name = "student_id")},
                inverseJoinColumns = {@JoinColumn (name = "course_id")})
    private List<Course> courses = new ArrayList<>();
}
