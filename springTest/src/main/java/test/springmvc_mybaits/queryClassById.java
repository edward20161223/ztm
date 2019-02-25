package test.springmvc_mybaits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring_mybatis.entry.class_s;
import spring_mybatis.service.class_sService;

@Controller
public class queryClassById {

	@Autowired
	private class_sService class_sService;
	
	@RequestMapping("/getClassById")
	public String getBanjian(Model model,@RequestParam(value = "id", required = false) Integer id){
		System.out.println("id is:"+id);
		class_s banjie=new class_s();
		banjie=class_sService.getBanji(id);
		if(banjie==null||banjie.equals("")){
			return "showClassByIDFail";
		}
		System.out.println("banjie is:"+banjie.toString());
		model.addAttribute("banJi", banjie);
		return "showClassByID";
	}
}
