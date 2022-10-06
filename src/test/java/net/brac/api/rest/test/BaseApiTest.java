package net.brac.api.rest.test;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public abstract class BaseApiTest {

    protected abstract String getControllerName();

    protected String key = "5d0a4a85-df7a-scapi-bits-93eb-145f6a9902ae";

    @BeforeClass
    protected void setup() {
        //QA Instance URL
        RestAssured.baseURI = "http://10.42.53.130:7099";
        RestAssured.basePath = "/" + getControllerName();
    }

}
