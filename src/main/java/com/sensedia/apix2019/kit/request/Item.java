package com.sensedia.apix2019.kit.request;

import com.sensedia.apix2019.kit.entity.Kit;
import com.sensedia.apix2019.kit.entity.Recommendation;
import com.sensedia.apix2019.kit.enumeration.Color;
import com.sensedia.apix2019.kit.enumeration.Type;

import lombok.Data;

@Data
public class Item {

    private Type type;
    private Color color;
    private String title;
    private Double price;
    private String link;
    private String image;
    private Long date;

    public Recommendation toEntity(Kit kit, int kitGroup) {
        return Recommendation.builder()
                .type(type)
                .color(color)
                .title(title)
                .price(price)
                .link(link)
                .image(image)
                .date(date)
                .kitGroup(kitGroup)
                .kit(kit)
                .build();
    }

}
