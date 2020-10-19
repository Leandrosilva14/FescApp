package com.leandro.fesc.exceptions;

import com.leandro.fesc.configuration.Translator;

public class ProductCodeAlreadyExistException extends BaseException {
    public static int STATUS_CODE = 400;

    public ProductCodeAlreadyExistException() {
        super(Translator.toLocale("product.code.already.exist.exception", new String[] {}), STATUS_CODE);
    }
}
