package utils;

import io.restassured.response.Response;

public class RequestUtils {

    public RequestUtils() {
    }

    public String parseResponse(Response jsonResponse, String propertyName) {
        return jsonResponse.jsonPath().get(String.format("data.%s", propertyName));
    }

}
