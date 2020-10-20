package com.thoughtworks.capability.gtb.restfulapidesign.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class GenderSerialize extends StdSerializer<Gender> {
    public GenderSerialize() {
        super(Gender.class);
    }

    @Override
    public void serialize(Gender gender, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeNumber(gender.ordinal());
    }
}
