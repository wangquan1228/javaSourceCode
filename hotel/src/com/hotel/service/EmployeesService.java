package com.hotel.service;

import java.util.List;

import org.apache.catalina.valves.rewrite.RewriteRule;
import org.junit.Test;

import com.hotel.dao.EmployeesDao;
import com.hotel.dao.impl.EmployeesDaoImp;
import com.hotel.entity.Employees;
/**
 * 业务层
 * @author wanqguan
 *
 */
public class EmployeesService {
	 /**
	  *调用登录验证方法
	  * @param account
	  * @param passwod
	  * @return
	  */
	 public Employees loginService(String account,String passwod){
		EmployeesDao dao=new EmployeesDaoImp();
		Employees employees=dao.login(account, passwod);
		System.out.println("通过用户名和密码从数据库中查询的结果:"+employees);
	    return employees;
	
	} 
	/*@Test
	public void loginService( ){
		EmployeesDao dao=new EmployeesDaoImp();
		Employees employees=dao.login("wq", "123");
		System.out.println("通过用户名和密码从数据库中查询的结果:"+employees);
	    
	
	}*/
	 
	 /**
	  * 查询方法
	  * @return
	  */
	 public List<Employees> employeesList(){
		 EmployeesDao dao =new EmployeesDaoImp();
		 return  dao.employeeslist();
	 }

	 /**
	  * 添加员工
	  */
	 public void addEmpService(Employees emp){
		 EmployeesDao dao =new EmployeesDaoImp();
		 dao.addEmployees(emp);
	 }
	 /**
	  * 获取一个员工
	  */
	 public Employees getEmpService(int id){
		 EmployeesDao dao=new EmployeesDaoImp();
		 return dao.getEmploy(id);
	 }
	 /**
	  *修改员工信息
	 * @return 
	  */
	 public void updateEmpService(Employees emp){
		 EmployeesDao dao =new EmployeesDaoImp();
		 dao.updateEmployees(emp);
		 
	 }
	 /**
	  * 删除选定的员工
	  */
	 public void deleteEmpService(int id){
		 EmployeesDao  dao =new EmployeesDaoImp();
		 dao.deleteEmpService(id);
	 }
	 /**
	  * 修改密码
	  */
	 public Boolean editPasswordService(String account,String oldPwd,String newPwd){
		 EmployeesDao  dao =new EmployeesDaoImp();
		 dao.editPassword(account,oldPwd, newPwd);
		 return true;
	 }

}
