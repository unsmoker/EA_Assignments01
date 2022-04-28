package lab05;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("book")
@Data @NoArgsConstructor
public class Book extends Product{
    @Column
    private String title;
}
