package requestBuilder;

import io.restassured.response.Response;
import payloadBuilder.UserPayload;

import static commons.Paths.BASE_URL;
import static io.restassured.RestAssured.given;

public class UserRequestBuilder {

    static String registeredUserId;
    static String userToken;

    public static Response userRegistration(String firstName, String lastName, String email, String password, String groupId) {

        String apiPath = "/APIDEV/register";
        Response response = given()
                .baseUri(BASE_URL)
                .basePath(apiPath)
                .header("Content-Type", "application/json")
                .body(UserPayload.registerUserPayload(firstName, lastName, email, password, groupId))
                .when()
                .post()
                .then()
                .extract().response();

        registeredUserId = response.jsonPath().getString("data.id");
        return response; // Placeholder for the actual implementation
    }

    public static Response userLogin(String email, String password) {

        String apiPath = "/APIDEV/login";
        Response response = given()
                .baseUri(BASE_URL)
                .basePath(apiPath)
                .header("Content-Type", "application/json")
                .body(UserPayload.userLoginPayload(email, password))
                .when()
                .post()
                .then()
                .extract().response();
        userToken = response.jsonPath().getString("data.token");
        return response; // Placeholder for the actual implementation
    }

    public static Response updateUserRole(String role) {
        String apiPath = "/APIDEV/admin/users/"+registeredUserId+"/role";
        return given()
                .baseUri(BASE_URL)
                .basePath(apiPath)
                .contentType("application/json")
                .header("Authorization", "Bearer " + userToken)
                .body(UserPayload.updateUserRole(role))
                .when()
                .put()
                .then()
                .extract()
                .response();
    }
}
