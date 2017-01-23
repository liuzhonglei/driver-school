package com.drivers.router.exceptions;

public class ExistedStatusCodeException extends RuntimeException {

    public ExistedStatusCodeException(String message) {
        super(message);
    }

    public ExistedStatusCodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
