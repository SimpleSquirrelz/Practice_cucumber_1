package com.cucumber.junit.steps;

import com.cucumber.junit.driver.DriverManager;
import com.cucumber.junit.pages.SearchPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchSteps {

    private static final SearchPage searchPage = new SearchPage();

    @And("the user writes {string} into search into search field")
    public void writeTextIntoSearchField(String text) {
        searchPage.searchField().sendKeys(text);
        searchPage.searchField().sendKeys(Keys.ENTER);
    }

    @And("the user clicks on the {string} filter for the search results")
    public void clickOnFilter(String filterName) {
        try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}

        searchPage.filterButton(filterName).click();

    }

    @And("the user clicks on the first item with {string} tag")
    public void theUserClicksOnTheFirstItemWithTag(String tag) {

        WebElement searchSection = searchPage.searchResultSection();
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        new Actions(DriverManager.getDriver()).moveToElement(searchSection).perform();

        long targetHeight;
        long maxHeight =(long)js.executeScript("return arguments[0].scrollHeight",searchSection);
        do{
            targetHeight = maxHeight;
            js.executeScript("arguments[0].scroll(0,"+targetHeight+")",searchSection);
            maxHeight = (long)js.executeScript("return arguments[0].scrollHeight",searchSection);
        }while(targetHeight!=maxHeight);

        searchPage.searchResultByTag(tag).click();
    }
}
