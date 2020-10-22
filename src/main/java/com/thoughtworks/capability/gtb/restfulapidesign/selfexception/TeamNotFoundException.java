package com.thoughtworks.capability.gtb.restfulapidesign.selfexception;

public class TeamNotFoundException extends RuntimeException{
    public TeamNotFoundException (String message) {
        super(message);
    }
}
