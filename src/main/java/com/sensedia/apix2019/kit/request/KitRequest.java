package com.sensedia.apix2019.kit.request;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sensedia.apix2019.kit.deserializer.ColorDeserializer;
import com.sensedia.apix2019.kit.deserializer.GenderDeserializer;
import com.sensedia.apix2019.kit.deserializer.TypeDeserializer;
import com.sensedia.apix2019.kit.entity.Kit;
import com.sensedia.apix2019.kit.entity.Specification;
import com.sensedia.apix2019.kit.enumeration.Color;
import com.sensedia.apix2019.kit.enumeration.Gender;
import com.sensedia.apix2019.kit.enumeration.Type;

public class KitRequest {

    private String phone;
    @JsonDeserialize(using = GenderDeserializer.class)
    private Gender gender;
    private List<SpecificationRequest> specifications = new ArrayList<>();

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

    public List<SpecificationRequest> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<SpecificationRequest> specifications) {
        this.specifications = specifications;
    }

    public Kit toEntity() {
        Kit kit = new Kit(phone, gender);

        List<Specification> specs = specifications.stream()
                .map(spec -> spec.toEntity(kit))
                .collect(Collectors.toList());
        kit.setSpecifications(specs);

        return kit;
    }

}

class SpecificationRequest {

    @JsonDeserialize(using = TypeDeserializer.class)
    private Type type;

    @JsonDeserialize(using = ColorDeserializer.class)
    private Color color;

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

    public Specification toEntity(Kit kit) {
        return new Specification(type, color, kit);
    }

}
