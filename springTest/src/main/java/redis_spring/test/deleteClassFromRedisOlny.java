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
		
		//���redisɾ�����ݣ�ɾ��redis��û�е�keyֵ����δ�������磺class_s20���ֵ��redis��key�в�������   20190226
		try {
			RedisCacheManagerMy.del(classkey.toString());
		} catch (Exception e) {
			return "deleteClassDataFromRedisFail";
		}
		
		return "deleteClassDataFromRedisSuccessful";
	}
}
