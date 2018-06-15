package com.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hotel.dao.BaseDao;
import com.hotel.dao.CustomerDao;
import com.hotel.entity.Customer;
import com.hotel.entity.Employees;
import com.hotel.entity.Room;
import com.hotel.util.DBUtil;

/**
 * 实现接口
 * 
 * @author wangquan
 *
 */
public class CustomerDaoImp extends BaseDao implements CustomerDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * 获取客户列表
	 */
	@Override
	public List<Customer> cusList() {
		// TODO Auto-generated method stub
		List<Customer> list = new ArrayList<Customer>();
		Customer customer = null;
		try {
			conn = DBUtil.getConn();
			String sql = "select * from customer";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				customer =new Customer();
				customer.setCustomerId(rs.getInt("id"));
				customer.setCustomerName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setCard(rs.getString("card"));
				customer.setRoomId(rs.getInt("room_id"));
			    customer.setInTime(rs.getTimestamp("in_time"));
				customer.setPayPrice(rs.getInt("pay_price"));
				customer.setRemark(rs.getString("remark"));
				list.add(customer);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return list;
	}
	/**
	 * 添加客户
	 */
	public void addCustomer(Customer cus) {
		// TODO Auto-generated method stub
		String sql="insert into customer(name,gender,card,room_id,pay_price,remark)"
				+ "values(?,?,?,?,?,?)";
		Object[] obj={cus.getCustomerName(),cus.getGender(),cus.getCard(),
				cus.getRoomId(), cus.getPayPrice(),cus.getRemark()};
		toUpdate(sql, obj);
		
	}
	/**
	 * 删除用户
	 */
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		String sql="delete from customer where id=?";
		Object[] obj={customerId};
		toUpdate(sql, obj);  
		 
	}
	/**
	 * 查找客户
	 */
	@Override
	public Customer findCustomer(int custoemrId) {
		// TODO Auto-generated method stub
		Customer cus=null;
		try {
			conn = DBUtil.getConn();
			String sql = "select * from customer where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, custoemrId );
			rs = ps.executeQuery();
			while (rs.next()) {
				cus = new Customer();
				cus.setCustomerId(rs.getInt("id"));
				cus.setCustomerName(rs.getString("name"));
				cus.setGender(rs.getString("gender"));
				cus.setCard(rs.getString("card"));
				cus.setRoomId(rs.getInt("room_id"));
				cus.setInTime(rs.getTimestamp("in_time"));
				cus.setPayPrice(rs.getInt("pay_price"));
				cus.setRemark(rs.getString("remark"));
			}
			return cus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return null;
	}
	/**
	 * 修改客户信息
	 */
	@Override
	public void updateCustomer(Customer cus) {
		// TODO Auto-generated method stub
		String sql="update customer set name=?,gender=?,card=?,room_id=?,pay_price=? ,remark=? where id=?";
		Object[] obj ={cus.getCustomerName(),cus.getGender(),cus.getCard(),
				cus.getRoomId(),cus.getPayPrice(),cus.getRemark(),cus.getCustomerId()};
		toUpdate(sql, obj);
	}
	 
	 
}
