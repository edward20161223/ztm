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
	    //��ȡ�����Ķ���
	    @SuppressWarnings("resource")
		ApplicationContext context =new ClassPathXmlApplicationContext("springTestRootServlet.xml");
	    class_sService banjiService =(class_sService)context.getBean("class_sService");
	    try {
	 	     Date creationDate=new Date();
	 	     class_s banji = new class_s("�༶testing",creationDate);
	 	     banjiService.saveBanji(banji);
		} catch (Exception e) {
			 System.out.println("����ִ����Ӱ༶��Ϣ�쳣��");
		}

	}
	

}
