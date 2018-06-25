package com.wq.dao.implment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wq.dao.BaseDao;
import com.wq.dao.PersonDao;
import com.wq.entity.Person;
import com.wq.util.DBUtil;

public class PersonDaoImp extends BaseDao implements PersonDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public void addPreson(Person p) {
		// TODO Auto-generated method stub
		String sql = "insert into person (id,name,pwd,sex,address)" 
				+ " values(?,?,?,?,?)";
		Object[] obj = { p.getId(), p.getName(), p.getPwd(), 
				p.getSex(), p.getAddress() };
		toUpdate(sql, obj);// 返回a=ps.executeUpdate()

	}

	@Override
	public Person update(Person p) {
		// TODO Auto-generated method stub
		Person person = new Person();
		String sql = "update person set name=?,pwd=?,sex=?,address=?"
				+ " where id=?";
		Object[] obj = { p.getName(), p.getPwd(), p.getSex(), 
				p.getAddress(), p.getId(), };
		toUpdate(sql, obj);// 返回a=ps.executeUpdate()
		return person;
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		Person p = new Person();
		String sql = "delete from person where id=?";
		Object[] obj = { id };
		toUpdate(sql, obj);// 返回a=ps.executeUpdate()
	}

	@Override
	public Person findByID(int id) {
		Person person = new Person();
		try {
			conn = DBUtil.getConn();
			String sql = "select * from student1 where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setPwd(rs.getString("pwd"));
				person.setSex(rs.getString("sex"));
				person.setAddress(rs.getString("address"));
				return person;
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<Person> show() {
		List<Person> list = new ArrayList<>();
		Person person=null;
		try {
			conn = DBUtil.getConn();
			String sql = "select * from person ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				person =new Person();//每一次循环后创建一个新的对象用于存储
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setPwd(rs.getString("pwd"));
				person.setSex(rs.getString("sex"));
				person.setAddress(rs.getString("address"));
				list.add(person);
			}
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return list;
	}

}
