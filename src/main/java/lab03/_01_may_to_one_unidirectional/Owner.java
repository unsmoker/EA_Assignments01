package lab03._01_may_to_one_unidirectional;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String address;

    public Owner(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
