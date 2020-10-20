package com.thoughtworks.capability.gtb.restfulapidesign.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @NonNull
    private String id;
    @NonNull
    private String name;
    @NonNull
    private Gender gender;
    @NonNull
    private String note;
}
