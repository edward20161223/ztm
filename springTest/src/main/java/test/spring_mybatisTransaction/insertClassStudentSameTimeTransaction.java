package test.spring_mybatisTransaction;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring_mybatis.action.class_sAction;
import spring_mybatis.entry.class_s;
import spring_mybatis.entry.student;


//模拟实现同时添加班级和人员信息，人员信息中的班级参考班级表的id，
//测试spring整合redis后，使用spring的事务功能实现事务处理
//添加事务管理，模拟数据库执行多条语句，其中一条执行失败，其他全部回滚20190226


@Controller
public class insertClassStudentSameTimeTransaction {
	
	@Autowired
	private rollerbackServer rollerbackServer;
	
	@RequestMapping("/insertCS")
	
	public String  insertClassStudent(String class_name,String name,Integer age,String school_number,Integer class_s,Model model){
		
		System.out.println("班级名称:"+class_name+"人名:"+name);
		
		//ApplicationContext context =new ClassPathXmlApplicationContext("springTestRootServlet.xml");
		//rollerbackServer rollerbackServer =(rollerbackServer)context.getBean("rollerbackServer");
		
		Date creationDate=new Date();
		class_s banji=new spring_mybatis.entry.class_s(class_name, creationDate);
		student xuesheng=new student(name,age,school_number,class_s);
		
		
		try {
			rollerbackServer.insertClassStudent(banji, xuesheng);
			System.out.println("事务提交成功！");
			return "deleteClassDataFromRedisSuccessful";
		} catch (Exception e) {
			System.out.println("插入数据失败，执行数spring事务回滚!");
			return "deleteClassDataFromRedisFail";
		}
		
		
		
	}
}
