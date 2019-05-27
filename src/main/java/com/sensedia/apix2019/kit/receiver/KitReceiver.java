package com.sensedia.apix2019.kit.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KitReceiver {

    @RabbitListener(queues = "${queue.recommendation-queue}")
    public void receiver(String message) {
        log.info("Message received:  {}", message);
    }

}
