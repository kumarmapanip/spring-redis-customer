package com.rvy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import com.rvy.entity.Customer;
import com.rvy.repo.CustomerRepository;

@RestController
@RequestMapping("/rvy/api/cm/v1/")
public class CustomerController {
	
	@Autowired
	private CustomerRepository repository;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer()
	{
		return repository.findAll();
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		Integer firstLayerRandomness =  ThreadLocalRandom.current().nextInt(1000001,100000004)%999999;
		Integer secondLayerRandomness = ThreadLocalRandom.current().nextInt(999,999978);
		Integer cipherKey = ThreadLocalRandom.current().nextInt(1000,5000);
		Integer encodedId = (firstLayerRandomness*cipherKey%firstLayerRandomness + secondLayerRandomness)%firstLayerRandomness;
		customer.setCustomerId(Math.abs(encodedId));
		return repository.save(customer);
	}
	
	@GetMapping("/customers/{id}")
	public Customer getById(@PathVariable("id") Integer id)
	{
		return repository.findById(id);
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		return repository.update(customer);
	}
	
	@DeleteMapping("/customers/{id}")
	public Integer deleteById(@PathVariable("id") Integer id)
	{
		return repository.deleteCustomer(id);
	}
	
}
