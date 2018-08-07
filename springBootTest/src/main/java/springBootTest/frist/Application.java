package springBootTest.frist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/*
 * 使用springboot，使用springboot自带的tomcat，如果项目引入自己的tomcat，会引起包冲突，需要删除掉应用的tomcat
 */

@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class Application {
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
