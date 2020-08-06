package demo.slecou;

import java.util.Scanner;

import demo.slecou.po.Student;
import demo.slecou.view.StudentView;
import demo.slecou.view.impl.StudentViewpl;


public class SelCouStudentSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SelCouStudentSystem().work();
	}
	
	public void work() {
		
		System.out.println("================================================================================================================");
		System.out.println("\t\t\t\t\t\tѧ������ģ��\t\t\t\t\t");
		System.out.println("================================================================================================================");
		
		
		//��¼
		//����AdminViewpl�µĵ�¼����
		StudentView sView = new StudentViewpl();
		
			int num = 0;
			while(num!=5){
				System.out.println("----- 1.ѧ��ע��		2.ѧ����¼		3.��ѯ�γ�		4.ѧ��ѡ��		5.�˳�ϵͳ	-----");
				Scanner input =  new Scanner(System.in);
				num  = input.nextInt();
				switch (num) {
					case 1:
						sView.saveStudent();
						break;
					case 2:
						Student student=sView.Login();
						if(student!=null){
							System.out.println("��¼�ɹ�");
							sView.showStudent(student.getStudentID());
						}else{
							System.out.println("��¼ʧ��");
						}
						break;
					case 3:
						sView.showCourse();
						break;
					case 4:
						sView.chooseCourse();
						break;
					case 5:
						System.out.println("�ɹ��˳���ллʹ�ã���ӭ�´�ʹ��");
						break;
					default:
						System.out.println("û�д˹���ѡ��");
						break;
				}
			}
	
	}
}
