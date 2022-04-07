package com.cucumber.junit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{
    private static final String SEARCH_FIELD = "//input[@class='app-input-query']";

    private static final String FILTER_SECTION = "//*[@class='locations-filter']";
    private static final String FILTER_PATTERN = "%s//*[text()='%s']";

    private static final String SEARCH_RESULT_SECTION = "//div[@class='results']";
    private static final String SEARCH_RESULTS = "//*[@class='item']";
    private static final String TAG_TEXT_PATTERN = "%s%s//*[contains(text(), '| %s')]";

    public WebElement searchField(){
        return findElement(By.xpath(SEARCH_FIELD));
    }

    public WebElement filterButton(String filterName){
        return findElement(By.xpath(String.format(FILTER_PATTERN,FILTER_SECTION,filterName)));
    }

    public WebElement searchResultSection(){
        return findElement(By.xpath(SEARCH_RESULT_SECTION));
    }

    public WebElement searchResultByTag(String tagName){
        return findElement(By.xpath(String.format(TAG_TEXT_PATTERN,SEARCH_RESULT_SECTION,SEARCH_RESULTS,tagName)));
    }
}
