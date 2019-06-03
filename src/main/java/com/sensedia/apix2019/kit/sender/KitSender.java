package com.sensedia.apix2019.kit.sender;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sensedia.apix2019.kit.config.ApplicationConfig;

@Component
public class KitSender {

    private static final Logger log = LogManager.getLogger(KitSender.class);

    @Autowired
    private ApplicationConfig applicationConfig;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message) {
        log.info("Sending message: {}", message);
        rabbitTemplate.convertAndSend(applicationConfig.getKitQueue(), message);
        log.info("Message sent.");
    }

}
