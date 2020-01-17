package com.seehope.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.seehope.entity.Users;
import com.seehope.entity.userstu;

public class userstuDao extends JdbcUtil2 {
	public userstu login(String username , String password) {
		userstu user = null;
		

		try {
			Connection conn = getConnection();
			String sql = "SELECT * FROM user WHERE username=? AND password=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new userstu();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				
			}
		
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

		return user;
	}
      
      
      
}
