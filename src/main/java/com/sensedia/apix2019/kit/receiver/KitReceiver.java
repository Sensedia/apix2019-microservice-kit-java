package com.sensedia.apix2019.kit.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class KitReceiver {

    // private final JsonConfig jsonConfig;

    @RabbitListener(queues = "${queue.kit-queue}")
    public void receiver(String message) {
        log.info("Message received:  {}", message);
        // KitResponse kitResponse = jsonConfig.toObject(message,
        // KitResponse.class);
        // log.info("KitResponse: {}", kitResponse);
    }

}
