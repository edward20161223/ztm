package springBootTest.frist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



/*
 * 使用springboot，使用springboot自带的tomcat，如果项目引入自己的tomcat，会引起包冲突，需要删除掉应用的tomcat
 */


/*
 * 映射访问与对象注入都与文件位置的关系，springboot项目的目录结构，springboot组件扫描的原理。20191217
 * @Controller  @RequestMapping("/test")  @ResponseBody  ==  @RestController  @RequestMapping("/calculationAdd")
 */


@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class Application {
	
    @RequestMapping("/test")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    
//    @RequestMapping("/hello")
//    @ResponseBody
//    public String sayHello(){
//        return "hello";
//    }
    
    
}



