package com.fooddiary.pages;
import com.fooddiary.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class USDAPage {

    WebDriver driver;

    // Locators
    private By searchBox = By.id("search-page-search-input");
    private By searchButton = By.id("search-page-search-button-sidebar");

    // Constructor
    public USDAPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void goToUSDAPage() {
       // driver.get("https://fdc.nal.usda.gov/food-search");
        driver.get(ConfigReader.get("base.url") + "/food-search");

    }

    public void searchFood(String foodName) {
        driver.findElement(searchBox).sendKeys(foodName);
        driver.findElement(searchButton).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void searchFoodWithWait(String foodName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        driver.findElement(searchBox).sendKeys(foodName);
        driver.findElement(searchButton).click();
    }
}