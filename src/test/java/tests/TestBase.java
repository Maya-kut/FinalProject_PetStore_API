package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {


    public static String apiKey = "special-key";

    @BeforeAll
    static void beforeAll() {

        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

}

