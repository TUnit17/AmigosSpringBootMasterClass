package com.example.demo.customer;

import java.util.Collections;
import java.util.List;


// both annotations can be removed because they are now handled by the CustomerConfiguration customerRepo file
//@Repository // Spring creates instance of CustomerRepository (hides new keyword), makes CustomerRepository a bean that we can inject in multiple places,makes CustomerRepository a singleton that if used in multiple places it is all the same
//@Primary // this is my primary implementation
public class CustomerRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers(){
        // TODO connect to real db
        return Collections.singletonList(
                new Customer(1L, "TODO. Implement real db", "todo password")
        );
    }
}
