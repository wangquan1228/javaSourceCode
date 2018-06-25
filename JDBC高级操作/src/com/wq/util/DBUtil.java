package com.wq.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DBUtil负责得到数据库的连接 工具类
 *
 */
public class DBUtil {
	private static String driver;
	private static String url;
	private static String use;
	private static String pwd;
	// static写静态代码块
	static {
		// 实例化 属性集
		Properties p = new Properties();
		// 从本类的字节流中根据路径找到输入流
		InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("com/wq/util/db.properties");
		try {
			// 加载字节流
			p.load(is);
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			use = p.getProperty("use");
			pwd = p.getProperty("pwd");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 封装一个Connection方法
	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(url, use, pwd);
	}

	//关闭一个连接
	public static void closeConn(Connection conn,PreparedStatement ps,ResultSet rs){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
