package com.sensedia.apix2019.kit.receiver;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.sensedia.apix2019.kit.config.JsonConfig;
import com.sensedia.apix2019.kit.exception.ResourceNotFoundException;
import com.sensedia.apix2019.kit.request.RecommendationRequest;
import com.sensedia.apix2019.kit.service.KitService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class KitReceiver {

    private final JsonConfig jsonConfig;
    private final KitService kitService;

    @RabbitListener(queues = "${queue.recommendation-queue}")
    public void receiver(Message message) {
        log.info("Message received: {}", message.toString());

        try {
            RecommendationRequest recommendationRequest = jsonConfig.toObject(message.getBody(),
                    RecommendationRequest.class);
            kitService.createRecommendation(recommendationRequest);

        } catch (ResourceNotFoundException e) {
            log.error("Message not fount");
        } catch (IllegalStateException e) {
            log.error("Error parsing Json");
        }
    }

}
