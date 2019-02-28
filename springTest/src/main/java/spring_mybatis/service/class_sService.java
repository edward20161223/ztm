package spring_mybatis.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_mybatis.dao.class_sDAO;
import spring_mybatis.entry.class_s;

@Service
public class class_sService {

	@Autowired
	private class_sDAO banjiDao;
	
	
	public void saveBanji(class_s banji){
		banjiDao.saveBanji(banji);
	}
	
	/*
	public class_s getBanji(int banji_id){
		class_s banji=banjiDao.getBanji(banji_id);
		return banji;
	}
	*/
	
	
	//���redis����֧�֣����ݷ��뻺�棬���ݴӻ����в�ѯ    20190225
	@Autowired
	private redis_spring.test.RedisCacheManagerMy RedisCacheManagerMy;
	
	
	public class_s getBanji(int banji_id){
		class_s banji;
		StringBuilder classkey=new StringBuilder();
		classkey.append("class_s");
		classkey.append(banji_id);
		
		Object queryResult=(Object) RedisCacheManagerMy.get(classkey.toString());
		if(queryResult==null||queryResult.equals("")){
			banji=banjiDao.getBanji(banji_id);
			if(banji==null||banji.equals("")){
				System.out.println("ϵͳ���޶�Ӧ��idֵ");
			}else{
				//���⿪��һ���߳�ִ�У����ݲ���redis�� 20190225
		        //ʹ�������ڲ��ഴ��Thread����
				/*
		        new Thread(){
		            @Override
		            public void run() {
		               System.out.println("hello new thread");
		               RedisCacheManagerMy.set(this.classkey.toString(), banji);
					   System.out.println("����key="+classkey.toString()+"��redis��");
		            }
		        }.start();
		        */
				
				System.out.println("ʹ���µ��߳̽����ݱ��浽redis��");
				Thread saveDataRedis=new saveClassDataToRedisThread(classkey.toString(),banji,RedisCacheManagerMy);
				saveDataRedis.start();
				
				//RedisCacheManagerMy.set(classkey.toString(), banji);
				//System.out.println("����key="+classkey.toString()+"��redis��");
			}
		}else{
			banji=(class_s)RedisCacheManagerMy.get(classkey.toString());
			System.out.println("��redis�л�� class��Ϣ ");
		}
		
		
		return banji;
	}
}
