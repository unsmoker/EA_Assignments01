package lab04.b_unidirectional_one_to_many;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String flightNumber;

    @Column
    private String from;

    @Column
    private String to;

    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "passanger_id")
    private Passenger passengers;
}
