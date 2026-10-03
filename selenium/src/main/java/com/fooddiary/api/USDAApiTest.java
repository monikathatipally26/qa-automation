package com.fooddiary.api;

import com.fooddiary.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class USDAApiTest {

    //private static final String BASE_URL = ConfigReader.get("api.base.url");
    private static final String BASE_URL = "https://api.nal.usda.gov/fdc/v1";

    private static final String API_KEY = ConfigReader.get("api.key");

   // private static final String API_KEY = "UXSjg4Txjv2FFYsLukanqxNEcJhSHLHXOXkzzboN";
    //System.out.println("API KEY: " +API_KEY);
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

    @DataProvider(name = "foodSearchData")
    public Object[][] getFoodData() {
        return new Object[][] {
                {"banana"},
                {"apple"},
                {"oats"},
                {"chicken"}
        };
    }

    @Test(dataProvider = "foodSearchData")
    public void testMultipleFoodSearches(String foodName) {
        Response response = RestAssured
                .given()
                .baseUri(BASE_URL)
                .queryParam("api_key", API_KEY)
                .queryParam("query", foodName)
                .when()
                .get("/foods/search")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println("Food: " + foodName +
                " | Status: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}