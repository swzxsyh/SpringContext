package com.test.infrastructure.exceptions;

import lombok.Data;

@Data
public abstract class AbstractCustomException extends RuntimeException {

    private int code;

    public AbstractCustomException(int code, String message) {
        super(message);
        this.code = code;
    }

    public AbstractCustomException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
