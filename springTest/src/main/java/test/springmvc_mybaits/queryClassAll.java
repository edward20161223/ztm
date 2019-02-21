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
    @Qualifier("class_sServiceQueryAllData")   //����ʹ��@ualifierע��ע��bookServiceҵ���
    private spring_mybatis.service.class_sServiceQueryAllData class_sServiceQueryAllData;
    
	@RequestMapping("/queryClass")
	public String  queryAllClass(Model model){
	       List<class_s> BJ = class_sServiceQueryAllData.getAll(); //����ҵ��㷽��
	       model.addAttribute("BJ",BJ);//�Ѵ����ݿ�ȡ�������ݷ��뵽model��
	        
		return "showAllClass";
	}
}
