package com.wq.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.Delete;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wq.entity.Customer;
import com.wq.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    // 获取servletContext
    ServletContext servletContext = ServletActionContext.getServletContext();
    // 从servletContext中获取spring容器
    WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    //获取customerService对象
    CustomerService customerService=(CustomerService) ac.getBean("customerService");
    private Customer customer = new Customer();

    @Override
    public Customer getModel() {
        // TODO Auto-generated method stub
        return customer;
    }

    /*
     * 获取客户列表
     */
    public String custList() {
        // 1 获取前台参数
        String custName = ServletActionContext.getRequest().getParameter("custName");
        // 2 创建查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        // 3判断参数条件
        if (StringUtils.isNotBlank(custName)) {
            dc.add(Restrictions.like("custName", "%" + custName + "%"));
        }
        // 4 调用service方法
        List<Customer> list = customerService.getAll(dc);
        // 5 将返回的list放入request中
        ServletActionContext.getRequest().setAttribute("list", list);
        return "list";
    }

    public String add() {
        customerService.addCustomer(customer);
        return "success";
    }

    public String delete() {
        customerService.delete(customer.getCustId());
        return "success";

    }

}
