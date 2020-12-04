package springBootTest.frist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@Controller
public class calculationTest {

    @Autowired
	mathematics mathematicsObject;
	
	//@RequestMapping(method= RequestMethod.GET)

    //@RequestMapping(value="/hello",method= RequestMethod.GET)
	
//    @RequestMapping("/hello")
//    @ResponseBody
//    public String sayHello(){
//        return "hello";
//    }
    
    @RequestMapping("/calculationAdd")
    public int excuteCalculation(){
    	int result=0;
    	result=mathematicsObject.add(5, 3);
    	return result;
    }
    
    
}
