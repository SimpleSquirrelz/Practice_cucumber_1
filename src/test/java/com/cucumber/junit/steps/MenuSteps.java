package com.cucumber.junit.steps;

import com.cucumber.junit.pages.DocsPage;
import com.cucumber.junit.pages.HomePage;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class MenuSteps {

    private final HomePage homePage = new HomePage();
    private final DocsPage docsPage = new DocsPage();

    @When("the user opens Cucumber website")
    public void openCucumberWebsite() {
        homePage.openCucumberWebsite();
    }

    @When("the user clicks on the {string} section")
    public void clickOnSection(String section) {
        homePage.menuSection(section).click();
    }

    @When("the user clicks on the {string} item")
    public void clickOnItem(String item) {
        homePage.menuChildItem(item).click();
    }

    @When("page with {string} is displayed")
    public void verifyPageTitlePresence(String pageTitle) {
        Assertions.assertThat(docsPage.isPageWithTitleIsDisplayed(pageTitle))
                .overridingErrorMessage("Page with title %s is not displayed",pageTitle)
                .isTrue();
    }

    @When("the user clicks on the search button")
    public void clickOnSearchButton() {
        homePage.menuSearchButton().click();
    }
}
