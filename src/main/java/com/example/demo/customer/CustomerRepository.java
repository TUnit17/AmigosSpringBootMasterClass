package com.example.demo.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository // Spring creates instance of CustomerRepository (hides new keyword), makes CustomerRepository a bean that we can inject in multiple places,makes CustomerRepository a singleton that if used in multiple places it is all the same
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
