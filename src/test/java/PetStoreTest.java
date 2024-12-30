import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class PetStoreTest {

    //Изолированные
    //CRUD

    @Test
    public void checkCreatePetWithoutBody() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("")
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .log().all()
                .statusCode(405)
                .body("code", equalTo(405))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("no data"));
    }

    @Test
    public void checkCreatePet() {
        long id = given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 10,\n" +
                        "    \"name\": \"Cat\"\n" +
                        "  },\n" +
                        "  \"name\": \"Tomas\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"onliner.by\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 15,\n" +
                        "      \"name\": \"Street\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .log().all()
                .statusCode(200)
                .body("name", equalTo("Tomas"))
                .body("category.name", equalTo("Cat"))
                .body("photoUrls", hasItem("onliner.by"))
                .extract().path("id");

        when()
                .get("https://petstore.swagger.io/v2/pet/" + id)
                .then()
                .log().all()
                .statusCode(200);

        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": " + id + ",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 20,\n" +
                        "    \"name\": \"Dog\"\n" +
                        "  },\n" +
                        "  \"name\": \"Bush\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"zzz.by\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"Home\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
        .when()
                .put("https://petstore.swagger.io/v2/pet")
        .then()
                .log().all()
        .statusCode(200);
    }
}