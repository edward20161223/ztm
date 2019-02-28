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
	
	//使用spring注解事务无效，解决问题方法：修改SpringMVC配置文件，在配置文件中扫描包中，添加过滤掉@service表示的类
    //不修改之前，只能通过代码解析上下文，事务注解才能生效，如下面的写法
    
    @Transactional(propagation=Propagation.REQUIRED)
	public void testTransaction(){
    	try {
 	       //获取上下文对象
 	       ApplicationContext context =new ClassPathXmlApplicationContext("springTestRootServlet.xml");
 	       class_sAction banjiAction =(class_sAction)context.getBean("class_sAction");
 	      
 	       Date creationDate=new Date();
 	       //DateFormat df2 = DateFormat.getDateTimeInstance();
 	       //System.out.println(df2.format(creationDate));
 	       //String date=df2.format(creationDate);
 	       class_s banji3 = new class_s("二年级(4)班级",creationDate);
 	       banjiAction.banjiSevice.saveBanji(banji3);
 	       
 	       
 	       student student = new student("小李",10,"006",14);
 	       banjiAction.studentService.save(student);
			
		} catch (Exception e) {
			// 输出异常提醒
			System.out.println("产生异常，数据库数据回滚！");
		}

	       
	}
    
	
    @Test
    public void test(){
    	testTransaction();
    }
	
}
