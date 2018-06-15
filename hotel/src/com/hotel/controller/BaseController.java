package com.hotel.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class BaseController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//http://ip:port/projectname/某个控制层类?method=方法&其他参数＝值
		String methodName = req.getParameter("method");// 控制层类的一个方法名称
		
		//当没有指定调用的方法时，那么默认请求一个方法execute()方法
		if(methodName == null || methodName.isEmpty()){
			methodName = "execute";
		}
		
		//反射， 无反射无框架。this是实例化的当前的对象，如果我调用的是EmployeeController 下的addEmp方法时，
		//这个this,就是指的是EmployeeController类
		Class c = this.getClass();
		
		//通过方法的名称获取方法的反射对象
		try {
			Method m = c.getMethod(methodName, HttpServletRequest.class, 
					HttpServletResponse.class);
			//执行当前反射的目标方法
			String result = (String) m.invoke(this, req, resp);
			if(result != null && !result.isEmpty()){
				req.getRequestDispatcher(result).forward(req, resp);
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
