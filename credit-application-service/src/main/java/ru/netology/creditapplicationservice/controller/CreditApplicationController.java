package ru.netology.creditapplicationservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.netology.creditapplicationservice.dto.CreditRequest;
import ru.netology.creditapplicationservice.dto.CreditResponse;
import ru.netology.creditapplicationservice.model.CreditStatus;
import ru.netology.creditapplicationservice.service.CreditApplicationService;

@RestController
@RequestMapping("/api/credit-applications")
@RequiredArgsConstructor
public class CreditApplicationController {

    private final CreditApplicationService service;

    @GetMapping("/{id}/status")
    public CreditStatus getStatusById(@PathVariable Long id) {
        return service.getStatusById(id);
    }

    @PostMapping
    public CreditResponse createCredit(@RequestBody CreditRequest request) {
        return service.createApplication(request);
    }
}
