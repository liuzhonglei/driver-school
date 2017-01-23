package com.drivers.router.web.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * Custom Jackson deserializer for transforming a JSON object (using the ISO 8601 date formatwith optional time)
 * to a JSR310 LocalDate object.
 */
public class JSR310ZoneDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {

    public static final JSR310ZoneDateTimeDeserializer INSTANCE = new JSR310ZoneDateTimeDeserializer();

    private JSR310ZoneDateTimeDeserializer() {}

    private static final DateTimeFormatter ISO_DATE_OPTIONAL_TIME;

    static {
        ISO_DATE_OPTIONAL_TIME = new DateTimeFormatterBuilder()
            .append(DateTimeFormatter.ISO_LOCAL_DATE)
            .optionalStart()
            .appendLiteral('T')
            .append(DateTimeFormatter.ISO_OFFSET_TIME)
            .toFormatter();
    }

    @Override
    public ZonedDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        switch(parser.getCurrentToken()) {
            case START_ARRAY:
                if(parser.nextToken() == JsonToken.END_ARRAY) {
                    return null;
                }
                int year = parser.getIntValue();

                parser.nextToken();
                int month = parser.getIntValue();

                parser.nextToken();
                int day = parser.getIntValue();

                if(parser.nextToken() != JsonToken.END_ARRAY) {
                    throw context.wrongTokenException(parser, JsonToken.END_ARRAY, "Expected array to end.");
                }
                return ZonedDateTime.now();
//                return ZonedDateTime.of(year, month, day,1,1,1);

            case VALUE_STRING:
                String string = parser.getText().trim();
                if(string.length() == 0) {
                    return null;
                }
                return ZonedDateTime.parse(string, ISO_DATE_OPTIONAL_TIME);
        }
        throw context.wrongTokenException(parser, JsonToken.START_ARRAY, "Expected array or string.");
    }
}
