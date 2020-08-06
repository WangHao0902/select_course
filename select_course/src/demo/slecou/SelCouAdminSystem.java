package demo.slecou;

import java.util.Scanner;

import demo.slecou.po.Admin;
import demo.slecou.po.Teacher;
import demo.slecou.view.AdminView;
import demo.slecou.view.CourseView;
import demo.slecou.view.TeacherView;
import demo.slecou.view.impl.AdminViewpl;
import demo.slecou.view.impl.CourseViewpl;
import demo.slecou.view.impl.TeacherViewpl;


public class SelCouAdminSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SelCouAdminSystem().work();
	}
	
	public void work() {
		
		System.out.println("================================================================================================================");
		System.out.println("\t\t\t\t\t\tѡ��ϵͳ��̨����ϵͳ\t\t\t\t\t");
		System.out.println("================================================================================================================");
		
		//��¼
		//����AdminViewpl�µĵ�¼����
		AdminView aview = new AdminViewpl();
		Admin admin = aview.adminLogin();
		if(admin!=null){		
			int num = 0;
			while(num!=3){
//				System.out.println("-----1.��ʾ�γ��б�		2.�޸Ŀγ���Ϣ		3.�����γ�		4.ע���γ�		5.�˳�ϵͳ-----");
				System.out.println("----- 1.�γ̹���ģ��		2.��ʦ����ģ��		3.�˳�ϵͳ	-----");
				Scanner input =  new Scanner(System.in);
				num  = input.nextInt();
				switch (num) {
					case 1:
						cour();
						break;
					case 2:
						teach();
						break;
					case 3:
						System.out.println("�ɹ��˳���ллʹ�ã���ӭ�´�ʹ��");
						break;
					default:
						System.out.println("û�д˹���ѡ��");
						break;
				}
			}
			
		}else{
			System.out.println("��¼ʧ��");
			
		}
	}
	public void cour(){
		System.out.println("================================================================================================================");
		System.out.println("\t\t\t\t\t\tѡ��ϵͳ��̨����ϵͳ_�γ̹���Աģ��\t\t\t\t\t");
		System.out.println("================================================================================================================");
		CourseView cView = new CourseViewpl();
		
		int num = 0;
		while(num!=6){
			System.out.println("-----1.��ʾ�γ��б�		2.�����γ�		3.�޸Ŀγ���Ϣ		4.ע���γ�		5.�鿴��Ӧ�γ��µ�ѧ����Ϣ		6.�˳�ϵͳ-----");

			Scanner input =  new Scanner(System.in);
			num  = input.nextInt();
			switch (num) {
				case 1:
					cView.showCourse();
					break;
				case 2:
					cView.saveCourse();
					break;
				case 3:
					cView.updateCourse();
					break;
				case 4:
					cView.delete();
					break;
				case 5:
					cView.lookstu();
					break;
				case 6:
					System.out.println("�ɹ��˳���ллʹ�ã���ӭ�´�ʹ��");
					break;
				default:
					System.out.println("û�д˹���ѡ��");
					break;
			}
		}
		
	}
	
	public void teach(){
		System.out.println("================================================================================================================");
		System.out.println("\t\t\t\t\t\tѡ��ϵͳ��̨����ϵͳ_��ʦ����Աģ��\t\t\t\t\t");
		System.out.println("================================================================================================================");
		int num = 0;
		TeacherView tView = new TeacherViewpl();
		while(num!=6){
			System.out.println("----- 1.��ʾ��ʦ�б�		2.������ʦ��Ϣ		3.�޸Ľ�ʦ��Ϣ		4.ע����ʦ��Ϣ		5.�鿴��Ӧ�γ��µ�ѧ����Ϣ		6.�˳�ϵͳ -----");

			Scanner input =  new Scanner(System.in);
			num  = input.nextInt();
			switch (num) {
				case 1:
					tView.showTeacher();
					break;
				case 2:
					tView.saveTeacher();
					break;
				case 3:
					tView.updateTeacher();
					break;
				case 4:
					tView.deleteTeacher();
					break;
				case 5:
					tView.lookstu();
					break;
				case 6:
					System.out.println("�ɹ��˳���ллʹ�ã���ӭ�´�ʹ��");
					break;
				default:
					System.out.println("û�д˹���ѡ��");
					break;
			}
		}
		
	}
	
}
