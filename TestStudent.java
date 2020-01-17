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
		//��¼����
		
		System.out.println("�������û���");
		String username = sc.nextLine();
		System.out.println("����������");
		String password = sc.nextLine();
		
		UserDao userDao = new UserDao();
		Users user = userDao.login(username, password);
		
		if(user!=null) {
			System.out.println("��¼�ɹ�");
			System.out.println("���ܲ˵�����");
			startMenu();
		}else {
			System.out.println("��¼ʧ�ܣ��û�������");
		}
		
		
		
	}
	
	
	//��¼����
		public static void loginMenu(){
			System.out.println("\n\n\t\t\t\t��ӭʹ��ѧ������ϵͳ\n\n");
			System.out.println("\t\t\t\t 1. �� ¼ ϵ ͳ\n\n");
			System.out.println("\t\t\t\t 2. �� ��\n\n");
			System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
			System.out.print("��ѡ��,��������:");
			Scanner input=new Scanner(System.in);
			int num=input.nextInt();
			if(num==1){
				userLogin();
			}else{
				System.out.println("�����˳�ϵͳ!");
			}
		}
		
		/**
		 * ���˵�
		 * @throws SQLException 
		 * @throws ParseException 
		 */
		public static void startMenu() {
			 System.out.println("�� ӭ �� �� ѧ�� �� �� ϵ ͳ");
		   	 System.out.println("-------------------------------------");
		   	 System.out.println("1. �鿴ȫ��ѧ��");
		   	 System.out.println("2. ��ѧ����Ų�ѯѧ��");
		   	 System.out.println("3. ������ģ����ѯѧ��");
		   	 System.out.println("4. ���༶��ѯѧ������");	   	 
		   	 System.out.println("5. �����ѧ����Ϣ");
		   	 System.out.println("6. ɾ��ѧ����Ϣ");
		     System.out.println("7. �޸�ѧ����Ϣ");
		     System.out.println("8.�鿴ĳרҵ�Ա�ΪX�ǵ�Ա��ѧ��");
		   	 System.out.println("9. ��         �� ");
		   	 System.out.print("--------------------------------------\n");
		
		   	 System.out.print("��ѡ�� ");
		   	 Scanner input = new Scanner(System.in);
		   	 int choice = input.nextInt();
		   	 switch(choice){
		   	    case 1:
		   	    	findAllStudents();
		   	    	returnMain();
		   	    	break;
		   	    case 2: 
		   	    	System.out.println("��������Ҫ��ѯ�ı��");
		   	    	int stuno = sc.nextInt();
		   	    	
		   	    	
		   	    	findStuById(studao.findStudentById(stuno));
		   	    	returnMain();
		   	    	break;
		   	    case 3:
		   	    	System.out.println("��������Ҫ��ѯ������");
		   	    	String stuname = sc.next();
		   	    	
		   	    	
		   	    	findByName(studao.findStudentsByName(stuname));
		   	    	returnMain();
		   	    	break;
		   	    case 4:
		   	    	System.out.println("��������Ҫ��ѯ�İ༶���");
		   	    	int classno = sc.nextInt();
		   	    	
		   	    	
		   	    	System.out.println("����Ϊ"+studao.findCountsByClassno(classno));
		   	    	returnMain();
		   	    	break;
		   	    case 5:
		   	    	
		   	    	addStu2();
		   	    	returnMain();
		   	    	break;
		   	    case 6:
		   	    	System.out.println("��������Ҫɾ����ѧ�����");
		   	    	int stuno2 = sc.nextInt();
		   	    	
		   	    	if(studao.deleteEmp(stuno2)!=0) {
		   	    		System.out.println("ɾ���ɹ�");
		   	    	}else {
		   	    		System.out.println("ɾ��ʧ��");
		   	    	}
		   	    	returnMain();
		   	    	break;
		   	    case 7:
		   	    	updateStu();	   	    	
		   	    	returnMain();
		   	    	break;
		   	    case 8:
		   	    	System.out.println("��������Ҫ��ѯ��רҵ");
		   	    	String speciality = sc.next();
		   	    	System.out.println("��������Ҫ��ѯ���Ա�");
		   	    	String studentsex = sc.next();
		   	 	    System.out.println("��������Ҫ��ѯ���Ƿ��ǵ�Ա��1/0��");
	   	    	    int isparty = sc.nextInt();
	   	    	    
	   	    	    
		   	    	findByA(studao.findStudentByA(speciality, studentsex, isparty));
		   	    	
		   	    	break;
		   	    case 9:
		   	    	System.out.println("\nлл ʹ �ã�");
		   	    	break;
		   	 }
	    }
		
		
		
	


	


	


		


		/**
	     * �������˵�
		 * @throws ParseException 
		 * @throws SQLException 
	     */
	    public static void returnMain(){
	   	 Scanner input = new Scanner(System.in); 
	   	 System.out.print("����0���أ�");
	        if(input.nextInt() == 0){
	       	 startMenu();
	        }else{
	       	 System.out.println("�������, �쳣��ֹ��");
	        }
	    }
		
	//---------------------------------------------
	    private static void findAllStudents() {
			// ����ȫ��
			System.out.println("ѧ�����\t\tѧ������\tѧ���Ա�\t��������\t\tרҵ\t�༶\t�Ƿ��뵳\t\tEmail\t\tqq\t\t��ַ");
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
			// ��ID����ѯѧ��
			System.out.println("ѧ�����\t\tѧ������\tѧ���Ա�\t��������\t\tרҵ\t�༶\t�Ƿ��뵳\t\tEmail\t\tqq\t\t��ַ");
			
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
				System.out.println("���޴���");
			}
				
				
		}
		//-------------------------------------------------------
		
		private static void addStu2() {
			// ����µ�ѧ����Ϣ
			try {
				

				System.out.println("��������Ҫ��ӵ�ѧ�����:");
				int studentno = sc.nextInt();
				System.out.println("��������Ҫ��ӵ�ѧ����");
				String studentname = sc.next();
				System.out.println("��������Ҫ��ӵ�ѧ���Ա�");
				String studentsex = sc.next();
				System.out.println("��������Ҫ��ӵĳ�������");
				String date = sc.next();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday= (Date) sdf.parse(date);
				System.out.println("��������Ҫ��ӵ�רҵ");
				String speciality = sc.next();
				System.out.println("��������Ҫ��ӵİ༶");
				int classno = sc.nextInt();
				System.out.println("��������Ҫ��ӵ��Ƿ��뵳");
				int isparty = sc.nextInt();
				System.out.println("��������Ҫ��ӵ�email");
				String email = sc.next();
				System.out.println("��������Ҫ��ӵ�qq");
				int qq = sc.nextInt();
				System.out.println("��������Ҫ��ӵļ�ͥ��ַ");
				String homeaddress = sc.next();
				
				students stu2 = new students( studentno, studentname,  studentsex, birthday, speciality, classno,
				isparty, email, qq, homeaddress);
				students s = new students();
				
				int num =  studao.addstu(stu2);
			
		
				
				if(num>0) {
					System.out.println("��ӳɹ�");
					
				}else {
					System.out.println("���ʧ��");
				}

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		//----------------------------------------------------------
		
		private static void updateStu() {
			// �޸���Ϣ
			try {
						
				System.out.println("��������Ҫ��ӵ�ѧ�����:");
				int studentno = sc.nextInt();
				System.out.println("��������Ҫ��ӵ�ѧ����");
				String studentname = sc.next();
				System.out.println("��������Ҫ��ӵ�ѧ���Ա�");
				String studentsex = sc.next();
				System.out.println("��������Ҫ��ӵĳ�������");
				String date = sc.next();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday= (Date) sdf.parse(date);
				System.out.println("��������Ҫ��ӵ�רҵ");
				String speciality = sc.next();
				System.out.println("��������Ҫ��ӵİ༶");
				int classno = sc.nextInt();
				System.out.println("��������Ҫ��ӵ��Ƿ��뵳");
				int isparty = sc.nextInt();
				System.out.println("��������Ҫ��ӵ�email");
				String email = sc.next();
				System.out.println("��������Ҫ��ӵ�qq");
				int qq = sc.nextInt();
				System.out.println("��������Ҫ��ӵļ�ͥ��ַ");
				String homeaddress = sc.next();
				students stu2 = new students( studentno, studentname,  studentsex, birthday, speciality, classno,
						isparty, email, qq, homeaddress);
				
				int num = studao.updateEmp(stu2);

				if(num>0) {
					System.out.println("�޸ĳɹ�");
					
				}else {
					System.out.println("�޸�ʧ��");
				}

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		
		//------------------------------------------------------
		private static void findByName(List<students> stus) {
			// ������ѯ
			
	System.out.println("ѧ�����\t\tѧ������\tѧ���Ա�\t��������\t\tרҵ\t�༶\t�Ƿ��뵳\t\tEmail\t\tqq\t\t��ַ");
			
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
			// �����ѯרҵ�Ա�ΪX�ǵ�Ա
         System.out.println("ѧ�����\t\tѧ������\tѧ���Ա�\t��������\t\tרҵ\t�༶\t�Ƿ��뵳\t\tEmail\t\tqq\t\t��ַ");
			
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
				System.out.println("���޴���");
			}
			
			
			
			
			
		}
		
		
		
		
		
	    
	    
	
	
	
	
}
