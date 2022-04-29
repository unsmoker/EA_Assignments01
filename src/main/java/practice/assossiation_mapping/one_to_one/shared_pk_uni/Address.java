package practice.assossiation_mapping.one_to_one.shared_pk;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Address {
    @Id
    private Integer id;
    private String street;
    private String suiteOrApt;
    private String city;
    private String state;
    private int zip;
}
