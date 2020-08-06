package demo.slecou.dao;


import java.util.List;

import demo.slecou.po.Course;
import demo.slecou.po.Student;

public interface StudentDAO {

	//新增学生
		public int saveStudent(String studentName,String studentClass);
		
		public Student Login(int studentID);
		
		//學生選課信息展示
		public List<Course> courseBystudentID(int studentID);
		
		//学生选课时条件
		public List<Course> listCourse(String teacherName,String courseName);
		public int panduan(int courseID,int studentID);
		public int chooseCourseByID(int courseID,int studentID);
		
		public Student showStudent(int studentID);
		
}
