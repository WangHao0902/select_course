package demo.slecou.view.impl;

import java.util.List;
import java.util.Scanner;

import demo.slecou.dao.AdminDAO;
import demo.slecou.dao.StudentDAO;
import demo.slecou.dao.impl.AdminDAOpl;
import demo.slecou.dao.impl.StudentDAOpl;
import demo.slecou.po.Course;
import demo.slecou.po.Student;
import demo.slecou.view.StudentView;

public class StudentViewpl implements StudentView {
	private StudentDAO  sdao = new StudentDAOpl();
	private Scanner input = new Scanner(System.in);
	@Override
	public void saveStudent() {
		// TODO Auto-generated method stub
		// 新增学生
		String studentName="";
		System.out.println("输入学生名称：");
		studentName=input.next();
		String studentClass="";
		System.out.println("输入学生班級：");
		studentClass=input.next();
		int studentid = sdao.saveStudent(studentName,studentClass);
        if(studentid > 0) {
            System.out.println("新建学生档案成功！学生编号为："+studentid);
        }else {
            System.out.println("新建学生档案失败！");
        }
	}
	
	@Override
	public Student Login() {
		// TODO Auto-generated method stub
		System.out.println("输入學生id");
		int studentID=input.nextInt();
		
		return sdao.Login(studentID);
		
	}

	@Override
	public void showCourse() {
		// TODO Auto-generated method stub
		System.out.println("输入學生id");
		int studentID=input.nextInt();

		List<Course> slist =sdao.courseBystudentID(studentID);
		System.out.println("你有"+slist.size()+"條選課信息");
		System.out.println("選課信息為：");
		for (int i = 0; i < slist.size(); i++) {
			System.out.println(slist.get(i).toString());
		}
	}

	
	@Override
	public void chooseCourse() {
		// TODO Auto-generated method stub
		String teacherName="";
		String courseName="";

		System.out.println("是否根据教师名称进行选课(y/n)");
		String str = input.next();
		if(str.equals("y")){
			System.out.println("输入要选择的教师名称：");
			teacherName=input.next();
		}
		System.out.println("是否根据课程名称进行选课(y/n)");
		String str2 = input.next();
		if(str2.equals("y")){
			System.out.println("输入要选择的课程名称：");
			courseName=input.next();
		}
		List<Course> slist =sdao.listCourse(teacherName, courseName);
		System.out.println("可供选择的選課信息為：");
		for (int i = 0; i < slist.size(); i++) {
			System.out.println(slist.get(i).toString());
		}
		
		System.out.println("输入學生id");
		int studentID=input.nextInt();
		int courseID=0;
		System.out.println("是否根据可选择的课程ID进行选课(y/n)");
		String str3 = input.next();
		if(str3.equals("y")){
			System.out.println("输入要选择的课程ID：");
			courseID=input.nextInt();
		}
		int num = 0;
		num=sdao.panduan(courseID, studentID);
		if(num==0){
			int count=0;
			count=sdao.chooseCourseByID(courseID, studentID);
			if(count>0){
				System.out.println("选课成功");
			}else{
				System.out.println("选课失败");
			}
		}else{
			System.out.println("该学生已选该课程");
		}
		
		
	}

	@Override
	public void showStudent(int studentID) {
		// TODO Auto-generated method stub
		
		Student student = sdao.showStudent(studentID);
		System.out.println(student.toString());
	}



	

}
