package basicTests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static commons.Paths.BASE_URL;
import static io.restassured.RestAssured.given;

public class UserLoginTest {

    String userToken;

    @Test
    public void testUserLogin() {
        String loginPath = "/APIDEV/login";
        String userLoginPayload = "{\n" +
                "  \"email\": \"admin@gmail.com\",\n" +
                "  \"password\": \"@12345678\"\n" +
                "}";

        Response response = given()
                .baseUri(BASE_URL)
                .basePath(loginPath)
                .header("Content-Type", "application/json")
                .body(userLoginPayload)
                .log().all()
                .post()
                .then().extract().response();

        userToken = response.jsonPath().getString("data.token");

        System.out.println("User Token: " + userToken);

    }
}
