package com.sensedia.apix2019.kit.request;

import com.sensedia.apix2019.kit.entity.Kit;
import com.sensedia.apix2019.kit.entity.Recommendation;
import com.sensedia.apix2019.kit.enumeration.Color;
import com.sensedia.apix2019.kit.enumeration.Type;

public class Item {

    private Type type;
    private Color color;
    private String title;
    private Double price;
    private String link;
    private String image;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Recommendation toEntity(Kit kit, int kitGroup) {
        return new Recommendation(type, color, title, price, link, image, kitGroup, kit);
    }

}
