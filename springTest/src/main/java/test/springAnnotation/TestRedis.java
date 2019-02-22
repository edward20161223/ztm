package test.springAnnotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import redis_spring.test.RedisCacheManagerMy;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestRedis extends UnitTestBase{

	public TestRedis() {
		super("classpath*:springTestServlet.xml");
	}
	
	@Test
	public void testPutGetDataRedis(){
		RedisCacheManagerMy RM=super.getBean("redisrCacheManager");
		RM.set("kTest", "kvalue");
		String vString="";
		vString=(String) RM.get("kTest");
		System.out.println("vString is:"+vString);
	}
}
