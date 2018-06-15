package com.hotel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.entity.Customer;
import com.hotel.service.CustomerService;
import com.sun.crypto.provider.RSACipher;

import sun.awt.RepaintArea;

/**
 * customer的servlet的封装
 * 
 * @author Administrator
 *
 */
@WebServlet("/customer")
public class CustomerController extends BaseController {
	private static final long serialVersionUID = 1L;

	/*
	 * 封装公共方法
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerService customerService = new CustomerService();
		List<Customer> customerList = customerService.customerListService();
		request.setAttribute("customerlist", customerList);
		request.getRequestDispatcher("customerlist.jsp").forward(request, response);
		return null;
	}

	/*
	 * 添加客户
	 */
	public String addCustomer(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	 
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String card=request.getParameter("card");
		int roomId=Integer.parseInt(request.getParameter("roomid"));
		int payPrice=Integer.parseInt(request.getParameter("payprice"));
		String remark=request.getParameter("remark");
		Customer cus=new Customer();
		cus.setCustomerName(name);
		cus.setGender(gender );
		cus.setCard( card);
		cus.setRoomId(roomId);
		cus.setPayPrice(payPrice);
		cus.setRemark(remark );
		try {
			CustomerService customerService=new CustomerService();
		    customerService.addCustomerService(cus);
		    request.setAttribute("msg", "添加成功");
		} catch (Exception e) {
			request.setAttribute("msg", "操作失败,清除开始");
		}
		request.setAttribute("url","customer");//emplist是employeesList.java 的webServlet
		request.getRequestDispatcher("msg.jsp").forward(request, response);
	      return null;
	}
	/*
	 * 删除一个用户
	 */
	public String deleteCus(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			CustomerService customerService=new CustomerService();
			customerService.deleteCustomerService(id);
		 
			request.setAttribute("msg", "退房成功!");
		} catch (Exception e) {
			request.setAttribute("msg", "操作失误请重新开始!");
		}
		 request.setAttribute("url","customer");//emplist是employeesList.java 的webServlet
		 request.getRequestDispatcher("msg.jsp").forward(request, response);
		return null;
		
	}
	/**
	 * 查找用户
	 */
	public String findCus(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		int id=Integer.parseInt(request.getParameter("id"));
		CustomerService customerService=new CustomerService();
		Customer cus=customerService.findCustomerService(id);
		request.setAttribute("cus", cus);
		request.getRequestDispatcher("cusedit.jsp").forward(request, response);
		return null;
	}
	/**
	 * 修改客户信息
	 */
	public String updateCus( HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;cahrset=utf-8"); 
		
		Customer cus=new Customer();
		cus.setCustomerId(Integer.parseInt(request.getParameter("id")));
		cus.setCustomerName(request.getParameter("name"));
		cus.setGender(request.getParameter("gender"));
		cus.setCard(request.getParameter("card"));
		cus.setRoomId(Integer.parseInt(request.getParameter("roomid")));
		cus.setPayPrice(Integer.parseInt(request.getParameter("payprice")));
		cus.setRemark(request.getParameter("remark"));
		 try {
			CustomerService customerService=new CustomerService();
			customerService.updateCustomer(cus);
			request.setAttribute("msg", "修改成功");
		} catch (Exception e) {
			request.setAttribute("msg", "操作失败");
		}
		 request.setAttribute("url","customer");//customer是CustomerController的webServlet
		 request.getRequestDispatcher("msg.jsp").forward(request, response);
		return null;
	}
}