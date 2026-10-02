package com.fooddiary.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class USDAApiTest {

    private static final String BASE_URL = "https://api.nal.usda.gov/fdc/v1";
    private static final String API_KEY = "UXSjg4Txjv2FFYsLukanqxNEcJhSHLHXOXkzzboN";

    @Test
    public void testFoodSearchReturns200() {
        Response response = RestAssured
                .given()
                .baseUri(BASE_URL)
                .queryParam("api_key", API_KEY)
                .queryParam("query", "banana")
                .when()
                .get("/foods/search")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Response time: " + response.getTime() + "ms");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testInvalidApiKeyReturns403() {
        Response response = RestAssured
                .given()
                .baseUri(BASE_URL)
                .queryParam("api_key", "INVALID_KEY")
                .queryParam("query", "banana")
                .when()
                .get("/foods/search")
                .then()
                .extract()
                .response();

        System.out.println("Status: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 403);
    }
}