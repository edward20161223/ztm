package test.spring_mybatisTransaction;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring_mybatis.entry.class_s;
import spring_mybatis.entry.student;


//ģ��ʵ��ͬʱ��Ӱ༶����Ա��Ϣ����Ա��Ϣ�еİ༶�ο��༶���id��
//����spring����redis��ʹ��spring��������ʵ��������
//����������ģ�����ݿ�ִ�ж�����䣬����һ��ִ��ʧ�ܣ�����ȫ���ع�20190226


@Controller
public class insertClassStudentSameTimeTransaction {

	@Autowired
	private spring_mybatis.service.class_sService class_sService;
	
	@Autowired
	private spring_mybatis.service.StudentService StudentService;
	
	
	@RequestMapping("/insertCS")
	public String  insertClassStudent(String class_name,String name,Integer age,String school_number,Integer class_s,Model model){
		
		System.out.println("�༶����:"+class_name+"����:"+name);
		Date creationDate=new Date();
		class_s banji=new spring_mybatis.entry.class_s(class_name, creationDate);
		student xuesheng=new student(name,age,school_number,class_s);
		
		class_sService.saveBanji(banji);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		StudentService.save(xuesheng);
		
		return "deleteClassDataFromRedisSuccessful";
	}
}
