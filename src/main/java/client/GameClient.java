package client;

import io.restassured.response.Response;

public class GameClient extends BaseHttpClient {


    public Response authenticate() {
        String authSuffix = "fn=authenticate&org=Demo";

        return get(authSuffix);
    }

    public Response spin(String sessid) {
        String spinSuffix = String.format("fn=play&currency=EUR&gameid=%d&sessid=%s&coin=0.05&amount=1.25",
                Integer.valueOf(properties.getProperty("game.id")), sessid);

        return get(spinSuffix);
    }
}
