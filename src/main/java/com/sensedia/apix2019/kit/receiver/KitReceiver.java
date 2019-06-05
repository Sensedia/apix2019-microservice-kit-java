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

    // está faltando uma anotação bem aqui ;)
    public void receiver(Message message) {
        
    }

}
