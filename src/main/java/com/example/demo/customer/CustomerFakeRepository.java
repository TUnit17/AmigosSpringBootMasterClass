package com.example.demo.customer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

// this @Repository annotation can be removed because the CustomerConfiguration handles the instantiating the CustomerFakeRepository
//@Repository(value="fake")
public class CustomerFakeRepository implements CustomerRepo{

    @Override
    public List<Customer> getCustomers(){
        return Arrays.asList(
                new Customer(1L, "James Bond"),
                new Customer(2L, "Tony Stark"),
                new Customer(3L, "Peter Parker")
        );
    }
}
