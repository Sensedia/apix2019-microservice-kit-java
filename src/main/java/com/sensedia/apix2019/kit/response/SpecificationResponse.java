package com.sensedia.apix2019.kit.response;

import com.sensedia.apix2019.kit.enumeration.Color;
import com.sensedia.apix2019.kit.enumeration.Type;

public class SpecificationResponse {

    private String id;
    private Type type;
    private Color color;

    public SpecificationResponse(String id, Type type, Color color) {
        this.id = id;
        this.type = type;
        this.color = color;
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

}
