package com.hotel.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.hotel.entity.Employees;
import com.hotel.service.EmployeesService;

/**
 * 登录请求
 * 
 * @author wangquan
 *
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
   /**
    * doGet()请求
    */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
        //获取前台页面参数
		String account = request.getParameter("account");
		String password = request.getParameter("password");

	    //System.out.println(account + ".............." + password);
		// 创建登录的employees对象
		Employees employees = new Employees();
		employees.setAccount(account);
		employees.setPassword(password);
		//System.out.println(employees);
     	 
		// 调用业务层
		EmployeesService employeesService = new EmployeesService();
		Employees exitEmp = employeesService.loginService(employees.getAccount(), employees.getPassword());
        HttpSession session=request.getSession();
		if(exitEmp.getAccount()==null||exitEmp.getPassword()==null ){
		    request.setAttribute("msg", "您输入的密码或者账号名有误,请重新输入!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
       }else {
    	session.setAttribute("exitEmp", exitEmp);
    	request.getRequestDispatcher("/main.jsp").forward(request, response);
	}
		 
	}
}
