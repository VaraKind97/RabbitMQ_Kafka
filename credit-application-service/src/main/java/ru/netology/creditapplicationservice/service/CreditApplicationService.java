package ru.netology.creditapplicationservice.service;

import ru.netology.crediteventcontracts.events.CreditApplicationEvent;
import ru.netology.crediteventcontracts.events.CreditDecisionEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.netology.creditapplicationservice.dto.CreditApplicationRequest;
import ru.netology.creditapplicationservice.entity.CreditApplication;
import ru.netology.creditapplicationservice.model.CreditStatus;
import ru.netology.creditapplicationservice.repository.CreditRepository;

@Service
@RequiredArgsConstructor
public class CreditApplicationService {
    private final CreditRepository repository;
    private final KafkaTemplate<String, CreditApplicationEvent> kafkaTemplate;

    public Long createApplication(CreditApplicationRequest request){
        CreditApplication application = new CreditApplication();
        BeanUtils.copyProperties(request, application);
        application = repository.save(application);

        CreditApplicationEvent event = new CreditApplicationEvent(
                application.getId(),
                application.getAmount(),
                application.getTerm(),
                application.getIncome(),
                application.getCurrentCreditLoad()
        );
        kafkaTemplate.send("credit-applications", event);
        return application.getId();
    }

    public CreditStatus getStatusById(Long id){

        return repository.findById(id)
                .map(CreditApplication::getStatus)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @RabbitListener(queues = "credit-decisions")
    public void handleCreditDecision(CreditDecisionEvent event){
        repository.findById(event.getId())
                .ifPresent(application -> {
                    application.setStatus(event.isApproved() ? CreditStatus.APPROVED : CreditStatus.REJECTED);
                    repository.save(application);
                });
    }
}
