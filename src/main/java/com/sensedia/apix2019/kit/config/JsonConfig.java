package com.sensedia.apix2019.kit.config;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class JsonConfig {

    private final ObjectMapper objectMapper;

    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new IllegalStateException();
        }
    }

    public <T> T toObject(String string, Class<T> classe) {
        try {
            return objectMapper.readValue(string, classe);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new IllegalStateException();
        }
    }

}
