package spring_mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis_spring.test.RedisCacheManagerMy;
import spring_mybatis.entry.class_s;

//@Service
public class saveClassDataToRedisThread extends Thread{

	//�½��̣߳�ʹ��springע�޷�ע�����
	//@Autowired
	//private redis_spring.test.RedisCacheManagerMy RedisCacheManagerMy;
	
	//���redis����֧�֣����ݷ��뻺�棬���ݴӻ����в�ѯ    20190225
	String key;
	class_s class_s;
	redis_spring.test.RedisCacheManagerMy RedisCacheManagerMy;
	
	public saveClassDataToRedisThread(){
	}
	
	public saveClassDataToRedisThread(String key,class_s classEntry,RedisCacheManagerMy RedisCacheManagerMy){
		this.key=key;
		this.class_s=classEntry;
		this.RedisCacheManagerMy=RedisCacheManagerMy;
	}
	
	public void run(){
		RedisCacheManagerMy.set(key, class_s);
		System.out.println("����key="+key+"��redis��");
	}
}
