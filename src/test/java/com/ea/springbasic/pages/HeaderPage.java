package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class HeaderPage extends BasePage {

    @FindBy(className = "c-navigation--bar c-navigation--bar--main")
    private WebElement header;
    @FindBy(className = "c-navigation-logo")
    private WebElement dhlLogo;
    @FindBy(className = "c-navigation-search--form js--navigation-search--form")
    private WebElement searchForm;
   //TODO map all elements, not in scope now


    public boolean isLogoDisplayed() {
        return fluentWait.until((d) -> dhlLogo.isDisplayed());
    }

    public boolean isSearchFormDisplayed() {
        return fluentWait.until((d) -> searchForm.isDisplayed());
    }

    public void clickOnLogo() {
        dhlLogo.click();
    }

    @Override
    public boolean isDisplayed() {
        return fluentWait.until((d) -> header.isDisplayed());
    }
}
