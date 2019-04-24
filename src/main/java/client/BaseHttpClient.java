package client;

import com.google.inject.Inject;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Properties;

public abstract class BaseHttpClient {
    @Inject
    public Properties properties;

    Response get(String suffix) {
        final String gameUrl = properties.getProperty("game.url");

        Response response = RestAssured.get(gameUrl + suffix);

        response.then().assertThat().statusCode(200);

        return response;
    }
}
