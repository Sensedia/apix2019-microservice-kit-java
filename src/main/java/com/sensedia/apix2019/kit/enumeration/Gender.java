package com.sensedia.apix2019.kit.enumeration;

import java.util.Arrays;

import com.sensedia.apix2019.kit.exception.PreconditionFailedException;

public enum Gender {

    M, F;

    public static Gender getByGender(String gender) {
        return Arrays.stream(Gender.values())
                .filter(genderEnum -> genderEnum.name().equals(gender))
                .findFirst()
                .orElseThrow(() -> new PreconditionFailedException("Gender invalid"));
    }
}
