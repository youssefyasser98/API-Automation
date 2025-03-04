package com.automation.api;

import com.automation.config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BaseTest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigReader.getProperty("base_url");
    }

    // Utility method to check API health before running tests
    @Test(priority = 0)
    public void checkApiHealth() {
        Response response = given()
                .when()
                .get("/api/unknown");

        if (response.statusCode() != 200) {
            Assert.fail("API is down! Status Code: " + response.statusCode());
        } else {
            System.out.println("API is working fine!");
        }
    }
}
