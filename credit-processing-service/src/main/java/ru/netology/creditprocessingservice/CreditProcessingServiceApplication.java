package ru.netology.creditprocessingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication
public class CreditProcessingServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CreditProcessingServiceApplication.class, args);
    }

}
