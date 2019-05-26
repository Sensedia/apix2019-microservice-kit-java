package com.sensedia.apix2019.kit.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class ApplicationConfig {

    @Value("${queue.kit-queue}")
    private String kitQueue;

    @Value("${queue.recommendation-queue}")
    private String recommendationQueue;

}
