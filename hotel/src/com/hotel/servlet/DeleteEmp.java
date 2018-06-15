package com.hotel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.entity.Employees;
import com.hotel.service.EmployeesService;

@WebServlet("/delete")
public class DeleteEmp extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 
		 try {
			int id=Integer.parseInt( req.getParameter("emp_id"));
			EmployeesService employeesService=new EmployeesService();
			employeesService.deleteEmpService(id);
			req.setAttribute("msg", "删除成功");
		} catch (Exception e) {
			 req.setAttribute("msg", "无法删除,请重新操作");
		}
		 req.setAttribute("url","emplist");//emplist是employeesList.java 的webServlet
		req.getRequestDispatcher("msg.jsp").forward(req, resp);
	}

}
