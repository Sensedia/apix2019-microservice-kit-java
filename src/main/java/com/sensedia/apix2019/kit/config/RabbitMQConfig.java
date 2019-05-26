package com.sensedia.apix2019.kit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class RabbitMQConfig {

    private final ApplicationConfig applicationConfig;

    @Bean
    public Queue kitQueue() {
        return new Queue(applicationConfig.getKitQueue());
    }

    @Bean
    public Queue recommendationQueue() {
        return new Queue(applicationConfig.getRecommendationQueue());
    }

}
