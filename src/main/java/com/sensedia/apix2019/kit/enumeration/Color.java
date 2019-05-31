package com.sensedia.apix2019.kit.enumeration;

import java.util.Arrays;

import com.sensedia.apix2019.kit.exception.PreconditionFailedException;

public enum Color {

    BLACK, BLUE, BROWN, GREEN, GREY, ORANGE, PINK, PURPLE, RED, WHITE, YELLOW;

    public static Color getByColor(String color) {
        return Arrays.stream(Color.values())
                .filter(colorEnum -> colorEnum.name().equals(color))
                .findFirst()
                .orElseThrow(() -> new PreconditionFailedException("Color invalid"));
    }
}
