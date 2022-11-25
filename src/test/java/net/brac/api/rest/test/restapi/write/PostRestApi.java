package net.brac.api.rest.test.restapi.write;

import static io.restassured.RestAssured.given;


import org.testng.annotations.Test;

public class PostRestApi {
    @Test
    public void postRestApiShouldSucceed() {
        given()
                .log().uri()
                .when()
                .get("http://localhost:3000/posts")
                .then()
                .log().body()
                .statusCode(200);
    }
}
