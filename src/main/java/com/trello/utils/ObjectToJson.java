package com.trello.utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class ObjectToJson {
    static ObjectMapper mapper = new ObjectMapper();

    public static String convertObjectToJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (IOException ioException) {
            System.out.println("getting exception while converting object to JSON.");
        }
        return null;
    }
}