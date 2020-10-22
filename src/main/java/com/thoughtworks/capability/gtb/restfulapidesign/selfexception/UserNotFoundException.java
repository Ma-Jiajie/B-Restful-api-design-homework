package com.thoughtworks.capability.gtb.restfulapidesign.selfexception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
