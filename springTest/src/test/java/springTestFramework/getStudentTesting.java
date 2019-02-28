package springTestFramework;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_mybatis.entry.student;
import spring_mybatis.service.StudentService;

/*
 * 模拟spring软件开发实现接口测试20190228
 */

public class getStudentTesting {
	@Test
	public void getStuent(){
		@SuppressWarnings("resource")
		ApplicationContext context =new ClassPathXmlApplicationContext("springTestRootServlet.xml");
		StudentService xueshengService=(StudentService)context.getBean("studentService");
		try {
			student ss=xueshengService.getStudent(10);
			System.out.println("student is:"+ss.toString());
		} catch (Exception e) {
			System.out.println("getstudent异常");
		}	
	}
	

}
