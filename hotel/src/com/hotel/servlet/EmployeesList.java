package com.hotel.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.entity.Employees;
import com.hotel.service.EmployeesService;

/**
 * 查询方法
 * @author Administrator
 *
 */
@WebServlet("/emplist")
public class EmployeesList extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeesService  employeesService=new EmployeesService();
		List<Employees> emplList=employeesService.employeesList();
	 
		req.setAttribute("emplList", emplList);//将得到的集合装在req的属性中
		req.getRequestDispatcher("/emplist.jsp").forward(req, resp);
	}
  
	
}
