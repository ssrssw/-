package com.seehope.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.seehope.dao.EmpDao;
import com.seehope.dao.UserDao;
import com.seehope.dao.studentDao;
import com.seehope.entity.Emp;
import com.seehope.entity.Users;
import com.seehope.entity.students;





public class TestStudent {

	
	static studentDao studao = new studentDao();
	static Scanner sc = new Scanner(System.in);

	
	
	public static void main(String[] args) {
		
		loginMenu();
	}
	
	
	private static void userLogin() {
		//登录方法
		
		System.out.println("请输入用户名");
		String username = sc.nextLine();
		System.out.println("请输入密码");
		String password = sc.nextLine();
		
		UserDao userDao = new UserDao();
		Users user = userDao.login(username, password);
		
		if(user!=null) {
			System.out.println("登录成功");
			System.out.println("功能菜单如下");
			startMenu();
		}else {
			System.out.println("登录失败，用户名错误");
		}
		
		
		
	}
	
	
	//登录界面
		public static void loginMenu(){
			System.out.println("\n\n\t\t\t\t欢迎使用学生管理系统\n\n");
			System.out.println("\t\t\t\t 1. 登 录 系 统\n\n");
			System.out.println("\t\t\t\t 2. 退 出\n\n");
			System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
			System.out.print("请选择,输入数字:");
			Scanner input=new Scanner(System.in);
			int num=input.nextInt();
			if(num==1){
				userLogin();
			}else{
				System.out.println("你已退出系统!");
			}
		}
		
		/**
		 * 主菜单
		 * @throws SQLException 
		 * @throws ParseException 
		 */
		public static void startMenu() {
			 System.out.println("欢 迎 进 入 学生 管 理 系 统");
		   	 System.out.println("-------------------------------------");
		   	 System.out.println("1. 查看全部学生");
		   	 System.out.println("2. 按学生编号查询学生");
		   	 System.out.println("3. 按姓名模糊查询学生");
		   	 System.out.println("4. 按班级查询学生人数");	   	 
		   	 System.out.println("5. 添加新学生信息");
		   	 System.out.println("6. 删除学生信息");
		     System.out.println("7. 修改学生信息");
		     System.out.println("8.查看某专业性别为X是党员的学生");
		   	 System.out.println("9. 退         出 ");
		   	 System.out.print("--------------------------------------\n");
		
		   	 System.out.print("请选择： ");
		   	 Scanner input = new Scanner(System.in);
		   	 int choice = input.nextInt();
		   	 switch(choice){
		   	    case 1:
		   	    	findAllStudents();
		   	    	returnMain();
		   	    	break;
		   	    case 2: 
		   	    	System.out.println("请输入你要查询的编号");
		   	    	int stuno = sc.nextInt();
		   	    	
		   	    	
		   	    	findStuById(studao.findStudentById(stuno));
		   	    	returnMain();
		   	    	break;
		   	    case 3:
		   	    	System.out.println("请输入你要查询的姓名");
		   	    	String stuname = sc.next();
		   	    	
		   	    	
		   	    	findByName(studao.findStudentsByName(stuname));
		   	    	returnMain();
		   	    	break;
		   	    case 4:
		   	    	System.out.println("请输入你要查询的班级编号");
		   	    	int classno = sc.nextInt();
		   	    	
		   	    	
		   	    	System.out.println("人数为"+studao.findCountsByClassno(classno));
		   	    	returnMain();
		   	    	break;
		   	    case 5:
		   	    	
		   	    	addStu2();
		   	    	returnMain();
		   	    	break;
		   	    case 6:
		   	    	System.out.println("请输入你要删除的学生编号");
		   	    	int stuno2 = sc.nextInt();
		   	    	
		   	    	if(studao.deleteEmp(stuno2)!=0) {
		   	    		System.out.println("删除成功");
		   	    	}else {
		   	    		System.out.println("删除失败");
		   	    	}
		   	    	returnMain();
		   	    	break;
		   	    case 7:
		   	    	updateStu();	   	    	
		   	    	returnMain();
		   	    	break;
		   	    case 8:
		   	    	System.out.println("请输入你要查询的专业");
		   	    	String speciality = sc.next();
		   	    	System.out.println("请输入你要查询的性别");
		   	    	String studentsex = sc.next();
		   	 	    System.out.println("请输入你要查询的是否是党员（1/0）");
	   	    	    int isparty = sc.nextInt();
	   	    	    
	   	    	    
		   	    	findByA(studao.findStudentByA(speciality, studentsex, isparty));
		   	    	
		   	    	break;
		   	    case 9:
		   	    	System.out.println("\n谢谢 使 用！");
		   	    	break;
		   	 }
	    }
		
		
		
	


	


	


		


		/**
	     * 返回主菜单
		 * @throws ParseException 
		 * @throws SQLException 
	     */
	    public static void returnMain(){
	   	 Scanner input = new Scanner(System.in); 
	   	 System.out.print("输入0返回：");
	        if(input.nextInt() == 0){
	       	 startMenu();
	        }else{
	       	 System.out.println("输入错误, 异常终止！");
	        }
	    }
		
	//---------------------------------------------
	    private static void findAllStudents() {
			// 查找全部
			System.out.println("学生编号\t\t学生姓名\t学生性别\t出生日期\t\t专业\t班级\t是否入党\t\tEmail\t\tqq\t\t地址");
			List<students> stus = studao.findAllstudents();
			for(students stu:stus) {
				System.out.print(stu.getStudentno()+"\t");
				System.out.print(stu.getStudentname()+"\t");
				System.out.print(stu.getStudentsex()+"\t");
				System.out.print(stu.getBirthday()+"\t");
				System.out.print(stu.getSpeciality()+"\t");
				System.out.print(stu.getClassno()+"\t");
				System.out.print(stu.getIsparty()+"\t");
				System.out.print(stu.getEmail()+"\t\t");
				System.out.print(stu.getQq()+"\t");
				System.out.println(stu.getHomeaddress()+"\t");
				
			}
			
			
		}
	    //--------------------------------------------------
		private static void findStuById(students stu) {
			// 靠ID来查询学生
			System.out.println("学生编号\t\t学生姓名\t学生性别\t出生日期\t\t专业\t班级\t是否入党\t\tEmail\t\tqq\t\t地址");
			
			if(stu!=null) {
				System.out.print(stu.getStudentno()+"\t");
				System.out.print(stu.getStudentname()+"\t");
				System.out.print(stu.getStudentsex()+"\t");
				System.out.print(stu.getBirthday()+"\t");
				System.out.print(stu.getSpeciality()+"\t");
				System.out.print(stu.getClassno()+"\t");
				System.out.print(stu.getIsparty()+"\t");
				System.out.print(stu.getEmail()+"\t\t");
				System.out.print(stu.getQq()+"\t");
				System.out.println(stu.getHomeaddress()+"\t");
			}else {
				System.out.println("查无此人");
			}
				
				
		}
		//-------------------------------------------------------
		
		private static void addStu2() {
			// 添加新的学生信息
			try {
				

				System.out.println("请输入你要添加的学生编号:");
				int studentno = sc.nextInt();
				System.out.println("请输入你要添加的学生名");
				String studentname = sc.next();
				System.out.println("请输入你要添加的学生性别");
				String studentsex = sc.next();
				System.out.println("请输入你要添加的出生日期");
				String date = sc.next();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday= (Date) sdf.parse(date);
				System.out.println("请输入你要添加的专业");
				String speciality = sc.next();
				System.out.println("请输入你要添加的班级");
				int classno = sc.nextInt();
				System.out.println("请输入你要添加的是否入党");
				int isparty = sc.nextInt();
				System.out.println("请输入你要添加的email");
				String email = sc.next();
				System.out.println("请输入你要添加的qq");
				int qq = sc.nextInt();
				System.out.println("请输入你要添加的家庭地址");
				String homeaddress = sc.next();
				
				students stu2 = new students( studentno, studentname,  studentsex, birthday, speciality, classno,
				isparty, email, qq, homeaddress);
				students s = new students();
				
				int num =  studao.addstu(stu2);
			
		
				
				if(num>0) {
					System.out.println("添加成功");
					
				}else {
					System.out.println("添加失败");
				}

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		//----------------------------------------------------------
		
		private static void updateStu() {
			// 修改信息
			try {
						
				System.out.println("请输入你要添加的学生编号:");
				int studentno = sc.nextInt();
				System.out.println("请输入你要添加的学生名");
				String studentname = sc.next();
				System.out.println("请输入你要添加的学生性别");
				String studentsex = sc.next();
				System.out.println("请输入你要添加的出生日期");
				String date = sc.next();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday= (Date) sdf.parse(date);
				System.out.println("请输入你要添加的专业");
				String speciality = sc.next();
				System.out.println("请输入你要添加的班级");
				int classno = sc.nextInt();
				System.out.println("请输入你要添加的是否入党");
				int isparty = sc.nextInt();
				System.out.println("请输入你要添加的email");
				String email = sc.next();
				System.out.println("请输入你要添加的qq");
				int qq = sc.nextInt();
				System.out.println("请输入你要添加的家庭地址");
				String homeaddress = sc.next();
				students stu2 = new students( studentno, studentname,  studentsex, birthday, speciality, classno,
						isparty, email, qq, homeaddress);
				
				int num = studao.updateEmp(stu2);

				if(num>0) {
					System.out.println("修改成功");
					
				}else {
					System.out.println("修改失败");
				}

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		
		//------------------------------------------------------
		private static void findByName(List<students> stus) {
			// 姓名查询
			
	System.out.println("学生编号\t\t学生姓名\t学生性别\t出生日期\t\t专业\t班级\t是否入党\t\tEmail\t\tqq\t\t地址");
			
	  for(students stu:stus) {
		System.out.print(stu.getStudentno()+"\t");
		System.out.print(stu.getStudentname()+"\t");
		System.out.print(stu.getStudentsex()+"\t");
		System.out.print(stu.getBirthday()+"\t");
		System.out.print(stu.getSpeciality()+"\t");
		System.out.print(stu.getClassno()+"\t");
		System.out.print(stu.getIsparty()+"\t");
		System.out.print(stu.getEmail()+"\t\t");
		System.out.print(stu.getQq()+"\t");
		System.out.println(stu.getHomeaddress()+"\t");
		
	   }
	 		
			
		}
	
		
//-----------------------------------------------------------		
		
		private static void findByA(students stu) {
			// 特殊查询专业性别为X是党员
         System.out.println("学生编号\t\t学生姓名\t学生性别\t出生日期\t\t专业\t班级\t是否入党\t\tEmail\t\tqq\t\t地址");
			
			if(stu!=null) {
				System.out.print(stu.getStudentno()+"\t");
				System.out.print(stu.getStudentname()+"\t");
				System.out.print(stu.getStudentsex()+"\t");
				System.out.print(stu.getBirthday()+"\t");
				System.out.print(stu.getSpeciality()+"\t");
				System.out.print(stu.getClassno()+"\t");
				System.out.print(stu.getIsparty()+"\t");
				System.out.print(stu.getEmail()+"\t\t");
				System.out.print(stu.getQq()+"\t");
				System.out.println(stu.getHomeaddress()+"\t");
			}else {
				System.out.println("查无此人");
			}
			
			
			
			
			
		}
		
		
		
		
		
	    
	    
	
	
	
	
}
