package lab06;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor
@Table(name = "Appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String appdate;
    @Embedded
    private Payment payment;
    @OneToOne
    private Patient patient;
    @OneToOne
    private Doctor doctor;
}
