package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import edu.mum.domain.Order;


public interface MessagingService {
    public void publish(RabbitTemplate rabbitTemplate, Order order);
}
