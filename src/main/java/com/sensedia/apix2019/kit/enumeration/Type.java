package com.sensedia.apix2019.kit.enumeration;

import java.util.Arrays;

import com.sensedia.apix2019.kit.exception.PreconditionFailedException;

public enum Type {

    PANT, SHIRT, SHOES;

    public static Type getByType(String type) {
        return Arrays.stream(Type.values())
                .filter(statusEnum -> statusEnum.name().equals(type))
                .findFirst()
                .orElseThrow(() -> new PreconditionFailedException("Type invalid"));
    }
}
