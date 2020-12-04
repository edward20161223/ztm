package springBootTest.frist;

import org.springframework.stereotype.Component;

@Component
public class mathematics {
	public int add(int a,int b){
		int c=-1;
		c=a+b;
		return c;
	}
}
