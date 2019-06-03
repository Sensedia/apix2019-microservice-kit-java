package com.sensedia.apix2019.kit.request;

import java.util.List;

public class RecommendationsPatchRequest {

    private List<Recommendations> recommendations;

    public List<Recommendations> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Recommendations> recommendations) {
        this.recommendations = recommendations;
    }

}
