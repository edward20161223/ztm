package test.springAnnotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestutilCalculation extends UnitTestBase{

	public TestutilCalculation() {
		super("classpath*:springTestServlet.xml");
	}
	
	@Test
	public void testAdd(){
		utilCalculation bean=super.getBean("utilCalculation");
		int rs;
		rs=bean.add(3, 5);
		System.out.println("½á¹ûÊÇ£º"+rs);
	}

}
