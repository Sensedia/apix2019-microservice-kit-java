package com.sensedia.apix2019.kit.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.sensedia.apix2019.kit.enumeration.Color;
import com.sensedia.apix2019.kit.enumeration.Type;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RecommendationReponse {

    private String id;
    private Type type;
    private Color color;
    private String title;
    private BigDecimal price;
    private String link;
    private String image;
    private LocalDate date;

}
