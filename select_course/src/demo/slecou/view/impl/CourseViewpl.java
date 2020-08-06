package demo.slecou.view.impl;

import java.util.List;
import java.util.Scanner;

import demo.slecou.dao.CourseDAO;
import demo.slecou.dao.impl.CourseDAOpl;
import demo.slecou.po.Course;
import demo.slecou.po.Student;
import demo.slecou.view.CourseView;

public class CourseViewpl implements CourseView {
	private CourseDAO  sdao = new CourseDAOpl();
	private Scanner input = new Scanner(System.in);
	
	@Override
	public void showCourse() {
		// TODO Auto-generated method stub
		List<Course> slist =sdao.showAll();
		System.out.println("選課信息為：");
		for (int i = 0; i < slist.size(); i++) {
			System.out.println(slist.get(i).toString());
		}
	}

	@Override
	public void saveCourse() {
		//新增课程
		String courseName="";
		System.out.println("输入课程名称：");
		courseName=input.next();
		int courseHour=0;
		System.out.println("输入课程时长：");
		courseHour=input.nextInt();
		int teacherID=0;
		System.out.println("输入教师ID：");
		teacherID=input.nextInt();
		int courseid = sdao.saveCourse(courseName,courseHour,teacherID);
        if(courseid > 0) {
            System.out.println("新建课程成功！课程编号为："+courseid);
        }else {
            System.out.println("新建课程失败！");
        }
	}

	@Override
	public void updateCourse() {
		// 修改课程信息
		Course course=new Course();
		System.out.println("输入课程ID进行课程信息修改");
		int courseID=input.nextInt();
		course.setCourseID(courseID);
		
		int num = sdao.updateCourseyn(courseID);
		if(num>0){
			
			
	            System.out.println("请输入新的课程名称：");
	            course.setCourseName(input.next());
	        
	            System.out.println("请输入新的课程时长：");
	            course.setCourseHour(input.nextInt());
	       
	            System.out.println("请输入新的讲师ID：");
	            course.setTeacherID(input.nextInt());
	        
	        
	        int count = sdao.update(course);
	        if(count>0) {
	            System.out.println("修改成功！");
	        }else {
	            System.out.println("修改失败！");
	        }
	         
		}else{
			System.out.println("课程信息中无该课程ID信息");
		}
		
		

		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("输入需要注销的课程编号：");
		String inStr="";
		int courseID=input.nextInt();
		System.out.println("是否确认删除课程"+courseID+"?(y/n)");
		inStr = input.next();
		if(inStr.equals("y")){
			int num = sdao.removeCourse(courseID);
			if(num>0){
				System.out.println("成功删除，删除了"+num+"条课程信息");
			}else{
				System.out.println("删除失败");
			}
		}
	}

	@Override
	public void lookstu() {
		// TODO Auto-generated method stub
		System.out.println("输入需要查看对应学生的课程编号：");
		int courseID=input.nextInt();
		List<Student> slist =sdao.lookstu(courseID);
		System.out.println("选这门课的学生信息為：");
		for (int i = 0; i < slist.size(); i++) {
			System.out.println(slist.get(i).toString());
		}
	}
}
