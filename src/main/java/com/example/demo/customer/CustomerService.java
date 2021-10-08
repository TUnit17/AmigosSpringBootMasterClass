package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;


@Component // makes CustomerService a bean that we can inject in multiple places,makes CustomerService a singleton that if used in multiple places it is all the same
public class CustomerService {

    private final CustomerRepo customerRepo;

    // inject the CustomerFakeRepository here
    public CustomerService(@Qualifier("fake") CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


    List<Customer> getCustomers(){
        return customerRepo.getCustomers();
    }
}
