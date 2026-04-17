package ru.netology.creditapplicationservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.creditapplicationservice.model.CreditStatus;
import java.math.BigDecimal;


@Entity
@Data
@Table(name = "credit_applications")
@AllArgsConstructor
@NoArgsConstructor
public class CreditApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false, precision = 38, scale = 2)
    private BigDecimal amount;

    @Column(name = "term", nullable = false)
    private Integer term;

    @Column(name = "income", nullable = false, precision = 38, scale = 2)
    private BigDecimal income;

    @Column(name = "current_credit_load", nullable = false, precision = 38, scale = 2)
    private BigDecimal currentCreditLoad;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "VARCHAR(20) DEFAULT 'PROCESSING'")
    private CreditStatus status = CreditStatus.PROCESSING;
}
