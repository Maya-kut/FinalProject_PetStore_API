package tests;

import io.qameta.allure.Owner;
import models.PetModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.Specifications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

@Owner("Maiya_Lys")
@Tag("api")
public class PetApiTest extends TestBase {
    @Test
    @DisplayName("Find pet by status 'Sold'")
    void findByStatusSoldTest() {
        given(Specifications.requestSpec)
                .when()
                .params("status", "sold")
                .get("/pet/findByStatus")
                .then()
                .spec(Specifications.responseSpec(200))
                .body("id", hasSize(greaterThan(0)));
    }

    @Test
    @DisplayName("Find pet by status 'Available'")
    void findByStatusAvailableTest() {
        given(Specifications.requestSpec)
                .when()
                .params("status", "available")
                .get("/pet/findByStatus")
                .then()
                .spec(Specifications.responseSpec(200))
                .body("id", hasSize(greaterThan(0)));
    }

    @Test
    @DisplayName("Find pet with non-existent status")
    void findWithNonExistentStatusTest() {
        given(Specifications.requestSpec)
                .when()
                .params("status", "none")
                .get("/pet/findByStatus")
                .then()
                .spec(Specifications.responseSpec(200))
                .body(is("[]"));
    }

    @Test
    @DisplayName("Find pet by id")
    void findByIdTest() {
        given(Specifications.requestSpec)
                .when()
                .get("/pet/9223372036854770000")
                .then()
                .spec(Specifications.responseSpec(200))
                .body("id", is(9223372036854770000L))
                .body("name", is("doggie"));
    }

    @Test
    @DisplayName("Find non-existent pet")
    void findByNonExistentIdTest() {
        given(Specifications.requestSpec)
                .when()
                .get("/pet/922337203685474000")
                .then()
                .spec(Specifications.responseSpec(404))//как правильно импортировать, чтобы работало?
                .body("type", is("error"))
                .body("message", is("Pet not found"));
    }

    @Test
    @DisplayName("Updates a pet in the store with form data")
    void successfulUpdatePetTest() {
        PetModel updateData = new PetModel();
        updateData.setId("9223372036854740000");
        updateData.setName("Hercules");
        updateData.setStatus("available");
        given(Specifications.requestSpec)
                .body(updateData)
                .when()
                .post("/pet/")
                .then()
                .spec(Specifications.responseSpec(200))
                .body("id", is(9223372036854740000L))
                .body("name", is("Hercules"))
                .body("status", is("available"));
    }
}
