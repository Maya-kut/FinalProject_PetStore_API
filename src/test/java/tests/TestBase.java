package tests;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {


    @BeforeAll
    static void beforeAll() {

        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

}

