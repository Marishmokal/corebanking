package com.cof.corebanking.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.cof.corebanking.model.Customer;
@Service
public class ConsumerServiceImpl implements ConsumerService {

	RestTemplate rest=new RestTemplate();
	@Value("${baseUrl}")
	String url;
	
	

	@Override
	public Customer createConsumerCustomer(Customer consumerCustomer) throws RestClientException, URISyntaxException {
		return rest.postForObject(new URI(url), consumerCustomer,Customer.class);
	}



	@Override
	public Customer getConsumerCustomerById(int id) throws RestClientException, URISyntaxException {
		String uri=url+id;
		return rest.getForObject(new URI(uri),Customer.class);
	}



	@Override
	public void deleteConsumerById(int id) {
		String uri=url+id;
		 rest.delete(uri,Integer.toString(id));
	}



	@Override
	public void updateConsumerCustomer(Customer customer) {
		 rest.put(url, customer,Customer.class );
	}



	@Override
	public List<Customer> getAll() throws RestClientException, URISyntaxException {
		 List<Customer>li=Arrays.asList(rest.getForObject(new URI(url),Customer[].class));
		 return li;
	}
	



	
	
	

}
