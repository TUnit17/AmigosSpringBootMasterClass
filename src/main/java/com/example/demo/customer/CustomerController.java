package com.example.demo.customer;

import com.example.demo.DemoApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// REST LAYER
@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController() {
        // this is bad bc customer service can only be used once in this class
        // but according to the diagram, customerService may be needed elsewhere
        // also hard to test
        customerService = new CustomerService();
    }

    @GetMapping
    Customer getCustomer(){
        return customerService.getCustomer();
    }

}
