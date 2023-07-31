package com.cof.corebanking.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.cof.corebanking.model.Customer;
import com.cof.corebanking.service.ConsumerService;

@RestController
@RequestMapping("/consumer-api")
public class ConsumerController {

	@Autowired
	ConsumerService consumerService;
	
	@PostMapping
	public Customer createConsumerCustomer(@RequestBody Customer consumerCustomer) throws RestClientException, URISyntaxException
	{
		return consumerService.createConsumerCustomer(consumerCustomer);
		
	}
	
	@GetMapping("/{id}")
	public Customer getConsumerCustomerById(@PathVariable("id")int id) throws RestClientException, URISyntaxException
	{
		return consumerService.getConsumerCustomerById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteConsumerCustomerById(@PathVariable("id")int id)
	{
		 consumerService.deleteConsumerById(id);
		
	}
	@PutMapping
	public void updateConsumerCustomer(@RequestBody Customer customer)
	{
		consumerService.updateConsumerCustomer(customer);
		
	}
	@GetMapping
	public List<Customer>getAll() throws RestClientException, URISyntaxException
	{
		return consumerService.getAll();
		
	}
	
}
