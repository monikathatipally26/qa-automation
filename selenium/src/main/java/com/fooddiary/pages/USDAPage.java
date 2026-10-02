package com.fooddiary.pages;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;

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
        driver.get("https://fdc.nal.usda.gov/food-search");
    }

    public void searchFood(String foodName) {
        driver.findElement(searchBox).sendKeys(foodName);
        driver.findElement(searchButton).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}