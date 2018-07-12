package ztmself.com.zjSpringActiveMQ;

import javax.annotation.Resource;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;


@Service("msgProducer")
public class msgProducer implements msgService{ //msgProduce类，没有在xml文件中配置，其在Java程序使用注解为@service

	public msgProducer() {
		// TODO Auto-generated constructor stub
	}

	private Destination destination;//发送队列
	private JmsTemplate jmsTemplate;
	private Destination replyQueueDestination;//回应信息队列
	
	
	@Override
	public void sendMessage(String mString) {
		System.out.println("生产者发送消息："+mString);
		jmsTemplate.send(destination, new MessageCreator(){
			 @Override
	            public Message createMessage(Session session) throws JMSException {
	                Message msg = session.createTextMessage(mString);
	                // 设置回复的信息的目的地.
	                msg.setJMSReplyTo(replyQueueDestination);
	                // 设置发送的信息类型 为非持久化信息
	                msg.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);

	                //创建一个消费者，用于接收对方回复的信息   注意，这个消费者临听   replyDestination
	                MessageConsumer comsumer = session.createConsumer(replyQueueDestination);
	                comsumer.setMessageListener(new MessageListener() {
	                    public void onMessage(Message m) {
	                        try {
	                            System.out.println("111接收到的回复信息:" + ((TextMessage) m).getText());
	                        } catch (JMSException e) {
	                            e.printStackTrace();
	                        }
	                    }
	               
	                });
	                return msg;
		       }
		});	
	}
	
    @Resource(name = "replyQueueDestination")
    public void setReplyDestination(Destination replyDestination) {
        this.replyQueueDestination = replyDestination;
    }
    @Resource(name = "sendQueueDestination")
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    @Resource(name = "jmsTemplate")
    public void setJsmTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
    
}
