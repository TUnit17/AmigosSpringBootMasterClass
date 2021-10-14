package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Bean // Spring will instantiate for me
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("Command line runner YEEEHAW!");
        };
    }

    @Bean
    // method to instantiate fake repo
    CustomerRepo customerRepo(){
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        return  new CustomerFakeRepository();
    }
}
