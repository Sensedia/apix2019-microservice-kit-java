package com.sensedia.apix2019.kit.entity;

import java.time.Instant;
import java.time.ZoneId;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.sensedia.apix2019.kit.enumeration.Color;
import com.sensedia.apix2019.kit.enumeration.Type;
import com.sensedia.apix2019.kit.response.RecommendationReponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Recommendation {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Color color;

    private String title;

    private Double price;

    private String link;

    private String image;

    private Long date;

    private int kitGroup;

    private boolean chosen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kit_id")
    private Kit kit;

    public RecommendationReponse toResponse() {
        return RecommendationReponse.builder()
                .id(id)
                .type(type)
                .color(color)
                .title(title)
                .price(price)
                .link(link)
                .image(image)
                .date(Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDate())
                .chosen(chosen)
                .build();
    }

}
