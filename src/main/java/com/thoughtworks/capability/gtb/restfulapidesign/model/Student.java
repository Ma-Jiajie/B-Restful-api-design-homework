package com.thoughtworks.capability.gtb.restfulapidesign.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @NotNull
    private String id;
    @NotNull
    private String name;
    @NotNull
    private Gender gender;
    @NotNull
    private String note;
}
