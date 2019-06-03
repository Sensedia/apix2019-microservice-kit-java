package com.sensedia.apix2019.kit.receiver;

import com.sensedia.apix2019.kit.config.JsonConfig;
import com.sensedia.apix2019.kit.exception.ResourceNotFoundException;
import com.sensedia.apix2019.kit.request.RecommendationRequest;
import com.sensedia.apix2019.kit.service.KitService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KitReceiver {

    private static final Logger log = LogManager.getLogger(KitReceiver.class);

    @Autowired
    private JsonConfig jsonConfig;

    @Autowired
    private KitService kitService;

    @RabbitListener(queues = "${queue.recommendation-queue}")
    public void receiver(Message message) {
        log.info("Message received: {}", message.toString());
        try {
            RecommendationRequest recommendationRequest = jsonConfig.toObject(message.getBody(),
                    RecommendationRequest.class);
            kitService.createRecommendation(recommendationRequest);
        } catch (ResourceNotFoundException e) {
            log.error("Message not fund", e);
        } catch (IllegalStateException e) {
            log.error("Erro parsing json", e);
        }
    }

}
