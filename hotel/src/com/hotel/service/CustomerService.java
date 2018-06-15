package com.hotel.service;
/**
 * 客户业务层
 * @author wangquan
 *
 */

import java.util.List;

import javax.sound.midi.VoiceStatus;

import com.hotel.dao.CustomerDao;
import com.hotel.dao.impl.CustomerDaoImp;
import com.hotel.entity.Customer;

public class CustomerService {
	/*
	 * 获取所有客户
	 */
	public List<Customer> customerListService(){
		CustomerDao dao =new CustomerDaoImp();
		return dao.cusList();
	}
   /**
    * 添加客户
    */
	public void addCustomerService(Customer cus){
		CustomerDao dao =new CustomerDaoImp();
		dao.addCustomer(cus);
		System.out.println("你好");
		
	}
	/**
	 * 删除一个用户
	 */
	public void deleteCustomerService(int id){
		CustomerDao  dao =new CustomerDaoImp();
		dao.deleteCustomer(id);
		 
	}
	/**
	 * 查找客户
	 */
	public Customer findCustomerService(int id){
		CustomerDao  dao =new CustomerDaoImp();
		return dao.findCustomer(id);
	}
	/**
	 * 修改客户信息
	 */
	public void updateCustomer(Customer cus){
		CustomerDao dao =new CustomerDaoImp();
		dao.updateCustomer(cus);
	}
}
