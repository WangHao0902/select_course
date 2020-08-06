package demo.slecou.view.impl;

import java.util.List;
import java.util.Scanner;

import demo.slecou.dao.TeacherDAO;
import demo.slecou.dao.impl.TeacherDAOpl;
import demo.slecou.po.Student;
import demo.slecou.po.Teacher;
import demo.slecou.view.TeacherView;

public class TeacherViewpl implements TeacherView {
	private TeacherDAO  tdao = new TeacherDAOpl();
	private Scanner input = new Scanner(System.in);
	@Override
	public void showTeacher() {
		// TODO Auto-generated method stub
		List<Teacher> tlist =tdao.showAll();
		System.out.println("�x�n��Ϣ�飺");
		for (int i = 0; i < tlist.size(); i++) {
			System.out.println(tlist.get(i).toString());
		}
	}

	@Override
	public void saveTeacher() {
		// TODO Auto-generated method stub
		//������ʦ
				String teacherName="";
				System.out.println("�����ʦ���ƣ�");
				teacherName=input.next();
				String technology="";
				System.out.println("�����ʦרҵ����");
				technology=input.next();
				int teacherID = tdao.saveTeacher(teacherName,technology);
		        if(teacherID > 0) {
		            System.out.println("�½���ʦ�ɹ�����ʦ���Ϊ��"+teacherID);
		        }else {
		            System.out.println("�½���ʦʧ�ܣ�");
		        }
	}

	@Override
	public void updateTeacher() {
		// TODO Auto-generated method stub
		Teacher teacher=new Teacher();
		System.out.println("�����ʦID���н�ʦ��Ϣ�޸�");
		int teacherID=input.nextInt();
		teacher.setTeacherID(teacherID);
		
		int num = tdao.updateTeacheryn(teacherID);
		if(num>0){
			
			
	            System.out.println("�������µĽ�ʦ���ƣ�");
	            teacher.setTeacherName(input.next());
	        
	            System.out.println("�������µĽ�ʦרҵ����");
	            teacher.setTechnology(input.next());
  
	        int count = tdao.update(teacher);
	        if(count>0) {
	            System.out.println("�޸ĳɹ���");
	        }else {
	            System.out.println("�޸�ʧ�ܣ�");
	        }
	         
		}else{
			System.out.println("��ʦ��Ϣ���޸ý�ʦID��Ϣ");
		}
	}

	@Override
	public void deleteTeacher() {
		// TODO Auto-generated method stub
		System.out.println("������Ҫע���Ľ�ʦ��ţ�");
		String inStr="";
		int teacherID=input.nextInt();
		System.out.println("�Ƿ�ȷ��ɾ����ʦ"+teacherID+"?(y/n)");
		inStr = input.next();
		if(inStr.equals("y")){
			int num = tdao.removeTeacher(teacherID);
			if(num>0){
				System.out.println("�ɹ�ɾ����ɾ����"+num+"����ʦ��Ϣ");
			}else{
				System.out.println("ɾ��ʧ��");
			}
		}
	}

	@Override
	public void lookstu() {
		// TODO Auto-generated method stub
		System.out.println("������Ҫ�鿴��Ӧѧ���Ľ�ʦID��");
		int teacherID=input.nextInt();
		List<Student> slist =tdao.lookstu(teacherID);
		System.out.println("ѡ���ſε�ѧ����Ϣ�飺");
		System.out.println(slist.size());
		for (int i = 0; i < slist.size(); i++) {
			System.out.println(slist.get(i).toString());
		}
	}
	

}
