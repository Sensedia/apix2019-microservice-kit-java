package com.sensedia.apix2019.kit.exception;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class MessageError implements Serializable {

    private static final long serialVersionUID = 5256651766510189965L;

    private String message;

    public MessageError(String message) {
        this.message = message;
    }

}
