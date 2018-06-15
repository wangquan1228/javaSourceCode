package com.hotel.entity;

import java.io.Serializable;

import javax.management.loading.PrivateClassLoader;

/**
 * room实体类
 * 
 * @author wangquan
 *
 */
public class Room implements Serializable {

	private int roomId;
	private String roomName;
	private String roomType;
	private int roomPrice;
	private String remark;

	public Room(int roomId, String roomName, String roomType, int roomPrice, String remark) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.remark = remark;
	}

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomName=" + roomName + ", roomType=" + roomType + ", roomPrice="
				+ roomPrice + ", remark=" + remark + "]";
	}

}
