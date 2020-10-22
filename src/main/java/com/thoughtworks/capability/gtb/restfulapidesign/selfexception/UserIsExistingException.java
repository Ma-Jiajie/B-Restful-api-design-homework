package com.thoughtworks.capability.gtb.restfulapidesign.selfexception;

public class UserIsExistingException extends RuntimeException{
    public UserIsExistingException(String message) {
        super(message);
    }
}
