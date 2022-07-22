package pe.com.project.bank.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Affiliate {
    private Long id;
    private Long clientId;
    private Long productId;
}
