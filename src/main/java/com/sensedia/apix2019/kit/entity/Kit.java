package com.sensedia.apix2019.kit.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.sensedia.apix2019.kit.enumeration.Gender;
import com.sensedia.apix2019.kit.response.KitResponse;
import com.sensedia.apix2019.kit.response.RecommendationReponse;
import com.sensedia.apix2019.kit.response.SpecificationResponse;

@Entity
public class Kit {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "kit")
    private List<Specification> specifications = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "kit")
    private List<Recommendation> recommendations = new ArrayList<>();

    public Kit() {
    }

    public Kit(String phone, Gender gender) {
        this.phone = phone;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Specification> specifications) {
        this.specifications = specifications;
    }

    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }

    public KitResponse toResponse() {
        Comparator<SpecificationResponse> typeSpecComparator = (t1, t2) -> t1.getType().name()
                .compareTo(t2.getType().name());
        List<SpecificationResponse> specificationResponse = specifications.stream()
                .map(Specification::toResponse)
                .sorted(typeSpecComparator)
                .collect(Collectors.toList());

        Comparator<RecommendationReponse> typeRecComparator = (t1, t2) -> t1.getType().name()
                .compareTo(t2.getType().name());

        List<RecommendationReponse> firstRecommendation = recommendations.stream().filter(x -> x.getKitGroup() == 0)
                .map(Recommendation::toResponse).sorted(typeRecComparator).collect(Collectors.toList());

        List<RecommendationReponse> secondRecommendation = recommendations.stream().filter(x -> x.getKitGroup() == 1)
                .map(Recommendation::toResponse).sorted(typeRecComparator).collect(Collectors.toList());

        List<RecommendationReponse> thirdRecommendation = recommendations.stream().filter(x -> x.getKitGroup() == 2)
                .map(Recommendation::toResponse).sorted(typeRecComparator).collect(Collectors.toList());

        return new KitResponse(id, phone, gender, specificationResponse, firstRecommendation, secondRecommendation,
                thirdRecommendation);
    }

    public KitResponse toQueue() {
        List<SpecificationResponse> specificationResponse = specifications.stream()
                .map(Specification::toResponse)
                .collect(Collectors.toList());
        return new KitResponse(id, phone, gender, specificationResponse);
    }

}
