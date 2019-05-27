package com.sensedia.apix2019.kit.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.sensedia.apix2019.kit.config.ApplicationConfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class KitSender {

    private final ApplicationConfig applicationConfig;
    private final RabbitTemplate rabbitTemplate;

    public void send(String message) {
        log.info("Sending message: {}", message);
        rabbitTemplate.convertAndSend(applicationConfig.getKitQueue(), message);
        log.info("Message sent.");
    }

}
