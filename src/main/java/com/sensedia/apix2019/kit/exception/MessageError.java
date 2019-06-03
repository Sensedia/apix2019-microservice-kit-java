package com.sensedia.apix2019.kit.exception;

import java.io.Serializable;

public class MessageError implements Serializable {

    private static final long serialVersionUID = 5256651766510189965L;

    private String message;

    public MessageError() {
    }

    public MessageError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
