package com.sensedia.apix2019.kit.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JsonConfig {

    @Autowired
    private ObjectMapper objectMapper;

    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException();
        }
    }

    public <T> T toObject(byte[] json, Class<T> classe) {
        try {
            return objectMapper.readValue(json, classe);
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

}
