import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class HHTest {

    @Test
    public void checkHH() {

        String response = when()
                .get("https://api.hh.ru/vacancies?text=QA")
        .then()
                .log().all()
                .statusCode(200)
                .extract().asString();

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        VacancyResponse vac = gson.fromJson(response, VacancyResponse.class);
        System.out.println(vac);

        for(Vacancy vacs: vac.getItems()) {
            if (vacs.getSalary() != null) {
                System.out.println(vacs);
            }
        }
    }
}