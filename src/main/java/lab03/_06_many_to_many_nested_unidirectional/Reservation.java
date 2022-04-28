package lab03._06_many_to_many_nested_unidirectional;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private LocalDate date;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "reservation_book", joinColumns = {@JoinColumn ( name =  "reservation_id")}, inverseJoinColumns = { @JoinColumn (name = "book_id")})
    private Book book;
}
