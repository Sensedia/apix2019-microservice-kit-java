package com.sensedia.apix2019.kit.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Value("${queue.kit-queue}")
    private String kitQueue;

    @Value("${queue.recommendation-queue}")
    private String recommendationQueue;

    @Value("${queue.notification-queue}")
    private String notificationQueue;

    public String getKitQueue() {
        return kitQueue;
    }

    public String getNotificationQueue() { return notificationQueue; }

    public String getRecommendationQueue() {
        return recommendationQueue;
    }
}
