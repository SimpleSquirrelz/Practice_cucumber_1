package com.cucumber.junit.steps;

import com.cucumber.junit.pages.BlogPage;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

public class BlogSteps {

    BlogPage blogPage = new BlogPage();

    @Then("blog page with {string} is displayed")
    public void verifyPageTitlePresence(String pageTitle) {
        Assertions.assertThat(blogPage.isPageWithTitleIsDisplayed(pageTitle))
                .overridingErrorMessage("Page with title %s is not displayed",pageTitle)
                .isTrue();
    }
}
