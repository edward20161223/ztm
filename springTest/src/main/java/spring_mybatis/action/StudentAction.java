package spring_mybatis.action;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import spring_mybatis.entry.student;
import spring_mybatis.service.StudentService;


/*
 * 测试执行查询20180809
 */


@Controller
public class StudentAction {
    @Autowired
    private StudentService studentService;
    
    
    @Test
    public void test1(){
       //获取上下文对象
       ApplicationContext context =new ClassPathXmlApplicationContext("springTestRootServlet.xml");
       StudentAction studentAction =(StudentAction)context.getBean("studentAction");
      
       student student = new student("小张",10,"005",2);
       studentAction.studentService.save(student);
       
       student std = studentAction.studentService.getStudent(1);
       System.out.println(std.getName());
    }
    
    
}
