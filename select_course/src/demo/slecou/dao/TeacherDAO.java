package demo.slecou.dao;

import java.util.List;

import demo.slecou.po.Student;
import demo.slecou.po.Teacher;

public interface TeacherDAO {

	public List<Teacher> showAll();
	
	public int saveTeacher(String teacherName,String technology);
	
	public int updateTeacheryn(int teacherID);
	
	public int update(Teacher teacher);
	
	public int removeTeacher(int teacherID);
	
	public List<Student> lookstu(int teacherID);
	
}
