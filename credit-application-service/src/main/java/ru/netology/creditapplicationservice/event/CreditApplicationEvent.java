package ru.netology.creditapplicationservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditApplicationEvent {
    private Long id;
    private boolean approved;
}
