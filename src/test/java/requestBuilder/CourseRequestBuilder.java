package requestBuilder;

import io.restassured.response.Response;

import static commons.Paths.BASE_URL;
import static io.restassured.RestAssured.given;
import static requestBuilder.UserRequestBuilder.userToken;

public class CourseRequestBuilder {

    public static Response courseRequest() {

        String apiPath = "/APIDEV/courses?category=automation&level=beginner";

        return given()
                .baseUri(BASE_URL)
                .basePath(apiPath)
                .contentType("application/json")
                .header("Authorization", "Bearer " + userToken)
                .when()
                .get()
                .then()
                .extract()
                .response();
    }
}