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
		System.out.println("�x�n��Ϣ�飺");
		for (int i = 0; i < slist.size(); i++) {
			System.out.println(slist.get(i).toString());
		}
	}

	@Override
	public void saveCourse() {
		//�����γ�
		String courseName="";
		System.out.println("����γ����ƣ�");
		courseName=input.next();
		int courseHour=0;
		System.out.println("����γ�ʱ����");
		courseHour=input.nextInt();
		int teacherID=0;
		System.out.println("�����ʦID��");
		teacherID=input.nextInt();
		int courseid = sdao.saveCourse(courseName,courseHour,teacherID);
        if(courseid > 0) {
            System.out.println("�½��γ̳ɹ����γ̱��Ϊ��"+courseid);
        }else {
            System.out.println("�½��γ�ʧ�ܣ�");
        }
	}

	@Override
	public void updateCourse() {
		// �޸Ŀγ���Ϣ
		Course course=new Course();
		System.out.println("����γ�ID���пγ���Ϣ�޸�");
		int courseID=input.nextInt();
		course.setCourseID(courseID);
		
		int num = sdao.updateCourseyn(courseID);
		if(num>0){
			
			
	            System.out.println("�������µĿγ����ƣ�");
	            course.setCourseName(input.next());
	        
	            System.out.println("�������µĿγ�ʱ����");
	            course.setCourseHour(input.nextInt());
	       
	            System.out.println("�������µĽ�ʦID��");
	            course.setTeacherID(input.nextInt());
	        
	        
	        int count = sdao.update(course);
	        if(count>0) {
	            System.out.println("�޸ĳɹ���");
	        }else {
	            System.out.println("�޸�ʧ�ܣ�");
	        }
	         
		}else{
			System.out.println("�γ���Ϣ���޸ÿγ�ID��Ϣ");
		}
		
		

		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("������Ҫע���Ŀγ̱�ţ�");
		String inStr="";
		int courseID=input.nextInt();
		System.out.println("�Ƿ�ȷ��ɾ���γ�"+courseID+"?(y/n)");
		inStr = input.next();
		if(inStr.equals("y")){
			int num = sdao.removeCourse(courseID);
			if(num>0){
				System.out.println("�ɹ�ɾ����ɾ����"+num+"���γ���Ϣ");
			}else{
				System.out.println("ɾ��ʧ��");
			}
		}
	}

	@Override
	public void lookstu() {
		// TODO Auto-generated method stub
		System.out.println("������Ҫ�鿴��Ӧѧ���Ŀγ̱�ţ�");
		int courseID=input.nextInt();
		List<Student> slist =sdao.lookstu(courseID);
		System.out.println("ѡ���ſε�ѧ����Ϣ�飺");
		for (int i = 0; i < slist.size(); i++) {
			System.out.println(slist.get(i).toString());
		}
	}
}
