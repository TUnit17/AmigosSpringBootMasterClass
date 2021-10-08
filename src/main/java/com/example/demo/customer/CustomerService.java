package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service // this is functionally the same as @Component, but just signifies that it is a Service Component
//@Component // makes CustomerService a bean that we can inject in multiple places,makes CustomerService a singleton that if used in multiple places it is all the same
public class CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


    List<Customer> getCustomers(){
        return customerRepo.getCustomers();
    }
}
