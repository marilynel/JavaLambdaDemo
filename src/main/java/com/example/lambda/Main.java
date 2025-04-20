package com.example.lambda;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a main method for local testing of the Lambda function.
 */
public class Main {
    public static void main(String[] args) {
        // Create a test event
        Map<String, Object> testEvent = new HashMap<>();
        testEvent.put("name", "Java Lambda User");

        // Create a simple context for local testing
        TestContext context = new TestContext();

        // Create an instance of the handler
        Handler handler = new Handler();

        // Invoke the handler
        Map<String, Object> result = handler.handleRequest(testEvent, context);

        // Print the result
        System.out.println("Result: " + new JSONObject(result).toString(2));
    }

    /**
     * Simple implementation of Context for local testing
     */
    private static class TestContext implements com.amazonaws.services.lambda.runtime.Context {
        @Override
        public String getAwsRequestId() {
            return "local-test-request-id";
        }

        @Override
        public String getLogGroupName() {
            return "local-test-log-group";
        }

        @Override
        public String getLogStreamName() {
            return "local-test-log-stream";
        }

        @Override
        public String getFunctionName() {
            return "JavaLambdaDemo";
        }

        @Override
        public String getFunctionVersion() {
            return "local-test-version";
        }

        @Override
        public String getInvokedFunctionArn() {
            return "local-test-arn";
        }

        @Override
        public com.amazonaws.services.lambda.runtime.CognitoIdentity getIdentity() {
            return null;
        }

        @Override
        public com.amazonaws.services.lambda.runtime.ClientContext getClientContext() {
            return null;
        }

        @Override
        public int getRemainingTimeInMillis() {
            return 15000;
        }

        @Override
        public int getMemoryLimitInMB() {
            return 128;
        }

        @Override
        public com.amazonaws.services.lambda.runtime.LambdaLogger getLogger() {
            return new com.amazonaws.services.lambda.runtime.LambdaLogger() {
                @Override
                public void log(String message) {
                    System.out.println("[LOG] " + message);
                }

                @Override
                public void log(byte[] message) {
                    System.out.println("[LOG] " + new String(message));
                }
            };
        }
    }
}