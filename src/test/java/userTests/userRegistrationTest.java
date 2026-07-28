package userTests;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import requestBuilder.AdminRequestBuilder;
import requestBuilder.AnnouncementRequestBuilder;
import requestBuilder.CourseRequestBuilder;
import requestBuilder.UserRequestBuilder;

import static org.hamcrest.CoreMatchers.equalTo;

public class userRegistrationTest {

    static String firstName;
    static String lastName;
    static String userEmail;
    static String password;
    static String groupId;
    static String title;
    static String content;
    static String isActive;

    static Faker faker = new Faker();

    @BeforeClass
    public static void setupData(){
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = "Group3" + faker.internet().emailAddress(); //unique email for each test run
        password = "7654321!";
        groupId = "0d4364c2-3476-44dc-abfb-cc901b254ef2";
    }

    @Test (priority = 1)
    public void userRegistrationTest(){
        Response response = UserRequestBuilder.userRegistration(firstName, lastName, userEmail, password, groupId);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 201);

    }
    @Test (priority = 2)
    public void testAdminLogin() {
        Response response = AdminRequestBuilder.adminLogin(
                "admin@gmail.com",
                "@12345678"
        );

        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void updateUserRoleTest() {
        Response response = UserRequestBuilder.updateUserRole("admin");

        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test (priority = 4)
    public void testUserApproval(){
        AdminRequestBuilder.approveUser()
                .then()
                .log().all()
                .assertThat()
                .body("success", equalTo(true));

    }

    @Test (priority = 5)
    public void testUserLoginAfterApproval() {
        UserRequestBuilder.userLogin(userEmail, password)
                .then()
                .log().all()
                .assertThat()
                .body("message", equalTo("Login successful"));

    }

    @Test(priority = 6)
    public void testCreateAnnouncement() {
        title = faker.book().title();
        content = faker.lorem().sentence();

        Response response = AnnouncementRequestBuilder.createAnnouncement(title, content);

        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(priority = 7)
    public void testUpdateAnnouncement() {
        title = faker.book().title();
        content = faker.lorem().paragraph();
        isActive = String.valueOf(true);

        Response response = AnnouncementRequestBuilder.updateAnnouncement(title, content, isActive);

        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 8)
    public void testdeleteAnnouncement(){
        Response response = AnnouncementRequestBuilder.deleteAnnouncement();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 9)
    public void testGetPublishedCourses(){
        Response response = CourseRequestBuilder.courseRequest();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    //Login with invalid credentials
    @Test(priority =10)
    public void testAdminLoginWithInvalidCredentials() {
        Response response = AdminRequestBuilder.adminLogin(
                "adminhlayi@gmail.com",
                "@12345678"
        );
        response.then()
                .log().all()
                .body("success", equalTo(false))
                .body("message", equalTo("Invalid email or password"))
                .body("error_code", equalTo("INVALID_CREDENTIALS"));
    }
}