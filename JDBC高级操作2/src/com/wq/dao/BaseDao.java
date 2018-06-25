package com.wq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wq.util.DBUtil;



public class BaseDao{
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

/**
 * 封装增删改查方法
 */
	//sql是要被执行的sql语句,obj是sql语句中 的参数
	public int toUpdate(String sql,Object[] obj){
		int a=0;
		try {
		    conn=DBUtil.getConn();
		    ps=conn.prepareStatement(sql);
		    // 循环 赋值参数
		    if(obj!=null&&obj.length>0){
		    	for(int i=0;i<obj.length;i++){
		    		ps.setObject(i+1, obj[i]);
		    	}
		    }
		    a=ps.executeUpdate();//返回受影响的行数
		    return a;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return a;
	}
}
