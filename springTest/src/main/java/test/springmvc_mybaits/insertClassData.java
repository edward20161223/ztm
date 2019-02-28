package test.springmvc_mybaits;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring_mybatis.entry.class_s;
import spring_mybatis.service.class_sService;



@Controller
public class insertClassData {
	
	@Autowired
	private class_sService banjiSevice;
	//private spring_mybatis.service.class_sServiceJ banjiSevice;
	
	
	@RequestMapping(value="/insertBanji")
	public String  insertdata(String class_name,String create_time,Model model){
		System.out.println("class_name is:"+class_name +" create_time is:"+create_time);
		try {
	 	       Date creationDate=new Date();
	 	       class_s banji3 = new class_s(class_name,creationDate);
	 	       banjiSevice.saveBanji(banji3);
	 	  	   
	 	       model.addAttribute("admin", banji3);
	 	       
			return "insertClassDataSuccess";
		} catch (Exception e) {
			return "insertClassDataFail";
		}
		
	}
}
