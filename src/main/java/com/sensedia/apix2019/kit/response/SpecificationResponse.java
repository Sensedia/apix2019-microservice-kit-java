package com.sensedia.apix2019.kit.response;

import com.sensedia.apix2019.kit.enumeration.Color;
import com.sensedia.apix2019.kit.enumeration.Type;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SpecificationResponse {

    private String id;
    private Type type;
    private Color color;

}
