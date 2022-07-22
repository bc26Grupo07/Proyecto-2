package pe.com.project.bank.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AffiliateActive {
    private Long id;
    private Long clientId;
    private String cardNumber;
    private double credit;
    private double balance;
}
