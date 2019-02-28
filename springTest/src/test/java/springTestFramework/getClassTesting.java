package springTestFramework;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_mybatis.entry.class_s;
import spring_mybatis.service.class_sService;

public class getClassTesting {

	@Test
	public void getCT(){
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("springTestRootServlet.xml");
		class_sService banjiService =(class_sService)context.getBean("class_sService");
		try {
			class_s cS=new class_s();
			cS=banjiService.getBanji(10);
			System.out.println("student is:"+cS.toString());
		} catch (Exception e) {
			System.out.println("查询班级信息异常！");
		}
	}
}
