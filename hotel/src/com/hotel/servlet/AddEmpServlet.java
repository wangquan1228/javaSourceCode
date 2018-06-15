package com.hotel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.entity.Employees;
import com.hotel.service.EmployeesService;
/**
 * 添加员工
 * @author wangquan
 *
 */
@WebServlet("/addEmp")
public class AddEmpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String name=req.getParameter("username");
		String account=req.getParameter("account");
		String password=req.getParameter("password");
		String mobile=req.getParameter("mobile");
		
		//实例化对象
		Employees emp=new Employees();
		emp.setUsernName(name);
		emp.setAccount(account);
		emp.setPassword(password);
		emp.setMobile(mobile);
		
		//调用业务层
		EmployeesService employeesService=new EmployeesService();
		employeesService.addEmpService(emp);
		req.getRequestDispatcher("center.jsp").forward( req, resp);
	}
	

}
