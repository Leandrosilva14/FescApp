package com.leandro.fesc.exceptions;

public class NotFoundException extends BaseException  {
    public static int STATUS_CODE = 404;

    public NotFoundException(String message) {
        super(message, STATUS_CODE);
    }
}
