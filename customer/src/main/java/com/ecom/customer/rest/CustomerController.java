package com.ecom.customer.rest;

import com.ecom.customer.models.Customer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/customer")
public class CustomerController {

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getCustomers(){
        final List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("C1", "GE", "New York, US"));
        customerList.add(new Customer("C2", "Reynolds", "New York, US"));
        customerList.add(new Customer("C3", "Thomson Reuters", "Toronto, Canada"));

        return ResponseEntity.ok(customerList);
    }
}
