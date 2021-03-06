package com.barath.customer.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barath.customer.app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

	public Customer findByCustomerName(String customerName);
	
}
