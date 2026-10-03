package com.fooddiary.tests;

import com.fooddiary.pages.USDAPage;
import com.fooddiary.utils.BaseTest;
import com.fooddiary.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class USDATest extends BaseTest {

    USDAPage usdaPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        usdaPage = new USDAPage(driver);
    }

    @Test
    public void verifyUSDAPageTitle() {
        usdaPage.goToUSDAPage();
        String title = usdaPage.getPageTitle();
        System.out.println("Page title: " + title);
        Assert.assertTrue(title.contains("FoodData"));
        // Assert.assertTrue(title.contains("WRONG")); // to test screenshot
    }

    @Test
    public void searchForFood() {
        usdaPage.goToUSDAPage();
        usdaPage.searchFoodWithWait("banana");
        System.out.println("Searched for banana!");

    }
}