package com.hotel.entity;

import java.io.Serializable;
/**
 * 顾客实体类
 * @author wangquan
 *
 */
import java.util.Date;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	private int customerId;
	private String customerName;
	private String gender;//性别
	private String card;
	private int roomId;
	private Date inTime;
	private int payPrice;
	private String remark;
	public Customer(int customerId, String customerName, String gender, String card, int roomId, Date inTime,
			int payPrice, String remark) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.gender = gender;
		this.card = card;
		this.roomId = roomId;
		this.inTime = inTime;
		this.payPrice = payPrice;
		this.remark = remark;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public int getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", gender=" + gender
				+ ", card=" + card + ", roomId=" + roomId + ", inTime=" + inTime + ", payPrice=" + payPrice
				+ ", remark=" + remark + "]";
	}

	 

}
