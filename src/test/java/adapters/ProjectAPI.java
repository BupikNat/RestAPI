package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.CreateProjectRq;
import models.CreateProjectRs;

import static io.restassured.RestAssured.given;

public class ProjectAPI {

    public static String token = "71d822c4c3d4718cf555e793a75c65710f3397cb84af11138828649e8273f4bb";
    public static String url = "https://api.qase.io/v1/project/";

    public static Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public static RequestSpecification spec =
            given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .header("Token", token);

    public static CreateProjectRs createProject(CreateProjectRq createProjectRq) {
        return
                given()
                        .spec(spec)
                        .body(gson.toJson(createProjectRq))
                        .when()
                        .post(url)
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .as(CreateProjectRs.class);
    }

    public static void deleteProject(String code) {
        given()
                .spec(spec)
                .when()
                .delete(url + code)
                .then()
                .log().all()
                .statusCode(200);
    }

    public static void getProject(String code) {
        given()
                .spec(spec)
                .when()
                .get(url + code)
                .then()
                .log().all()
                .statusCode(200);
    }
}