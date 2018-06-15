package com.hotel.servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import com.hotel.entity.Employees;
import com.hotel.service.EmployeesService;
@WebServlet("/editpwd")
public class EditPasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 req.setCharacterEncoding("utf-8");
		 resp.setCharacterEncoding("utf-8");
	     String account=req.getParameter("account");
	     String oldPwd=req.getParameter("oldpassword");
	     String newPwd=req.getParameter("newpassword");
	     
	    	EmployeesService employeesService=new EmployeesService();
		    Boolean flag=  employeesService.editPasswordService(account, oldPwd, newPwd);
		  if(flag=true){
			      req.setAttribute("msg", "修改成功,请重新登录");
			      req.setAttribute("url","login.jsp");//emplist是employeesList.java 的webServlet
				req.getRequestDispatcher("msg1.jsp").forward(req, resp);
		  }else{
			req.setAttribute("msg", "操作失败,请重新开始");
		    req.setAttribute("url","center.jsp");//emplist是employeesList.java 的webServlet
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		  }
	     	
	}

}
