package tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class ReqResTest {

    @Test
    public void getListUsers() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"page\": 2,\n" +
                        "    \"per_page\": 6,\n" +
                        "    \"total\": 12,\n" +
                        "    \"total_pages\": 2,\n" +
                        "    \"data\": [\n" +
                        "        {\n" +
                        "            \"id\": 7,\n" +
                        "            \"email\": \"michael.lawson@reqres.in\",\n" +
                        "            \"first_name\": \"Michael\",\n" +
                        "            \"last_name\": \"Lawson\",\n" +
                        "            \"avatar\": \"https://reqres.in/img/faces/7-image.jpg\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 8,\n" +
                        "            \"email\": \"lindsay.ferguson@reqres.in\",\n" +
                        "            \"first_name\": \"Lindsay\",\n" +
                        "            \"last_name\": \"Ferguson\",\n" +
                        "            \"avatar\": \"https://reqres.in/img/faces/8-image.jpg\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 9,\n" +
                        "            \"email\": \"tobias.funke@reqres.in\",\n" +
                        "            \"first_name\": \"Tobias\",\n" +
                        "            \"last_name\": \"Funke\",\n" +
                        "            \"avatar\": \"https://reqres.in/img/faces/9-image.jpg\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 10,\n" +
                        "            \"email\": \"byron.fields@reqres.in\",\n" +
                        "            \"first_name\": \"Byron\",\n" +
                        "            \"last_name\": \"Fields\",\n" +
                        "            \"avatar\": \"https://reqres.in/img/faces/10-image.jpg\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 11,\n" +
                        "            \"email\": \"george.edwards@reqres.in\",\n" +
                        "            \"first_name\": \"George\",\n" +
                        "            \"last_name\": \"Edwards\",\n" +
                        "            \"avatar\": \"https://reqres.in/img/faces/11-image.jpg\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 12,\n" +
                        "            \"email\": \"rachel.howell@reqres.in\",\n" +
                        "            \"first_name\": \"Rachel\",\n" +
                        "            \"last_name\": \"Howell\",\n" +
                        "            \"avatar\": \"https://reqres.in/img/faces/12-image.jpg\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"support\": {\n" +
                        "        \"url\": \"https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral\",\n" +
                        "        \"text\": \"Tired of writing endless social media content? Let Content Caddy generate it for you.\"\n" +
                        "    }\n" +
                        "}")
        .when()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getSingleUser() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"data\": {\n" +
                        "        \"id\": 2,\n" +
                        "        \"email\": \"janet.weaver@reqres.in\",\n" +
                        "        \"first_name\": \"Janet\",\n" +
                        "        \"last_name\": \"Weaver\",\n" +
                        "        \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\n" +
                        "    },\n" +
                        "    \"support\": {\n" +
                        "        \"url\": \"https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral\",\n" +
                        "        \"text\": \"Tired of writing endless social media content? Let Content Caddy generate it for you.\"\n" +
                        "    }\n" +
                        "}")
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .log().all()
                .statusCode(200)
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"));
    }

    @Test
    public void getListResource() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"page\": 1,\n" +
                        "    \"per_page\": 6,\n" +
                        "    \"total\": 12,\n" +
                        "    \"total_pages\": 2,\n" +
                        "    \"data\": [\n" +
                        "        {\n" +
                        "            \"id\": 1,\n" +
                        "            \"name\": \"cerulean\",\n" +
                        "            \"year\": 2000,\n" +
                        "            \"color\": \"#98B2D1\",\n" +
                        "            \"pantone_value\": \"15-4020\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 2,\n" +
                        "            \"name\": \"fuchsia rose\",\n" +
                        "            \"year\": 2001,\n" +
                        "            \"color\": \"#C74375\",\n" +
                        "            \"pantone_value\": \"17-2031\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 3,\n" +
                        "            \"name\": \"true red\",\n" +
                        "            \"year\": 2002,\n" +
                        "            \"color\": \"#BF1932\",\n" +
                        "            \"pantone_value\": \"19-1664\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 4,\n" +
                        "            \"name\": \"aqua sky\",\n" +
                        "            \"year\": 2003,\n" +
                        "            \"color\": \"#7BC4C4\",\n" +
                        "            \"pantone_value\": \"14-4811\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 5,\n" +
                        "            \"name\": \"tigerlily\",\n" +
                        "            \"year\": 2004,\n" +
                        "            \"color\": \"#E2583E\",\n" +
                        "            \"pantone_value\": \"17-1456\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 6,\n" +
                        "            \"name\": \"blue turquoise\",\n" +
                        "            \"year\": 2005,\n" +
                        "            \"color\": \"#53B0AE\",\n" +
                        "            \"pantone_value\": \"15-5217\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"support\": {\n" +
                        "        \"url\": \"https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral\",\n" +
                        "        \"text\": \"Tired of writing endless social media content? Let Content Caddy generate it for you.\"\n" +
                        "    }\n" +
                        "}")
        .when()
                .get("https://reqres.in/api/unknown")
        .then()
                .log().all()
                .statusCode(200)
                .body("per_page", equalTo(6))
                .body("total", equalTo(12));
    }

    @Test
    public void getSingleResource() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"data\": {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"fuchsia rose\",\n" +
                        "        \"year\": 2001,\n" +
                        "        \"color\": \"#C74375\",\n" +
                        "        \"pantone_value\": \"17-2031\"\n" +
                        "    },\n" +
                        "    \"support\": {\n" +
                        "        \"url\": \"https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral\",\n" +
                        "        \"text\": \"Tired of writing endless social media content? Let Content Caddy generate it for you.\"\n" +
                        "    }\n" +
                        "}")
        .when()
                .get("https://reqres.in/api/unknown/2")
        .then()
                .log().all()
                .statusCode(200)
                .body("data.name", equalTo("fuchsia rose"))
                .body("data.year", equalTo(2001));
    }

    @Test
    public void postCreate() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\",\n" +
                        "    \"id\": \"778\",\n" +
                        "    \"createdAt\": \"2024-12-30T09:40:18.087Z\"\n" +
                        "}")
        .when()
                .post("https://reqres.in/api/users")
        .then()
                .log().all()
                .statusCode(201)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"));
    }

    @Test
    public void putUpdate() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion\"\n" +
                        "}")
        .when()
                .put("https://reqres.in/api/users/2")
        .then()
                .log().all()
                .statusCode(200)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("zion"));
    }

    @Test
    public void patchUpdate() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
        .when()
                .patch("https://reqres.in/api/users/2")
        .then()
                .log().all()
                .statusCode(200)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("zion resident"));
    }

    @Test
    public void deleteUser() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("")
        .when()
                .delete("https://reqres.in/api/users/2")
        .then()
                .log().all()
                .statusCode(204);
    }

    @Test
    public void postRegisterSuccessful() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}")
        .when()
                .post("https://reqres.in/api/register")
        .then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo(4))
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void postRegisterUnsuccessful() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"sydney@fife\"\n" +
                        "}")
        .when()
                .post("https://reqres.in/api/register")
        .then()
                .log().all()
                .statusCode(400)
                .body("error", equalTo("Missing password"));
    }

    @Test
    public void postLoginSuccessful() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
        .when()
                .post("https://reqres.in/api/login")
        .then()
                .log().all()
                .statusCode(200)
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void postLoginUnsuccessful() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"peter@klaven\"\n" +
                        "}")
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().all()
                .statusCode(400)
                .body("error", equalTo("Missing password"));
    }
}
