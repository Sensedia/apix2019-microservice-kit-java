package com.sensedia.apix2019.kit.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.sensedia.apix2019.kit.enumeration.Gender;

public class GenderDeserializer extends JsonDeserializer<Gender> {

    @Override
    public Gender deserialize(JsonParser jsonParser, DeserializationContext ctxt)
            throws IOException {

        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        if (node == null) {
            return null;
        }

        String gender = node.textValue();
        return Gender.getByGender(gender);
    }

}
