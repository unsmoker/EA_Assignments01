package lab06;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String doctortype;
    private String firstName;
    private String lastName;
}
