package com.example.demo.customer;

import java.util.Arrays;
import java.util.List;

// this @Repository annotation can be removed because the CustomerConfiguration handles the instantiating the CustomerFakeRepository
//@Repository(value="fake")
public class CustomerFakeRepository implements CustomerRepo{

    @Override
    public List<Customer> getCustomers(){
        return Arrays.asList(
                new Customer(1L, "James Bond", "password123"),
                new Customer(2L, "Tony Stark", "password456"),
                new Customer(3L, "Peter Parker", "password789"),
                new Customer(4L, "Roboob", "password789")
        );
    }
}
