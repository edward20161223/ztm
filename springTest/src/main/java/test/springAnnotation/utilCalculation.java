package test.springAnnotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope
@Component
public class utilCalculation {

	public utilCalculation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see º”º∆À„
	 * @param a 
	 * @param b
	 * @return
	 */
	public int add(int a,int b){
		int re=-1;
		re=a+b;
		return re;
	}
	
	public int subtraction(int a,int b){
		int re=-1;
		re=a-b;
		return re;
	}
	
}
