package com.hotel.service;
/**
 * 房间业务层
 * @author wangquan
 *
 */

import java.util.List;

import org.junit.Test;

import com.hotel.dao.RoomDao;
import com.hotel.dao.impl.RoomDaoImp;
import com.hotel.entity.Room;

public class RoomService {
	//获取房间列表
  
	public List<Room> roomList(){
	RoomDao  dao=new RoomDaoImp();
	 
	return dao.roomList();
	} 
	/*@Test 
	public void roomList(){
		RoomDao  dao=new RoomDaoImp();
		System.out.println(dao.roomList());
	}*/
}
