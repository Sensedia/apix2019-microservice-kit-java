package com.sensedia.apix2019.kit.response;

import java.time.LocalDate;

import com.sensedia.apix2019.kit.enumeration.Color;
import com.sensedia.apix2019.kit.enumeration.Type;

public class RecommendationReponse {

    private String id;
    private Type type;
    private Color color;
    private String title;
    private Double price;
    private String link;
    private String image;
    private LocalDate date;
    private Boolean chosen;

    public RecommendationReponse(String id, Type type, Color color, String title, Double price, String link,
            String image, LocalDate date, Boolean chosen) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.title = title;
        this.price = price;
        this.link = link;
        this.image = image;
        this.date = date;
        this.chosen = chosen;
    }

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public String getLink() {
        return link;
    }

    public String getImage() {
        return image;
    }

    public LocalDate getDate() {
        return date;
    }

    public Boolean getChosen() {
        return chosen;
    }

}
