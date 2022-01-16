package org.example.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * @author weimenghua
 * @time 2023-01-13 14:35
 * @description
 */
public class JsonConverter {
    public static JSONObject objectToJSONObject(Object object) {
        try {
            String jsonString = new ObjectMapper().writeValueAsString(object);
            return new JSONObject(jsonString);
        }catch (JSONException | JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONArray objectToJSONArray(Object object) {
        try {
            String jsonString = new ObjectMapper().writeValueAsString(object);
            return new JSONArray(jsonString);
        } catch (JSONException | JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T jsonObjectToObject(Object jsonObject, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(jsonObject.toString(), clazz);
        } catch (IOException e) {
            return null;
        }
    }
}
