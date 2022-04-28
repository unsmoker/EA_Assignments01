package lab03._06_many_to_many_nested_unidirectional;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String isbn;

    @Column
    private String title;

    @Column
    private String author;
}
