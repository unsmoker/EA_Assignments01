package lab02.prob1;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
@Table(name="Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column
    private String title;
    @Column
    private String ISBN;
    @Column
    private String author;
    @Column
    private double price;
    @Column
    private LocalDate publishDate;

    private void setId (long id){
        this.id = id;
    }
}
