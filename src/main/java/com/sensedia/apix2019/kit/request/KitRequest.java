package com.sensedia.apix2019.kit.request;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sensedia.apix2019.kit.Deserializer.TypeDeserializer;
import com.sensedia.apix2019.kit.entity.Kit;
import com.sensedia.apix2019.kit.entity.Specification;
import com.sensedia.apix2019.kit.enumeration.Color;
import com.sensedia.apix2019.kit.enumeration.Gender;
import com.sensedia.apix2019.kit.enumeration.Type;

import lombok.Data;

@Data
public class KitRequest {

    private String phone;
    private Gender gender;
    private List<SpecificationRequest> specifications = new ArrayList<>();

    public Kit toEntity() {
        Kit kit = Kit.builder()
                .phone(phone)
                .gender(gender)
                .build();

        List<Specification> specs = specifications.stream()
                .map(spec -> spec.toEntity(kit))
                .collect(Collectors.toList());
        kit.setSpecifications(specs);

        return kit;
    }

}

@Data
class SpecificationRequest {

    @JsonDeserialize(using = TypeDeserializer.class)
    private Type type;
    private Color color;

    public Specification toEntity(Kit kit) {
        return Specification.builder()
                .kit(kit)
                .type(type)
                .color(color)
                .build();
    }

}
