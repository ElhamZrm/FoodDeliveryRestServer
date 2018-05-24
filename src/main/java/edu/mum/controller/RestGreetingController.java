package edu.mum.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.mum.amqp.MessagingService;
import edu.mum.amqp.MessagingServiceImpl;
import edu.mum.domain.Greeting;
import edu.mum.domain.Order;



@RestController
public class RestGreetingController {
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name" , defaultValue="world") String name) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/order-app-context.xml");
        RabbitTemplate topicTemplate =  context.getBean("topicTemplate",RabbitTemplate.class);
     	MessagingService MessagingService = new MessagingServiceImpl();
     	MessagingService.publish(topicTemplate,new Order());


		
		return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
	}

}