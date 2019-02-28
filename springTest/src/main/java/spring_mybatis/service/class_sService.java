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
	
	
	//添加redis缓存支持，数据放入缓存，数据从缓存中查询    20190225
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
				System.out.println("系统中无对应的id值");
			}else{
				//另外开启一个线程执行，数据插入redis中 20190225
		        //使用匿名内部类创建Thread对象
				/*
		        new Thread(){
		            @Override
		            public void run() {
		               System.out.println("hello new thread");
		               RedisCacheManagerMy.set(this.classkey.toString(), banji);
					   System.out.println("保存key="+classkey.toString()+"到redis中");
		            }
		        }.start();
		        */
				
				System.out.println("使用新的线程将数据保存到redis中");
				Thread saveDataRedis=new saveClassDataToRedisThread(classkey.toString(),banji,RedisCacheManagerMy);
				saveDataRedis.start();
				
				//RedisCacheManagerMy.set(classkey.toString(), banji);
				//System.out.println("保存key="+classkey.toString()+"到redis中");
			}
		}else{
			banji=(class_s)RedisCacheManagerMy.get(classkey.toString());
			System.out.println("从redis中获得 class信息 ");
		}
		
		
		return banji;
	}
}
