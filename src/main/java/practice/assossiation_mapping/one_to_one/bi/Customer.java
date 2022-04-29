package practice.assossiation_mapping.one_to_one.uni;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;

    /**
     * it is same as manytoone with unique constraint
     */
    @OneToOne
    private Address address;
}
