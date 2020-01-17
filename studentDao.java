package com.seehope.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.seehope.entity.Emp;
import com.seehope.entity.students;


public class studentDao extends JdbcUtil2 {

	//添加功能
		public int addstu(students stu) {
			String sql = "insert into studentinfo values(?,?,?,?,?,?,?,?,?,?)";
			Object[] param = {
					stu.getStudentno(),stu.getStudentname(),stu.getStudentsex(),
					stu.getBirthday(),stu.getSpeciality(),stu.getClassno(),stu.getIsparty(),
					stu.getEmail(),stu.getQq(),stu.getHomeaddress()
			};
			
			return myExecuteUpdate(sql,param);
		}
		
		//修改功能
		public int updateEmp(students stu) {
			String sql = "update studentinfo set studentname=?,studentsex=?,birthday=?,speciality=?,class=?,isparty=?,email=?,qq=?,homeaddress=? where studentno=?";
			
			Object[] param = {
					stu.getStudentname(),stu.getStudentsex(),
					stu.getBirthday(),stu.getSpeciality(),stu.getClassno(),stu.getIsparty(),
					stu.getEmail(),stu.getQq(),stu.getHomeaddress(),stu.getStudentno()
			};
			
			

			return myExecuteUpdate(sql,param);
		}
		
		//删除功能
		public int deleteEmp(int studentno) {
			String sql = "delete FROM studentinfo WHERE studentno=?";
			
			Object[] param = {studentno};

			return myExecuteUpdate(sql,param);
		}
		//查找全部学生
		public List<students> findAllstudents(){
			List<students> stuList = new ArrayList<students>();
			try {
				Connection conn = getConnection();
				String sql = "SELECT * FROM studentinfo";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					students stu = new students();
					stu.setStudentno(rs.getInt("studentno"));
					stu.setStudentname(rs.getString("studentname"));
					stu.setStudentsex(rs.getString("studentsex"));
					stu.setBirthday(rs.getDate("birthday"));
					stu.setSpeciality(rs.getString("speciality"));
					stu.setClassno(rs.getInt("class"));
					stu.setIsparty(rs.getInt("isparty"));
					stu.setEmail(rs.getString("email"));
					stu.setQq(rs.getInt("qq"));
					stu.setHomeaddress(rs.getString("homeaddress"));
					stuList.add(stu);
					
				}
				
				closeAll(conn,pstmt,rs);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			

			return stuList;
		}
		
		
		//通过ID查找学生
		
		public students findStudentById(int studentno) {
			students stu = null;
			try {
				Connection conn = getConnection();
				String sql = "SELECT * FROM studentinfo WHERE studentno=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, studentno);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					stu = new students();
					stu.setStudentno(rs.getInt("studentno"));
					stu.setStudentname(rs.getString("studentname"));
					stu.setStudentsex(rs.getString("studentsex"));
					stu.setBirthday(rs.getDate("birthday"));
					stu.setSpeciality(rs.getString("speciality"));
					stu.setClassno(rs.getInt("class"));
					stu.setIsparty(rs.getInt("isparty"));
					stu.setEmail(rs.getString("email"));
					stu.setQq(rs.getInt("qq"));
					stu.setHomeaddress(rs.getString("homeaddress"));
					
					
					
				}
				
				closeAll(conn,pstmt,rs);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			

			return stu;
		}
		
		//模糊查找某个姓名的学生
		public List<students> findStudentsByName(String studentname){
			List<students> stuList = new ArrayList<students>();
			
			try {
				Connection conn = getConnection();
				String sql = "SELECT * FROM studentinfo WHERE studentname like ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+studentname+"%");
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					students stu = new students();
					stu.setStudentno(rs.getInt("studentno"));
					stu.setStudentname(rs.getString("studentname"));
					stu.setStudentsex(rs.getString("studentsex"));
					stu.setBirthday(rs.getDate("birthday"));
					stu.setSpeciality(rs.getString("speciality"));
					stu.setClassno(rs.getInt("class"));
					stu.setIsparty(rs.getInt("isparty"));
					stu.setEmail(rs.getString("email"));
					stu.setQq(rs.getInt("qq"));
					stu.setHomeaddress(rs.getString("homeaddress"));
					stuList.add(stu);
					
				}
				
				closeAll(conn,pstmt,rs);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
			return stuList;
		}
		
		
		//查询某个班的人数
		public int findCountsByClassno(int classno){
			int num = 0;
			
			try {
				Connection conn = getConnection();
				String sql = "SELECT count(*) FROM studentinfo WHERE class=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, classno);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					num=rs.getInt(1);
					
				}
				
				
				closeAll(conn,pstmt,rs);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
			return num;
		}
	
		// 特殊查询专业性别为X是党员
		public students findStudentByA(String speciality, String studentsex, int isparty) {
			students stu = null;
			try {
				Connection conn = getConnection();
				String sql = "SELECT * FROM studentinfo WHERE speciality=? AND studentsex=? AND isparty=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, speciality);
				pstmt.setString(2, studentsex);
				pstmt.setInt(3, isparty);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					stu = new students();
					stu.setStudentno(rs.getInt("studentno"));
					stu.setStudentname(rs.getString("studentname"));
					stu.setStudentsex(rs.getString("studentsex"));
					stu.setBirthday(rs.getDate("birthday"));
					stu.setSpeciality(rs.getString("speciality"));
					stu.setClassno(rs.getInt("class"));
					stu.setIsparty(rs.getInt("isparty"));
					stu.setEmail(rs.getString("email"));
					stu.setQq(rs.getInt("qq"));
					stu.setHomeaddress(rs.getString("homeaddress"));
					
					
					
				}
				
				closeAll(conn,pstmt,rs);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
			return stu;
		}
	
	
	
	
	
	
	
	
}
