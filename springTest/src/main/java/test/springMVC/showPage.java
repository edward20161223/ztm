package test.springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class showPage {
    @RequestMapping(value="/welcome")  //welcomeҪ���ʵ�url��ַ
    public  String  hello(){
        System.out.println("hello,springmvc");
        return "hello";  //hello���߼���ͼ��,�ͺ�׺�����һ�𹹳���ͼ��  /web-inf/jsp/hello.jsp
    }
}
