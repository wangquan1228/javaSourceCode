package com.wq.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wq.entity.Customer;
import com.wq.entity.LinkMan;
import com.wq.service.LinkManService;
import com.wq.service.impl.LinkManServiceImpl;
 
public class LinkManAction extends ActionSupport {
    ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
    LinkManService linkManService=(LinkManService) ac.getBean("linkManservice");

    /*
	 * 使用离线查询
	 */
	public String lkmList() {
		// 1 获取前台参数
		String lkm_name = ServletActionContext.getRequest().getParameter("lkm_name");
		// 2 创建查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		// 3判断参数条件
		if (StringUtils.isNotBlank(lkm_name)) {
			dc.add(Restrictions.like("lkm_name", "%" + lkm_name + "%"));
		}
		// 4 调用service方法
		List<LinkMan> list = linkManService.lkmListService(dc);
		// 5 将返回的list放入request中
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}

	/*
	 * 添加联系人
	 */
	private Long custId;

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	private LinkMan man;

	public LinkMan getMan() {
		return man;
	}

	public void setMan(LinkMan man) {
		this.man = man;
	}

	public String add() {
		linkManService.addLinkMan(man, custId);
		return "success";
	}
}
