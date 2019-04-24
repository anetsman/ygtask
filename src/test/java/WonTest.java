import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.not;

public class WonTest extends BaseApiTest {

    private Response authResponse;

    @BeforeEach
    public void setUp() {
        authResponse = gameClient.authenticate();
    }

    @Test
    public void spinUntilWinTest() {

        boolean win = false;
        int numberOfSpins = 1;

        while (!win) {
            try {
                Response response = gameClient.spin(request.parseResponse(authResponse, "sessid"));
//                System.out.println(authResponse.jsonPath().getString("data.sessid"));
                System.out.println(String.format(
                        "spin # %d, win amount: %s", numberOfSpins,
                        response.jsonPath().getString("data.wager.bets[0].wonamount")));
                response.then().assertThat().body("data.wager.bets[0].wonamount", not("0.00"));
                win = true;
            } catch (AssertionError error) {
                if (numberOfSpins >= 30) {
                    throw new AssertionError(String.format("Not possible to win after %d spins", numberOfSpins));
                }
//                authResponse = gameClient.authenticate();
                System.out.println("spinning again... ");
                numberOfSpins += 1;
            }
        }
    }
}
