package lab05;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cd")
@Data @NoArgsConstructor
public class CD extends Product{
    @Column
    private String artist;
}
