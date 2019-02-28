package springTestFramework;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_mybatis.entry.student;
import spring_mybatis.service.StudentService;


public class addStudentTesting {

	@Test
	public void addST(){
		
		//异常，bean的名字为StudentService，但是在使用getBean方法获取bean的时候，bean的名字开始字母应该小写studentService。
		//如果大写StudentService,会产生异常，显示没有定这样的类的名字20190228
		@SuppressWarnings("resource")
		ApplicationContext context =new ClassPathXmlApplicationContext("springTestRootServlet.xml");
		StudentService xueshengService=(StudentService)context.getBean("studentService");
		
		//直接创建对象，执行方法产生异常，
		//StudentService xueshengService=new StudentService();
		
		try {
			student student = new student("KD",10,"005",2);//姓名  年龄   学号  班级id
			xueshengService.save(student);
		} catch (Exception e) {
			System.out.println("测试添加学生信息异常!");
		}

	}
}
