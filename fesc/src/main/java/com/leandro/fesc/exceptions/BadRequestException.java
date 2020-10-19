package com.leandro.fesc.exceptions;

public class BadRequestException extends BaseException {
    public static int STATUS_CODE = 400;

    public BadRequestException(String message) {
        super(message, STATUS_CODE);
    }
}
