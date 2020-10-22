package com.thoughtworks.capability.gtb.restfulapidesign.controller.requestdto;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {
    @NotNull
    private String id;
    private String name;
    private Gender gender;
    private String note;
}
