package com.avisys.cim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avisys.cim.Customer;
import com.avisys.cim.repository.CustomerRepository;

//annotation to tell SC that this is the service component.
@Service
//Annotation for telling the sc that every method of this class should managed under respective transaction.
@Transactional
public class CustomerServiceImpl {

	//DI of customer Repository layer for doing crud operations on database.
    @Autowired
    private CustomerRepository customerRepository;

    //Service Method for getting all customers.
    public List<Customer> getAllCustomers() {
    	return customerRepository.findAll();
    }
    
    //Service Method for filtering customers based on all 3 parameters.
    public List<Customer> searchCustomers(String firstName, String lastName, String mobileNumber) {
        return customerRepository.findByFirstNameAndLastNameAndMobileNumber(firstName, lastName, mobileNumber);
    }
    
    //Service Method for filtering customers based on first name.
	public List<Customer> getCustomersByFirstName(String firstName) {
		return customerRepository.findByFirstName(firstName);
	}
	//Service Method for filtering customers based on last name.
	public List<Customer> getCustomersByLastName(String lastName) {
		return customerRepository.findByLastName(lastName);
	}
	//Service Method for filtering customers based on mobile number.
	public Customer getCustomerByMobileNumber(String mobileNumber) {
		return customerRepository.findByMobileNumber(mobileNumber);
	}
}

