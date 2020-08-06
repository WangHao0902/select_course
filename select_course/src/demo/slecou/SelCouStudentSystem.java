package demo.slecou;

import java.util.Scanner;

import demo.slecou.po.Student;
import demo.slecou.view.StudentView;
import demo.slecou.view.impl.StudentViewpl;


public class SelCouStudentSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SelCouStudentSystem().work();
	}
	
	public void work() {
		
		System.out.println("================================================================================================================");
		System.out.println("\t\t\t\t\t\t学生管理模块\t\t\t\t\t");
		System.out.println("================================================================================================================");
		
		
		//登录
		//调用AdminViewpl下的登录方法
		StudentView sView = new StudentViewpl();
		
			int num = 0;
			while(num!=5){
				System.out.println("----- 1.学生注册		2.学生登录		3.查询课程		4.学生选课		5.退出系统	-----");
				Scanner input =  new Scanner(System.in);
				num  = input.nextInt();
				switch (num) {
					case 1:
						sView.saveStudent();
						break;
					case 2:
						Student student=sView.Login();
						if(student!=null){
							System.out.println("登录成功");
							sView.showStudent(student.getStudentID());
						}else{
							System.out.println("登录失败");
						}
						break;
					case 3:
						sView.showCourse();
						break;
					case 4:
						sView.chooseCourse();
						break;
					case 5:
						System.out.println("成功退出，谢谢使用，欢迎下次使用");
						break;
					default:
						System.out.println("没有此功能选项");
						break;
				}
			}
	
	}
}
