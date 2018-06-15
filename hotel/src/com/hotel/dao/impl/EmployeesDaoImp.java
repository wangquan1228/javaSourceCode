package com.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hotel.dao.BaseDao;
import com.hotel.dao.EmployeesDao;
import com.hotel.entity.Employees;
import com.hotel.util.DBUtil;

/**
 * 实现接口
 * 
 * @author Administrator
 *
 */
public class EmployeesDaoImp extends BaseDao implements EmployeesDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * 登录验证方法实现
	 */
	@Override
	public Employees login(String account, String password) {
		Employees emp = new Employees();
		try {
			conn = DBUtil.getConn();
			String sql = "select * from user where account=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setUsernName(rs.getString("user_name"));
				emp.setAccount(rs.getString("account"));
				emp.setPassword(rs.getString("password"));
				emp.setMobile(rs.getString("mobile"));
				emp.setStatus(rs.getInt("status"));
				emp.setCreateTime(rs.getTimestamp("create_time"));
			}
			return emp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return null;
	}

	/**
	 * 查询所有员工
	 */
	@Override
	public List<Employees> employeeslist() {
		// TODO Auto-generated method stub
		List<Employees> list = new ArrayList<Employees>();
		Employees emp = null;
		try {
			conn = DBUtil.getConn();
			String sql = "select * from user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employees();
				emp.setId(rs.getInt("id"));
				emp.setUsernName(rs.getString("user_name"));
				emp.setAccount(rs.getString("account"));
				emp.setPassword(rs.getString("password"));
				emp.setMobile(rs.getString("mobile"));
				emp.setStatus(rs.getInt("status"));
				emp.setCreateTime(rs.getTimestamp("create_time"));
				list.add(emp);
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
	 * 添加员工
	 */
	@Override
	public void addEmployees(Employees emp) {
		String sql = "insert into user (user_name,account,password, mobile)" 
	+ "values(?,?,?,?)";
		Object[] obj = { emp.getUserName(), emp.getAccount(), emp.getPassword(), emp.getMobile() };
		toUpdate(sql, obj);
	}

	@Override
	public Employees getEmploy(int id) {
		Employees emp = null;
		try {
			conn = DBUtil.getConn();
			String sql = "select * from user where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employees();
				emp.setId(rs.getInt("id"));
				emp.setUsernName(rs.getString("user_name"));
				emp.setAccount(rs.getString("account"));
				emp.setPassword(rs.getString("password"));
				emp.setMobile(rs.getString("mobile"));
				emp.setStatus(rs.getInt("status"));
				emp.setCreateTime(rs.getTimestamp("create_time"));
			}
			return emp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return null;
	}

	@Override
	public void updateEmployees(Employees emp) {
		// TODO Auto-generated method stub
		String sql = "update user set user_name=?,account=?,mobile=?,status=? where id=?";
		Object[] obj = { emp.getUserName(), emp.getAccount(), emp.getMobile(), emp.getStatus(), emp.getId() };
		toUpdate(sql, obj);
	}
	/**
	 * 删除选定的员工
	 */
	@Override
	public void deleteEmpService(int id) {
		// TODO Auto-generated method stub
		String sql="delete from user where id=?";
		Object[] obj={id};
		toUpdate(sql, obj);
	}
	/**
	 * 修改密码
	 */
	@Override
	public void editPassword(String account,String oldPwd,String newPwd) {
		// TODO Auto-generated method stub
		String sql = "update user set password=? where account=?and password=?";
		Object[] obj = { newPwd,account,oldPwd };
		toUpdate(sql, obj);
	}

}
