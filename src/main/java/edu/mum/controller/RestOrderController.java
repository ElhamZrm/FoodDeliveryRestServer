package edu.mum.controller;

import java.time.LocalDate;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.amqp.MessagingService;
import edu.mum.amqp.MessagingServiceImpl;
import edu.mum.domain.Order;

@RestController
@RequestMapping({"/publishOrder"})
public class RestOrderController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public Order publish() {
		Order order = new Order();
		order.setName("Elham");
		order.setEmail("ezarrinmehr@mum.edu");
		order.setAddress("maharishi university iowa");
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/order-app-context.xml");
        RabbitTemplate topicTemplate =  context.getBean("topicTemplate",RabbitTemplate.class);
     	MessagingService MessagingService = new MessagingServiceImpl();
     	MessagingService.publish(topicTemplate,order);
		return order;
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Order publish(@RequestBody Order order) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/order-app-context.xml");
        RabbitTemplate topicTemplate =  context.getBean("topicTemplate",RabbitTemplate.class);
     	MessagingService MessagingService = new MessagingServiceImpl();
     	MessagingService.publish(topicTemplate,order);
		return order;
		
	}

}
