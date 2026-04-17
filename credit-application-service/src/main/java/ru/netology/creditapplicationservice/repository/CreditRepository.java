package ru.netology.creditapplicationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.creditapplicationservice.entity.CreditApplication;

@Repository
public interface CreditRepository extends JpaRepository<CreditApplication, Long> {
}
