package com.thoughtworks.capability.gtb.restfulapidesign.selfexception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResult {
    private String httpCode;
    private String message;
}