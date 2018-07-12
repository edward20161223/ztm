package ztmself.com.zjSpringActiveMQ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	
	public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        msgProducer ps=(msgProducer) ac.getBean("msgProducer");
        for( int i=0;i<3;i++){
            Thread t=new Thread(new User(ps,"mmm"+i));
            t.start();
        }

	}

}

class User implements Runnable{
    private msgProducer ps;
    private String name;
    public User(msgProducer ps, String name) {
        super();
        this.ps = ps;
        this.name = name;
    }

    @Override
    public void run() {
        for( int i=0;i<3;i++){
            ps.sendMessage(name+"向你问好");
        }
    }
}


