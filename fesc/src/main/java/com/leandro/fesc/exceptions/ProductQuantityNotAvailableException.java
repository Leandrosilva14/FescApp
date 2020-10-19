package com.leandro.fesc.exceptions;

import com.leandro.fesc.configuration.Translator;

public class ProductQuantityNotAvailableException extends BaseException {
    public static int STATUS_CODE = 400;

    public ProductQuantityNotAvailableException() {
        super(Translator.toLocale("product.quantity.not.available.exception", new String[] {}), STATUS_CODE);
    }
}
