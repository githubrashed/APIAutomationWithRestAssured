package net.brac.api.rest.test.scapir.get;

import io.restassured.response.Response;
import net.brac.api.rest.test.scapir.BaseControllerTest;
import net.brac.api.rest.test.scapir.get.pojo.TransactionsTermSavingsData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class TransactionsTermSavingsTest extends BaseControllerTest {

    private String updatedAt = "2022-09-27 12:11:40";
    String orgNo = "value";
    String startDate = "2021-02-04";
    String endDate = "2022-09-24";

    @Test
    public void getTransactionsTermSavingsInfoShouldSucceed() {
        given()
                .log().uri()
                .when()
                .get("ApplicationUrl/ControllerName/API?/TransactionsTermSavings?&UpdatedAt={updatedAt}&key={key}&OrgNo={orgNo}&StartDate={startDate}&EndDate={endDate}", updatedAt, key, orgNo, startDate, endDate)
                .then()
                .statusCode(200)
                .log().body()
                .body("message", equalTo(null));

    }

    @Test
    public void getTransactionsTermSavingsInfoWithValidateResponseDataShouldSucceed() {
        Response response = given()
                .log().uri()
                .when()
                .get("/TransactionsTermSavings?&UpdatedAt={updatedAt}&OrgNo={orgNo}&StartDate={startDate}&EndDate={endDate}", updatedAt, orgNo, startDate, endDate);

        String orgNo1 = response.jsonPath().getString("data[0].OrgNo");
        String orgMemNo1 = response.jsonPath().getString("data[0].OrgMemNo");

        List<TransactionsTermSavingsData> transactionsTermSavingsDataList = given()
                .log().uri()
                .when()
                .get("/TransactionsTermSavings?&UpdatedAt={updatedAt}&OrgNo={orgNo}&StartDate={startDate}&EndDate={endDate}", updatedAt, orgNo, startDate, endDate)
                .then()
                .statusCode(200)
                .log().body()
                .body("message", equalTo(null))
                .extract().body().jsonPath().getList("transactionsTermSavingsDataList", TransactionsTermSavingsData.class);

        for (TransactionsTermSavingsData data : transactionsTermSavingsDataList) {
            Assert.assertEquals(data.getProjectCode(), 015);
            Assert.assertEquals(data.getOrgNo(), orgNo1);
            Assert.assertEquals(data.getOrgNo(), orgMemNo1);
        }
    }
}
