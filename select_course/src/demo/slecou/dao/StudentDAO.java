package demo.slecou.dao;


import java.util.List;

import demo.slecou.po.Course;
import demo.slecou.po.Student;

public interface StudentDAO {

	//����ѧ��
		public int saveStudent(String studentName,String studentClass);
		
		public Student Login(int studentID);
		
		//�W���x�n��Ϣչʾ
		public List<Course> courseBystudentID(int studentID);
		
		//ѧ��ѡ��ʱ����
		public List<Course> listCourse(String teacherName,String courseName);
		public int panduan(int courseID,int studentID);
		public int chooseCourseByID(int courseID,int studentID);
		
		public Student showStudent(int studentID);
		
}
