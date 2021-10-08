package com.example.demo.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component // makes CustomerService a bean that we can inject in multiple places,makes CustomerService a singleton that if used in multiple places it is all the same
@Primary // this is my primary implementation
public class CustomerRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers(){
        // TODO connect to real db
        return Collections.singletonList(
                new Customer(1L, "TODO. Implement real db")
        );
    }
}
