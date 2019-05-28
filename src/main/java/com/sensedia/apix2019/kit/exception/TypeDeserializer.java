package com.sensedia.apix2019.kit.exception;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.sensedia.apix2019.kit.enumeration.Type;

public class TypeDeserializer extends JsonDeserializer<Type> {

    @Override
    public Type deserialize(JsonParser jsonParser, DeserializationContext ctxt)
            throws IOException {

        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        if (node == null) {
            return null;
        }

        String type = node.textValue();
        return Type.getByType(type);
    }

}
