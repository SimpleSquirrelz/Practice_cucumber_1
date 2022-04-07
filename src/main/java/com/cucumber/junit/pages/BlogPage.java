package com.cucumber.junit.pages;

import org.openqa.selenium.By;

public class BlogPage extends BasePage{
    private static final String PAGE_TITLE_PATTERN = "//*[contains(@class,'hero-header') and contains(text(),'%s')]";

    public boolean isPageWithTitleIsDisplayed(String title){
        return isElementDisplayed(By.xpath(String.format(PAGE_TITLE_PATTERN,title)));
    }
}
