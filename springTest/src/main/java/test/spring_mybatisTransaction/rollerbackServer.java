package test.spring_mybatisTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring_mybatis.entry.class_s;
import spring_mybatis.entry.student;


//设置数据表存在关联关系，班级，学生。学生数据包含班级id，模拟同时插入班级与学生，学生信息，学生信息输入不存在的班级id值，导致已经执行的SQL语句回滚。
//输入正确数据，班级与学生信息同时添加。
//20190227


@Service
public class rollerbackServer {

	@Autowired
	private spring_mybatis.service.class_sService class_sService;
	
	@Autowired
	private spring_mybatis.service.StudentService StudentService;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public void insertClassStudent(class_s banjie,student xuansheng){
		
		class_sService.saveBanji(banjie);
		
		System.out.println("事务测试");
		//int testD=1/0;
		
		StudentService.save(xuansheng);
		
	}
}
