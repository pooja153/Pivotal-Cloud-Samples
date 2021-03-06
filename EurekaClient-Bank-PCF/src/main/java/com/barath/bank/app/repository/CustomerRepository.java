package com.barath.bank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.barath.bank.app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
	
	public Customer findByCustomerName(String customerName);
	
}
