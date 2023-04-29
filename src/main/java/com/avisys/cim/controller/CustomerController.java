package com.avisys.cim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.Customer;
import com.avisys.cim.service.CustomerServiceImpl;


//Annotation to tell SC that this is a controller component with rest api endpoints.
@RestController
//mapping "/customer" uri with customer controller
@RequestMapping("/customer")
//Customer controller for handling all the CRUD operations related to customer.
public class CustomerController {

	//DI of customer service layer for managing transactions and accessing underlying repository layer.
    @Autowired
    private CustomerServiceImpl customerService;

    //API end-point for getting all the customers from the database.
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
    	List<Customer> customers= customerService.getAllCustomers();
    	//checking if the results are found after querying the database, and sending the appropriate http status-code as response.
    	if(customers!=null) {
    		return ResponseEntity.status(HttpStatus.OK).body(customers);
    	}else {
    		return ResponseEntity.notFound().build();
    	}
    }
    
    //API end-point for filtered list of customers based on search parameters sent with request.
    @GetMapping(params = {"firstName", "lastName", "mobileNumber"})
    public ResponseEntity<List<Customer>> filteredCustomers(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("mobileNumber") String mobileNumber) {
    	List<Customer> customers= customerService.searchCustomers(firstName,lastName,mobileNumber);
    	if(customers!=null) {
    		return ResponseEntity.status(HttpStatus.OK).body(customers);
    	}else {
    		return ResponseEntity.notFound().build();
    	}
    }
    
    //API end-point for filtered list of customers based on first-name sent with request.
    @GetMapping(params = "firstName")
    public ResponseEntity<List<Customer>> getCustomersByFirstName(@RequestParam String firstName) {
    	List<Customer> customers= customerService.getCustomersByFirstName(firstName);
    	if(customers!=null) {
    		return ResponseEntity.status(HttpStatus.OK).body(customers);
    	}else {
    		return ResponseEntity.notFound().build();
    	}
    }
    
    //API end-point for filtered list of customers based on last-name sent with request.
    @GetMapping(params = "lastName")
    public ResponseEntity<List<Customer>> getCustomersByLastName(@RequestParam String lastName) {
    	List<Customer> customers= customerService.getCustomersByLastName(lastName);
    	if(customers!=null) {
    		return ResponseEntity.status(HttpStatus.OK).body(customers);
    	}else {
    		return ResponseEntity.notFound().build();
    	}
    }
    
    //API end-point for filtered list of customer based on Mobile Number sent with request.
    @GetMapping(params = "mobileNumber")
    public ResponseEntity<Customer> getCustomersByMobileNumber(@RequestParam String mobileNumber) {
        Customer customer= customerService.getCustomerByMobileNumber(mobileNumber);
        if(customer!=null) {
    		return ResponseEntity.status(HttpStatus.OK).body(customer);
    	}else {
    		return ResponseEntity.notFound().build();
    	}
    }
}






