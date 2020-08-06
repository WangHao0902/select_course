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
		// ����ѧ��
		String studentName="";
		System.out.println("����ѧ�����ƣ�");
		studentName=input.next();
		String studentClass="";
		System.out.println("����ѧ���༉��");
		studentClass=input.next();
		int studentid = sdao.saveStudent(studentName,studentClass);
        if(studentid > 0) {
            System.out.println("�½�ѧ�������ɹ���ѧ�����Ϊ��"+studentid);
        }else {
            System.out.println("�½�ѧ������ʧ�ܣ�");
        }
	}
	
	@Override
	public Student Login() {
		// TODO Auto-generated method stub
		System.out.println("����W��id");
		int studentID=input.nextInt();
		
		return sdao.Login(studentID);
		
	}

	@Override
	public void showCourse() {
		// TODO Auto-generated method stub
		System.out.println("����W��id");
		int studentID=input.nextInt();

		List<Course> slist =sdao.courseBystudentID(studentID);
		System.out.println("����"+slist.size()+"�l�x�n��Ϣ");
		System.out.println("�x�n��Ϣ�飺");
		for (int i = 0; i < slist.size(); i++) {
			System.out.println(slist.get(i).toString());
		}
	}

	
	@Override
	public void chooseCourse() {
		// TODO Auto-generated method stub
		String teacherName="";
		String courseName="";

		System.out.println("�Ƿ���ݽ�ʦ���ƽ���ѡ��(y/n)");
		String str = input.next();
		if(str.equals("y")){
			System.out.println("����Ҫѡ��Ľ�ʦ���ƣ�");
			teacherName=input.next();
		}
		System.out.println("�Ƿ���ݿγ����ƽ���ѡ��(y/n)");
		String str2 = input.next();
		if(str2.equals("y")){
			System.out.println("����Ҫѡ��Ŀγ����ƣ�");
			courseName=input.next();
		}
		List<Course> slist =sdao.listCourse(teacherName, courseName);
		System.out.println("�ɹ�ѡ����x�n��Ϣ�飺");
		for (int i = 0; i < slist.size(); i++) {
			System.out.println(slist.get(i).toString());
		}
		
		System.out.println("����W��id");
		int studentID=input.nextInt();
		int courseID=0;
		System.out.println("�Ƿ���ݿ�ѡ��Ŀγ�ID����ѡ��(y/n)");
		String str3 = input.next();
		if(str3.equals("y")){
			System.out.println("����Ҫѡ��Ŀγ�ID��");
			courseID=input.nextInt();
		}
		int num = 0;
		num=sdao.panduan(courseID, studentID);
		if(num==0){
			int count=0;
			count=sdao.chooseCourseByID(courseID, studentID);
			if(count>0){
				System.out.println("ѡ�γɹ�");
			}else{
				System.out.println("ѡ��ʧ��");
			}
		}else{
			System.out.println("��ѧ����ѡ�ÿγ�");
		}
		
		
	}

	@Override
	public void showStudent(int studentID) {
		// TODO Auto-generated method stub
		
		Student student = sdao.showStudent(studentID);
		System.out.println(student.toString());
	}



	

}
