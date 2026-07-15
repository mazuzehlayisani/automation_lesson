package requestBuilder;

import io.restassured.response.Response;

import static commons.Paths.BASE_URL;
import static io.restassured.RestAssured.given;

public class AdminRequestBuilder {

    static public String adminToken;

    public static Response adminLogin(String username, String password) {
        Response response = UserRequestBuilder.userLogin(username, password);
        adminToken = response.jsonPath().getString("data.token");
        return response;
    }

    public static Response approveUser() {
        String apiPath = "/APIDEV/admin/users/{userId}/approve";
        return given()
                .baseUri(BASE_URL)
                .basePath(apiPath)
                .pathParams("userId", UserRequestBuilder.registeredUserId)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + adminToken)
                .log().all()
                .when()
                .put()
                .then()
                .extract().response();
    }
}