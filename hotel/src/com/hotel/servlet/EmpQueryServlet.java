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
 * 获取通过ID的对象
 * @author wangquan
 *
 */

@WebServlet("/EmpQueryServlet.dao")
public class EmpQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public EmpQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 调用业务层的ff
		int id=Integer.parseInt( request.getParameter("emp_id"));
		EmployeesService employeesService=new EmployeesService();
		Employees emp=employeesService.getEmpService(id);
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("empedit.jsp").forward(request, response);
	}

	 
	 
}
