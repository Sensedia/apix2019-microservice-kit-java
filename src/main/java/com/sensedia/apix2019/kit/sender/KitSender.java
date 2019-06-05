package com.sensedia.apix2019.kit.sender;

import com.sensedia.apix2019.kit.config.ApplicationConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KitSender {

    private static final Logger log = LogManager.getLogger(KitSender.class);

    // dica de ouro: use RabbitTemplate!

    public void sendToCrawler(String message) {
        
    }
}
