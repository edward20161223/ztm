package springTestFramework;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_mybatis.entry.student;
import spring_mybatis.service.StudentService;


public class addStudentTesting {

	@Test
	public void addST(){
		
		//�쳣��bean������ΪStudentService��������ʹ��getBean������ȡbean��ʱ��bean�����ֿ�ʼ��ĸӦ��СдstudentService��
		//�����дStudentService,������쳣����ʾû�ж��������������20190228
		@SuppressWarnings("resource")
		ApplicationContext context =new ClassPathXmlApplicationContext("springTestRootServlet.xml");
		StudentService xueshengService=(StudentService)context.getBean("studentService");
		
		//ֱ�Ӵ�������ִ�з��������쳣��
		//StudentService xueshengService=new StudentService();
		
		try {
			student student = new student("KD",10,"005",2);//����  ����   ѧ��  �༶id
			xueshengService.save(student);
		} catch (Exception e) {
			System.out.println("�������ѧ����Ϣ�쳣!");
		}

	}
}
