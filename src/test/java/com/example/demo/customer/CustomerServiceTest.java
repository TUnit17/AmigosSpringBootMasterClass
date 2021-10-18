package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    private CustomerService underTest;
    @Autowired // very important in order to connect to the db
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }


    @Test
    void getCustomers() {
        // given
        Customer cust1 = new Customer(1L, "cust1", "123", "cust1@mail.com");
        Customer cust2 = new Customer(2L, "cust2", "123", "cust2@mail.com");
        customerRepository.saveAll(Arrays.asList(cust1, cust2));
        // when
        List<Customer> customers = underTest.getCustomers();
        // then
        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
        // given
        Customer cust2 = new Customer(2L, "cust2", "123", "cust2@mail.com");
        customerRepository.save(cust2);
        // when
        Customer actual = underTest.getCustomer(2L);
        // then
        assertEquals(2L,actual.getId());
        assertEquals("cust2",actual.getName());
        assertEquals("123",actual.getPassword());
        assertEquals("cust2@mail.com",actual.getEmail());
    }
}
