package com.example.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Handler implements RequestHandler<Map<String, Object>, Map<String, Object>> {

    @Override
    public Map<String, Object> handleRequest(Map<String, Object> input, Context context) {
        // Log the input received
        context.getLogger().log("Input: " + new JSONObject(input).toString());

        // Process the input
        String message = "Hello";
        if (input.containsKey("name")) {
            message += " " + input.get("name");
        } else {
            message += " World";
        }

        // Prepare and return the response
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 200);
        response.put("message", message);
        response.put("timestamp", System.currentTimeMillis());

        // Log the response
        context.getLogger().log("Response: " + new JSONObject(response).toString());

        return response;
    }
}