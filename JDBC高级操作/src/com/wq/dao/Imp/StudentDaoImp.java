package com.wq.dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wq.dao.StudentDao;
import com.wq.entity.Student;
import com.wq.util.DBUtil;

public  class StudentDaoImp implements StudentDao{
	//链接数据库组件
	private Connection conn;
	//得到预编译sql语句组件
	private PreparedStatement ps;
	//处理集组件
	private ResultSet rs;

	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		try {
			conn=DBUtil.getConn();
			String sql="insert into student1(name,pwd,sex,address) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setObject(2, s.getPwd());
			ps.setObject(3, s.getSex());
			ps.setObject(4, s.getAddress());
			// 会返回一个int值 表示 你影响了 几行数据
			ps.executeUpdate();
			System.out.println("插入成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
	}

	@Override
	public void removeStudent(String name) {
		// TODO Auto-generated method stub
		try {
			conn=DBUtil.getConn();
			String sql="delete  from student1 where name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.executeUpdate();
			System.out.println("操作成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		
	}
	
	@Override
	public void removeStudent(int id) {
		// TODO Auto-generated method stub
		try {
			conn=DBUtil.getConn();
			String sql="delete  from student1 where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("操作成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		
	}
	@Override
	public Student updateStudent(Student s) {
		// TODO Auto-generated method stub
		Student student=new Student();
		try {
			conn=DBUtil.getConn();
			String sql="update Student1 set name=?,pwd=?,sex=?,address=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getPwd());
			ps.setObject(3, s.getSex());
			ps.setString(4,s.getAddress());
			ps.setInt(5, s.getId());
			ps.executeUpdate();
			System.out.println("修改成功");
			return student;
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		
		return student;
	}

	public Student findById(int id) {
		Student s =new Student();
		// TODO Auto-generated method stub
		try {
			conn=DBUtil.getConn();
			String sql="select * from student1 where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPwd(rs.getString("pwd"));
				s.setSex(rs.getString("sex"));
				s.setAddress(rs.getString("address"));
				
			}
			return s;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		
		return s;
	}

	

}
