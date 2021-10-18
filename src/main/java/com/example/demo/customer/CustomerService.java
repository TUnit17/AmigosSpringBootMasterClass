package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;


@Service // this is functionally the same as @Component, but just signifies that it is a Service Component
@AllArgsConstructor // replaces the constructor below
@Slf4j
public class CustomerService {

    // THIS DEPENDENCY INJECTION IS NO LONGER NEEDED
    //private final CustomerRepo customerRepo;

    private final CustomerRepository customerRepository;

//    @Autowired
//    public CustomerService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    List<Customer> getCustomers(){
        log.info("getCustomer was called");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () ->{
                            NotFoundException notFoundException = new NotFoundException(
                                    "customer not found with id: " + id);
                            log.info("error in getting customer {}",id);
                            return notFoundException;
                        }
                );
    }
}
