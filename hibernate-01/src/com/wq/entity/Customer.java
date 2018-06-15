package com.wq.entity;

public class Customer {
	
	private Long custId;
	private String custName;
	private String custSource;
	private String custIndustry;
	private String custLevel;
	private String custLinkman;
	private String custPhone;
	private String custMoblie;
	
	public Customer(Long custId, String custName, String custSource, String custIndustry, String custLevel,
			String custLinkman, String custPhone, String custMoblie) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custSource = custSource;
		this.custIndustry = custIndustry;
		this.custLevel = custLevel;
		this.custLinkman = custLinkman;
		this.custPhone = custPhone;
		this.custMoblie = custMoblie;
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
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custSource=" + custSource
				+ ", custIndustry=" + custIndustry + ", custLevel=" + custLevel + ", custLinkman=" + custLinkman
				+ ", custPhone=" + custPhone + ", custMoblie=" + custMoblie + "]";
	}
	
	
	
}
