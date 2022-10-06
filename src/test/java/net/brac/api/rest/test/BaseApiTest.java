package net.brac.api.rest.test;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public abstract class BaseApiTest {

    protected abstract String getControllerName();

    protected String key = "key value";

    @BeforeClass
    protected void setup() {
        //QA Instance URL
        RestAssured.baseURI = "Application URL";
        RestAssured.basePath = "/" + getControllerName();
    }

}
