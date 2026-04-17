package ru.netology.creditapplicationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditApplicationRequest {
    private BigDecimal amount;
    private Integer term;
    private BigDecimal income;
    private BigDecimal currentCreditLoad;
}
