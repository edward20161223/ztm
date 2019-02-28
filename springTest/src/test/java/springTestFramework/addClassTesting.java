package springTestFramework;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import spring_mybatis.entry.class_s;
import spring_mybatis.service.class_sService;

public class addClassTesting {

	@Test
	public void addCT(){
	    //获取上下文对象
	    @SuppressWarnings("resource")
		ApplicationContext context =new ClassPathXmlApplicationContext("springTestRootServlet.xml");
	    class_sService banjiService =(class_sService)context.getBean("class_sService");
	    try {
	 	     Date creationDate=new Date();
	 	     class_s banji = new class_s("班级testing",creationDate);
	 	     banjiService.saveBanji(banji);
		} catch (Exception e) {
			 System.out.println("测试执行添加班级信息异常！");
		}

	}
	

}
