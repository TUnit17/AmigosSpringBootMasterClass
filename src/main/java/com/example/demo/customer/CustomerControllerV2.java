package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RequestMapping(path="api/v2/customers")
// REST LAYER
@RestController // allows http requests to be sent thru annotations like @GetMapping
public class CustomerControllerV2 {

    private final CustomerService customerService;

    @Autowired
    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping(path ="{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id){
        return customerService.getCustomer(id);
    }

    // @Valid == checks to make sure the request is valid
    @PostMapping
    void createNewCustomer(@Valid @RequestBody Customer customer){
        // NOTE: doesn't actually add an entry
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }

    // NOTE: doesnt actually delete an entry
    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("DELETE REQUEST FOR CUSTOMER ID: " + id);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer){
        System.out.println("PUT REQUEST...");
        System.out.println(customer);
    }
}
