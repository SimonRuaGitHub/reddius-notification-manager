package com.reddius.consumer;

import com.reddius.dto.Email;
import com.reddius.service.MailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver implements RabbitListenerConfigurer{

    private MailService mailService;

    @Autowired
    public RabbitMQReceiver(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {

    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMsg(Email email){
        System.out.println("Received message: "+email.toString());
       // mailService.sendMail(email);
    }
}
