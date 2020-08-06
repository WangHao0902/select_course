package demo.slecou.view;

import demo.slecou.po.Student;

public interface StudentView {

	public void saveStudent();
	
	public Student Login();
	
	public void showCourse();
	
	public void chooseCourse();
	
	public void showStudent(int studentID);
	
}
