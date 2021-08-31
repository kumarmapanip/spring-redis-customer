package com.rvy.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.rvy.entity.Customer;

@Repository
public class CustomerRepository {

	public static final String HASH_KEY = "customer_rvy";
	
	@Autowired
	private RedisTemplate template;
	
	public Customer save(Customer customer)
	{
		template.opsForHash().put(HASH_KEY, customer.getCustomerId(), customer);
		return customer;
	}
	
	public List<Customer> findAll(){
		return template.opsForHash().values(HASH_KEY);
	}
	
	public Customer findById(Integer id) {
		return (Customer) template.opsForHash().get(HASH_KEY, id);
	}
	
	public Integer deleteCustomer(Integer id) {
		template.opsForHash().delete(HASH_KEY, id);
		return id;
	}
	
	public Customer update(Customer customer) {
		template.opsForHash().put(HASH_KEY, customer.getCustomerId(), customer);
		return customer;
	}
}
