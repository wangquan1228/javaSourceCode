package com.wq.entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	
	private Long custId;
	private String custName;
	private String custSource;
	private String custIndustry;
	private String custLevel;
	private String custLinkman;
	private String custPhone;
	private String custMoblie;
	
	 
	  //使用set集合，表达一对多关系
	private Set<LinkMan> LinkMan = new HashSet<LinkMan>();

	public Set<LinkMan> getLinkMan() {
		return LinkMan;
	}
	public void setLinkMan(Set<LinkMan> linkMan) {
		LinkMan = linkMan;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustLinkman() {
		return custLinkman;
	}
	public void setCustLinkman(String custLinkman) {
		this.custLinkman = custLinkman;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustMoblie() {
		return custMoblie;
	}
	public void setCustMoblie(String custMoblie) {
		this.custMoblie = custMoblie;
	}
	public Customer(Long custId, String custName, String custSource, String custIndustry, String custLevel,
			String custLinkman, String custPhone, String custMoblie, Set<com.wq.entity.LinkMan> linkMan) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custSource = custSource;
		this.custIndustry = custIndustry;
		this.custLevel = custLevel;
		this.custLinkman = custLinkman;
		this.custPhone = custPhone;
		this.custMoblie = custMoblie;
		LinkMan = linkMan;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", LinkMan=" + LinkMan + "]";
	}
	 
	
	
	
}
