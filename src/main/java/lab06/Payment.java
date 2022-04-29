package lab06;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Payment {
    @Column
    private String paydate;
    @Column
    private double amount;
}
