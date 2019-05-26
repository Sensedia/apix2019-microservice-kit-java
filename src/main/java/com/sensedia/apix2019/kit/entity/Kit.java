package com.sensedia.apix2019.kit.entity;

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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Kit {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Builder.Default
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "kit")
    private List<Specification> specifications = List.of();

    @Builder.Default
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "kit")
    private List<Recommendation> recommendations = List.of();

    public KitResponse toResponse() {
        return KitResponse.builder()
                .id(id)
                .phone(phone)
                .gender(gender)
                .specifications(specifications.stream().map(Specification::toResponse).collect(Collectors.toList()))
                .recommendations(recommendations.stream().map(Recommendation::toResponse).collect(Collectors.toList()))
                .build();
    }
}
