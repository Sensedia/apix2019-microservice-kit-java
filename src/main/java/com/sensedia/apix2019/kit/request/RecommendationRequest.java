package com.sensedia.apix2019.kit.request;

import java.util.List;

import lombok.Data;

@Data
public class RecommendationRequest {

    private String id;
    private List<KitRecommendationRequest> recommendations;

}