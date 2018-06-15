package com.hotel.dao;

import java.util.List;

import com.hotel.entity.Employees;
 

public interface EmployeesDao {
	//登录验证
	public Employees login(String username, String password);
	//获取员工列表
	public List<Employees> employeeslist();
    //添加员工
	public void addEmployees(Employees emp);
     //根据id获取员工
	public Employees getEmploy(int id);
	 //修改员工信息
	public void updateEmployees(Employees emp);
	//删除一个员工
	public void deleteEmpService(int id);
	//修改密码
	public void editPassword(String account,String oldPwd,String newPwd);
}
