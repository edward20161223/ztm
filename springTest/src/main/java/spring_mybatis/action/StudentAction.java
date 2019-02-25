package spring_mybatis.action;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import spring_mybatis.entry.student;
import spring_mybatis.service.StudentService;


/*
 * ����ִ�в�ѯ20180809
 */


@Controller
public class StudentAction {
    @Autowired
    private StudentService studentService;
    
    
    @Test
    public void test1(){
       //��ȡ�����Ķ���
       ApplicationContext context =new ClassPathXmlApplicationContext("springTestRootServlet.xml");
       StudentAction studentAction =(StudentAction)context.getBean("studentAction");
      
       student student = new student("С��",10,"005",2);
       studentAction.studentService.save(student);
       
       student std = studentAction.studentService.getStudent(1);
       System.out.println(std.getName());
    }
    
    
}
