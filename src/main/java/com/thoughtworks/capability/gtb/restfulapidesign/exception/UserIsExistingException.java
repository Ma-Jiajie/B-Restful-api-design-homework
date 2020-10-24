package com.thoughtworks.capability.gtb.restfulapidesign.exception;

public class UserIsExistingException extends RuntimeException{
    public UserIsExistingException(String message) {
        super(message);
    }
}
