package demo.slecou;

import java.util.Scanner;

import demo.slecou.po.Admin;
import demo.slecou.po.Teacher;
import demo.slecou.view.AdminView;
import demo.slecou.view.CourseView;
import demo.slecou.view.TeacherView;
import demo.slecou.view.impl.AdminViewpl;
import demo.slecou.view.impl.CourseViewpl;
import demo.slecou.view.impl.TeacherViewpl;


public class SelCouAdminSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SelCouAdminSystem().work();
	}
	
	public void work() {
		
		System.out.println("================================================================================================================");
		System.out.println("\t\t\t\t\t\t选课系统后台管理系统\t\t\t\t\t");
		System.out.println("================================================================================================================");
		
		//登录
		//调用AdminViewpl下的登录方法
		AdminView aview = new AdminViewpl();
		Admin admin = aview.adminLogin();
		if(admin!=null){		
			int num = 0;
			while(num!=3){
//				System.out.println("-----1.显示课程列表		2.修改课程信息		3.新增课程		4.注销课程		5.退出系统-----");
				System.out.println("----- 1.课程管理模块		2.教师管理模块		3.退出系统	-----");
				Scanner input =  new Scanner(System.in);
				num  = input.nextInt();
				switch (num) {
					case 1:
						cour();
						break;
					case 2:
						teach();
						break;
					case 3:
						System.out.println("成功退出，谢谢使用，欢迎下次使用");
						break;
					default:
						System.out.println("没有此功能选项");
						break;
				}
			}
			
		}else{
			System.out.println("登录失败");
			
		}
	}
	public void cour(){
		System.out.println("================================================================================================================");
		System.out.println("\t\t\t\t\t\t选课系统后台管理系统_课程管理员模块\t\t\t\t\t");
		System.out.println("================================================================================================================");
		CourseView cView = new CourseViewpl();
		
		int num = 0;
		while(num!=6){
			System.out.println("-----1.显示课程列表		2.新增课程		3.修改课程信息		4.注销课程		5.查看对应课程下的学生信息		6.退出系统-----");

			Scanner input =  new Scanner(System.in);
			num  = input.nextInt();
			switch (num) {
				case 1:
					cView.showCourse();
					break;
				case 2:
					cView.saveCourse();
					break;
				case 3:
					cView.updateCourse();
					break;
				case 4:
					cView.delete();
					break;
				case 5:
					cView.lookstu();
					break;
				case 6:
					System.out.println("成功退出，谢谢使用，欢迎下次使用");
					break;
				default:
					System.out.println("没有此功能选项");
					break;
			}
		}
		
	}
	
	public void teach(){
		System.out.println("================================================================================================================");
		System.out.println("\t\t\t\t\t\t选课系统后台管理系统_教师管理员模块\t\t\t\t\t");
		System.out.println("================================================================================================================");
		int num = 0;
		TeacherView tView = new TeacherViewpl();
		while(num!=6){
			System.out.println("----- 1.显示教师列表		2.新增教师信息		3.修改教师信息		4.注销教师信息		5.查看对应课程下的学生信息		6.退出系统 -----");

			Scanner input =  new Scanner(System.in);
			num  = input.nextInt();
			switch (num) {
				case 1:
					tView.showTeacher();
					break;
				case 2:
					tView.saveTeacher();
					break;
				case 3:
					tView.updateTeacher();
					break;
				case 4:
					tView.deleteTeacher();
					break;
				case 5:
					tView.lookstu();
					break;
				case 6:
					System.out.println("成功退出，谢谢使用，欢迎下次使用");
					break;
				default:
					System.out.println("没有此功能选项");
					break;
			}
		}
		
	}
	
}
