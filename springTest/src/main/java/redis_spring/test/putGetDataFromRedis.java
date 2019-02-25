package redis_spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class putGetDataFromRedis {

	@Autowired
	private RedisCacheManagerMy RedisCacheManager;
	
	@RequestMapping("/redisTest")
	public String putGetData(){
		RedisCacheManager.set("kTest", "kvalue");
		String vString="";
		vString=(String) RedisCacheManager.get("kTest");
		System.out.println("vString is:"+vString);
		return "insertClassDataFail";
		//return null;
	}
}
