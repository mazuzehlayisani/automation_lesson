package requestBuilder;

import io.restassured.response.Response;
import payloadBuilder.AnnouncementPayload;

import static commons.Paths.BASE_URL;
import static io.restassured.RestAssured.given;
import static requestBuilder.UserRequestBuilder.userToken;

public class AnnouncementRequestBuilder {
    static String announcementId;

    public static Response createAnnouncement(String title, String content) {

        String apiPath = "/APIDEV/admin/announcements";
        Response response = given()
                .baseUri(BASE_URL)
                .basePath(apiPath)
                .contentType("application/json")
                .header("Authorization", "Bearer " + userToken)
                .body(AnnouncementPayload.createAnnouncementPayload(title, content))
                .when()
                .post()
                .then()
                .extract().response();

        announcementId = response.jsonPath().getString("data.id");
        return response; // Placeholder for the actual implementation
    }

    public static Response updateAnnouncement(String title, String content, String isActive) {

        String apiPath = "/APIDEV/admin/announcements/" + announcementId;
        return given()
                .baseUri(BASE_URL)
                .basePath(apiPath)
                .contentType("application/json")
                .header("Authorization", "Bearer " + userToken)
                .body(AnnouncementPayload.updateAnnouncementPayload(title, content, isActive))
                .when()
                .put()
                .then()
                .extract().response(); // Placeholder for the actual implementation
    }

    public static Response deleteAnnouncement() {
        String apiPath = "/APIDEV/admin/announcements/"+ announcementId;
        return given()
                .baseUri(BASE_URL)
                .basePath(apiPath)
                .header("Authorization", "Bearer " + userToken)
//                .header("Content-Type", "application/json")
                .when()
                .delete()
                .then()
                .extract()
                .response();
    }
}


