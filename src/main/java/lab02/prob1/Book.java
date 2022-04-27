package lab02.prob1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter @Setter
@Entity
@ToString
@Table(name="Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String title;
    @Column
    private String ISBN;
    @Column
    private String author;
    @Column
    private double price;
    @Temporal(TemporalType.DATE)
    private Date publish_date;
    private void setId (long id){
        this.id = id;
    }
}
