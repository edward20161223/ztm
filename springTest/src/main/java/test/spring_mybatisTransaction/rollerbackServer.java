package test.spring_mybatisTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring_mybatis.entry.class_s;
import spring_mybatis.entry.student;


//�������ݱ���ڹ�����ϵ���༶��ѧ����ѧ�����ݰ����༶id��ģ��ͬʱ����༶��ѧ����ѧ����Ϣ��ѧ����Ϣ���벻���ڵİ༶idֵ�������Ѿ�ִ�е�SQL���ع���
//������ȷ���ݣ��༶��ѧ����Ϣͬʱ��ӡ�
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
		
		System.out.println("�������");
		//int testD=1/0;
		
		StudentService.save(xuansheng);
		
	}
}
