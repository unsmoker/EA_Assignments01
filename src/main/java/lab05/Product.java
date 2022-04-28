package lab05;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.STRING)
@Data @NoArgsConstructor
public  class Product {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;
}
