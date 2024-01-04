package org.example.parser.jsonAdapters;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeAdapter extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String dateTimeString = jsonParser.readValueAs(String.class);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        return LocalDateTime.parse(dateTimeString, formatter);
    }
}
