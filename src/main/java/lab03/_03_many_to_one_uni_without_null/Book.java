package lab03._03_many_to_one_uni_without_null;

import lombok.Data;

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

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="publisher_id")
    private Publisher publisher;
    private void setId (long id){
        this.id = id;
    }
}
