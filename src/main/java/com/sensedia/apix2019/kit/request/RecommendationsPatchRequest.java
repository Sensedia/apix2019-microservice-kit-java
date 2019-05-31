package com.sensedia.apix2019.kit.request;

import java.util.List;

import lombok.Data;

@Data
public class RecommendationsPatchRequest {

    private List<Recommendations> recommendations;

}
