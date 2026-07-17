package userTests;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import requestBuilder.AdminRequestBuilder;
import requestBuilder.UserRequestBuilder;

import static org.hamcrest.CoreMatchers.equalTo;

public class userRegistrationTest {

    static String firstName;
    static String lastName;
    static String userEmail;
    static String password;
    static String groupId;

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
    //Login with invalid credentials
    @Test(priority =6)
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