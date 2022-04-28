package lab05;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("dvd")
@Data @NoArgsConstructor
public class DVD extends Product{
    @Column
    private String genre;
}
