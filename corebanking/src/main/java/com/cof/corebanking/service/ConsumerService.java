package com.cof.corebanking.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.web.client.RestClientException;

import com.cof.corebanking.model.Customer;

public interface ConsumerService {

Customer createConsumerCustomer(Customer consumerCustomer) throws RestClientException, URISyntaxException;

Customer getConsumerCustomerById(int id) throws RestClientException, URISyntaxException;

void deleteConsumerById(int id);

void updateConsumerCustomer(Customer customer);

List<Customer> getAll() throws RestClientException, URISyntaxException;

}
