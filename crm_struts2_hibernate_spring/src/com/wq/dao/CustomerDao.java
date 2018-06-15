package com.wq.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wq.entity.Customer;
import com.wq.entity.LinkMan;

public interface CustomerDao {
	void addCustomer(Customer c);

	List<Customer> getAll(DetachedCriteria dc);
	
	void delete(Long custId);
}
