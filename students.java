package com.seehope.entity;

import java.util.Date;

public class students {
    private int studentno;
    private String studentname;
    private String studentsex;
    private Date birthday;
    private String speciality;
    private int classno;
    private int isparty;
    private String email;
    private int qq;
    private String homeaddress;
	

    
    
    
    
    
    
    
    public students() {
		super();
	}



	public students(int studentno, String studentname, String studentsex, Date birthday, String speciality, int classno,
			int isparty, String email, int qq, String homeaddress) {
		super();
		this.studentno = studentno;
		this.studentname = studentname;
		this.studentsex = studentsex;
		this.birthday = birthday;
		this.speciality = speciality;
		this.classno = classno;
		this.isparty = isparty;
		this.email = email;
		this.qq = qq;
		this.homeaddress = homeaddress;
	}
    
    
    
	public int getStudentno() {
		return studentno;
	}
	public void setStudentno(int studentno) {
		this.studentno = studentno;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentsex() {
		return studentsex;
	}
	public void setStudentsex(String studentsex) {
		this.studentsex = studentsex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public int getClassno() {
		return classno;
	}
	public void setClassno(int classno) {
		this.classno = classno;
	}
	public int getIsparty() {
		return isparty;
	}
	public void setIsparty(int isparty) {
		this.isparty = isparty;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getQq() {
		return qq;
	}
	public void setQq(int qq) {
		this.qq = qq;
	}
	public String getHomeaddress() {
		return homeaddress;
	}
	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}
	
	
	
	
	
	
	
	
	
	
	
}
