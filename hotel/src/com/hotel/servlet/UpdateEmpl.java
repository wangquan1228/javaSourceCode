package com.hotel.servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.entity.Employees;
import com.hotel.service.EmployeesService;
/**
 * 修改个人信息
 * @author wangquan
 *
 */
@WebServlet("/updateEmp")
public class UpdateEmpl extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		Employees emp=new Employees();
		emp.setId(Integer.parseInt(req.getParameter("id")));
		emp.setUsernName(req.getParameter("username"));
		emp.setAccount(req.getParameter("account"));
		emp.setMobile(req.getParameter("mobile"));
		emp.setStatus(Integer.parseInt(req.getParameter("status")));
		try {
			 EmployeesService employeesService=new EmployeesService();
			 employeesService.updateEmpService(emp);
			 req.setAttribute("msg", "员工信息修改成功");
		} catch (Exception e) {
			req.setAttribute("msg", "修改失败,请重新操作");
		}
		req.setAttribute("url","emplist");//emplist是employeesList.java 的webServlet
		req.getRequestDispatcher("msg.jsp").forward(req, resp);
		 //调用业务层方法
		
	}
	

}
