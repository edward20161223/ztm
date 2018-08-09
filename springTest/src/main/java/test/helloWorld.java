package test;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * ²âÊÔspringMVC¿ò¼Ü£¬Ê¹ÓÃ×¢½â20180807
 */


@Controller
public class helloWorld {

	public helloWorld() {
	}

	
    @RequestMapping("/hello")
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.getWriter().append("hello world frist springMVC !");
    }
}
