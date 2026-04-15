package ru.netology.creditapplicationservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.creditapplicationservice.model.CreditStatus;
import java.math.BigDecimal;


@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "credits", schema = "public")
public class CreditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false, precision = 38, scale = 2)
    private BigDecimal amount;

    @Column(name = "term", nullable = false)
    private Integer term;

    @Column(name = "income", nullable = false, precision = 38, scale = 2)
    private BigDecimal income;

    @Column(name = "currentCreditLoad", nullable = false, precision = 38, scale = 2)
    private BigDecimal currentCreditLoad;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "VARCHAR(20) DEFAULT 'PROCESSING'")
    private CreditStatus status = CreditStatus.PROCESSING;
}
