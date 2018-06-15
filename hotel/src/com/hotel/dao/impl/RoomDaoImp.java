package com.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hotel.dao.BaseDao;
import com.hotel.dao.RoomDao;
import com.hotel.entity.Customer;
import com.hotel.entity.Room;
import com.hotel.util.DBUtil;

/**
 * 实现接口
 * 
 * @author Administrator
 *
 */
public class RoomDaoImp extends BaseDao implements RoomDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * 获取放假列表
	 */
	@Override
	public List<Room> roomList() {
		// TODO Auto-generated method stub
		List<Room> list = new ArrayList<Room>();
		Room room = null;
		try {
			conn = DBUtil.getConn();
			String sql = "select * from room";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				room = new Room();
				room.setRoomId(rs.getInt("id"));
				room.setRoomName(rs.getString("room_name"));
				room.setRoomType(rs.getString("room_type"));
				room.setRoomPrice(rs.getInt("room_price"));
				room.setRemark(rs.getString("remark"));
				list.add(room);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return list;
	}

	 
}
