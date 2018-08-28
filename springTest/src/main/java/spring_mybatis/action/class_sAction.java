package spring_mybatis.action;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring_mybatis.entry.class_s;
import spring_mybatis.entry.student;
import spring_mybatis.service.StudentService;
import spring_mybatis.service.class_sService;

@Controller
@Transactional
public class class_sAction {
	@Autowired
	private class_sService banjiSevice;
    @Autowired
    private StudentService studentService;
	
	
    @Transactional(propagation=Propagation.REQUIRED)
	public void testTransaction(){
    	try {
 	       //��ȡ�����Ķ���
 	       ApplicationContext context =new ClassPathXmlApplicationContext("springTestRootServlet.xml");
 	       class_sAction banjiAction =(class_sAction)context.getBean("class_sAction");
 	      
 	       Date creationDate=new Date();
 	       //DateFormat df2 = DateFormat.getDateTimeInstance();
 	       //System.out.println(df2.format(creationDate));
 	       //String date=df2.format(creationDate);
 	       class_s banji3 = new class_s("���꼶(4)�༶",creationDate);
 	       banjiAction.banjiSevice.saveBanji(banji3);
 	       
 	       
 	       student student = new student("С��",10,"006",14);
 	       banjiAction.studentService.save(student);
			
		} catch (Exception e) {
			// ����쳣����
			System.out.println("�����쳣�����ݿ����ݻع���");
		}

	       
	}
    
	
    @Test
    public void test(){
    	testTransaction();
    }
	
}
