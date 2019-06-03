package com.sensedia.apix2019.kit.response;

import java.util.List;

import com.sensedia.apix2019.kit.enumeration.Gender;

public class KitResponse {

    private String id;
    private String phone;
    private Gender gender;
    private List<SpecificationResponse> specifications;
    private List<RecommendationReponse> firstRecommendation;
    private List<RecommendationReponse> secondRecommendation;
    private List<RecommendationReponse> thirdRecommendation;

    public KitResponse(String id, String phone, Gender gender, List<SpecificationResponse> specifications) {
        this.id = id;
        this.phone = phone;
        this.gender = gender;
        this.specifications = specifications;
    }

    public KitResponse(String id, String phone, Gender gender, List<SpecificationResponse> specifications,
            List<RecommendationReponse> firstRecommendation, List<RecommendationReponse> secondRecommendation,
            List<RecommendationReponse> thirdRecommendation) {
        this.id = id;
        this.phone = phone;
        this.gender = gender;
        this.specifications = specifications;
        this.firstRecommendation = firstRecommendation;
        this.secondRecommendation = secondRecommendation;
        this.thirdRecommendation = thirdRecommendation;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public Gender getGender() {
        return gender;
    }

    public List<SpecificationResponse> getSpecifications() {
        return specifications;
    }

    public List<RecommendationReponse> getFirstRecommendation() {
        return firstRecommendation;
    }

    public List<RecommendationReponse> getSecondRecommendation() {
        return secondRecommendation;
    }

    public List<RecommendationReponse> getThirdRecommendation() {
        return thirdRecommendation;
    }

}
