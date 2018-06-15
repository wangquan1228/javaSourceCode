package com.hotel.dao;
/**
 * 房间接口
 * @author wangquan
 *
 */

import java.util.List;

import com.hotel.entity.Room;

public interface RoomDao {
    //获取房间列表
	public List<Room> roomList();
	
	 
}
