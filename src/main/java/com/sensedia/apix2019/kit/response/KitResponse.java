package com.sensedia.apix2019.kit.response;

import java.util.List;

import com.sensedia.apix2019.kit.enumeration.Gender;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Builder
@Data
public class KitResponse {

    private String id;
    private String phone;
    private Gender gender;
    private List<SpecificationResponse> specifications;
    private List<RecommendationReponse> firstRecommendation;
    private List<RecommendationReponse> secondRecommendation;
    private List<RecommendationReponse> thirdRecommendation;

}
