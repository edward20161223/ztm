package redis_spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class deleteClassFromRedisOlny {

	@Autowired
	private RedisCacheManagerMy RedisCacheManagerMy;
	@RequestMapping("/deleteclass")
	public String DeleteDataFromRedis(Model model,@RequestParam(value = "id", required = false) Integer id){
		System.out.println("delete class id is:"+id);
		StringBuilder classkey=new StringBuilder();
		classkey.append("class_s");
		classkey.append(id);
		
		//添加redis删除数据，删除redis中没有的key值，并未报错，例如：class_s20这个值在redis的key中并不存在   20190226
		try {
			RedisCacheManagerMy.del(classkey.toString());
		} catch (Exception e) {
			return "deleteClassDataFromRedisFail";
		}
		
		return "deleteClassDataFromRedisSuccessful";
	}
}
