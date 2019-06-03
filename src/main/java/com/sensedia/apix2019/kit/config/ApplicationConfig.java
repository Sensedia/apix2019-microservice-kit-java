package com.sensedia.apix2019.kit.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Value("${queue.kit-queue}")
    private String kitQueue;

    @Value("${queue.recommendation-queue}")
    private String recommendationQueue;

    public String getKitQueue() {
        return kitQueue;
    }

    public String getRecommendationQueue() {
        return recommendationQueue;
    }

}
