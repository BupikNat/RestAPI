package tests;

import adapters.ProjectAPI;
import io.restassured.http.ContentType;
import models.CreateProjectRq;
import models.CreateProjectRs;
import org.testng.Assert;
import org.testng.annotations.Test;

import static adapters.ProjectAPI.*;
import static io.restassured.RestAssured.given;

public class ProjectTest {

    @Test
    public void checkCreateProject() {
        CreateProjectRq rq = CreateProjectRq.builder()
                .title("QA Test2")
                .code("QA2")
                .description("Test")
                .build();
        CreateProjectRs rs = createProject(rq);
        Assert.assertEquals(rs.getStatus(), true);
        Assert.assertEquals(rs.getResult().getCode(), "QA2");

        deleteProject("QA2");
    }
}