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
		System.out.println("選課信息為：");
		for (int i = 0; i < tlist.size(); i++) {
			System.out.println(tlist.get(i).toString());
		}
	}

	@Override
	public void saveTeacher() {
		// TODO Auto-generated method stub
		//新增教师
				String teacherName="";
				System.out.println("输入教师名称：");
				teacherName=input.next();
				String technology="";
				System.out.println("输入教师专业方向：");
				technology=input.next();
				int teacherID = tdao.saveTeacher(teacherName,technology);
		        if(teacherID > 0) {
		            System.out.println("新建教师成功！教师编号为："+teacherID);
		        }else {
		            System.out.println("新建教师失败！");
		        }
	}

	@Override
	public void updateTeacher() {
		// TODO Auto-generated method stub
		Teacher teacher=new Teacher();
		System.out.println("输入教师ID进行教师信息修改");
		int teacherID=input.nextInt();
		teacher.setTeacherID(teacherID);
		
		int num = tdao.updateTeacheryn(teacherID);
		if(num>0){
			
			
	            System.out.println("请输入新的教师名称：");
	            teacher.setTeacherName(input.next());
	        
	            System.out.println("请输入新的教师专业方向：");
	            teacher.setTechnology(input.next());
  
	        int count = tdao.update(teacher);
	        if(count>0) {
	            System.out.println("修改成功！");
	        }else {
	            System.out.println("修改失败！");
	        }
	         
		}else{
			System.out.println("教师信息中无该教师ID信息");
		}
	}

	@Override
	public void deleteTeacher() {
		// TODO Auto-generated method stub
		System.out.println("输入需要注销的教师编号：");
		String inStr="";
		int teacherID=input.nextInt();
		System.out.println("是否确认删除教师"+teacherID+"?(y/n)");
		inStr = input.next();
		if(inStr.equals("y")){
			int num = tdao.removeTeacher(teacherID);
			if(num>0){
				System.out.println("成功删除，删除了"+num+"条教师信息");
			}else{
				System.out.println("删除失败");
			}
		}
	}

	@Override
	public void lookstu() {
		// TODO Auto-generated method stub
		System.out.println("输入需要查看对应学生的教师ID：");
		int teacherID=input.nextInt();
		List<Student> slist =tdao.lookstu(teacherID);
		System.out.println("选这门课的学生信息為：");
		System.out.println(slist.size());
		for (int i = 0; i < slist.size(); i++) {
			System.out.println(slist.get(i).toString());
		}
	}
	

}
