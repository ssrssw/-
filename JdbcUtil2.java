package com.seehope.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil2 {
	// 连接数据库的字符串
		private static String url = "jdbc:mysql://127.0.0.1:3306/students";
		// jdbc协议+数据库协议+主机地址+端口+连接的数据库
		private static String user = "root"; // 用户名
		private static String password = "root";// 密码

		// 建立连接
		public static Connection getConnection() {
			Connection conn = null;// 数据连接对象
			if (conn == null) {
				// 获取连接并捕获异常
				try {
					Class.forName("com.mysql.jdbc.Driver");//(1)加载驱动
					conn = DriverManager.getConnection(url, user, password);//(2)进行连接
				} catch (Exception e) {
					e.printStackTrace();// 异常处理
				}
			}
			return conn;// 返回连接对象
		}

		// 关闭资源
		public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
			// 若结果集对象不为空，则关闭
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 若Statement对象不为空，则关闭
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 若数据库连接对象不为空，则关闭
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public static int myExecuteUpdate(String sql, Object[] param) {
			Connection conn = getConnection();// 数据连接对象
			
			PreparedStatement pstmt = null;
			int num = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
				if (param != null) {
					for (int i = 0; i < param.length; i++) {
						pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
					}
				}
				num = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeAll(conn, pstmt, null);
			}
			return num;
		}


}
