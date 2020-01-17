package com.seehope.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil2 {
	// �������ݿ���ַ���
		private static String url = "jdbc:mysql://127.0.0.1:3306/students";
		// jdbcЭ��+���ݿ�Э��+������ַ+�˿�+���ӵ����ݿ�
		private static String user = "root"; // �û���
		private static String password = "root";// ����

		// ��������
		public static Connection getConnection() {
			Connection conn = null;// �������Ӷ���
			if (conn == null) {
				// ��ȡ���Ӳ������쳣
				try {
					Class.forName("com.mysql.jdbc.Driver");//(1)��������
					conn = DriverManager.getConnection(url, user, password);//(2)��������
				} catch (Exception e) {
					e.printStackTrace();// �쳣����
				}
			}
			return conn;// �������Ӷ���
		}

		// �ر���Դ
		public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
			// �����������Ϊ�գ���ر�
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// ��Statement����Ϊ�գ���ر�
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// �����ݿ����Ӷ���Ϊ�գ���ر�
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public static int myExecuteUpdate(String sql, Object[] param) {
			Connection conn = getConnection();// �������Ӷ���
			
			PreparedStatement pstmt = null;
			int num = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
				if (param != null) {
					for (int i = 0; i < param.length; i++) {
						pstmt.setObject(i + 1, param[i]); // ΪԤ����sql���ò���
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
