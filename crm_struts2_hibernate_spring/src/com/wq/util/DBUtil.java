package com.wq.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static String driver;
	private static String url;
	private static String use;
	private static String pwd;
	static {
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
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 封装链接方法
	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(url, use, pwd);
	}

	// 封装关闭方法
	public static void closeConn(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
