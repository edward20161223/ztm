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


//ģ��ʵ��ͬʱ��Ӱ༶����Ա��Ϣ����Ա��Ϣ�еİ༶�ο��༶���id��
//����spring����redis��ʹ��spring��������ʵ��������
//����������ģ�����ݿ�ִ�ж�����䣬����һ��ִ��ʧ�ܣ�����ȫ���ع�20190226


@Controller
public class insertClassStudentSameTimeTransaction {
	
	@Autowired
	private rollerbackServer rollerbackServer;
	
	@RequestMapping("/insertCS")
	
	public String  insertClassStudent(String class_name,String name,Integer age,String school_number,Integer class_s,Model model){
		
		System.out.println("�༶����:"+class_name+"����:"+name);
		
		//ApplicationContext context =new ClassPathXmlApplicationContext("springTestRootServlet.xml");
		//rollerbackServer rollerbackServer =(rollerbackServer)context.getBean("rollerbackServer");
		
		Date creationDate=new Date();
		class_s banji=new spring_mybatis.entry.class_s(class_name, creationDate);
		student xuesheng=new student(name,age,school_number,class_s);
		
		
		try {
			rollerbackServer.insertClassStudent(banji, xuesheng);
			System.out.println("�����ύ�ɹ���");
			return "deleteClassDataFromRedisSuccessful";
		} catch (Exception e) {
			System.out.println("��������ʧ�ܣ�ִ����spring����ع�!");
			return "deleteClassDataFromRedisFail";
		}
		
		
		
	}
}
