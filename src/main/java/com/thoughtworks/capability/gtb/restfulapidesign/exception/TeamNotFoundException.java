package com.thoughtworks.capability.gtb.restfulapidesign.exception;

public class TeamNotFoundException extends RuntimeException{
    public TeamNotFoundException (String message) {
        super(message);
    }
}
