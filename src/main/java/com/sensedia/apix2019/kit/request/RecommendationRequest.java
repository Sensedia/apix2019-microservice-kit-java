package com.sensedia.apix2019.kit.request;

import java.util.List;

public class RecommendationRequest {

    private String id;
    private List<List<Item>> recommendations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<List<Item>> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<List<Item>> recommendations) {
        this.recommendations = recommendations;
    }

}
