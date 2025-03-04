package com.automation.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class UserApiTest extends BaseTest {
    private static int userId;
    private static String userName = "Youssef"; 
    private static String userJob = "Software Test Engineer"; 

    @Test(priority = 1)
    public void createUser() {
        String requestBody = "{ \"name\": \"" + userName + "\", \"job\": \"" + userJob + "\" }";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/users");

        response.then().statusCode(201);

        System.out.println("Create User Response: " + response.prettyPrint());

        userId = response.jsonPath().getInt("id");
        Assert.assertTrue(userId > 0, "User ID not received in response!");

    }

    @Test(priority = 2, dependsOnMethods = "createUser")
    public void getUser() {
        Assert.assertTrue(userId > 0, "Invalid user ID. Cannot proceed with Get User test!");

        Response response = given()
                .when()
                .get("/api/users/" + userId);

        response.then().statusCode(200);

        int returnedId = response.jsonPath().getInt("data.id");
        String returnedName = response.jsonPath().getString("data.first_name"); 
        String returnedJob = response.jsonPath().getString("data.job"); 

        Assert.assertEquals(returnedId, userId, "Retrieved user ID does not match!");
        Assert.assertEquals(returnedName, userName, "Retrieved user name does not match!");
        Assert.assertEquals(returnedJob, userJob, "Retrieved job does not match!");

        System.out.println("User Retrieved Successfully: " + response.prettyPrint());
    }

    @Test(priority = 3, dependsOnMethods = "createUser")
    public void updateUser() {
        String updatedName = "Youssef Yasser";
        String updatedJob = "Senior QA Engineer";

        String updateBody = "{ \"name\": \"" + updatedName + "\", \"job\": \"" + updatedJob + "\" }";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(updateBody)
                .when()
                .put("/api/users/" + userId);

        response.then().statusCode(200);

        Assert.assertEquals(response.jsonPath().getString("name"), updatedName, "Name update failed!");
        Assert.assertEquals(response.jsonPath().getString("job"), updatedJob, "Job update failed!");

        System.out.println("User Updated Successfully: " + response.prettyPrint());
    }
}
