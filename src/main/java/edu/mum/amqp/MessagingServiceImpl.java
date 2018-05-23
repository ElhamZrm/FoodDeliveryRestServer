package edu.mum.amqp;


import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.domain.Order;


public class MessagingServiceImpl implements MessagingService {
    
	public void publish(RabbitTemplate rabbitTemplate , Order order) {
 
        rabbitTemplate.convertAndSend("customer.orders",order);
         
    }
	
}
