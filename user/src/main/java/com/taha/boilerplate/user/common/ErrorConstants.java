package com.taha.boilerplate.user.common;

import java.util.Properties;

public class ErrorConstants {

    private static Properties properties = ErrorPropertiesLoader.load();

    public static final  String ERROR_USER_ALREADY_EXISTS = properties.getProperty("error.user.alreadyExists");
    public static final  String ERROR_INCORRECT_EMAIL_OR_PASSWORD = properties.getProperty("error.user.incorrectEmailOrPassword");

}
