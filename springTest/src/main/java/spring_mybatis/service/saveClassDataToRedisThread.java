package spring_mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis_spring.test.RedisCacheManagerMy;
import spring_mybatis.entry.class_s;

//@Service
public class saveClassDataToRedisThread extends Thread{

	//新建线程，使用spring注无法注入对象
	//@Autowired
	//private redis_spring.test.RedisCacheManagerMy RedisCacheManagerMy;
	
	//添加redis缓存支持，数据放入缓存，数据从缓存中查询    20190225
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
		System.out.println("保存key="+key+"到redis中");
	}
}
