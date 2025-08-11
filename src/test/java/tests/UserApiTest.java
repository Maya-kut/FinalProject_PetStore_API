package tests;

import models.UserModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.Specifications;
import testData.UserData;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static testData.UserData.*;

@Tag("api")
public class UserApiTest extends TestBase {

    @Test
    @DisplayName("Create user")
    void createUserTest() {
        UserModel createUserData = new UserModel();
        createUserData.setId(Math.toIntExact(id));
        createUserData.setUserName(userName);
        createUserData.setFirstName(userName);
        createUserData.setLastName(userSurname);
        createUserData.setEmail(userEmail);
        createUserData.setPassword(userPassword);
        createUserData.setPhone(userPhone);
        createUserData.setUserStatus(userStatus);

        String response = given(Specifications.requestSpec)
                .body(createUserData)
                .when()
                .post("/user")
                .then()
                .spec(Specifications.responseSpec(200))
                .extract().path("message");

        assertThat(response).isEqualTo(UserData.id.toString());
    }

    @Test
    @DisplayName("Get user")
    void getUserTest() {
        given(Specifications.requestSpec)
                .when()
                .get("user/Dwight")
                .then()
                .spec(Specifications.responseSpec(200))
                .body("id", is(3793))
                .body("firstName", is("Burl"));
    }

    @Test
    @DisplayName("Get non-existent user")
    void getNonExistentUserTest() {
        given(Specifications.requestSpec)
                .when()
                .get("user/BurlBurl")
                .then()
                .spec(Specifications.responseSpec(404))
                .body("type", is("error"))
                .body("message", is("User not found"));
    }

    @Test
    @DisplayName("Update user information")
    void updateUserTest() {
        UserModel updateUser = new UserModel();
        updateUser.setId(Math.toIntExact(id));
        updateUser.setUserName("Hermione2_0");
        updateUser.setFirstName("Hermione");
        updateUser.setLastName("Granger");
        updateUser.setEmail("hermione@gmail.com");
        updateUser.setPassword(userPassword);
        updateUser.setPhone(userPhone);
        updateUser.setUserStatus(userStatus);
        String response = given(Specifications.requestSpec)
                .body(updateUser)
                .when()
                .put("user/Anton")
                .then()
                .spec(Specifications.responseSpec(200))
                .extract().path("message");

        assertThat(response).isEqualTo(UserData.id.toString());
    }
}
