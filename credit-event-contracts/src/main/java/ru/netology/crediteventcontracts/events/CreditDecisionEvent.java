package ru.netology.crediteventcontracts.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditDecisionEvent {
    private Long id;
    private boolean approved;
}
