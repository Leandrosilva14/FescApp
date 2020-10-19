package com.leandro.fesc.api;

public class ApiResponseMessages {
    public static final String MESSAGE_200 = "Successful request with body content";
    public static final String MESSAGE_201 = "Successful request with body content";
    public static final String MESSAGE_202 = "The request has been accepted but the processing has not been completed "
            + "yet";
    public static final String MESSAGE_204 = "Successful request without body content";
    public static final String MESSAGE_400 = "The request was invalid or could not be served. An accompanying error "
            + "message will explain further";
    public static final String MESSAGE_401 = "Authentication credentials were missing or incorrect";
    public static final String MESSAGE_403 = "The request is understood, but it has been refused or access is not "
            + "allowed";
    public static final String MESSAGE_404 = "The requested resource could not be found";
    public static final String MESSAGE_409 = "Conflict between resources. An accompanying error message will explain "
            + "further";
    public static final String MESSAGE_500 = "Something went wrong on the server. An accompanying error message will "
            + "explain further";
    public static final String MESSAGE_507 = "Insufficient Storage";
}
