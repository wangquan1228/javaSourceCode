package com.wq.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wq.entity.Customer;
import com.wq.entity.LinkMan;

public interface CustomerService {
	void addCustomer(Customer c);

	List<Customer> getAll(DetachedCriteria dc);
	
	void delete(Long custId);
}
