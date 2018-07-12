package ztmself.com.zjSpringActiveMQ;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;


@Component("msgConsumer")
public class msgConsumer implements SessionAwareMessageListener<TextMessage>{

	public msgConsumer() {
		// TODO Auto-generated constructor stub
	}
	

	private Destination destination;//发送队列
	
	@Override
	public void onMessage(TextMessage message, Session session) throws JMSException {
        System.out.println("222接收到发送者的消息是一个文本消息:"+ message.getText());
        //通过session 创建  producer对象，再回送信息
        //从message中取出信息回送的目的地,以便创建生产者.
        MessageProducer producer=session.createProducer( message.getJMSReplyTo()   );
        //创建一条消息
        Message textMessage=session.createTextMessage(  "生产者发过来的信息已经处理完毕，game over..." );   
        //调用发送
        producer.send(textMessage);
	}
	
    @Resource(name="sendQueueDestination")
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

}
