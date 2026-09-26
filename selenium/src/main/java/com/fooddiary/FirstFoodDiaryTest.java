package com.fooddiary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstFoodDiaryTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    @Test
    public void testUSDAfoodSearch()throws InterruptedException {
        driver.get("https://fdc.nal.usda.gov/food-search");
        Thread.sleep(3000); // wait 3 seconds
        String title = driver.getTitle();
        System.out.println("USDA Page title: " + title);
        Assert.assertTrue(title.contains("FoodData"));
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}