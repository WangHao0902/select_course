package demo.slecou.dao;

import java.util.List;

import demo.slecou.po.Course;
import demo.slecou.po.Student;

public interface CourseDAO {

	public List<Course> showAll();
	//ĞÂÔö¿Î³Ì
	public int saveCourse(String courseName,int courseHour,int teacherID);
	
	public int updateCourseyn(int courseID);
	
	public int update(Course course);
	
	public int removeCourse(int courseID);
	
	public List<Student> lookstu(int courseID);
}
