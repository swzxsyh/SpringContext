package com.test.infrastructure.exceptions;

public class ParamErrorException extends AbstractCustomException {
    public ParamErrorException(String message) {
        super(400, message);
    }

    public ParamErrorException(String message, Throwable cause) {
        super(400, message, cause);
    }
}
