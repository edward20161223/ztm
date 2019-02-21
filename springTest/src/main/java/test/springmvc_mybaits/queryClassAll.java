package test.springmvc_mybaits;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring_mybatis.entry.class_s;

@Controller
public class queryClassAll {

    @Autowired
    @Qualifier("class_sServiceQueryAllData")   //这里使用@ualifier注解注入bookService业务层
    private spring_mybatis.service.class_sServiceQueryAllData class_sServiceQueryAllData;
    
	@RequestMapping("/queryClass")
	public String  queryAllClass(Model model){
	       List<class_s> BJ = class_sServiceQueryAllData.getAll(); //调用业务层方法
	       model.addAttribute("BJ",BJ);//把从数据库取到的数据放入到model中
	        
		return "showAllClass";
	}
}
