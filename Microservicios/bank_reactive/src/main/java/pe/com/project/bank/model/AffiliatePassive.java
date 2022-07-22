package pe.com.project.bank.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AffiliatePassive {
    private Long id;
    private Long clientId;
    private String accountType;
    private double balance;
    private String accountNumber;
    private String headLine;
    private String signature;
    private boolean commission;
    private double movementQuantity;
    private String clientType;
}
