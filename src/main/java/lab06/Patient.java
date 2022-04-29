package lab06;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "patient")
@SecondaryTable(name = "address")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(table = "address")
    private String street;
    @Column(table = "address")
    private String zip;
    @Column(table = "address")
    private String city;
}
