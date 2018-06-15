package com.hotel.dao;
/**
 * 封装客户接口
 * @author wangquan
 *
 */

import java.util.List;

import com.hotel.entity.Customer;

public interface CustomerDao {
	
	public List<Customer> cusList();
	
	public void addCustomer(Customer cus);
	
	public void  deleteCustomer(int customerId);
	
	public Customer findCustomer(int custoemrId);

	public void updateCustomer(Customer cus);

	 

}
