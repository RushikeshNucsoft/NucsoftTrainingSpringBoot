package com.banksystem.management.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banksystem.management.dao.BankDao;
import com.banksystem.management.dao.CustomerDao;
import com.banksystem.management.entity.Customer;

@RestController
@RequestMapping("/CustomerCRUDApp")
public class CustomerCRUDController {
	
	@Autowired
	private CustomerDao customerDao;
	
	@PostMapping("/CreateCustomers")
	public Customer createCustomer(@RequestBody Customer customer) {
	    // Save the customer object in the database
	    Customer savedCustomer = customerDao.save(customer);
	    return savedCustomer;
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") int customerId) {
	    // Find the customer by ID in the database
	    Optional<Customer> optionalCustomer = customerDao.findById(customerId);
	    
	    if (optionalCustomer.isPresent()) {
	        // Customer record found, return it as a response
	        Customer customer = optionalCustomer.get();
	        return ResponseEntity.ok().body(customer);
	    } else {
	        // Customer record not found, return a not found response
	        return ResponseEntity.notFound().build();
	    }
	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") int customerId, @RequestBody Customer customerDetails) {
	    // Find the customer by ID in the database
	    Optional<Customer> optionalCustomer = customerDao.findById(customerId);
	    
	    if (optionalCustomer.isPresent()) {
	        // Customer record found, update its details
	        Customer customer = optionalCustomer.get();
	        customer.setCustomerName(customerDetails.getCustomerName());
	        customer.setCustomerPhone(customerDetails.getCustomerPhone());
	        customer.setCustomerAddress(customerDetails.getCustomerAddress());
	        customer.setBranchName(customerDetails.getBranchName());
	        customer.setBranchId(customerDetails.getBranchId());
	        customer.setBankName(customerDetails.getBankName());
	        customer.setBankId(customerDetails.getBankId());
	        customer.setLoanId(customerDetails.getLoanId());
	        
	        // Save the updated customer object in the database
	        Customer updatedCustomer = customerDao.save(customer);
	        return ResponseEntity.ok().body(updatedCustomer);
	    } else {
	        // Customer record not found, return a not found response
	        return ResponseEntity.notFound().build();
	    }
	}

	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable(value = "id") int customerId) {
	    // Find the customer by ID in the database
	    Optional<Customer> optionalCustomer = customerDao.findById(customerId);
	    
	    if (optionalCustomer.isPresent()) {
	        // Customer record found, delete it from the database
	    	customerDao.delete(optionalCustomer.get());
	        return ResponseEntity.noContent().build();
	    } else {
	        // Customer record not found, return a not found response
	        return ResponseEntity.notFound().build();
	    }
	}


}
