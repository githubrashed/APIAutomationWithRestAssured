package net.brac.api.rest.test.RestApiAutomation.readwrite;

import com.thedeanda.lorem.LoremIpsum;
import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReadWriteApi {


    @Test
    public void getUserDetailsInformation() {

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;

        int userid = given()
                .when()
                .get("/posts")
                .then()
                .log().body()
                .extract().jsonPath().getInt("[0].id");

        given()
                .log().uri()
                .when()
                .get("/posts")
                .then()
                .log().body()
                .statusCode(200)
                .log().body()
                .body("[0].id", equalTo(userid));

    }

    @Test
    public void storeUserInformation() {

        String userName = LoremIpsum.getInstance().getTitle(2);
        String jobTitle = LoremIpsum.getInstance().getTitle(2);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", userName);
        jsonObject.put("jobTitle", jobTitle);

//        Map<String, String > userList = new HashMap<>();
//        userList.put("name", userName);
//        userList.put("jobTitle", jobTitle);

        given()
                .header("Content-Type", "application/json")
                .body(jsonObject.toString())
                .log().uri()
                .when()
                .post("http://localhost:3000/posts/")
                .then()
                .log().body()
                .statusCode(201)
                .body("name", equalTo(userName));
    }

}
