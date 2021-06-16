package com.reddius.consumer;

import com.reddius.dto.Email;
import com.reddius.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver implements RabbitListenerConfigurer{

    private MailService mailService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQReceiver.class);

    @Autowired
    public RabbitMQReceiver(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {

    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMsg(Email email){
        LOGGER.info("Received message: {} from thread: {}",email.toString(),Thread.currentThread().getId());
        mailService.sendMail(email);
    }
}
